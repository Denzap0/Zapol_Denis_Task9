package Task.Main;

import Task.Classes.*;
import Task.Interfaces.Movable;
import Task.Stores.CarsStore;

public class Main {

    public static void main(String[] args) {
        /*Car car1 = new DriftCar();
        car1.move();
        DriftCar car2 = new DriftCar();
        car2.move();
        car2.refueling(50);
        car2.drift(5, 55);
        Car car3 = new GasolineTanker();
        car3.move();
        GasolineTanker car4 = new GasolineTanker();
        car4.move();
        car4.fuelFill(400);
        car4.fuelDrain(400);
        System.out.println(car4.getFuelCapacity());
        Movable anim1 = new Guepard();
        anim1.move();
        Guepard anim2 = new Guepard();
        anim2.move();
        anim2.sleep();
        Movable anim3 = new Eagle();
        anim3.move();
        Eagle anim4 = new Eagle();
        anim4.setFlightSpeed(240);
        anim4.setFlightAltitude(100);
        anim4.move();*/

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
