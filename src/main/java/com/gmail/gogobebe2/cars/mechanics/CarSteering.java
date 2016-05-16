package com.gmail.gogobebe2.cars.mechanics;

import org.bukkit.Location;

public class CarSteering {
    private Car car;

    protected CarSteering(Car car) {
        this.car = car;
    }

    protected void tilt(TiltDirection tiltDirection, Location initialLocation, Location finalLocation) {
        // TODO change the vertical direction of the minecart.
    }
    protected void turn(TurnDirection turnDirection, Location initialLocation, Location finalLocation) {
        // TODO change the horizontal direction of the minecart.
    }

    private enum TurnDirection {
        RIGHT,
        LEFT
    }

    private enum TiltDirection {
        UP,
        DOWN
    }
}
