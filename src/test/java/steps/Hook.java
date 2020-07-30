package steps;

import Base.BaseUtil;


//import cucumber.api.PickleStepTestStep;
//import cucumber.api.TestCase;
//import gherkin.pickles.PickleStep;
//import io.cucumber.core.api.Scenario;


import io.cucumber.java.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by Karthik on 31/01/2019.
 */

public class Hook extends BaseUtil{


    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) {
    	
    	String browser = System.getProperty("browser");
    	
        base.scenarioDef = base.features.createNode(scenario.getName());

        System.out.println("Opening the browser : " + browser);
        
        if(browser != null) {
        	if(browser.equalsIgnoreCase("Chrome")) {
            	System.setProperty("webdriver.chrome.driver", "C:/driver/Web/chromedriver.exe");
                base.Driver = new ChromeDriver();
            } else if(browser.equalsIgnoreCase("Firefox")) {
            	System.setProperty("webdriver.firefox.marionette", "C:/driver/Web/geckodriver.exe");
                base.Driver = new FirefoxDriver();
            } else {
            	System.setProperty("webdriver.chrome.driver", "C:/driver/Web/chromedriver.exe");
                base.Driver = new ChromeDriver();
            }
        } else {
        	System.setProperty("webdriver.chrome.driver", "C:/driver/Web/chromedriver.exe");
            base.Driver = new ChromeDriver();
        }
        
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
        base.Driver.quit();
    }

    @BeforeStep
    public void BeforeEveryStep(Scenario scenario) {
        System.out.println("Before every step " + scenario.getId());

        //((PickleStep)((PickleStepTestStep)
    }

    @AfterStep
    public void AfterEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
        //System.out.println("Before every step " + stepTestStep.getId());
    }

}
