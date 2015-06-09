import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    private List<ParkingLot> parks = new ArrayList<ParkingLot>();

    public List<ParkingLot> getParks() {
        return parks;
    }

    public ParkingBoy manageLot(ParkingLot lot) {
        parks.add(lot);
        return this;
    }

    public ParkingLot park(Car car) {
        Optional<ParkingLot> parkingLot = getParkingLot();
        if (parkingLot.isPresent()) {
            parkingLot.get().park(car);
            return parkingLot.get();
        }
        return null;
    }

    public Optional<ParkingLot> getParkingLot() {
        return parks.stream().filter(park -> park.canPark()).findFirst();
    }
}
