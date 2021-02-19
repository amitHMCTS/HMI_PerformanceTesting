package uk.gov.hmcts.reform.hmi.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment

object SendListingInformationCASEHQ {
  val SendListing= scenario(scenarioName = "020_SendListing_Post")
    .exec(http(requestName="Send_Listing_Information")
      .get("/hearings/")
      .headers(Environment.headers)
      .check(status.is(200))
      .check(bodyString.saveAs("BODY1")))
    .exec{
      session =>
        println(session("BODY1").as[String])
        session
    }


}
