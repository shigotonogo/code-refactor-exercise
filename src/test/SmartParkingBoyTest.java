import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SmartParkingBoyTest {

    @Test
    public void shouldParkingCarToTheLotWithMostAvailableLots(){
        SmartParkingBoy boy = new SmartParkingBoy();
        ParkingLot lot1 = new ParkingLot(3);
        ParkingLot lot2 = new ParkingLot(2);
        boy.manageLot(lot2).manageLot(lot1);
        Car car = new Car("112");
        ParkingLot park = boy.park(car);
        assertThat(park, is(lot1));
    }
}
