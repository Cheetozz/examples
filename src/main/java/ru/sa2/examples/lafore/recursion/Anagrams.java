package ru.sa2.examples.lafore.recursion;

/**
 * Created by Alexander Smirnov on 30.09.2015.
 * email:       alexander@pingala.ru
 * email-work:  aleksandrsmirnov@at-consulting.ru
 */
public class Anagrams {

    private int callNo;

    private char charArray[];

    public Anagrams(String word){
        callNo = 0;
        charArray = word.toCharArray();
    }

    public void printAnagrams(){
        doAnagram(charArray.length);
    }

    private void doAnagram(int size){

        int start = charArray.length - size;
        if (size == 1) return;

        for (int i = start; i < charArray.length; i++) {
            doAnagram(size - 1);
            if (size == 2){
                displayWord();
            }
            cycleShift(size);
        }
    }

    private void cycleShift(int size){
        int start = charArray.length - size;
        char tmp = charArray[start];

        for (int j = start + 1; j < charArray.length; j++){
            charArray[j - 1] = charArray[j];
        }
        charArray[charArray.length - 1] = tmp;

    }

    private void displayWord(){

        System.out.println("anagram no " + ++callNo + ":\t" + new String(charArray));

    }

    public static void main(String[] args) {

        String word = "word";
        Anagrams anagrams = new Anagrams(word);
        anagrams.printAnagrams();

    }
}
