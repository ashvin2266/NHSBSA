package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class NhsWalesHelpPage {
    private WebDriver driver;
    private String year;
    @FindBy(css = "#next-button")
    WebElement startBtn;
    @FindBy(css = "#label-wales")
    WebElement walesCountry;
    @FindBy(css = "#label-england")
    WebElement englandCountry;
    @FindBy(css = "#label-scotland")
    WebElement scotlandCountry;
    @FindBy(css = "#label-nire")
    WebElement northIrelandCountry;
    @FindBy(css = "#next-button")
    WebElement nextBtn;
    @FindBy(css = "#dob-day")
    WebElement dayEle;
    @FindBy(id = "dob-month")
    WebElement monthEle;
    @FindBy(id = "dob-year")
    WebElement yearEle;
    @FindBy(id = "label-yes")
    WebElement yesEle;
    @FindBy(id = "label-no")
    WebElement noEle;
    @FindBy(xpath = "//h2[@class='heading-large']")
    WebElement successMsg;
    @FindBy(xpath = "//ul[@class='form-hint-list']//li")
    List<WebElement> helpListEl;
    @FindBy(xpath = "//main[@id='content']//ul[2]//li")
    List<WebElement> moneyOffEle;
    @FindBy(css = "label[for='yes-universal']")
    WebElement yesUniversalCredit;



    public NhsWalesHelpPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnStartBtn(){

        startBtn.click();
    }
    public String getPageTitle(){
        String actualPageTitle=driver.getTitle();
        return actualPageTitle;}


    public void selectLivingCountry(String countryName) {
        if (countryName.equalsIgnoreCase("England")) {
            englandCountry.click();
        } else if (countryName.equalsIgnoreCase("Scotland")) {
            scotlandCountry.click();
        } else if (countryName.equalsIgnoreCase("Wales")) {
            walesCountry.click();
        } else if (countryName.equalsIgnoreCase("Northern Ireland")) {
            northIrelandCountry.click();
        } else {
            System.out.println("Country name is not in list");
        }
        nextBtn.click();
    }
    public void clickOnNextBtn(){
        nextBtn.click();
    }
    public void setDateOfBirth(String day, String month, String year, int expAge){
        int currentYear=2021;
        int ActualAge=currentYear- Integer.valueOf(year);
        if (ActualAge==expAge){
            dayEle.sendKeys(day);
            monthEle.sendKeys(month);
            yearEle.sendKeys(String.valueOf(year));
            nextBtn.click();
        }
        else {
            System.out.println("Given age --->"+expAge + " not match with actual Age is---->"+ ActualAge);
        }

    }
    public void selectYes(){
        yesEle.click();
    }
    public void selectNo(){
        noEle.click();

    }

    public String getMessage(){
        String actualMessage=successMsg.getText();
        return actualMessage;
    }
    public void liveWithPartner(){
        yesEle.click();
            }
        public void haveDiabetesAndGlucoma(){
        yesEle.click();
        nextBtn.click();
        yesEle.click();
        nextBtn.click();
    }
    public List<String> getListOfGetFree() {
        List<String> helpList=new ArrayList<>();
        for(WebElement e: helpListEl) {
            String text=e.getText();
            helpList.add(text);
        }
        System.out.println(helpList);
        return helpList;

    }
    public List<String> getListOfMoneyOff() {
        List<String> getMoneyOffList=new ArrayList<>();
        for(WebElement e: moneyOffEle) {
            String text=e.getText();
            getMoneyOffList.add(text);
        }
        return getMoneyOffList;

    }
    public void getUniversalCredit(){
        yesUniversalCredit.click();
        nextBtn.click();
    }
}
