package uk.gov.hmcts.reform.hmi.performance.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

// Provides the Tenant, ClientID, ClientSecret, Scope, grantype and captures the token and stores it in bearerx

object OAuth {
  val OAuthData= csv("OAuth.csv").circular

  val tenant        = "${Tenant}";
  val clientId      = "${ClientID}";
  val clientSecret  = "${ClientSecret}";
  val scope         = "${Scope}";
  val granttype     ="${grantype}"


  //val baseUrl = "vh-video-api-preprod.azurewebsites.net";
  val header        = Map("Content-Type" -> """application/x-www-form-urlencoded""");
  val authURI       = "https://login.microsoftonline.com";
  //var datets = ((((new Timestamp(new Date().getTime())).toString) + "Z").replace(" ", "T")).toString

  val auth = scenario("GetToken")
    .feed(OAuthData)
    .exec(http("Microsoft Token Generation")
      .post(s"$authURI/$tenant/oauth2/v2.0/token")
      .formParam("scope", scope)
      .formParam("grant_type", granttype)
      .formParam("client_secret", clientSecret)
      .formParam("client_id", clientId)

      .headers(header).check(status.is(200))
      .check(jsonPath("$..access_token").saveAs("bearerx")))
      .exec{
        session =>
//          println(session("bearerx").as[String])
//          println(session)
          session
    }

}
