package base;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.http.HttpDsl.http;

public abstract class BaseSimulation extends Simulation {
    private Config config = ConfigFactory.load();

    public Integer addUsersPerStep = Integer.parseInt(System.getProperty("addUsersPerStep", "1"));
    public Integer stepRumpTime = Integer.parseInt(System.getProperty("stepRumpTime", "1"));
    public Integer stepTime = Integer.parseInt(System.getProperty("stepTime", "1"));
    public Integer stepCnt = Integer.parseInt(System.getProperty("stepCnt", "1"));
    public Integer stabilityStepTime = Integer.parseInt(System.getProperty("stabilityStepTime", "2"));
    public String env = System.getProperty("env", "testint");

    public String baseUrl = config.getString(env + ".url");

    public HttpProtocolBuilder httpProtocol =
            http.baseUrl(baseUrl)
                    .acceptHeader("application/json")
                    .contentTypeHeader("application/json")
                    .header("Authorization", "Bearer NWM4Y2RiMWQtYWNjNC00YzU0LTgxOWYtZjdiNDA3MzYxZTY0");
}