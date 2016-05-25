package com.gmail.gogobebe2.cars.mechanics;

import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class CarListener implements Listener {
    @EventHandler
    private void onVehicleMove(VehicleMoveEvent event) {
        // TODO wasd
    }

    @EventHandler
    private void onVehicleExit(VehicleExitEvent event) {
        if (event.getExited() instanceof Player && event.getVehicle() instanceof Minecart) {
            Car car = Car.getCar(event.getVehicle().getUniqueId());
            if (car != null) car.stopCompletely();
        }
    }

    @EventHandler
    private void onVehicleDestroyed(VehicleDestroyEvent event) {
        if (event.getVehicle() instanceof Minecart) {
            Car car = Car.getCar(event.getVehicle().getUniqueId());
            if (car != null) Car.removeInstance(car);
        }
    }
}
