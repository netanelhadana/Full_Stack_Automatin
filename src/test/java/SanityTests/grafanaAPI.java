package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.apiFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class grafanaAPI extends commonOps
{

//    @Test(description = "Test01: Get Team From Grafana")
//    @Description("Tests Description: Login to Grafana and Get Team")
//    public void test01_getTeam()
//    {
//        verifications.text(apiFlows.getTeamProperty("teams[0].name"),"jony");
//    }

    //Preconditions - Raise the Server(C:\Automation\grafana-7.1.5\bin\grafana-server)
    @Test(description = "Test01: Add Team and Verify")
    @Description("Tests Description: Add Team to Grafana and Verify it")
    public void test01_addTeamAndVerify()
    {
        apiFlows.postTeam("shimon","shimi3@gmail.com");
        verifications.text(apiFlows.getTeamProperty("teams[0].name"),"shimon");
    }

    @Test(description = "Test02: Update Team and Verify")
    @Description("Tests Description: Update Team in Grafana and Verify it")
    public void test02_updateTeamAndVerify()
    {
        apiFlows.updateTeam("yosi","yosi@gmail.com", "6");
        verifications.text(apiFlows.getTeamProperty("teams[0].name"),"yosi");
    }

    @Test(description = "Test03: Delete Team and Verify")
    @Description("Tests Description: Delete Team in Grafana and Verify it")
    public void test03_deleteTeamAndVerify()
    {
        apiFlows.deleteTeam("6");
        verifications.text(apiFlows.getTeamProperty("totalCount"),"0");
    }
}
