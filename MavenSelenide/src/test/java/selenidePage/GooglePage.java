package selenidePage;

import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.By;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import selenideConfig.ConfigKeys;

public class GooglePage {

	  public static GooglePage setDriver() {
			System.setProperty("webdriver.chrome.driver", ConfigKeys.getConfigKey("driver_path"));
			System.setProperty("selenide.browser", ConfigKeys.getConfigKey("selenide_browser"));
		    return page(GooglePage.class);
		  }
	  
	  public GooglePage openHomepage() {
		  	Selenide.open(ConfigKeys.getConfigKey("home_page"));
		  	return page(GooglePage.class);		  
	  }
	  
	   public GooglePage searchFor(String text) {
	        $(By.name("q")).val(text).pressEnter();
	        return this;
	    }
	   
	    public ElementsCollection results() {
	        return $$(".srg .g");
	    }
}
