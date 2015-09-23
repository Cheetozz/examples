package ru.sa2.examples.runnable;

/**
 * Created by AlVyaSmirnov on 26.02.2015.
 */
public class Thread2 implements Runnable {

    public void run() {
        while (true){
            String prop = System.getProperty("one");
            System.out.println(prop);

            if (prop.isEmpty()) break;
        }
    }
}
