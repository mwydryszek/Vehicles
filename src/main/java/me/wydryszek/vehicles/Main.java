package me.wydryszek.vehicles;

import me.wydryszek.vehicles.menu.UserMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger logger = LogManager.getLogger();
    public static final Logger printLogger = LogManager.getLogger("printLogger");
    public static void main(String[] args) {
        UserMenu menu = new UserMenu();
        menu.displayMenu();
    }

}
