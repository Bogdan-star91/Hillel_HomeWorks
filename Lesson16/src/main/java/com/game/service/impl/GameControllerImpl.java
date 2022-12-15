package com.game.service.impl;

import com.game.dto.Computer;
import com.game.dto.GameItem;
import com.game.dto.GameResult;
import com.game.dto.Player;
import com.game.service.Saved;
import lombok.Data;

import java.util.InputMismatchException;
import java.util.Scanner;


@Data
public class GameControllerImpl implements Saved {

    private static final Scanner sc = new Scanner(System.in);
    private Player player;
    private Computer computer;
    private GameResult winner;

    public GameControllerImpl(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void startGame() {
        System.out.println("\nThe game starts !!! Good luck !!!");
        System.out.println("\nTo end the game enter: stop");
        System.out.println("\nEnter value: [Scissors = s, Rock = r, Paper = p]");
        player.setCountGame(0);
        player.setCountWinGame(0);
        player.setCountLoseGame(0);
    }

    public GameResult winner() {
        winner = GameResult.COMPUTER;
        GameItem cItem = computer.getItem();
        System.out.println("Computer value: " + cItem);
        if (player.getItem() == cItem) {
            winner = GameResult.DRAW;
            return winner;
        }
        if (player.getItem() == GameItem.PAPER && cItem == GameItem.ROCK) {
            winner = GameResult.PLAYER;
        } else if (player.getItem() == GameItem.ROCK && cItem == GameItem.SCISSORS) {
            winner = GameResult.PLAYER;
        } else if (player.getItem() == GameItem.SCISSORS && cItem == GameItem.PAPER) {
            winner = GameResult.PLAYER;
        }
        return winner;
    }

    public void endGame() {
        String result = "Player " + player.getName() + " won " + player.getCountWinGame()
                + " games, lose " + player.getCountLoseGame() + " games. Total games played: "
                + player.getCountGame() + ".";
        System.out.println(result);
        sc.nextLine();
        System.out.println("Do you want to save your results? Y/N");
        String choice = sc.nextLine();
        try {
            if (choice.equalsIgnoreCase("Y")) {
                Saved.saved(result);
                System.out.println("Results saved successfully !!!");
            } else {
                System.out.println("Good luck !!!");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Good luck !!!");
            System.exit(0);
        }
    }


    @Override
    public void endRound() {
        player.setCountGame(player.getCountGame() + 1);
        if (winner == GameResult.PLAYER) {
            player.setCountWinGame(player.getCountWinGame() + 1);
        } else if (winner == GameResult.COMPUTER) {
            player.setCountLoseGame(player.getCountLoseGame() + 1);
        }
        System.err.println("Win in " + player.getCountGame() + " round is: " + winner.toString());
    }
}
