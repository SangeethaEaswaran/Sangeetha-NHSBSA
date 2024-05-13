package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pageObjects.SearchJobsPageObjects;
import utils.TestContext;

import java.util.List;

public class SearchJobsStepDefinitions {
    TestContext testContext;
    private WebDriver driver;
    SearchJobsPageObjects searchJobsPage = new SearchJobsPageObjects();
    public SearchJobsStepDefinitions(TestContext context){
        context = testContext;
    }
    @Before
    public void setUp(){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximised");
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
//        System.out.println("driver=>"+ driver);
    }
    @Given("I am a job-seeker on NHS Jobs website")
    public void navigate_to_nhs_job_search_website() {
        searchJobsPage.launchNHSJobSearch();
    }
    @When("I select more search options link")
    public void select_more_options(){
        searchJobsPage.selectMoreOptionsLink();
    }

    @And("^I search for job by (.*) (.*)$")
    public void job_search(String key, String value) {
        searchJobsPage.searchJobsBy(key, value);
    }
    @When("^I put my preferences keyword-(.*),location-(.*) into the Search functionality$")
    public void search_for_jobs(String keyword, String location) {
        System.out.println("keyword"+keyword);
        searchJobsPage.searchJobs(keyword,location);
    }
    @Then("I should get a list of jobs which matches my preferences")
    public void verify_list_of_jobs() {
        searchJobsPage.verifyJobsDisplay();
    }
    @Then("sort my search results with the newest Date Posted")
    public void sort_jobs() {
        searchJobsPage.sortJobs();
    }

    @Then("I refine my search for below and apply filters")
    public void refine_search(List<String> refineCriteria) {
        System.out.println("refineCriteria"+refineCriteria);
        searchJobsPage.refineSearch();
    }

    @After
    public void quit(){
//        try {
////            driver.wait(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        driver.quit();
    }
}
