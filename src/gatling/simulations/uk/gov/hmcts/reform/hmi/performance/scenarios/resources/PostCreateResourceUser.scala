package uk.gov.hmcts.reform.hmi.performance.scenarios.resources
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment

object PostCreateResourceUser {
  val PostCreateResourceUser = scenario(scenarioName = "41.Create.ResourceUser.Post")
    .exec(http(requestName="41.Create.ResourceUser.Post")
      .post("/resources/user")
      .headers(Environment.headers)
      .body(ElFileBody("bodies/PostCreateResourceUser.json")).asJson
      .check(status.is(202))
      .check(bodyString.saveAs("BODY2")))
    .exec{
      session =>
        println(session("BODY2").as[String])
        session
    }
}
