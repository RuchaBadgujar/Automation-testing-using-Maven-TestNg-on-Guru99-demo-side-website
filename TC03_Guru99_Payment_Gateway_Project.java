package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC03_Guru99_Payment_Gateway_Project {
	WebDriver w;

	@BeforeMethod
	public void launch_browser_open_URL() 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\Desktop\\selenium jar\\New folder\\chromedriver.exe");
		w = new ChromeDriver();
		// 2.To Open URL
		w.get("https://demo.guru99.com/payment-gateway/index.php");
		w.manage().window().maximize();
	}

	@Test(priority = 1)
	public void Validate_Add_To_card_and_fill_the_bank_details() 
	{
		WebElement card = w.findElement(By.xpath("//*[@id=\"nav\"]/a[1]"));
		card.click();
		Select licencePeriod = new Select(w.findElement(By.xpath("//*[@id=\"three\"]/div/form/div/div[4]/select")));
		licencePeriod.selectByValue("4");
		WebElement buynow = w.findElement(By.xpath("//*[@id=\"three\"]/div/form/div/div[8]/ul/li/input"));
		buynow.click();
		// Fill the payment process
		WebElement card_no = w.findElement(By.xpath("//input[@id='card_nmuber']"));
		card_no.sendKeys("1254369854012584");
		Select month = new Select(w.findElement(By.xpath("//select[@id='month']")));
		month.selectByValue("6");
		Select expeiration_year = new Select(w.findElement(By.id("year")));
		expeiration_year.selectByValue("2025");
		WebElement ccv = w.findElement(By.name("cvv_code"));
		ccv.sendKeys("4521");
		WebElement submit = w.findElement(By.name("submit"));
		submit.click();
		w.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		w.navigate().back();
		w.navigate().back();
		System.out.println("3.1:Validate Add To card and fill the bank details is pass");
	}

	@Test(priority = 2)
	public void Validate_validate_generate_card_number_button_and_print_url() throws InterruptedException
	{
		// TC05.2:validate generate card number button
		Thread.sleep(2000);
		// click on Generate Card Number
		WebElement generate_card_no = w.findElement(By.xpath("//*[@id=\"nav\"]/a[2]"));
		generate_card_no.click();
		w.navigate().back();
		System.out.println("3.3:validate generate card number button is pass");
	}

	@Test(priority = 3)
	public void Validate_validate_credit_card_number_button() throws InterruptedException 
	{
		WebElement check_credit_card_limit = w.findElement(By.xpath("//header/div[1]/nav[1]/a[3]"));
		check_credit_card_limit.click();
		WebElement credit_card_no = w.findElement(By.id("card_nmuber"));
		credit_card_no.sendKeys("1542369875124536");
		WebElement submit1 = w.findElement(By.xpath("//body/section[@id='three']/div[1]/form[1]/div[1]/div[6]/input[1]"));
		submit1.click();
		System.out.println("3.2:validate check_credit_card_limit is pass");
	}
}
