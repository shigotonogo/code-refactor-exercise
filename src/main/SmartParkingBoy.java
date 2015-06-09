import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy() {
        super();
    }

    @Override
    public ParkingLot park(Car car) {
        Optional<ParkingLot> mostAvaibleLots = getParks().stream().sorted(
                (lot1, lot2) -> Integer.compare(lot2.getAvailableLots(), lot1.getAvailableLots()))
                .findFirst();
        if (mostAvaibleLots.isPresent()) {
            ParkingLot parkedLot = mostAvaibleLots.get();
            parkedLot.park(car);
            return parkedLot;
        }
        return null;
    }
}
