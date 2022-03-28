package TestCases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TC01_Guru99_Browser_Action 
{
	WebDriver w;

	@BeforeTest
	public void launch_browser() 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\Desktop\\selenium jar\\New folder\\chromedriver.exe");
		w = new ChromeDriver();

	}

	@Test
	public void Launch_the_browser_and_open_New_Demo_Tou_Website()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\Desktop\\selenium jar\\New folder\\chromedriver.exe");
		w = new ChromeDriver();
		w.get("http://demo.guru99.com/test/newtours/index.php");
		w.manage().window().maximize();
	}

	@Test
	public void Print_Page_title_Current_URL_and_Page_Source() {

		// 1. print page title
		w.get("https://demo.guru99.com/test/newtours/");
		String Page_Title = w.getTitle();
		System.out.println("Page Tital of  Guru99 Webside is:" + Page_Title);

		// 2. print current URL
		String current_url = w.getCurrentUrl();
		System.out.println("Current URL of Guru99 Webside is:" + current_url);

		// 3.print page source
		String Page_Source = w.getPageSource();
		System.out.println("Page Source of Guru99 Webside is:" + Page_Source);

	}

	@Test
	public void Print_Total_no_of_links_available_on_Website() 
	{
		List<WebElement> links = w.findElements(By.tagName("a"));
		int Total_links = links.size();
		System.out.println("Total links available on webside :" + Total_links);
	}

	@Test
	public void Validate_Page_Title_and_Login_to_new_demo_tour_webside() {
		String a = "Welcome: Mercury Tours";
		if (w.getTitle().equals(a))
		{
			// 1.enter UN
			WebElement UserName = w.findElement(By.name("userName"));
			UserName.sendKeys("abc");
			// 2.enter PWD
			WebElement password = w.findElement(By.name("password"));
			password.sendKeys("abc");
			// 3.click on submit
			WebElement submit = w.findElement(By.name("submit"));
			submit.click();
			System.out.println("Tital Of The Page Is Correct");
		}
		else 
		{
			System.out.println("Please Enter Corecct Page Tital");
		}
	}

	// close browser
	@AfterTest
	public void close_window()
	{
		w.quit();
	}

}
