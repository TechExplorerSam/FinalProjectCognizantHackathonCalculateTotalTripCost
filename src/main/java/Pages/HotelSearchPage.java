package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelSearchPage {
    WebDriver driver;

    By locationInput = By.id("mainSearch");
    By checkInDate = By.id("checkIn");
    By checkOutDate = By.id("checkOut");
    By guestsDropdown = By.id("guests");
    By searchButton = By.id("searchBtn");

    public HotelSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLocation(String location) {
        driver.findElement(locationInput).sendKeys(location);
    }

    public void selectDates(String checkIn, String checkOut) {
        driver.findElement(checkInDate).sendKeys(checkIn);
        driver.findElement(checkOutDate).sendKeys(checkOut);
    }

    public void selectGuests(String guests) {
        driver.findElement(guestsDropdown).sendKeys(guests);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
}
