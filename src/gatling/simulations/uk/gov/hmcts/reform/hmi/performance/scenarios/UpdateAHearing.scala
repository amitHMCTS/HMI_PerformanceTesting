package uk.gov.hmcts.reform.hmi.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment

object UpdateAHearing {
  val UpdateHearingData= csv("UpdateAHearing.csv").circular

  val UpdateAHearing= scenario(scenarioName = "030_UpdateAHearing_PUT")
    .feed(UpdateHearingData)
    .exec(http(requestName="Update_hearings_Request")
      .put("/hearings/${case_id}")
      .headers(Environment.headers)
      .body(ElFileBody("bodies/UpdateHearing.json")).asJson
      .check(status.is(202))
      .check(bodyString.saveAs("BODY2")))
//    .exec{
//      session =>
//        println(session("BODY2").as[String])
//        session
//    }
}
