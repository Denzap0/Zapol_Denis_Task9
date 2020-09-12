package Task.Classes;

public class CarForThreads {

    public volatile boolean engineWork;

    public CarForThreads() {
        this.engineWork = false;
    }

    public void drive(){
        if(engineWork)
        System.out.println("Car is driving");
    }
}
