package Task.Main;

import Task.Classes.CarForThreads;
import Task.Classes.SynchronizedClassExample;
import Task.Stores.CarsStore;
import Task.Threads.ConsumerThread;
import Task.Threads.ProducerThread;


public class Main {

    public static void main(String[] args) {


        /*
        CarsStore store = new CarsStore(999999); //Producer/Consumer not daemon
        ConsumerThread consumer = new ConsumerThread(store);
        ProducerThread producer = new ProducerThread(store);
        System.out.println("Is producer a daemon: " + producer.isDaemon());
        System.out.println("Is consumer a daemon: " + consumer.isDaemon());
        producer.start();
        consumer.start();*/


        /*CarsStore storeForDaemons = new CarsStore(999999); //Producer/Consumer daemon
        ConsumerThread consumerDaemon = new ConsumerThread(storeForDaemons);
        ProducerThread producerDaemon = new ProducerThread(storeForDaemons);
        producerDaemon.setDaemon(true);
        consumerDaemon.setDaemon(true);
        System.out.println("Is producer a daemon: " + producerDaemon.isDaemon());
        System.out.println("Is consumer a daemon: " + consumerDaemon.isDaemon());
        producerDaemon.start();
        consumerDaemon.start();




        SynchronizedClassExample example = new SynchronizedClassExample(); //Synchronized object example
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    example.method4Thread1();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    example.method4Thread2();
                }
            }
        });
        thread1.start();
        thread2.start();
        System.out.println("First state state right now: " + thread1.getState());
        System.out.println("Second state state right now: " + thread2.getState());*/




        CarForThreads car = new CarForThreads(); //Join method example
        Thread drivingThread = new Thread(car::drive);
        Thread engineStartThread = new Thread(drivingThread) {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                car.engineWork = true;
            }
        };

        engineStartThread.start();
        System.out.println("Is engine start thread alive: " + engineStartThread.isAlive());

        try{
            engineStartThread.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        drivingThread.start();
        System.out.println("Is driving thread alive: " + drivingThread.isAlive());



    }
}

