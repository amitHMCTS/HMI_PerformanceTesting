package uk.gov.hmcts.reform.hmi.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment

object DeleteAHearingRequest {
  val DeleteHearingData=csv("DeleteAHearingRequest.csv").circular

  val DeleteHearing = scenario(scenarioName = "060_DeleteHearing_DELETE")
    .feed(DeleteHearingData)
    .exec(http(requestName="Delete_hearings_Request")
      .delete("/hearings/")
      .headers(Environment.headers)
      .body(StringBody("""{
      "deleteMethod": "${deleteMethod}",
      "deleteMessage": "${deleteMessage}",
      "listingRequestId": "${listingRequestId}",
      "hearingIdCaseHQ": "${hearingIdCaseHQ}" }
        """)).asJson
      .check(status.is(200))
      .check(bodyString.saveAs("BODY1")))
    .exec{
      session =>
        println(session("BODY1").as[String])
        session
    }
}
