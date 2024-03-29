package com.game.service;

import com.game.dto.GameItem;
import com.game.dto.GameResult;
import com.game.dto.Player;

public interface GameController {
    void startGame();
    GameResult winner();
    GameResult endGame();

    GameResult endRound();

    final class FakeController implements GameController{

        private Player pFake;
        private GameItem cItem;

        public FakeController(Player player, GameItem gameItem){
            pFake = player;
            cItem = gameItem;
        }
        @Override
        public void startGame() {

        }

        @Override
        public GameResult winner() {
            if(pFake.getItem() == cItem){
                return GameResult.DRAW;
            }
            if(pFake.getItem() == GameItem.PAPER && cItem == GameItem.ROCK){
                return GameResult.PLAYER;
            }else if(pFake.getItem() == GameItem.ROCK && cItem == GameItem.SCISSORS){
                return GameResult.PLAYER;
            }else if(pFake.getItem() == GameItem.SCISSORS && cItem == GameItem.PAPER){
                return GameResult.PLAYER;
            }
            return GameResult.COMPUTER;
        }

        @Override
        public GameResult endGame() {
            return GameResult.DRAW;
        }

        @Override
        public GameResult endRound() {
            return GameResult.DRAW;
        }
    }
}
