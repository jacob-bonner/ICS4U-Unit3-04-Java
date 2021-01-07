/*
* This program solves the Towers of Hanoi algorithm.
*
* @author  Jacob Bonner
* @version 1.0
* @since   2021-01-07
*/

import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;  // Import the Scanner class

public class TowersOfHanoi {
  /**
   * This function solves the Towers of Hanoi algorithm. 
   */
  static void solveTowers(int diskNumber, ArrayList<Integer> fromRod, 
                          ArrayList<Integer> toRod,
                          ArrayList<Integer> spareRod) {
    if (diskNumber > 0) {
      // Calling the solving function again
      solveTowers(diskNumber - 1, fromRod, spareRod, toRod);

      // Moving the top disk from one rod to another
      toRod.add(fromRod.get(fromRod.size() - 1));
      fromRod.remove(fromRod.size() - 1);

      // Printing the disks on rod A
      System.out.print("Rod A: ");
      for (int fromCounter = 0; fromCounter < fromRod.size();
           fromCounter++) {
        System.out.print(fromRod.get(fromCounter) + ", ");
      }
      System.out.print("     ");

      // Printing the disks on rod B
      System.out.print("Rod B: ");
      for (int toCounter = 0; toCounter < toRod.size();
           toCounter++) {
        System.out.print(toRod.get(toCounter) + ", ");
      }
      System.out.print("     ");

      // Printing the disks on rod C
      System.out.print("Rod C: ");
      for (int spareCounter = 0; spareCounter < spareRod.size();
           spareCounter++) {
        System.out.print(spareRod.get(spareCounter) + ", ");
      }
      System.out.println("");

      // Calling the solving function again
      solveTowers(diskNumber - 1, spareRod, toRod, fromRod);
    }
  }

  /**
   * This function accepts input for the number of disks and passes it to 
   * another function to solve the algorithm.
   */
  public static void main(String[] args) {
    try {
      // User input for how many disks there are in the game
      Scanner userInput = new Scanner(System.in);
      System.out.print("How many disks in your Towers of Hanoi game: ");
      int userDisks = userInput.nextInt();

      // Printing a note about the disks
      System.out.println("NOTE: Larger numbers represent larger disks");
      System.out.println();

      // Intializing lists that will be used as the rods
      ArrayList<Integer> firstArray = new ArrayList<Integer>();
      ArrayList<Integer> secondArray = new ArrayList<Integer>();
      ArrayList<Integer> thirdArray = new ArrayList<Integer>();

      // Adding numbers to one of the arrays to represent disks
      for (int counter = 0; counter < userDisks; counter++) {
        firstArray.add(userDisks - counter);
      }

      // Calling the function that will solve the algorithm
      if (userDisks < 1) {
        // Throwing that an improper integer was entered
        throw null;
      } else {
        solveTowers(userDisks, firstArray, secondArray, thirdArray);
      }

      // Printing that a solution was found
      System.out.println("");
      System.out.println("Towers of Hanoi Successfully Solved");

      // Catches and tells the user what error occurred
    } catch (NullPointerException e) {
      System.out.println("");
      System.out.println("ERROR: Cannot solve Towers of Hanoi with the inputted" 
                         + " number of disks");
    } catch (Exception e) {
      System.out.println("");
      System.out.println("ERROR: Invalid Input");
    }
  }
}
