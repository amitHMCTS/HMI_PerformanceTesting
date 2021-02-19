package uk.gov.hmcts.reform.hmi.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment

object GetHearingInfoByID {
  val GetHearingData= csv("GetHearingInfoByID.csv").circular

  val GetHearing = scenario(scenarioName = "040_GetHearing_GET")
    .feed(GetHearingData)
    .exec(http(requestName="get_request_hearings")
      .get("/hearings?hearingDate=${hearingDate}&hearingType=${hearingType}&hearingIdCaseHQ=${hearingIdCaseHQ}")
      .headers(Environment.headers)
      .check(status.is(200))
      .check(bodyString.saveAs("BODY1")))
    .exec{
      session =>
        println(session("BODY1").as[String])
        session
    }
}
