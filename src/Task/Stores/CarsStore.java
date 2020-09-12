package Task.Stores;

import Task.Classes.*;
import Task.Interfaces.Movable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CarsStore {

    private int cashier;
    private ArrayList<Car> cars = new ArrayList<>();

    public CarsStore(int cashier) {
        this.cashier = cashier;
        for(int i = 0; i < 3; i++){
            cars.add(new DriftCar());
        }
    }

    public void printProducts() {
        for (Car i : cars) {
            System.out.println(i.toString() + " ");
        }
    }

    public synchronized void get() {
        /*if(num >= 1 && num <= 10 && money >= cars[num - 1].getPrice()){
            this.cashier += cars[num - 1].getPrice();
            cars[num - 1] = null;
            System.out.println("You bought a car");
        }
        else {
            System.out.println("You can not bought a car");

        }*/
        while (cars.size() < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cars.remove(0);
        System.out.println("1 product removed");
        System.out.println("products in store " + cars.size());
        notify();

    }

    public synchronized void put() {
        while (cars.size() >= 7) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cars.add(new DriftCar());
        System.out.println("1 product added");
        System.out.println("Products in store " + cars.size());
        notify();
    }
    /*public void sell(T car, int money){
        if(money <= car.getPrice() * 0.8 && this.cashier >= car.getPrice() * 0.8){ // 20% - loss of value
            for(int i = 0; i < 10; i++){
                if(cars[i] == null){
                    cars[i] = car;
                    this.cashier -= money;
                    car = null;
                    System.out.println("You sold you car");
                }
            }
        }
        else{
            System.out.println("You can not sell your car");
        }
    }*/

    public int getCashier() {
        return cashier;
    }

    public void setCashier(int cashier) {
        this.cashier = cashier;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
}
