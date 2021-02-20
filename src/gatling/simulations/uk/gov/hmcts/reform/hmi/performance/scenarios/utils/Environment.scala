package uk.gov.hmcts.reform.hmi.performance.scenarios.utils

object Environment {

  val baseURL = ""
 val headers = Map(
    "Ocp-Apim-Subscription-Key" -> "",
    "Source-System"             -> "CFT",
    "Request-Type"              -> "THEFT",
    "Request-Processed-At"      -> "2020-11-18T20:20:39+00:00",
    "Accept"                    -> "application/json",
    "Request-Created-At"        -> "2020-11-18T20:20:39+00:00",
    "Destination-System"        -> "SNL",
    "transactionIdHMCTS"        -> "${transaction_idhmcts}",
    "Content-Type"              ->"application/json",
   "Authorization" -> "bearer ${bearerx}")
}
