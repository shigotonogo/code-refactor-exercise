import java.util.Optional;

public class BrilliantParkingBoy extends ParkingBoy {
    public BrilliantParkingBoy() {
        super();
    }

    @Override
    public Optional<ParkingLot> getParkingLot() {
        return getParks().stream().sorted(
                    (lot1, lot2) -> Double.compare(lot2.getAvailableLots() / (double)lot2.getTotal(), lot1.getAvailableLots() /(double) lot1.getTotal()))
                    .findFirst();
    }
}
