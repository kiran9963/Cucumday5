package org.Cucum;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Task5 {
	static WebDriver driver;

	@Given("User should launch the Browser")
	public void user_should_launch_the_Browser() {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\GT Sanatorium\\Downloads\\eclipse-jee-oxygen-3a-win32-x86_64\\eclipse\\Lokesh\\CuCumberDay5\\Chrome\\chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.get("http://www.demo.guru99.com/telecom/");
	}
	@Given("User click the Add Tariff button")
	public void user_click_the_Add_Tariff_button() {
	   driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	}

	@When("USer Should provide the Details")
	public void user_Should_provide_the_Details(io.cucumber.datatable.DataTable data) throws InterruptedException {
		List<List<String>> twodlist = data.asLists(String.class);
		driver.findElement(By.xpath("//input[@placeholder='Monthly Rental']")).sendKeys(twodlist.get(0).get(1));
		driver.findElement(By.xpath("//input[@placeholder='Free Local Minutes']")).sendKeys(twodlist.get(1).get(1));
		driver.findElement(By.xpath("//input[@placeholder='Free International Minutes']")).sendKeys(twodlist.get(2).get(2));
		driver.findElement(By.xpath("//input[@placeholder='Free SMS Pack']")).sendKeys(twodlist.get(0).get(3));
		driver.findElement(By.xpath("//input[@placeholder='Local Per Minutes Charges']")).sendKeys(twodlist.get(1).get(0));
		driver.findElement(By.xpath("//input[@placeholder='Inter. Per Minutes Charges']")).sendKeys(twodlist.get(2).get(3));
		driver.findElement(By.xpath("//input[@placeholder='SMS Per Charges']")).sendKeys(twodlist.get(0).get(4));
	 Thread.sleep(30000);
	}

	@Then("User Should click the Submit Button")
	public void user_Should_click_the_Submit_Button() {
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		String text =	driver.findElement(By.xpath("//h2[contains (text(), 'Congratulation ')]")).getText();
	 
	System.out.println(text);
		
		
		
	   
	}

}
