package com.gmail.gogobebe2.cars.mechanics;

enum CarMovingDirection {
    FORWARDS(CarMovingDirection.BACKWARDS),
    BACKWARDS(CarMovingDirection.FORWARDS);

    private CarMovingDirection opposite;

    CarMovingDirection(CarMovingDirection opposite) {
        this.opposite = opposite;
    }

    CarMovingDirection getOpposite() {
        return this.opposite;
    }
}
