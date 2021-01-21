package uk.gov.hmcts.reform.hmi.performance.scenarios.hearings
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment

object PutUpdateHearingReq {

  val PutUpdateHearingReqData= csv("UpdateAHearing.csv").circular
  val PutUpdateHearingReq= scenario(scenarioName = "13.Update.Hearing.PUT")
    .feed(PutUpdateHearingReqData)
    .exec(http(requestName="13.Update.Hearing.PUT")
      .put("/hearings/${case_id}")
      .headers(Environment.headers)
      .body(ElFileBody("bodies/UpdateHearing.json")).asJson
      .check(status.is(202))
      .check(bodyString.saveAs("BODY12")))
    .exec{
      session =>
        println(session("BODY12").as[String])
        session
    }
}
