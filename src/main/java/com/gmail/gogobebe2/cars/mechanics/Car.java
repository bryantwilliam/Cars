package com.gmail.gogobebe2.cars.mechanics;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Car {
    private static List<Car> carList = new ArrayList<>();
    private CarAcceleration backwardAcceleration;
    private CarAcceleration forwardAcceleration;
    private CarSteering carSteering; // TODO use this in listener with a/d to turn and check block infront to tilt.
    private Minecart minecart;

    /**
     * This will also automatically spawn the minecart and mount the player onto it.
     * @param maxSpeed the max speed the minecart can reach when accelerating.
     * @param acceleration the amount the velocity changes by every tick.
     * @param turnDisplacement the tilt (x axis) length of movement of the minecart when a player presses a or d.
     * @param tiltDisplacement the tilt (y axis) length of movement of the minecart when a player encounters a block
     *                         it needs to move upwards on.
     * @param driver driver to be mounted.
     */
    Car(float maxSpeed, float acceleration, float turnDisplacement, float tiltDisplacement, Player driver) {
        this.createMinecartAndMountPlayer(maxSpeed, driver);
        this.carSteering = new CarSteering(this, turnDisplacement, tiltDisplacement);
        backwardAcceleration = new CarAcceleration(acceleration, this, CarMovingDirection.BACKWARDS);
        forwardAcceleration = new CarAcceleration(acceleration, this, CarMovingDirection.FORWARDS);
    }

    private void createMinecartAndMountPlayer(float maxSpeed, Player driver) {
        minecart = (Minecart) driver.getWorld().spawnEntity(driver.getLocation(), EntityType.MINECART);
        minecart.setMaxSpeed(maxSpeed);
        minecart.setSlowWhenEmpty(true); // This probably isn't needed since I do it myself.
        minecart.setPassenger(driver);
    }

    CarAcceleration getAcceleration(CarMovingDirection direction) {
        if (direction == CarMovingDirection.FORWARDS) return forwardAcceleration;
        return backwardAcceleration;
    }

    void stopCompletely() { // TODO call this if a player lets go of holding down w/s.
        backwardAcceleration.stopAccelerating();
        forwardAcceleration.stopAccelerating();
        minecart.getVelocity().zero();
    }

    Minecart getMinecart() {
        return minecart;
    }

    static void removeInstance(Car car) {
        carList.remove(car);
    }

    static Car getCar(UUID minecartUUID) {
        for (Car car : carList) if (car.getMinecart().getUniqueId().equals(minecartUUID)) return car;
        return null;
    }
}
