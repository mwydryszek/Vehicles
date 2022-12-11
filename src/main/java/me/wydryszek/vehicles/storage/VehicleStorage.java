package me.wydryszek.vehicles.storage;

import me.wydryszek.vehicles.objects.*;

import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

import static me.wydryszek.vehicles.Main.logger;

public class VehicleStorage {

    private final List<Vehicle> list = List.of(
            new Car(300, "BMW"),
            new Car(200, "Opel"),
            new Ship(45, "Fincantieri"),
            new Ship(50, "K Shipbuilding"),
            new Plane(800, "Boeing"),
            new Plane(1000, "Airbus"),
            new Bicycle(30, "Trek"),
            new Bicycle( 25, "Scott")
    );

    public Vehicle getTheFastestVehicle(Class<?> vehicleType){
        return list.stream()
                .filter(entry -> vehicleType.isInstance(entry))
                .max(Comparator.comparing(v -> v.getMaxSpeed()))
                .orElse(null);
    }

    public void printTheFastestVehicle(VehicleType vehicleType){

        Vehicle fastestVehicle = null;

        switch(vehicleType){

            case CAR:
                fastestVehicle = getTheFastestVehicle(Car.class);
                break;

            case SHIP:
                fastestVehicle = getTheFastestVehicle(Ship.class);
                break;

            case PLANE:
                fastestVehicle = getTheFastestVehicle(Plane.class);
                break;

            case BICYCLE:
                fastestVehicle = getTheFastestVehicle(Bicycle.class);
                break;
        }

        if(fastestVehicle == null){
            logger.info("Brak pojazdu tego typu w bazie");
        }else{
            logger.info("Pojazd " + vehicleType + " producent " + fastestVehicle.getManufacturer()
                    + " jest najszybszy" + "(maksymalna prędkość to "+ fastestVehicle.getMaxSpeed()+")");
        }

    }


}
