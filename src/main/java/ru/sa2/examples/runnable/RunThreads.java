package ru.sa2.examples.runnable;

/**
 * Created by AlVyaSmirnov on 27.02.2015.
 */
public class RunThreads {

    public static void main(String[] args) {
        Runnable t1 = new Thread1();
        Runnable t2 = new Thread2();

        Thread thread1 = new Thread(t1, "t1");
        thread1.start();
        Thread thread2 = new Thread(t2, "t2");
        thread2.start();

        for (int i = 0 ; i <= 10 ; i++){

            Thread t = new Thread(new MyRun("" + i));

            try {
                t.join();
                t.start();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class MyRun implements Runnable{

    private String suffix;
    private int count;
    private int limit;

    public MyRun(String str){
        this.suffix = str;
        this.count = 0;
        this.limit = (int)(Math.random() * 10);
        System.out.println(limit);
    }

    public void run(){
        while (count != limit) {
            count++;
            System.out.println("hui\t" + this.suffix);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}