package com.game.dto;

import com.game.service.ItemService;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Player implements ItemService {
    private String name;
    private GameItem gameItem = GameItem.PAPER;

    private int countGame = 0;
    private int countWinGame = 0;
    private int countLoseGame = 0;

    public GameItem getItem() {
        return gameItem;
    }
}
