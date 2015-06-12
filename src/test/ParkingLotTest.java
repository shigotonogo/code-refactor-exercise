import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParkingLotTest {
    private ParkingLot parkingLot;
    private Car car;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot("", 5, 2);
        car = new Car("1");
    }

    @Test
    public void couldParkingInTheLot() throws Exception {
        assertThat(parkingLot.canPark(), is(true));
    }

    @Test
    public void couldNotParkingIfFull() {
        parkingLot = new ParkingLot("", 5, 0);
        assertThat(parkingLot.canPark(), is(false));
    }

    @Test
    public void getCarWhenCarIsInLot() {
        parkingLot.park(car);

        assertThat(parkingLot.getCar(car), is(car));
    }

    @Test
    public void shouldReturnNullWhenTheACarIsNotInLot() throws Exception {
        assertThat(parkingLot.getCar(car), is(nullValue()));
    }
}
