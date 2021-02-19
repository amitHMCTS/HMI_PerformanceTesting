package uk.gov.hmcts.reform.hmi.performance.scenarios.snl
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import scala.concurrent.duration.DurationInt

object CreateHearingSchedule {

  def Home()= {
    val httpProtocol = http
      .baseUrl("https://hmcts-training.casehq.net")
      .disableFollowRedirect
      .doNotTrackHeader("1")
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36")

    val headers_0 = Map(
      "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
      "accept-encoding" -> "gzip, deflate, br",
      "accept-language" -> "en-US,en;q=0.9",
      "sec-fetch-dest" -> "document",
      "sec-fetch-mode" -> "navigate",
      "sec-fetch-site" -> "none",
      "sec-fetch-user" -> "?1",
      "upgrade-insecure-requests" -> "1")
//
//    val headers_1 = Map(
//      "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
//      "accept-encoding" -> "gzip, deflate, br",
//      "accept-language" -> "en-US,en;q=0.9",
//      "origin" -> "https://hmcts-training.casehq.net",
//      "sec-fetch-dest" -> "document",
//      "sec-fetch-mode" -> "navigate",
//      "sec-fetch-site" -> "same-origin",
//      "sec-fetch-user" -> "?1",
//      "upgrade-insecure-requests" -> "1")
//
//    val headers_2 = Map(
//      "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
//      "accept-encoding" -> "gzip, deflate, br",
//      "accept-language" -> "en-US,en;q=0.9",
//      "sec-fetch-dest" -> "document",
//      "sec-fetch-mode" -> "navigate",
//      "sec-fetch-site" -> "same-origin",
//      "sec-fetch-user" -> "?1",
//      "upgrade-insecure-requests" -> "1")
//
//    val headers_3 = Map(
//      "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
//      "accept-encoding" -> "gzip, deflate, br",
//      "accept-language" -> "en-US,en;q=0.9",
//      "sec-fetch-dest" -> "iframe",
//      "sec-fetch-mode" -> "navigate",
//      "sec-fetch-site" -> "same-origin",
//      "upgrade-insecure-requests" -> "1")
//
//    val headers_4 = Map("Upgrade-Insecure-Requests" -> "1")

    //===========HOME PAGE================
//    val chain_0 =
      exec(http("request_0:GET_https://hmcts-training.casehq.net/casehqtraining/CMSHomeAction.do")
      .get("/casehqtraining/CMSHomeAction.do").headers(headers_0)
      .check(bodyString.saveAs("BODYx")))
      .exec{
        session =>
          println(session("BODYx").as[String])
//          println("HTTP.ResponseCode-->",session("Statusx").as[String])
          session
      }
//      .pause(68)
//
//      //===========LOGIN PAGE================
//      .exec(http("request_1:POST_https://hmcts-training.casehq.net/casehqtraining/j_security_check")
//        .post("/casehqtraining/j_security_check").headers(headers_1)
//        .formParam("j_username", "amit.sinha@hmcts.net")
//        .formParam("j_password", "password")
//        .formParam("submit", "Login")
//        .check(status.is(303)))
//
//      .exec(http("request_2:GET_https://hmcts-training.casehq.net/casehqtraining/CMSHomeAction.do")
//        .get("/casehqtraining/CMSHomeAction.do").headers(headers_2))
//      .pause(468.milliseconds)
//
//      .exec(http("request_3:GET_https://hmcts-training.casehq.net/casehqtraining/loading.html")
//        .get("/casehqtraining/loading.html").headers(headers_3))
//
//      .exec(http("request_4:GET_https://hmcts-training.casehq.net/casehqtraining/loading.html")
//        .get("/casehqtraining/loading.html").headers(headers_4))
//      .pause(54)
//
//      //===========LOGOUT================
//      .exec(http("request_74:GET_https://hmcts-training.casehq.net/casehqtraining/LogoutAction.action?XSRF-TOKEN=685f16c5-769c-4f7f-bcae-6b5e18e9b866")
//        .get("/casehqtraining/LogoutAction.action?XSRF-TOKEN=685f16c5-769c-4f7f-bcae-6b5e18e9b866")
//        .headers(headers_2)
//        .check(status.is(302)))
//      .exec(http("request_75:GET_https://hmcts-training.casehq.net/casehqtraining/CMSHomeAction.do?XSRF-TOKEN=685f16c5-769c-4f7f-bcae-6b5e18e9b866")
//        .get("/casehqtraining/CMSHomeAction.do?XSRF-TOKEN=685f16c5-769c-4f7f-bcae-6b5e18e9b866")
//        .headers(headers_2)
//        .check(bodyBytes.is(RawFileBody("/recordedsimulation2/0075_response.html"))))

//=========================================================================================
//
//    exec(http("01.01.Admin.Portal.Home").get(adminURL + "/api/config").headers(adminWebHeaders.headers_0)
//        .check(jsonPath("$.client_id").saveAs("clientIdx"))
//        .check(jsonPath("$.tenant_id").saveAs("tenantIdx"))
//        .check(regex("""redirect_uri":"https://(.*?)/""").saveAs("adminUri")))
//      .pause(Environment.minTime,Environment.maxTime)
//
//      .exec(http("01.02.Admin.Portal.Home")
//        .get(authURL + "/${tenantIdx}/oauth2/authorize?response_type=id_token&client_id=${clientIdx}&redirect_uri="+adminURL+"/home&state=40bdbd96-17ff-4d6b-93bc-828b316f2c2f&client-request-id=65ac9818-81db-48c9-82f9-9041327f3a46&x-client-SKU=Js&x-client-Ver=1.0.15&nonce=9a34b4ca-f00c-476d-b482-d868b0de901c")
//        .headers(adminWebHeaders.headers_1).check(status.is(session => 200)))
//      .pause(Environment.minTime,Environment.maxTime)
//
//      .exec(http("01.03.Admin.Portal.Home")
//        .get(authURL + "/${tenantIdx}/oauth2/authorize?response_type=id_token&client_id=${clientIdx}&redirect_uri="+adminURL+"/home&state=40bdbd96-17ff-4d6b-93bc-828b316f2c2f&client-request-id=65ac9818-81db-48c9-82f9-9041327f3a46&x-client-SKU=Js&x-client-Ver=1.0.15&nonce=9a34b4ca-f00c-476d-b482-d868b0de901c&sso_reload=true")
//        .headers(adminWebHeaders.headers_1).check(status.is(session => 200))
//        .check(regex("""apiCanary":"(.*?)",""").saveAs("apiCanaryIdx"))
//        .check(regex("""canary":"(.*?)",""").saveAs("canaryIdx"))
//        .check(regex("""hpgid":(.*?),""").saveAs("hpgIdx"))
//        .check(regex("""sessionId":"(.*?)",""").saveAs("sessionIdx"))
//        .check(regex("""sCtx":"(.*?)",""").saveAs("CtxIdx"))
//        .check(regex("""sFT":"(.*?)",""").saveAs("flowTokenx")))
//      .pause(Environment.minTime,Environment.maxTime)
//
//      .exec(http("01.04.Admin.Portal.Home").post(authURL + "/common/GetCredentialType?mkt=en-GB")
//        .headers(adminWebHeaders.headers_2).body(ElFileBody("data/BookLogin.json")).asJson)
//      .pause(Environment.minTime,Environment.maxTime)
  }
}
