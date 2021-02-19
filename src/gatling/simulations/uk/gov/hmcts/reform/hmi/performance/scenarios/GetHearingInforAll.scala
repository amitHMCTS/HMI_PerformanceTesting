package uk.gov.hmcts.reform.hmi.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment

object GetHearingInforAll {


  val GetHearingAll = scenario(scenarioName = "050_GetHearing_GET")
    .exec(http(requestName="get_request_hearings_all")
      .get("/hearings")
      .headers(Environment.headers)
      .check(status.is(200))
      .check(bodyString.saveAs("BODY1")))
    .exec{
      session =>
        println(session("BODY1").as[String])
        session
    }
}
