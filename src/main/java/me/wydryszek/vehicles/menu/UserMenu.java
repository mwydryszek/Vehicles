package me.wydryszek.vehicles.menu;

import lombok.Getter;
import me.wydryszek.vehicles.objects.*;
import me.wydryszek.vehicles.storage.VehicleStorage;


import java.util.*;

import static me.wydryszek.vehicles.Main.logger;
import static me.wydryszek.vehicles.Main.printLogger;

@Getter
public class UserMenu {

    private final VehicleStorage vehicleStorage;

    public UserMenu() {
        vehicleStorage = new VehicleStorage();
    }

    public void displayMenu() {

        final Scanner scanner = new Scanner(System.in);

        boolean askForOption = true;

        while (askForOption) {

            int option = 1;

            printLogger.trace("Wybierz opcję (1-6)");
            printLogger.trace("1. CAR\n" +
                    "2. SHIP\n" +
                    "3. PLANE\n" +
                    "4. BICYCLE\n" +
                    "5. ALL\n" +
                    "6. EXIT\n");

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                logger.info("Opcja musi być cyfrą 1-6\n");
                scanner.nextLine();
                continue;
            }


            switch (option) {
                case 1:
                    vehicleStorage.printTheFastestVehicle(VehicleType.CAR);
                    break;
                case 2:
                    vehicleStorage.printTheFastestVehicle(VehicleType.SHIP);
                    break;
                case 3:
                    vehicleStorage.printTheFastestVehicle(VehicleType.PLANE);
                    break;
                case 4:
                    vehicleStorage.printTheFastestVehicle(VehicleType.BICYCLE);
                    break;
                case 5:
                    for(VehicleType type : VehicleType.values()){
                        vehicleStorage.printTheFastestVehicle(type);
                    }
                    break;
                case 6:
                    askForOption = false;
                    break;
                default:
                    logger.info("Podaj poprawną opcje\n");
                    break;
            }

        }

        scanner.close();

    }
}


