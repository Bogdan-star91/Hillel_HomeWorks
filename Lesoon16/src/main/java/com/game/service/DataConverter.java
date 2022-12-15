package com.game.service;

import com.game.dto.GameItem;

public interface DataConverter {
    GameItem convert(String str);
}
