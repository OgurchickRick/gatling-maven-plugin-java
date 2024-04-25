package requests;

import io.gatling.javaapi.core.ScenarioBuilder;
import templates.PersonalDataTmp;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class FirstReq {

    public ScenarioBuilder createScenario(String sncName) {

        PersonalDataTmp data = new PersonalDataTmp();
        data.set_sort("name");
        data.set_elements("Patient.id,Patient.name,Patient.snils,Patient.gender,Patient.birthDate,Patient.identifier");
        data.setOrganizationNot("mobileOrganization");
        data.set_page(1);
        data.set_count(15);
        data.setFamilyMissing(false);

        return scenario(sncName)
                .exec(http("GET-/box/ValueSet/mmdx-vs-treatmentPlan-businessStatus/$expand")
                        .get("/box/ValueSet/mmdx-vs-treatmentPlan-businessStatus/$expand")
                        .check(status().is(200)))
                .exec(http("POST-/backend-mm/logging/show/personal_data")
                        .post("/backend-mm/logging/show/personal_data")
                        .body(StringBody(data.toString()))
                        .check(status().is(200)));
    }
}
