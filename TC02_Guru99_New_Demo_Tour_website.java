package TestCases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;


public class TC02_Guru99_New_Demo_Tour_website
{
	WebDriver w;

	@BeforeTest
	public void launch_Browser()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\HP\\\\Desktop\\\\selenium jar\\\\New folder\\\\chromedriver.exe");
		w = new ChromeDriver();
		// 2.To Open URL
		w.get("http://demo.guru99.com/test/newtours/index.php");
		// 3.maximize windows
		w.manage().window().maximize();
	}

	@Test(priority = 2)
	public void validate_Login_with_invalid_data_and_print_error()
	{
		// 1.enter valid UN
		WebElement UN1 = w.findElement(By.name("userName"));
		UN1.clear();
		// 2.Enter Invalid PWD2
		WebElement PWD1 = w.findElement(By.name("password"));
		PWD1.sendKeys("1397");
		// 3click on submit button
		w.findElement(By.name("submit")).click();
		WebElement x = w.findElement(By.xpath("//span[contains(text(),'Enter your userName and password correct')]"));
		// 4.print error massage
		String a = x.getText();
		System.out.println(a);
		System.out.println("2.2validate login with invalid data and print error is pass");
	}

	@Test(priority = 3)
	public void Validate_sign_On_with_valid_data_and_click_on_sign_off() 
	{
		w.navigate().refresh();
		// 1.click on sign on
		w.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a"))
				.click();
		// 2.enter UN
		w.findElement(By.name("userName")).sendKeys("abc");
		// 3.enter PWD
		w.findElement(By.name("password")).sendKeys("abc");
		// 4.click on submit
		w.findElement(By.name("submit")).click();
		// 5.click on Sign off
		w.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).click();
		System.out.println("2.3:Validate sign on with valid data and click on sign off is pass");
	}

	@Test(priority = 4)
	public void Validate_Register_Form_with_valid_data()
	{
		// 1.click on register link
		w.findElement(By.linkText("REGISTER")).click();
		// 2.Enter valid first name
		w.findElement(By.name("firstName")).sendKeys("Rucha");
		// 3.Enter valid last name
		w.findElement(By.name("lastName")).sendKeys("Badgujar");
		// 4.Enter valid phonr no
		w.findElement(By.name("phone")).sendKeys("7466468638");
		// 5.Enter valid email
		w.findElement(By.name("userName")).sendKeys("ruchabadgujar01@gmail.com");
		// 6.Enter valid address
		w.findElement(By.name("address1")).sendKeys("old dhuler");
		// 7.Enter city
		w.findElement(By.name("city")).sendKeys("Dhule");
		// 8.Enter state
		w.findElement(By.name("state")).sendKeys("Maharasta");
		// 9.Enter postal code
		w.findElement(By.name("postalCode")).sendKeys("424001");
		// 10.Enter country
		Select s = new Select(w.findElement(By.name("country")));
		s.selectByValue("INDIA");
		// 11.Enter email
		w.findElement(By.name("email")).sendKeys("ruchabadgujar01@gmail.com");
		// 15.Enter password
		w.findElement(By.name("password")).sendKeys("badgujarrucha@1397");
		// 16.Enter confirm pass
		w.findElement(By.name("confirmPassword")).sendKeys("badgujarrucha@1397");
		// 17.click submit
		w.findElement(By.name("submit")).click();
		// 18.back to home page
		w.navigate().to("https://demo.guru99.com/test/newtours/");
		System.out.println("2.4:Validate Register Form with valid data is pass");
	}

	@Test(priority = 1)
	public void Validate_Flight_Form_with_valid_data() throws InterruptedException
	{
		// 1.click on flight link
		w.findElement(By.linkText("Flights")).click();
		Thread.sleep(5000);
		// 2.click on round click
		w.findElement(By.xpath("//tbody/tr[2]/td[2]/b[1]/font[1]/input[1]")).click();
		// 3.select no of passanger
		Select S1 = new Select(w.findElement(By.name("passCount")));
		S1.selectByValue("2");
		// 4.select no of departing from
		Select s1 = new Select(w.findElement(By.name("fromPort")));
		s1.selectByValue("London");
		// 5.select no of on(from month)
		Select s2 = new Select(w.findElement(By.name("fromMonth")));
		s2.selectByValue("3");
		// 6.select no of on (from day)
		Select s3 = new Select(w.findElement(By.name("fromDay")));
		s3.selectByValue("4");
		// 7.select from arriving in
		Select s4 = new Select(w.findElement(By.name("toPort")));
		s4.selectByValue("New York");
		// 8.select no of returning
		Select s5 = new Select(w.findElement(By.name("toMonth")));
		s5.selectByValue("5");
		// 9.select no of returning
		Select s6 = new Select(w.findElement(By.name("toDay")));
		s6.selectByValue("10");
		w.findElement(By.xpath("//tbody/tr[9]/td[2]/font[1]/font[1]/input[2]")).click();
		// 10.select no of airline
		Select s7 = new Select(w.findElement(By.xpath("//tbody/tr[10]/td[2]/select[1]")));
		s7.selectByVisibleText("Blue Skies Airlines");
		// 11.click on find flights
		w.findElement(By.name("findFlights")).click();
		System.out.println("2.1:Validate Register Form with valid data is pass");
	}

	@Test(priority = 5)
	public void validate_all_links_available_on_page() 
	{
		// 1.click on hotel
		WebElement hotel = w.findElement(By.linkText("Hotels"));
		hotel.click();
		w.navigate().back();

		w.navigate().back();
		// 4.click on destinations
		WebElement Destinations = w.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[6]/td[2]/a"));
		Destinations.click();
		w.navigate().back();
		// 5.click on vacation
		WebElement Vacations = w.findElement(By.linkText("Vacations"));
		Vacations.click();
		w.navigate().back();
		// 6.click on support
		WebElement SUPPORT = w.findElement(By.linkText("SUPPORT"));
		SUPPORT.click();
		w.navigate().back();
		// 8.click on contact
		WebElement CONTACT = w.findElement(By.linkText("CONTACT"));
		CONTACT.click();
		w.navigate().back();
		// 9.click on contact
		WebElement HOME = w.findElement(By.linkText("Home"));
		HOME.click();
		// 10.click on your destination
		WebElement you_destination = w.findElement(By.linkText("your destination"));
		you_destination.click();
		// 11.click on your destination
		WebElement featured_vacation_destinations = w.findElement(By.linkText("featured vacation destinations"));
		featured_vacation_destinations.click();
		// 11.click on your destination
		WebElement BusinessTravel = w.findElement(By.linkText("Business Travel @ About.com"));
		BusinessTravel.click();
		System.out.println("2.5:click on all the links available on the page is pass");
	}

	@AfterTest
	public void afterTest() {
		w.quit();
	}

}
