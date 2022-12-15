package com.game.service.impl;

import com.game.dto.GameItem;
import com.game.error.ErrorGameImpl;
import com.game.service.DataConverter;
import lombok.Data;

import java.util.Locale;
import java.util.Objects;

@Data
public class DataConverterImpl implements DataConverter {

    @Override
    public GameItem convert(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            throw new ErrorGameImpl("Not correct value! Try again!");
        }
        str = str.toLowerCase(Locale.ROOT);
        if (GameItem.PAPER.toString().startsWith(str) && GameItem.PAPER.toString().contains(str)) {
            return GameItem.PAPER;
        } else if (GameItem.ROCK.toString().startsWith(str) && GameItem.ROCK.toString().contains(str)) {
            return GameItem.ROCK;
        } else if (GameItem.SCISSORS.toString().startsWith(str) && GameItem.SCISSORS.toString().contains(str)) {
            return GameItem.SCISSORS;
        }

        throw new ErrorGameImpl("Not correct value! Try again!");
    }
}
