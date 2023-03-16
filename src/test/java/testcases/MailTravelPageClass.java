package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;

public class MailTravelPageClass extends BasePage {
	WebDriver driver;


	@FindBy(xpath = "//input[@id='searchtext_freetext_search_form']")
	WebElement searchBox;

	@FindBy(xpath = "//div[@id='freetext_search_form']//button[@class='nbf_button nbf_tpl_quicksearch_button']")
	WebElement searchIcon;

	@FindBy(xpath = "//div[@id='iterator_4_product_custom_product-price-row']//button[@id='iterator_4_product_custom_more-info-button']")
	WebElement moreInfoBtn;

	@FindBy(xpath = "//div[@class='nbf_tpl_pms_calendar_price']")
	public WebElement departureDate;

	@FindBy(xpath = "//div[@id='book-button']")
	WebElement bookOnlineBtn;

	@FindBy(xpath = "//select[@id='room-1859920-numselect']")
	WebElement roomTypeDropdown;

	@FindBy(xpath = "//div[@class='nbf_fancy_nbf_tpl_pms_book_room nbf_fg_pms_button_text ']")
	WebElement continueBtn2;

	@FindBy(xpath = "//select[@id='pax-a-title-1']")
	WebElement titleDropdown;

	@FindBy(xpath = "//input[@id='pax-a-first-1']")
	WebElement firstNameInput;

	@FindBy(xpath = "/input[@id='pax-a-last-1']")
	WebElement lastNameInput;
	@FindBy(xpath = "//select[@id='pax-a-dobd-1']")
	WebElement day;
	@FindBy(xpath = "//select[@id='pax-a-dobm-1']")
	WebElement month;
	@FindBy(xpath = "//select[@id='pax-a-doby-1']")
	WebElement year;
	@FindBy(xpath = "//select[@id='pax-a-title-2']")
	WebElement titleDropdown1;

	@FindBy(xpath = "//input[@id='pax-a-first-2']")
	WebElement firstNameInput1;

	@FindBy(xpath = "/input[@id='pax-a-last-2']")
	WebElement lastNameInput1;
	@FindBy(xpath = "//select[@id='pax-a-dobd-2']")
	WebElement day1;
	@FindBy(xpath = "//select[@id='pax-a-dobm-2']")
	WebElement month1;
	@FindBy(xpath = "//select[@id='pax-a-doby-2']")
	WebElement year1;

	@FindBy(xpath = "//div[@class='nbf_fancy_paxButton nbf_fg_pms_button_text ']")
	WebElement continueBtn3;

	@FindBy(xpath = "//input[@id='contact-name']")
	WebElement yourName;

	@FindBy(xpath = "//input[@id='contact-mobile']")
	WebElement contactno;

	@FindBy(xpath = "//input[@id='contact-email']")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='contact-address1']")
	WebElement address;

	@FindBy(xpath = "//input[@id='contact-city")
	WebElement city;

	@FindBy(xpath = "//input[@id='contact-postcpde")
	WebElement postcode;

	@FindBy(xpath = "//select[@id='contact-country']")
	WebElement country;

	@FindBy(xpath = "//button[@class='nbf_button nbf_tpl_pms_button']")
	WebElement submit;

	@FindBy(xpath = "//span[@id='price-pin_riviera-days-num']")
	WebElement days;

	@FindBy(xpath = "//span[@class='ibecurr']")
	WebElement price;

	@FindBy(xpath = "//a[contains(text(), '0808 239 5315')]")
	WebElement telNumber;

	@Test
	public void testMailTravel() throws InterruptedException {
		// Step 1: Verify the title of the page
		Assert.assertEquals(driver.getTitle(), "Mail Travel | Holidays, Cruises & Tours from your favourite newspaper");

		// Step 2: Type "India" in the search box
		searchBox.sendKeys("India");
		searchIcon.click();
		Thread.sleep(6000); // Wait for the page to load

		// Step 3: Click "More Info" button
		moreInfoBtn.click();
		Thread.sleep(6000); // Wait for the page to load

		// Step 4: Verify tour details
		// verify days, price, and telephone number are displayed
		
		  if (days.isDisplayed() && price.isDisplayed() && telNumber.isDisplayed()) {
		  System.out.println("Days, price, and telephone number displayed"); } else {
		  System.out.println("Days, price, and telephone number not displayed"); }
		 
		// step 5 : Select departure date

		departureDate.sendKeys("2023-10-12");

		// Step 5: Click "Book Online" button
		bookOnlineBtn.click();
		Thread.sleep(5000); // Wait for the page to load

		Select dropdown = new Select(roomTypeDropdown);

		// Select an option by its visible text
		dropdown.selectByValue("2");

		// Step 6: Click "Continue" button
		continueBtn2.click();

		Select title = new Select(titleDropdown);

		// Select an option by its visible text
		
		
		// fill passenger details and continue
		title.selectByValue("Mrs");
		

		firstNameInput.sendKeys("John");

		lastNameInput.sendKeys("Doe");

		Select day = new Select(titleDropdown);

		// Select an option by its visible text
		day.selectByValue("23");

		Select month = new Select(titleDropdown);

		// Select an option by its visible text
		month.selectByValue("March");

		Select year = new Select(titleDropdown);

		// Select an option by its visible text
		year.selectByValue("2003");
		
		Select title1 = new Select(titleDropdown1);

		// Select an option by its visible text
		title1.selectByValue("Mrs");
		
		firstNameInput1.sendKeys("Varsha");

		lastNameInput1.sendKeys("Gujrati");

		Select day1 = new Select(titleDropdown);

		// Select an option by its visible text
		day1.selectByValue("23");

		Select month1 = new Select(titleDropdown);

		// Select an option by its visible text
		month1.selectByValue("March");

		Select year1 = new Select(titleDropdown);

		// Select an option by its visible text
		year1.selectByValue("2004");

		emailAddress.sendKeys("johndoe@example.com");
		address.sendKeys("london road");
		city.sendKeys("London");
		postcode.sendKeys("CR0 3PF");

		Select country1 = new Select(country);

		// Select an option by its visible text
		country1.selectByValue("GB");

		submit.click();

	}
}
