package Tests;

import org.testng.annotations.*;
import com.tripautomation_project.BaseTests;
import Pages.CruisesPage;
import java.util.List;

public class CruisesTest extends BaseTests {

    @BeforeClass
    public void setup() {
        setUp();
    }

    @Test
    public void verifyCruiseDetails() throws Exception {
        //  Read cruise details dynamically from Excel
        List<String> cruiseDetails = ReadCruiseDetailsFromExcel.readExcelWords();
        String cruiseLine = cruiseDetails.get(0);
        String shipName = cruiseDetails.get(1);

        CruisesPage cruisePage = new CruisesPage(driver);
        cruisePage.selectCruiseLine(cruiseLine);
        cruisePage.selectShip(shipName);

        // Fetching the details from the Web page by Calling the Methods From Page class
        List<String> languages = cruisePage.getLanguages();
        String passengers = cruisePage.getPassengers();
        String crew = cruisePage.getCrew();
        String launchYear = cruisePage.getLaunchYear();

        // Printing all the details for verification
        System.out.println("Cruise Line: " + cruiseLine);
        System.out.println("Ship Name: " + shipName);
        System.out.println("Languages Offered: " + String.join(", ", languages));
        System.out.println("Passengers: " + passengers);
        System.out.println("Crew: " + crew);
        System.out.println("Launch Year: " + launchYear);
        
       
    }

    @AfterClass
    public void teardown() {
        tearDown();
    }
}