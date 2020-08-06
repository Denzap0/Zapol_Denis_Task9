package Task.Main;

import Task.Classes.*;
import Task.Interfaces.Movable;
import Task.Stores.CarsStore;

public class Main {

    public static void main(String[] args) {

        DriftCar[] cars = new DriftCar[10];
        for(int i = 0; i < 10; i++){
            cars[i] = new DriftCar();
        }
        CarsStore<DriftCar> driftStore = new CarsStore<DriftCar>(20000, cars);
        driftStore.printProducts();
        driftStore.purchase(3, 40000);
        System.out.println(driftStore.getCashier());
        DriftCar sellCar = new DriftCar();
        driftStore.sell(sellCar, 10000);
        System.out.println(driftStore.getCashier());

        DriftCar car = new DriftCar();
        System.out.println(car.getHandBrake());
    }
}
