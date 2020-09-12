package Task.Threads;

import Task.Stores.CarsStore;

public class ConsumerThread extends Thread{

    CarsStore store;

    public ConsumerThread(CarsStore store){
        this.store = store;
    }
    @Override
    public void run(){
        for(int i = 0; i < 20; i++){
            store.get();
        }
    }
}
