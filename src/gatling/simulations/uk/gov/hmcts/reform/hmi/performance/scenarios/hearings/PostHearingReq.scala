package uk.gov.hmcts.reform.hmi.performance.scenarios.hearings
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment

object PostHearingReq {

  val PostHearingReq = scenario(scenarioName = "11.Request.Hearing.Post")
    .exec(http(requestName="11.RequestHearing.Post")
      .post("/hearings/")
      .headers(Environment.headers)
      .body(ElFileBody("bodies/RequestHearing.json")).asJson
      .check(status.is(202))
      .check(bodyString.saveAs("BODY11")))
    .exec{
      session =>
        println(session("BODY11").as[String])
        session
    }
}
