package Task.Threads;

import Task.Stores.CarsStore;

public class ProducerThread extends Thread{

    CarsStore store;

    public ProducerThread(CarsStore store){
        this.store = store;
    }
    @Override
    public void run(){
        for(int i = 0; i < 20; i++){
            store.put();
        }
    }
}
