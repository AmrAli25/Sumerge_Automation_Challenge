package websitebase;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestData;
import utils.TestngListener;


@Listeners(TestngListener.class)
public class BookingTests extends BaseTest {


    @Test(description = """
            User choose a City, checkIn, and checkOut date to search for available hotels to reserve
             Steps:
             1.Open www.booking.com
             2.In search type the Location Alexandria, select Check-in date 1 October 2025 and Check-
                out date 14 October 2025 and click Search
             3.From search results, pick Tolip Hotel Alexandria
             4.Click on See Availability button to go to the booking’s details page
             5.In details page: Select the bed and amount and click I’ll reserve button to navigate to the
               confirmation page
            """, dataProvider = "csvData")
    public void bookingTulipHotelTestcase(TestData data) {
        homePage.verifyHeader()
                .enterDestination(data.getDestination())
                .enterDates(data.getCheckInDate(), data.getCheckOutDate())
                .clickSearchButton()
                .clickOnWantedHotel()
                .verifyDates()
                .selectBeds()
                .selectAmount()
                .clickReserveBtn()
                .verifyHotelName();
    }


}
