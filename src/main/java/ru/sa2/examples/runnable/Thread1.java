package ru.sa2.examples.runnable;

/**
 * Created by AlVyaSmirnov on 26.02.2015.
 */
public class Thread1 implements Runnable{


    public void run() {
        System.setProperty("one", "two");
    }
}
