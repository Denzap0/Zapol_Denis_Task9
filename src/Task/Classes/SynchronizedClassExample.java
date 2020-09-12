package Task.Classes;

import java.util.ArrayList;
import java.util.HashSet;

public class SynchronizedClassExample {

    String str = "";

    public SynchronizedClassExample() {

    }

    public void method4Thread1() {


        synchronized (this) {
            while (str.equals("Here was 1 thread")) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            str = "Here was 1 thread";
            System.out.println(str);
            notify();
        }

    }

    public void method4Thread2() {

        synchronized (this) {
            while (str.equals("Here was 2 thread")) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            str = "Here was 2 thread";
            System.out.println(str);
            notify();
        }

    }


}
