package com.gmail.gogobebe2.cars.mechanics;

import com.gmail.gogobebe2.cars.Cars;
import org.bukkit.Bukkit;
import org.bukkit.entity.Minecart;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

class CarAcceleration {
    private boolean isAccelerating;
    private final float ACCELERATION;
    private final Car CAR;
    private final CarMovingDirection DIRECTION;

    CarAcceleration(float acceleration, Car car, CarMovingDirection direction) {
        this.ACCELERATION = acceleration;
        this.CAR = car;
        this.DIRECTION = direction;
    }

    void accelerate() { // TODO call this if a player holds down w/s depending on direction.
        isAccelerating = true;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Cars.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                if (!isAccelerating) {
                    cancel();
                    return;
                } else if (CAR.getAcceleration(DIRECTION.getOpposite()).isAccelerating) {
                    // Just stop the car if both cars are accelerating because it means the driver is holding down 's'
                    // and 'w' at the same time.
                    CAR.stopCompletely();
                    return;
                }

                Minecart minecart = CAR.getMinecart();
                Vector velocity = minecart.getVelocity();
                velocity.add(/* TODO ACCELERATION direction*/new Vector());
                if (velocity.length() >= minecart.getMaxSpeed()) isAccelerating = false;
                minecart.setDerailedVelocityMod(velocity);
            }
        }, 1, 1);
    }

    void stopAccelerating() {
        // This will stop the car accelerating because it checks when it runs the BukkitRunnable.
        isAccelerating = false;
    }

    boolean isAccelerating() {
        return isAccelerating;
    }
}
