package uk.gov.hmcts.reform.hmi.performance.scenarios.listings
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.Predef.scenario
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment


object PutUpdateListingReq {
  val PutUpdateListingReqData= csv("RequestHearingData1.csv").circular
  val PutUpdateListingReq= scenario(scenarioName = "21.Update.Listing.PUT")
    .feed(PutUpdateListingReqData)
    .exec(http(requestName="21.Update.Listing.PUT")
//      .put("/listings/E200017"
        .put("/listings/${transaction_idhmcts}")
      .headers(Environment.headers)
      .body(ElFileBody("bodies/PutUpdateListingReq1.json")).asJson
      .check(status.is(202))
      .check(bodyString.saveAs("BODY21")))
    .exec{
      session =>
        println(session("BODY21").as[String])
        session
    }
}
