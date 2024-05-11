import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchJobs {
    @Test
    public void dummyTest(){
        WebDriver driver = new ChromeDriver();
        System.out.println("title =>"+ driver.getTitle());
driver.get("https://www.jobs.nhs.uk/candidate/search");
driver.findElement(By.id("accept-cookies")).click();
driver.findElement(By.id("keyword")).sendKeys("QA");
driver.findElement(By.id("search")).click();
//driver.quit();
    }
}
