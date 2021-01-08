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
  static void solveTowers(int diskNumber, char fromRod, char toRod,
                          char spareRod) {
    if (diskNumber == 1) {
      // Moving the top disk from one rod to another
      System.out.println("Moving disk 1 from rod " + fromRod 
                         + " to rod " + toRod);
      return;
    }

    // Calling the solving function again
    solveTowers(diskNumber - 1, fromRod, spareRod, toRod);

    // Printing the move that was taken
    System.out.println("Moving disk " + diskNumber + " from rod " + fromRod 
                       + " to rod " + toRod);

    // Calling the solving function again
    solveTowers(diskNumber - 1, spareRod, toRod, fromRod);
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

      // Calling the function that will solve the algorithm
      if (userDisks < 1) {
        // Throwing that an improper integer was entered
        throw null;
      } else {
        solveTowers(userDisks, 'A', 'C', 'B');
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
