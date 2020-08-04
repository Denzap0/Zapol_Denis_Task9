package Task.Stores;

import Task.Classes.*;
import Task.Interfaces.Movable;

import java.lang.reflect.Array;

public class CarsStore<T extends Movable> {

    private int cashier;
    private T[] cars;

    public CarsStore(int cashier, T[] cars) {
        this.cashier = cashier;
        this.cars = cars;

    }

    public void printProducts() {
        for (T i : cars) {
            System.out.println(i.toString() + " ");
        }
    }

    public void purchase(int num, int money){
        if(num >= 1 && num <= 10 && money >= cars[num - 1].getPrice()){
            this.cashier += cars[num - 1].getPrice();
            cars[num - 1] = null;
            System.out.println("You bought a car");
        }
        else {
            System.out.println("You can not bought a car");
        }
    }

    public void sell(T car, int money){
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
    }

    public int getCashier() {
        return cashier;
    }

    public void setCashier(int cashier) {
        this.cashier = cashier;
    }

    public T[] getCars() {
        return cars;
    }

    public void setCars(T[] cars) {
        this.cars = cars;
    }
}
