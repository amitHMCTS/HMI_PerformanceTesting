package uk.gov.hmcts.reform.hmi.performance.simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import uk.gov.hmcts.reform.hmi.performance.scenarios.utils.Environment
import uk.gov.hmcts.reform.hmi.performance.scenarios.{OAuth, RequestHearing, UpdateAHearing}

class HMIScenarios extends Simulation
{
  val RequestHearingData1= csv("RequestHearingData1.csv").circular
  val RequestHearingData2= csv("RequestHearingData2.csv").circular
  val RequestHearingData3= csv("RequestHearingData3.csv").circular
  exec(flushCookieJar)
  exec(flushHttpCache)


//  val httpProtocol = http.baseUrl (url = Environment.baseURL)
  val BashURL = Environment.baseURL
   val httpProtocol = http
  .baseUrl(BashURL).proxy(Proxy("proxyout.reform.hmcts.net", 8080))
  val RH = scenario("RequestHearing").feed(RequestHearingData1)
    .exec(
      OAuth.auth,
      //Hearing
        RequestHearing.RequestHearing
    )
  val RHU = scenario("RequestUpdateHearing").feed(RequestHearingData2)
    .exec(
      OAuth.auth,
      //Hearing
      RequestHearing.RequestHearing,
      UpdateAHearing.UpdateAHearing
    )
  val  RHUC= scenario("RequestUpdateDeleteHearing").feed(RequestHearingData3)
    .exec(
      OAuth.auth,
      //Hearing
      RequestHearing.RequestHearing,
      UpdateAHearing.UpdateAHearing

    )

  //================Smoke Tests======================
//setUp(
// RH.inject(atOnceUsers(users = 1))
//// RHU.inject(atOnceUsers(users = 1))
//// RHUC.inject(atOnceUsers(users = 1))
// ).protocols(httpProtocol)

//Smokes test 50 executions over 10 min
//================10% Load Scenario================
//  setUp(
//    RH.inject(rampUsers(26) during (600)),
//    RHU.inject(nothingFor(60), rampUsers(5) during (600)),
//    RHUC.inject(nothingFor(120), rampUsers(10) during (600)),
//  ) .protocols(httpProtocol).maxDuration(1200)

  //================20% Load Scenario================
  /*
  setUp(
    RH.inject(rampUsers(52) during (600)),
    RHU.inject(nothingFor(60), rampUsers(10) during (600)),
    RHUC.inject(nothingFor(120), rampUsers(2) during (600))
  ) .protocols(httpProtocol)
    .maxDuration(1200)
*/
  //================30% Load Scenario================
  /*
  setUp(
    RH.inject(rampUsers(78) during (600)),
    RHU.inject(nothingFor(60), rampUsers(16) during (600)),
    RHUC.inject(nothingFor(120), rampUsers(4) during (600))
  ) .protocols(httpProtocol)
    .maxDuration(1200)
*/
//40% Load Scenario
/*
  setUp(
    RH.inject(rampUsers(103) during (600)),
    RHU.inject(nothingFor(60), rampUsers(21) during (600)),
    RHUC.inject(nothingFor(120), rampUsers(5) during (600))
  ) .protocols(httpProtocol)
.maxDuration(1200)
*/

  //50% load Load Scenario
 /* setUp(RH.inject(rampUsers(129) during (600)),
    RHU.inject(nothingFor(60), rampUsers(26) during (600)),
    RHUC.inject(nothingFor(120), rampUsers(7) during (600))
  ) .protocols(httpProtocol)
    .maxDuration(1200)
*/
  //60% load Load Scenario
/*   setUp(RH.inject(rampUsers(155) during (600)),
    RHU.inject(nothingFor(60), rampUsers(32) during (600)),
    RHUC.inject(nothingFor(120), rampUsers(8) during (600))
  ) .protocols(httpProtocol).maxDuration(1200)
*/
  //70% load Load Scenario
  /*setUp(RH.inject(rampUsers(180) during (600)),
    RHU.inject(nothingFor(60), rampUsers(37) during (600)),
    RHUC.inject(nothingFor(120), rampUsers(10) during (600))
  ) .protocols(httpProtocol).maxDuration(1200)
  */

  //80% load Load Scenario
  /*setUp(RH.inject(rampUsers(207) during (600)),
    RHU.inject(nothingFor(60), rampUsers(42) during (600)),
    RHUC.inject(nothingFor(120), rampUsers(11) during (600))
  ) .protocols(httpProtocol).maxDuration(1200)
*/

  //90% load Load Scenario
  /*setUp(RH.inject(rampUsers(233) during (600)),
    RHU.inject(nothingFor(60), rampUsers(47) during (600)),
    RHUC.inject(nothingFor(120), rampUsers(12) during (600))
  ) .protocols(httpProtocol).maxDuration(1200)
*/
//  100% load Load Scenario
    setUp(
    RH.inject(rampUsers(1240) during (3600)),
    RHU.inject(nothingFor(60), rampUsers(233) during (3600)),
    RHUC.inject(nothingFor(120), rampUsers(78) during (3600))
  ) .protocols(httpProtocol).maxDuration(4000)

  //200% of the load Scenario
//setUp(
//  RH.inject(rampUsers(2480) during (3600)),
//  RHU.inject(nothingFor(60), rampUsers(466) during (3600)),
//  RHUC.inject(nothingFor(120), rampUsers(156) during (3600))
//) .protocols(httpProtocol).maxDuration(4000)

  // 8hr soak Test
//  setUp(
//    RH.inject(rampUsers(9920) during (28800)),
//     RHU.inject(nothingFor(60), rampUsers(1864) during (28800)),
//     RHUC.inject(nothingFor(120), rampUsers(624) during (28800))
//   ) .protocols(httpProtocol).maxDuration(29000)

}
