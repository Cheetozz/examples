package ru.sa2.examples.lafore.recursion;

/**
 * Created by alvyasmirnov on 30.09.2015.
 */
public class Recursion {

    static int callNo = 0;

    static char charArray[];

    public static void doAnagram(int size){

        int start = charArray.length - size;
        if (size == 1) return;

        for (int i = start; i <= charArray.length; i++) {
            if (size == 2){
                cycleShift();
                displayWord();
            }
            doAnagram(--size);
        }
    }

    static void cycleShift(){

    }

    static void displayWord(){

        System.out.println("call no:\t" + ++callNo);

    }

    public static void main(String[] args) {


        String word = "word";

        charArray = word.toCharArray();


        doAnagram(charArray.length);

    }
}
