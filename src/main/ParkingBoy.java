import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parks = new ArrayList<ParkingLot>();
    public ParkingBoy manageLot(ParkingLot lot) {
        parks.add(lot);
        return this;
    }

    public ParkingLot park(Car car) {
        for (ParkingLot park : parks) {
            if (park.canPark()) {
                park.park(car);
                return park;
            }
        }
        return null;
    }
}
