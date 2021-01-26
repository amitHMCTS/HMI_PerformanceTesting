package uk.gov.hmcts.reform.hmi.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment



object RequestHearing {

  val RequestHearing = scenario(scenarioName = "010_RequestHearing_Post")
    .exec(http(requestName="post_request_hearings")
      .post("/hearings/")
      .headers(Environment.headers)
      .body(ElFileBody("bodies/RequestHearing.json")).asJson
      .check(status.is(202))
//      .check(bodyString.saveAs("BODY2"))
      .check(status.saveAs("Statusx")))
//    .exec{
//      session =>
//        println(session("BODY2").as[String])
//        println("HTTP.ResponseCode-->",session("Statusx").as[String])
//        println("Create Request Hearing-->",session)
//        session
//    }
}