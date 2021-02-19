package uk.gov.hmcts.reform.hmi.performance.scenarios.utils

object Environment {

//  val baseURL = "https://hmi-apim-svc-dev.azure-api.net/hmi"
  //val baseURL = "https://hmi-apim.preview.platform.hmcts.net/hmi/"
  //val baseURL = "https://hmi-apim.perftest.platform.hmcts.net/hmi/"
  //val baseURL = "https://hmi-apim.aat.platform.hmcts.net/hmi/"
//  val baseURL = "https://hmi-apim.emulator.platform.hmcts.net/hmi"
//  val baseURL = "https://hmi-apim-svc-sbox.azure-api.net/hmi"
  val baseURL = "https://hmi-apim.staging.platform.hmcts.net/hmi"
 val headers = Map(
  //"Ocp-Apim-Subscription-Key" -> "50048c93e1624ad29726a6b7beb25df8",
 // "Ocp-Apim-Subscription-Key" -> "ecea5d25107e4348b3e3c2c9ee12e023",
    "Ocp-Apim-Subscription-Key" -> "ecea5d25107e4348b3e3c2c9ee12e023",


    "Source-System"             -> "CFT",
    "Request-Type"              -> "THEFT",
//   "Request-Type"             -> "ASSAULT",
    "Request-Processed-At"      -> "2020-11-18T20:20:39+00:00",
    "Accept"                    -> "application/json",
    "Request-Created-At"        -> "2020-11-18T20:20:39+00:00",
    "Destination-System"        -> "SNL",
 // "Destination-System"        -> "MOCK",
    "transactionIdHMCTS"        -> "${transaction_idhmcts}",
    "Content-Type"              ->"application/json",
     //"charset"                  ->"utf-8",
   "Authorization" -> "bearer ${bearerx}")

// val csvFeeder = csv("Feeder_file.csv").random

}
