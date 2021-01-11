package WorkFlows;

import Extensions.apiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;

// Business Flow, That binds several steps to one action
public class apiFlows extends commonOps
{
    @Step("Get Team From Grafana")
    public static String getTeamProperty(String Jpath)
    {
        Response response = apiActions.get("/api/teams/search");
        return apiActions.extractFromJSON(response,Jpath);
    }

    @Step("Create New Team In Grafana")
    public static void postTeam(String name, String email)
    {
        requestParams.put("name",name);
        requestParams.put("email",email);
        apiActions.post(requestParams, "/api/teams");
    }

    @Step("Update Team In Grafana")
    public static void updateTeam(String name, String email, String id)
    {
        requestParams.put("name",name);
        requestParams.put("email",email);
        apiActions.put(requestParams, "/api/teams/" + id);
    }

    @Step("Delete Team In Grafana")
    public static void deleteTeam(String id)
    {
        apiActions.delete(id);
    }
}
