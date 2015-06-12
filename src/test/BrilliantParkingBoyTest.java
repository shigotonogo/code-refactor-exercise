import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ywdong on 6/9/15.
 */
public class BrilliantParkingBoyTest {
    @Test
    public void shouldParkingCarToTheLotWithMostAvailableLots(){
        BrilliantParkingBoy boy = new BrilliantParkingBoy("");
        ParkingLot lot1 = new ParkingLot("", 5, 2);
        ParkingLot lot2 = new ParkingLot("", 5, 3);
        ParkingLot lot3 = new ParkingLot("", 5, 1);
        boy.manageLot(lot1).manageLot(lot2).manageLot(lot3);
        Car car = new Car("112");
        ParkingLot park = boy.park(car);
        assertThat(park, is(lot2));
    }
}
