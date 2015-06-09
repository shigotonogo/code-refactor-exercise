import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy() {
        super();
    }

    @Override
    public Optional<ParkingLot> getParkingLot() {
        return getParks().stream().sorted(
                    (lot1, lot2) -> Integer.compare(lot2.getAvailableLots(), lot1.getAvailableLots()))
                    .findFirst();
    }



}
