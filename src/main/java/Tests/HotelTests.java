package Tests;


import org.testng.annotations.Test;

import com.tripautomation_project.BaseTests;

import Pages.HotelSearchPage;


public class HotelTests extends BaseTests {

    @Test
    public void verifyHotelSearch() {
        HotelSearchPage hotelPage = new HotelSearchPage(driver);
        hotelPage.enterLocation("Nairobi");
        hotelPage.selectDates("12/01/2025", "12/06/2025");
        hotelPage.selectGuests("4");
        hotelPage.clickSearch();
    }
}
