package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CruisesPage {
	
	WebDriver driver;

    By cruiseLineDropdown = By.xpath("//button[@aria-haspopup='listbox']/span[contains(text(),'Cruise line')]");
    By cruiseLineDropdownOptions=By.xpath("//button[contains(@aria-label,'Cruise line')]/following::div[@role='option']");
    By shipDropdown = By.xpath("//button[@aria-haspopup='listbox']/span[contains(text(),'Cruise ship')]");
    By shipDropdownOptions=By.xpath("//button[contains(@aria-label,'Cruise ship')]/following::div[@role='option']");
    By searchButton=By.xpath("//button[text()='Search']");
    By languagesList = By.xpath("//div[@id='ship_reviews']/descendant::div[text()='Language']");
    By passengersInfo = By.xpath("//h2[text()='Overview']/following::div[text()='Passengers: ']");
    By crewInfo = By.xpath("//h2[text()='Overview']/following::div[text()='Passengers: ']/span[contains(text(),'Crew')]");
    By launchYearInfo = By.xpath("//h2[text()='Overview']/following::div[text()='Launched: ']");
    
    public CruisesPage(WebDriver driver) {
        this.driver = driver;
    }

   


    public void selectCruiseLine(String line) throws InterruptedException {
          driver.findElement(cruiseLineDropdown).click();
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
          List<WebElement> cruiseLineOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cruiseLineDropdownOptions));
          for (WebElement option : cruiseLineOptions) {
              if (option.getText().contains(line)) {
                  option.click();
                  Thread.sleep(1000);
                  break;
              }
          }
      }



public void selectShip(String ship) throws InterruptedException {
        driver.findElement(shipDropdown).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> shipsOption = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(shipDropdownOptions));
        for (WebElement option : shipsOption) {
            if (option.getText().contains(ship)) {
                option.click();
                Thread.sleep(1000);
                break;
            }
        }
    }

    
    public void SearchButtonClick() {
    	driver.findElement(searchButton).click();
    }

    public List<String> getLanguages() {
        List<String> languages = new ArrayList<>();
        driver.findElements(languagesList).forEach(element -> languages.add(element.getText()));
        return languages;
    }

    public String getPassengers() {
        return driver.findElement(passengersInfo).getText();
    }

    public String getCrew() {
        return driver.findElement(crewInfo).getText();
    }

    public String getLaunchYear() {
        return driver.findElement(launchYearInfo).getText();
    }


}
