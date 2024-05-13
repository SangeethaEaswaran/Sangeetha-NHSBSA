package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SearchJobsPageObjects {
    private WebDriver driver = new ChromeDriver();;
    public void launchNHSJobSearch() {
        String url = "https://www.jobs.nhs.uk/candidate/search";
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.id("accept-cookies")).click();
    }
    public void searchJobs(String keyword, String location){
        driver.findElement(By.id("keyword")).sendKeys(keyword);
        driver.findElement(By.xpath("//*[@data-test='search-location-input']")).sendKeys(location);
        driver.findElement(By.id("search")).click();
    }
    public void verifyJobsDisplay(){
        By searchResult = By.xpath("//*[@data-test='search-result-query']");
        WebElement element =driver.findElement(searchResult);
        Assert.assertTrue(element.isDisplayed());
        System.out.println(element.isDisplayed()+ element.getText());
    }
    public void selectMoreOptionsLink(){
        driver.findElement(By.id("searchOptionsBtn")).click();
    }
    public void sortJobs(){
        Select dropdown = new Select(driver.findElement(By.id("sort")));
        dropdown.selectByValue("publicationDateDesc");
        driver.quit();
    }

    public void refineSearch(){
        driver.findElement(By.xpath("//*[@data-test='filter-working-pattern']")).click();
        driver.findElement(By.xpath("//*[@data-test='working-pattern-full-time']")).click();

        driver.findElement(By.xpath("//*[@data-test='filter-contract-type']")).click();
        driver.findElement(By.xpath("//*[@data-test='contract-type-permanent']")).click();

        driver.findElement(By.xpath("//*[@data-test='refine-search-button']")).click();
    }

    public void searchJobsBy(String key, String value){
        switch(key){
            case "job-reference":
                driver.findElement(By.xpath("//*[@data-test='search-jobReference-input']")).sendKeys(value);
                break;
            case "employer":
                driver.findElement(By.xpath("//*[@data-test='search-employer-input']")).sendKeys(value);
                break;
            case "keyword":
                driver.findElement(By.xpath("//*[@data-test='search-jobTitle-input']")).sendKeys(value);
                break;
            case "location":
                driver.findElement(By.xpath("//*[@data-test='search-location-input']")).sendKeys(value);
                break;
            default:
                break;
        }
        driver.findElement(By.id("search")).click();
    }
}
