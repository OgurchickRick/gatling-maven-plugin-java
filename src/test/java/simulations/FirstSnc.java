package simulations;

import base.BaseSimulation;
import io.gatling.javaapi.core.PopulationBuilder;
import requests.FirstReq;

import static io.gatling.javaapi.core.OpenInjectionStep.atOnceUsers;

public class FirstSnc extends BaseSimulation {
    PopulationBuilder scn =  new FirstReq().createScenario("First SNC").injectOpen(atOnceUsers(addUsersPerStep)).protocols(httpProtocol);

    {
        setUp(scn);
    }

}
