package uk.gov.hmcts.reform.hmi.performance

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import uk.gov.hmcts.reform.hmi.performance.simulation.HMIScenarios


object GatlingRun {
  def main(args: Array[String]): Unit = {

    val simClass = classOf[HMIScenarios].getName
//    val simClass = classOf[SNLscenarios].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)
    Gatling.fromMap(props.build)
  }
}