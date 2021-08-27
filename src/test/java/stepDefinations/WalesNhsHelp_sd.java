package stepDefinations;

import driverFactory.DriverClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjectModel.NhsWalesHelpPage;
import util.ConfigReader;

import java.io.IOException;
import java.util.List;

public class WalesNhsHelp_sd {
    private WebDriver driver;
    private ConfigReader configReader = new ConfigReader();
    private NhsWalesHelpPage walesHelpPage = new NhsWalesHelpPage(DriverClass.getDriver());

    @Given("I am on the help paying nhs costs page")
    public void iAmOnTheHelpPayingNhsCostsPage() throws IOException {
        DriverClass.getDriver().get(configReader.init_prop().getProperty("url"));
    }

    @And("I am a person from {string}")
    public void iAmAPersonFrom(String countryName) {
        walesHelpPage.clickOnStartBtn();
        walesHelpPage.selectLivingCountry(countryName);
    }

    @Given("I am {int} years old and I enter the Day as {string} and Month as {string} and Year as {string}")
    public void iAmYearsOldAndIEnterTheDayAsAndMonthAsAndYearAs(int age, String day, String month, String year) {
        walesHelpPage.setDateOfBirth(day, month, year, age);
    }

    @And("I am in full time education")
    public void iAmInFullTimeEducation() {

        walesHelpPage.selectYes();
    }

    @When("click on next button")
    public void clickOnNextButton() {
        walesHelpPage.clickOnNextBtn();
    }
    @Then("I can see the nhs cost help result page title contains {string}")
    public void iCanSeeTheNhsCostHelpResultPageTitleContains(String pageTitle) {
        Assert.assertTrue(walesHelpPage.getPageTitle().contains(pageTitle));
        System.out.println("Page title of the result page is verified");
    }

    @And("I verify message as {string} with full time education")
    public void iVerifyMessageAsWithFullTimeEducation(String message) {
        Assert.assertTrue(walesHelpPage.getMessage().contains(message));
        System.out.println("Successful message is verified");
    }
    @And("I can see following help get free")
    public void iCanSeeFollowingHelpGetFree(DataTable expectedHelpList) {
        List<String> expectedList=expectedHelpList.asList();
        System.out.println(expectedList);
        List<String> ActualList=walesHelpPage.getListOfGetFree();
        System.out.println(ActualList);
        Assert.assertEquals(expectedList,ActualList);
    }
//*****************************************************************************
    @And("I am not in full time education")
    public void iAmNotInFullTimeEducation() {
        walesHelpPage.selectNo();
        walesHelpPage.clickOnNextBtn();
    }

    @And("I dont live with partner")
    public void iDontLiveWithPartner() {
        walesHelpPage.liveWithPartner();
        walesHelpPage.clickOnNextBtn();
    }

    @And("I dont claim benefits")
    public void iDontClaimBenefits() {
        walesHelpPage.selectNo();
        walesHelpPage.clickOnNextBtn();    }

    @And("I am not pregnant")
    public void iAmNotPregnant() {
        walesHelpPage.selectNo();
        walesHelpPage.clickOnNextBtn();
    }

    @And("I dont have injury serving armed forces")
    public void iDontHaveInjuryServingArmedForces() {
        walesHelpPage.selectNo();
        walesHelpPage.clickOnNextBtn();
    }

    @And("I dont have diabetes and glucoma")
    public void iDontHaveDiabetesAndGlucoma() {
        walesHelpPage.selectNo();
        walesHelpPage.clickOnNextBtn();
        walesHelpPage.selectNo();
        walesHelpPage.clickOnNextBtn();
    }

    @And("I dont live in care home")
    public void iDontLiveInCareHome() {
        walesHelpPage.selectNo();
        walesHelpPage.clickOnNextBtn();

    }

    @And("I have no savings")
    public void iHaveNoSavings() {
        walesHelpPage.selectNo();

    }
//****************************************************************
    @And("I do live with partner")
    public void iDoLiveWithPartner() {
        walesHelpPage.liveWithPartner();
        walesHelpPage.clickOnNextBtn();
    }

    @And("I do have injury serving armed forces")
    public void iDoHaveInjuryServingArmedForces() {
        walesHelpPage.selectYes();
        walesHelpPage.clickOnNextBtn();
    }

    @And("I do have diabetes and glucoma")
    public void iDoHaveDiabetesAndGlucoma() {
        walesHelpPage.haveDiabetesAndGlucoma();

    }
//********************************************************

    @And("I do live in care home")
    public void iDoLiveInCareHome() {
        walesHelpPage.selectYes();
        walesHelpPage.clickOnNextBtn();

    }

    @And("I do get help from council")
    public void iDoGetHelpFromCouncil() {
        walesHelpPage.selectYes();
          }

    @And("I do not get help from council")
    public void iDoNotGetHelpFromCouncil() {
        walesHelpPage.selectNo();
        walesHelpPage.clickOnNextBtn();
    }

    @And("I do have savings of £{int}")
    public void iDoHaveSavingsOf£(int saving) {
        walesHelpPage.selectYes();
    }

    @And("I claim benefits or tax credit")
    public void iClaimBenefitsOrTaxCredit() {
        walesHelpPage.selectYes();
        walesHelpPage.clickOnNextBtn();
    }

    @And("we received universal credit payment")
    public void weReceivedUniversalCreditPayment() {
        walesHelpPage.getUniversalCredit();
    }

    @And("we have responsibility with child")
    public void weHaveResponsibilityWithChild() {
        walesHelpPage.selectYes();
        walesHelpPage.clickOnNextBtn();
    }

    @And("we have a combined take home pay in last credit period")
    public void weHaveACombinedTakeHomePayInLastCreditPeriod() {
        walesHelpPage.selectYes();
    }

    @And("I can see following help I get Money off")
    public void iCanSeeFollowingHelpIGetMoneyOff(DataTable expectedHelp) {
        List<String> expectedList=expectedHelp.asList();
        System.out.println("Expected List--->"+expectedList);
        List<String> ActualList=walesHelpPage.getListOfMoneyOff();
        System.out.println("Actual list---->"+ActualList);
        Assert.assertEquals(expectedList,ActualList);

    }
}