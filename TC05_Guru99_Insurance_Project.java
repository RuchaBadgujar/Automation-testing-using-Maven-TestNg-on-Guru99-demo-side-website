package TestCases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class TC05_Guru99_Insurance_Project {
	WebDriver w;

	@BeforeTest
	public void launch_browser_open_url() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\Desktop\\selenium jar\\selenium-java-3.141.59\\chromedriver.exe");
		w = new ChromeDriver();
		w.get("https://demo.guru99.com/insurance/v1/index.php");
		w.manage().window().maximize();

	}

	@Test(priority = 1)
	public void validate_register_with_valid_data() {
		// 1.click on register
		WebElement register = w.findElement(By.linkText("Register"));
		register.click();
		// 2.select title
		Select s = new Select(w.findElement(By.id("user_title")));
		s.selectByValue("Miss");
		// 3.enter first name
		WebElement firstName = w.findElement(By.name("firstname"));
		firstName.sendKeys("Rucha");
		// 4.enter UserSurname
		WebElement UserSurname = w.findElement(By.id("user_surname"));
		UserSurname.sendKeys("Patil");
		// 5.enter PhoneNo
		WebElement PhoneNo = w.findElement(By.id("user_phone"));
		PhoneNo.sendKeys("7498554125");
		// 6.select year
		Select year = new Select(w.findElement(By.id("user_dateofbirth_1i")));
		year.selectByValue("1937");
		// 7.select month
		Select month = new Select(w.findElement(By.id("user_dateofbirth_2i")));
		month.selectByValue("2");
		// 8.select date
		Select date = new Select(w.findElement(By.id("user_dateofbirth_3i")));
		date.selectByValue("7");
		// 9.enter UserSurname
		WebElement licenceType = w.findElement(By.id("licencetype_t"));
		licenceType.click();
		// 10.select licencePeriod
		Select licencePeriod = new Select(w.findElement(By.id("user_licenceperiod")));
		licencePeriod.selectByValue("3");
		// 11.select occupation
		Select occupation = new Select(w.findElement(By.id("user_licenceperiod")));
		occupation.selectByValue("6");
		// 12.enter Address
		WebElement Address = w.findElement(By.id("user_address_attributes_street"));
		Address.sendKeys("AbC chock,goa");
		// 13.enter city
		WebElement city = w.findElement(By.id("user_address_attributes_city"));
		city.sendKeys("Goa");
		// 14.enter country
		WebElement country = w.findElement(By.id("user_address_attributes_county"));
		country.sendKeys("India");
		// 15.enter post code
		WebElement Postcode = w.findElement(By.id("user_address_attributes_postcode"));
		Postcode.sendKeys("457821");
		// 16.enter email
		WebElement Email = w.findElement(By.id("user_user_detail_attributes_email"));
		Email.sendKeys("ganesh@gmail.com");
		// 17 enter password
		WebElement Password = w.findElement(By.id("user_user_detail_attributes_password"));
		Password.sendKeys("ganesh@123");
		// 18 enter confirm password
		WebElement confirm_password = w.findElement(By.id("user_user_detail_attributes_password_confirmation"));
		confirm_password.sendKeys("ganesh@123");
		// 19.click on submit
		WebElement submit = w.findElement(By.name("submit"));
		submit.click();
		System.out.println("5.1:validate register with valid data is pass");

	}

	@Test(priority = 2)
	public void validate_login_with_valid_data() {
		// 1.enter email
		WebElement Email1 = w.findElement(By.id("email"));
		Email1.sendKeys("ganesh@gmail.com");
		// 2.enter password
		WebElement Password2 = w.findElement(By.id("password"));
		Password2.sendKeys("ganesh@123");
		// 3.click on submit
		WebElement sumbit2 = w.findElement(By.name("submit"));
		sumbit2.click();
		System.out.println("5.2:validate login with valid data is pass");

	}

	@Test(priority = 3)
	public void validate_Home_button_and_print_text() {
		WebElement Home = w.findElement(By.linkText("Home"));
		Home.click();

		System.out.println("5.3:validate Home button is pass");
	}

	@Test(priority = 4)
	public void validate_request_quotation_with_valid_data() {
		// 1.click on request quotation
		WebElement Request_Quotation = w.findElement(By.linkText("Request Quotation"));
		Request_Quotation.click();
		// 2.select break down
		Select a = new Select(w.findElement(By.id("quotation_breakdowncover")));
		a.selectByValue("No cover");
		// 3.click on wind screen repair
		WebElement windscreenrepair = w.findElement(By.xpath("//input[@id='quotation_windscreenrepair_f']"));
		windscreenrepair.click();
		// 4.enter email
		WebElement incidents = w.findElement(By.name("incidents"));
		incidents.sendKeys("Hit by car");
		// 5.enter registration no
		WebElement registration = w.findElement(By.id("quotation_vehicle_attributes_registration"));
		registration.sendKeys("MH12ab8542");
		// 6.enter mileage
		WebElement mileage = w.findElement(By.id("quotation_vehicle_attributes_mileage"));
		mileage.sendKeys("30");
		// 7.Enter vehicle value
		WebElement vehicle_value = w.findElement(By.id("quotation_vehicle_attributes_value"));
		vehicle_value.sendKeys("75000");
		// 8.select year
		Select year1 = new Select(w.findElement(By.id("quotation_vehicle_attributes_policystart_1i")));
		year1.selectByValue("2015");
		// 9.select month
		Select month1 = new Select(w.findElement(By.id("quotation_vehicle_attributes_policystart_2i")));
		month1.selectByValue("2");
		// 10.select date
		Select date1 = new Select(w.findElement(By.id("quotation_vehicle_attributes_policystart_3i")));
		date1.selectByValue("15");
		// 11.click on Save Quotation
		WebElement Save_Quotation = w.findElement(By.xpath("//body/div[3]/div[1]/div[2]/form[1]/div[8]/input[3]"));
		Save_Quotation.click();
		w.navigate().back();
		System.out.println("5.4:validate request quotation with valid data is pass");

	}

	@Test(priority = 5)
	public void validate_retrieve_quotation_with_valid_data() {
		// 1.click on retrieve quotation
		WebElement retrieve_Quotation = w.findElement(By.xpath(" //a[@id='ui-id-3']"));
		retrieve_Quotation.click();
		// 2.enter id
		WebElement id = w.findElement(By.name("id"));
		id.sendKeys("9723");
		// 2.click on
		WebElement retrieve = w.findElement(By.id("getquote"));
		retrieve.click();
		w.navigate().back();
		System.out.println("5.5:validate retrieve quotation with valid data is pass");
	}

	@Test(priority = 6)
	public void validate_validate_profile_button() {
		// TC03.6:validate profile button
		WebElement profile = w.findElement(By.xpath("//a[@id='ui-id-4']"));
		profile.click();
		System.out.println("Prfiles text field");
		WebElement text1 = w.findElement(By.xpath("//strong[contains(text(),'Title:')]"));
		String c = text1.getText();
		System.out.println(c);
		WebElement text2 = w.findElement(By.xpath("//strong[contains(text(),'Firstname:')]"));
		String d = text2.getText();
		System.out.println(d);
		WebElement text3 = w.findElement(By.xpath("//strong[contains(text(),'Surname:')]"));
		String e = text3.getText();
		System.out.println(e);
		WebElement text4 = w.findElement(By.xpath("//strong[contains(text(),'Phone:')]"));
		String f = text4.getText();
		System.out.println(f);
		WebElement text5 = w.findElement(By.xpath("//strong[contains(text(),'Dataofbirth:')]"));
		String g = text5.getText();
		System.out.println(g);
		WebElement text6 = w.findElement(By.xpath("//strong[contains(text(),'License type:')]"));
		String h = text6.getText();
		System.out.println(h);
		WebElement text7 = w.findElement(By.xpath("//strong[contains(text(),'License type:')]"));
		String i = text7.getText();
		System.out.println(i);
		WebElement text8 = w.findElement(By.xpath("//strong[contains(text(),'Occupation:')]"));
		String j = text8.getText();
		System.out.println(j);
		WebElement text9 = w.findElement(By.xpath("//strong[contains(text(),'Driver History:')]"));
		String k = text9.getText();
		System.out.println(k);
		WebElement text10 = w.findElement(By.xpath("//p[contains(text(),'ADDRESS:')]"));
		String l = text10.getText();
		System.out.println(l);
		System.out.println("5.6:validate profile button and print all text available on page");
		w.navigate().refresh();
	}

	@Test(priority = 7)
	public void validate_edit_profile_with_valid_data() {
		// 1.click on edit profile
		WebElement edit_profile = w.findElement(By.xpath("//a[@id='ui-id-5']"));
		edit_profile.click();
		// 2.select title
		Select t1 = new Select(w.findElement(By.id("user_title")));
		t1.selectByValue("Miss");
		// 3.enter UserSurname
		WebElement UserSurname1 = w.findElement(By.id("user_surname"));
		UserSurname1.sendKeys("Patil");
		// 4.enter first name
		WebElement firstName1 = w.findElement(By.id("user_firstname"));
		firstName1.sendKeys("Rucha");
		// 5.enter PhoneNo
		WebElement PhoneNo1 = w.findElement(By.id("user_phone"));
		PhoneNo1.sendKeys("7498551234");
		// 6.select year
		Select year2 = new Select(w.findElement(By.id("user_dateofbirth_1i")));
		year2.selectByValue("1992");
		// 7.select month
		Select month2 = new Select(w.findElement(By.id("user_dateofbirth_2i")));
		month2.selectByValue("7");
		// 8.select date
		Select date2 = new Select(w.findElement(By.id("user_dateofbirth_3i")));
		date2.selectByValue("1");
		// 9.enter Address
		WebElement Address1 = w.findElement(By.id("user_address_attributes_street"));
		Address1.sendKeys("Z bridge,pune");
		// 10.enter city
		WebElement city1 = w.findElement(By.id("user_address_attributes_city"));
		city1.sendKeys("Pune");
		// 11.enter country
		WebElement country1 = w.findElement(By.id("user_address_attributes_county"));
		country1.sendKeys("India");
		// 12.enter post code
		WebElement Postcode1 = w.findElement(By.id("user_address_attributes_postcode"));
		Postcode1.sendKeys("457821");
		WebElement edit = w.findElement(By.xpath("//*[@id=\"edit_user_\"]/div[14]/input"));
		edit.click();
		w.close();
		System.out.println("5.7:validate edit profile with valid data");
	}

}
