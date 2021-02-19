package uk.gov.hmcts.reform.hmi.performance.scenarios.resources
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment
import io.gatling.core.Predef._
import io.gatling.http.Predef._
object PutUpdateResourceUser {
  val PutUpdateResourceUser = scenario(scenarioName = "43.Update.ResourceUser.Post")
    .exec(http(requestName="43.Update.ResourceUser.Post")
      .put(s"/resources/userId")
      .headers(Environment.headers)
      .body(ElFileBody("bodies/PutUpdateResourceUser.json")).asJson
      .check(status.is(202))
      .check(bodyString.saveAs("BODY2")))
    .exec{
      session =>
        println(session("BODY2").as[String])
        session
    }
}
