package com.gmail.gogobebe2.cars.mechanics;

import org.bukkit.Location;
import org.bukkit.entity.Minecart;

class CarSteering {
    private Car car;
    private final float TURN_DISPLACEMENT;
    private final float TILT_DISPLACEMENT;

    CarSteering(Car car, float turnDisplacement, float tiltDisplacement) {
        this.car = car;
        TURN_DISPLACEMENT = turnDisplacement;
        TILT_DISPLACEMENT = tiltDisplacement;
    }

    void tilt(TiltDirection tiltDirection) { // TODO Call if going up a hill.
        Minecart minecart = car.getMinecart();
        Location location = minecart.getLocation();
        location.setYaw(location.getYaw() + (tiltDirection == TiltDirection.DOWN ? -TILT_DISPLACEMENT : TILT_DISPLACEMENT));
        minecart.teleport(location);
    }
    void turn(TurnDirection turnDirection) { // TODO Call if a/d is pressed.
        Minecart minecart = car.getMinecart();
        Location location = minecart.getLocation();
        location.setPitch(location.getPitch() + (turnDirection == TurnDirection.LEFT ? -TURN_DISPLACEMENT : TURN_DISPLACEMENT));
        minecart.teleport(location);
    }

    enum TurnDirection {
        RIGHT,
        LEFT
    }

    enum TiltDirection {
        UP,
        DOWN
    }
}
