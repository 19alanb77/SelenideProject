package selenideTest;

import static com.codeborne.selenide.Condition.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenidePage.GooglePage;
import selenidePage.ToolsQAPage;

public class SelenideTest {

	@BeforeTest(description = "Initialization of ChromeDriver properties")
	public static void init() {
		GooglePage.setDriver();
	}
	
	@Test(description = "Find automation practice form in Google")
	public void googleSearch() {		
		GooglePage google = new GooglePage();
        google.openHomepage().searchFor("automation practice form");
        google.results().get(0).shouldHave(text("Demo Form for practicing Selenium Automation - ToolsQA")).click();
	}
	
	@Test(description = "Insert personal data",dependsOnMethods = "googleSearch")
	public void sendPersonalData() {
		ToolsQAPage tools = new ToolsQAPage();
		tools.insertName("Alan").insertSurname("Buda");
		tools.pickRadioButtons("Male", "2");
	}
	
	@Test(description = "Insert date and upload example picture", dependsOnMethods = "sendPersonalData")
	public void chooseDateAndPicture() {
		ToolsQAPage tools = new ToolsQAPage();
		tools.chooseDateAndPicture("2019-03-07", "Automation Tester");
	}
	
	@Test(description = "Download file and pick checkbox", dependsOnMethods = "chooseDateAndPicture")
	public void downloadFramework() {
		ToolsQAPage tools = new ToolsQAPage();
		tools.downloadFramework("Selenium Webdriver");
	}
	
	@Test(description = "Pick positions from listbox", dependsOnMethods = "downloadFramework")
	public void pickFromListboxes() {
		ToolsQAPage tools = new ToolsQAPage();
		tools.pickFromListboxes("Australia","Switch Commands");
	}
	
	@Test(description = "Assert text and send form", dependsOnMethods = "pickFromListboxes")
	public void sendForm() {
		ToolsQAPage tools = new ToolsQAPage();
		tools.sendForm();
	}
	
	@Test(description = "Open another page and check data", dependsOnMethods = "sendForm")
	public void checkTable() {
		ToolsQAPage tools = new ToolsQAPage();
		tools.clickNewPage();
		tools.checkData("Dubai");
	}
}
