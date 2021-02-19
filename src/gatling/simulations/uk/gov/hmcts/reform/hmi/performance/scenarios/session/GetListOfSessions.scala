package uk.gov.hmcts.reform.hmi.performance.scenarios.session
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment


object GetListOfSessions {
  val GetListOfSessions = scenario(scenarioName = "31.Get.List.Of.Sessions")
    .exec(http(requestName="31.Get.List.Of.Sessions")
      .get("/sessions?requestSessionType=ADHOC")
      .headers(Environment.headers)
      .check(status.is(200))
      .check(bodyString.saveAs("BODY31")))
    .exec{
      session =>
        println(session("BODY31").as[String])
        session
    }
}
