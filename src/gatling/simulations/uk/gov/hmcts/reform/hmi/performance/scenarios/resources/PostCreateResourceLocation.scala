package uk.gov.hmcts.reform.hmi.performance.scenarios.resources
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment

object PostCreateResourceLocation {
  val PostCreateResourceLocation = scenario(scenarioName = "42.Create.ResourceLocation.Post")
    .exec(http(requestName="42.Create.ResourceLocation.Post")
      .post("/resources/location")
      .headers(Environment.headers)
      .body(ElFileBody("bodies/PostCreateResourceLocation.json")).asJson
      .check(status.is(202))
      .check(bodyString.saveAs("BODY2")))
    .exec{
      session =>
        println(session("BODY2").as[String])
        session
    }
}
