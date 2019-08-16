package hw4;

import java.util.Scanner;
import hw4.CFPlayer;
import hw4.RandomAI;
import hw4.AndersAI;
import hw4.ConsoleCF;
import hw4.GUICF;


public class Test {
  public static void main(String[] args) {
    Scanner reader = new Scanner (System.in);
    System.out.println("Enter 1 to play with AI; Enter 2 time AI 1 vs AI 2");
    int gameMode = reader.nextInt();
    if (gameMode==1) {
      new GUICF(new AndersAI());
    } else if (gameMode==2) {
      CFPlayer ai1 = new AndersAI();
      CFPlayer ai2 = new RandomAI();
      int n = 10000;
      int winCount = 0;
      for (int i =0; i < n ; i++) {
        ConsoleCF game = new ConsoleCF(ai1, ai2);
        game.playOut();
        if(game.getWinner() == ai1.getName())
          winCount++;
      }
      System.out.println(((double) winCount)/n);
    } else {
      ConsoleCF game = new ConsoleCF(new AndersAI());
      game.playOut();
      System.out.println(game.getWinner() + " has won.");
    } 
  }
}
