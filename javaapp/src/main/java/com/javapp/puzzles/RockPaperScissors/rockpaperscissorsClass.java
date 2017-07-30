package com.javapp.puzzles.RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class rockpaperscissorsClass {

  public static void main(String[] args) {

    //create variables to be used as user's options
    final int Paper = 0;
    final int Rock = 1;
    final int Scissors = 2;

    //create scanner object to store user's decision
    Scanner input = new Scanner(System.in);

    //create random object for computer
    Random r = new Random(System.currentTimeMillis());

    //create variable to tally score
    int playerTotal = 0;

    //create do while so that games run as long as player's score is 0
    do {
      //prompt the user for their option
      System.out.println("Enter 0 for paper,1 for rock or 2 for scissors");

      //store user's decision in Scanner objet input
      int option = input.nextInt();

      //create variable from Random object to store Computer's decision
      int compChoice = r.nextInt(3);

      //use a switch case to switch between user's options
      switch (option) {

        //if user picks 0
        case Paper:

          //this is a draw
          if (compChoice == Paper) {
            playerTotal += 1;
          }
          //computer picks 2 and user picks 0
          else if (compChoice == Scissors) {
            playerTotal -= 3; //lose
          }
          //computer picks
          else {
            playerTotal += 3; //win
          }
          break;

        case Rock:
          if (compChoice == Paper) {
            playerTotal -= 3; //lose
          } else if (compChoice == Scissors) {
            playerTotal += 3; //win
          } else {
            playerTotal += 1; //draw
          }
          break;

        case Scissors:
          if (compChoice == Paper) {
            playerTotal += 3; //win
          } else if (compChoice == Scissors) {
            playerTotal += 1; //draw
          } else {
            playerTotal += 1; //draw
          }
          break;

        default:
          System.out.println("invalid choice");
      }
    } while (playerTotal >= 0);

    System.out.println("Your score " + playerTotal);


  }
}