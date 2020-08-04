package Task.Classes;

import Task.Enums.Model;
import Task.Interfaces.Movable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class Car implements Movable {

    protected final SimpleDateFormat dateF = new SimpleDateFormat("dd MM yyyy h:m:s");;
    protected String colour;
    protected int serialNum, price;
    protected Date date;
    protected Model model;
    protected boolean state;

    public Car() {
        colour = "White";
        date = new Date();
        model = Model.MERCEDES;
        state = false;
    }

    public Car(String colour, int serialNum, Date date, Model model, boolean state) {
        this.colour = colour;
        this.date = date;
        this.model = model;
        this.state = state;
    }

    public abstract void move();

    public void stop() {
        System.out.println("Car is stopped");
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public String getDate() {
        return dateF.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("Model: ");
        strBuilder.append(model);
        strBuilder.append(", colour: ");
        strBuilder.append(colour);
        strBuilder.append(", date: ");
        strBuilder.append(date);
        return strBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return colour.equals(car.colour) &&
                model == car.model;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, serialNum, date, model, state);
    }

}
