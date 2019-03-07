package selenidePage;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import java.io.File;
import org.openqa.selenium.By;
import selenideConfig.ConfigKeys;

public class ToolsQAPage {

	   public ToolsQAPage insertName(String name) {
	        $(By.name("firstname")).val(name);
	        return this;
	    }
	   
	   public ToolsQAPage insertSurname(String surname) {
	        $(By.name("lastname")).val(surname);
	        return this;
	    }
	   
	   public ToolsQAPage pickRadioButtons(String sex, String experience) {
		   $("input").selectRadio(sex);
		   $("input").selectRadio(experience);
	        return this;
	    }
	   
	   public ToolsQAPage chooseDateAndPicture(String date, String tester) {
		   $(By.id("datepicker")).val(date);		   
		   $$("input").find(value(tester)).click();
		   File file = new File(ConfigKeys.getConfigKey("file_path"));
		   $(By.id("photo")).uploadFile(file);
	        return this;
	    }
	   
	   public ToolsQAPage downloadFramework(String tool) {
		   $$("a").find(text("Test File to Download")).click();
		   $$("input").find(value(tool)).click();
		   return this;
	   }
	   
	   public ToolsQAPage pickFromListboxes(String continent,String command) {
		   $(By.id("continents")).click();
		   $$("option").find(text(continent)).click();
		   $$("option").find(text(command)).click();
		   return this;
	   }
	   
	   public ToolsQAPage sendForm() {
		   $$(By.id("NextedText")).shouldHave(texts("Text1"));
		   $(By.id("submit")).click();
		   return this;
	   }
	   
	   public ToolsQAPage clickNewPage() {
		   $(By.xpath("//div/form/fieldset/div[5]/a/strong")).click();
		   return page(ToolsQAPage.class);
	   }
	   
	   public ToolsQAPage checkData(String data) {
		   $(".tsc_table_s13").should(exist).shouldHave(text(data));
		   return this;
	   }
}
