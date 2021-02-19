package uk.gov.hmcts.reform.hmi.performance.scenarios.resources
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object PutUpdateResourceLocation {
  val PutUpdateResourceLocation = scenario(scenarioName = "44.Update.ResourceLocation.Post")
    .exec(http(requestName="44.Update.ResourceLocation.Post")
      .put(s"/resources/LocationId")
      .headers(Environment.headers)
      .body(ElFileBody("bodies/PutUpdateResourceLocation.json")).asJson
      .check(status.is(202))
      .check(bodyString.saveAs("BODY2")))
    .exec{
      session =>
        println(session("BODY2").as[String])
        session
    }
}