package mukesh_assignment5;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class assignment_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		// WebDriver driver = new ChromeDriver();

		assignment_5 m1 = new assignment_5();
		m1.method1();

	}

	public void method1() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		System.out.println("Task 1");

		String url = driver.getCurrentUrl();
		System.out.println(url);
		boolean endwith = url.endsWith("login");
		System.out.println(endwith);
		boolean contains = url.contains("demo");
		System.out.println(contains);

		String title = driver.getTitle();
		boolean containstitle = title.contains("HRM");
		System.out.println(containstitle);
		System.out.println(
				"===============================================================================================================");
		System.out.println("Task 2");

		WebElement i = driver.findElement(By.xpath("//*[@class=\"oxd-icon orangehrm-sm-icon\"]"));
		if (i.isDisplayed()) {
			System.out.println("Logo displayed");
		}
		System.out.println(
				"===============================================================================================================");
		System.out.println("Task 3");

		int count = driver.findElements(By.xpath("//*[@class=\"oxd-icon orangehrm-sm-icon\"]")).size();
		if (count == 4) {
			System.out.println("Footer has 4 social media icons");
		} else {
			System.out.println("Footer does not have 4 social media icons");
		}
		System.out.println(
				"===============================================================================================================");
		System.out.println("Task 4");

		Map<String, String> socialMediaURLs = new HashMap<String, String>();
		WebElement facebookIcon = driver.findElement(By.xpath("//a[@href=\"https://www.facebook.com/OrangeHRM/\"]"));
		socialMediaURLs.put("Facebook", facebookIcon.getAttribute("href"));
		WebElement twitterIcon = driver.findElement(By.xpath("//a[@href=\"https://twitter.com/orangehrm?lang=en\"]"));
		socialMediaURLs.put("Twitter", twitterIcon.getAttribute("href"));
		WebElement youtubeIcon = driver.findElement(By.xpath("//a[@href=\"https://www.youtube.com/c/OrangeHRMInc\"]"));
		socialMediaURLs.put("Youtube", youtubeIcon.getAttribute("href"));
		WebElement linkedinIcon = driver
				.findElement(By.xpath("//a[@href=\"https://www.linkedin.com/company/orangehrm/mycompany/\"]"));
		socialMediaURLs.put("Linkedin", linkedinIcon.getAttribute("href"));
		System.out.println(socialMediaURLs);

		System.out.println(
				"===============================================================================================================");
		System.out.println("Task 5");

		String[] socialMediaUrls = new String[4];
		socialMediaUrls[0] = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[3]/div[1]/a[1]"))
				.getAttribute("href");
		socialMediaUrls[1] = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[3]/div[1]/a[2]"))
				.getAttribute("href");
		socialMediaUrls[2] = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[3]/div[1]/a[3]"))
				.getAttribute("href");
		socialMediaUrls[3] = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[3]/div[1]/a[4]"))
				.getAttribute("href");

		boolean youtubeFound = false;
		for (String url1 : socialMediaUrls) {
			if (url1.contains("youtube")) {
				youtubeFound = true;
				break;
			}
		}
		System.out.println("Youtube found : " + youtubeFound);
		driver.quit();
	}
	
	
}
