// Programmer: Zachariah Magee
// Class: CS 145 Summer 2022
// Lab: Letter Inventory
// Date: July 22 2022
// IDE: Intellij Idea, GitHub: isZachariah

import java.util.*;

public class LetterInventory {
   
   // initialize variables
   public static final int LETTER = 26;
   private int[] inventory;
   private int letterNum;
   private int size;

   // main method utilizes available methods 
   // printing results to the console
   public static void main(String[] args) {
      LetterInventory hopeful = new LetterInventory("Hopeful");
      LetterInventory hopeless = new LetterInventory("Hopeless");
      int e = hopeless.get('e');
      System.out.println(e);
      System.out.println(hopeless.toString());
      System.out.println(hopeful.toString());
      LetterInventory hope = hopeful.add(hopeless);
      LetterInventory zachariah = new LetterInventory("Zachariah");
      LetterInventory zach = new LetterInventory("Zach");
      LetterInventory ariah = zachariah.subtract(zach);
      System.out.println(hope.toString());
      System.out.println(ariah.toString());
      LetterInventory all = hope.add(zachariah.add(zach));
      System.out.println(all);
      
   } // end of main method
   
   // constructor for LetterInventory object
   public LetterInventory (String data) {
      inventory = new int[LETTER];
      data = data.toLowerCase();
      for (int i = 0; i < data.length(); i++) {
         letterNum = data.charAt(i) - 'a';
         if (letterNum >= 0 && letterNum <= 25) {
            inventory[letterNum]++;
            size++;
         } // end if statement
      } // end for loop
   } // end of LetterInventory constructor method
   
   public int get (char letter) {
      char ch = Character.toLowerCase(letter);
      if (ch > 'z' || ch < 'a') {
         throw new IllegalArgumentException();
      } // end if statement
      int num = ch - 'a';
      int total = inventory[num];
      return total;
   } // end of get method - 
   // returns integer value of letter occurrence
   
   
   public void set (char letter, int value) {
      int newLetter = (Character.toLowerCase(letter) - 'a');
      if (newLetter > 'z' || newLetter < 'a' || value < 0) {
			throw new IllegalArgumentException();
		} // end if statement
      if (inventory[newLetter] > value) {
         size -= inventory[newLetter];
      } // end if statement
      inventory[newLetter] = value;
      size += value;
   } // end of void set method
         
   public int size () { return size; }
   
   public boolean isEmpty () { return (size == 0); }
   
   @Override
   public String toString () {
      String result = "[";
      for (int i = 0; i < LETTER; i++) {
         char string = (char)(i + 'a');
         for (int j = 0; j < inventory[i]; j++) {
            result += string;
         } // end inner for loop
      } // end for loop
      return result + "]";
   } // end of override toString method
   
   public LetterInventory add (LetterInventory addend) {
      LetterInventory summation = new LetterInventory();
      for (int i = 0; i < LETTER; i++) {
         summation.inventory[i] = inventory[i] + addend.inventory[i];
      } // end for loop
      summation.size = size + addend.size;
      return summation;
   } // end of add method
   
   public LetterInventory subtract (LetterInventory subtrahend) {
      LetterInventory difference = new LetterInventory();
      for (int i = 0; i < LETTER; i++) {
         difference.inventory[i] = inventory[i] - subtrahend.inventory[i];
         if (difference.inventory[i] < 0) {
            return null;
         } // end if statement
      } // end for loop
      difference.size = size - subtrahend.size;
      return difference;
   } // end of subtract method
   
   // constructor for add and subtract methods
   private LetterInventory() {
      this("");
   } // end secondary constructor method
   
} // end of LetterInventory class