import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingBoy implements Parkable {
    private List<ParkingLot> parks = new ArrayList<ParkingLot>();
    private String name;

    public ParkingBoy(String name) {
        this.name = name;
    }

    public List<ParkingLot> getParks() {
        return parks;
    }


    public String getName() {
        return name;
    }

    public ParkingBoy manageLot(ParkingLot lot) {
        parks.add(lot);
        return this;
    }


    @Override
    public ParkingLot park(Car car) {
        Optional<ParkingLot> parkingLot = getParkingLot();
        if (parkingLot.isPresent()) {
            parkingLot.get().park(car);
            return parkingLot.get();
        }
        return null;
    }

    @Override
    public boolean canPark() {
        return parks.stream().allMatch(ParkingLot::canPark);
    }

    @Override
    public Car getCar(Car car) {
        for (ParkingLot park : parks) {
            Car gotCar = park.getCar(car);
            if (gotCar != null) {
                return gotCar;
            }
        }
        return null;
    }

    public Optional<ParkingLot> getParkingLot() {
        return parks.stream().filter(park -> park.canPark()).findFirst();
    }
}
