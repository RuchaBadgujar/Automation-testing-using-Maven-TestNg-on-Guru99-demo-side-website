package TestCases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TC04_Guru99_Telecom_Project 
{
	WebDriver w;

	@BeforeTest
	public void launch_browser()
	{
		// 1.launch browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\Desktop\\selenium jar\\New folder\\chromedriver.exe");
		w = new ChromeDriver();
		// 2.To Open URL
		w.get("https://demo.guru99.com/telecom/index.html");
		w.manage().window().maximize();

	}

	@Test(priority = 1)
	public void validate_add_customer_with_valid_data() throws InterruptedException 
	{
		WebElement add_customer = w.findElement(By.linkText("Add Customer"));
		add_customer.click();
		Thread.sleep(5000);
		WebElement background_check = w.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[2]/label"));
		background_check.click();
		WebElement firstname = w.findElement(By.id("fname"));
		firstname.sendKeys("Rucha");
		WebElement lastname = w.findElement(By.id("lname"));
		lastname.sendKeys("Patil");
		WebElement email = w.findElement(By.id("email"));
		email.sendKeys("badgujarrucha097@gmail.com");
		WebElement address = w
				.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]"));
		address.sendKeys("dhule");
		WebElement MobileNo = w.findElement(By.name("telephoneno"));
		MobileNo.sendKeys("7975826124");
		WebElement submit = w
				.findElement(By.xpath("//body/section[@id='main']/div[1]/form[1]/div[1]/div[9]/ul[1]/li[1]/input[1]"));
		submit.click();
		WebElement homepage = w.findElement(By.xpath("//*[@id=\"main\"]/div/div/ul/li/a"));
		homepage.click();
		System.out.println("4.1:validate add customer with valid data is pass");
	}

	@Test(priority = 2)
	public void validate_add_traffice_plan_for_customer_with_valid_data() 
	{
		WebElement add_traffic_plan = w
				.findElement(By.xpath("//body/section[@id='one']/div[1]/div[1]/div[2]/h3[1]/a[1]"));
		add_traffic_plan.click();
		WebElement add_customer_id = w.findElement(By.xpath("//input[@id='customer_id']"));
		add_customer_id.sendKeys("592188");
		w.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[6]/input")).click();
		WebElement add_traffic_plan2 = w.findElement(By.xpath("//*[@id=\"main\"]/div/form/div[2]/input"));
		add_traffic_plan2.click();
		WebElement Home = w.findElement(By.xpath("	//body/section[@id='main']/div[1]/ul[1]/li[1]/a[1]"));
		Home.click();
		System.out.println("4.3:validate add traffice plan for customer with valid data is pass");
	}

	@Test(priority = 3)
	public void validate_add__Tariff_Plan_with_valid_data() throws InterruptedException 
	{

		w.navigate().to("https://demo.guru99.com/telecom/index.html");
		// Add Tariff Plan
		WebElement Add_Tariff_Plan = w.findElement(By.linkText("Add Tariff Plan"));
		Add_Tariff_Plan.click();
		Thread.sleep(4000);
		WebElement monthly_rental = w.findElement(By.id("rental1"));
		monthly_rental.sendKeys("50");
		WebElement local_miniutes = w.findElement(By.xpath("//input[@id='local_minutes']"));
		local_miniutes.sendKeys("1000");
		WebElement Freeinternationalminuits = w.findElement(By.xpath("//*[@id=\"inter_minutes\"]"));
		Freeinternationalminuits.sendKeys("9000");
		WebElement freeSmsPack = w.findElement(By.xpath("//input[@id='sms_pack']"));
		freeSmsPack.sendKeys("3000");
		WebElement local_miniutes_charge = w.findElement(By.xpath("//input[@id='minutes_charges']"));
		local_miniutes_charge.sendKeys("1");
		WebElement international_miniutes_charge = w.findElement(By.xpath("//input[@id='inter_charges']"));
		international_miniutes_charge.sendKeys("5");
		WebElement smsCharge = w.findElement(By.xpath("//*[@id=\"sms_charges\"]"));
		smsCharge.sendKeys("2");
		w.findElement(By.xpath("//body/section[@id='main']/div[1]/form[1]/div[1]/div[36]/ul[1]/li[1]/input[1]"))
				.click();
		w.findElement(By.xpath("//*[@id=\"main\"]/div/ul/li/a")).click();
		System.out.println("4.3:validate add Tariff Plan with valid datais pass");
	}

	@Test(priority = 4)
	public void Validate_paybills_with_valid_data()
	{
		WebElement paybills = w.findElement(By.xpath("//body/section[@id='one']/div[1]/div[3]/div[2]/h3[1]/a[1]"));
		paybills.click();
		w.findElement(By.name("customer_id")).sendKeys("592188");
		w.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[6]/input")).click();
		w.navigate().refresh();
		w.navigate().to("https://demo.guru99.com/telecom/index.html");
		System.out.println("4.4:validate Pay bills with valid data is pass");
	}

	@AfterTest
	public void close_browser() 
	{
		w.close();
	}

}
