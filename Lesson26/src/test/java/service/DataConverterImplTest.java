package service;

import com.game.dto.GameItem;
import com.game.service.DataConverter;
import com.game.service.impl.DataConverterImpl;
import com.game.error.ErrorGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataConverterImplTest {

    @Test
    void convertPaper() {
        DataConverter dataConverter = new DataConverterImpl();
        Assertions.assertEquals(GameItem.PAPER,dataConverter.convert("p"));
        Assertions.assertEquals(GameItem.PAPER,dataConverter.convert("pApe"));
        Assertions.assertEquals(GameItem.PAPER,dataConverter.convert("pAPEr"));
    }

    @Test
    void convertRock() {
        DataConverter dataConverter = new DataConverterImpl();
        Assertions.assertEquals(GameItem.ROCK,dataConverter.convert("r"));
        Assertions.assertEquals(GameItem.ROCK,dataConverter.convert("rock"));
        Assertions.assertEquals(GameItem.ROCK,dataConverter.convert("ROck"));
    }

    @Test
    void convertScissors() {
        DataConverter dataConverter = new DataConverterImpl();
        Assertions.assertEquals(GameItem.SCISSORS,dataConverter.convert("s"));
        Assertions.assertEquals(GameItem.SCISSORS,dataConverter.convert("scissors"));
        Assertions.assertEquals(GameItem.SCISSORS,dataConverter.convert("SCissorS"));
    }

    @Test
    void notCorrectValue() {
        DataConverter dataConverter = new DataConverterImpl();
        Assertions.assertThrows(ErrorGame.class ,() -> dataConverter.convert("paper1"));
        Assertions.assertThrows(ErrorGame.class ,() -> dataConverter.convert("1rock"));
        Assertions.assertThrows(ErrorGame.class ,() -> dataConverter.convert("1scissors"));
        Assertions.assertThrows(ErrorGame.class ,() -> dataConverter.convert(""));
        Assertions.assertThrows(ErrorGame.class ,() -> dataConverter.convert("124125"));
        Assertions.assertThrows(ErrorGame.class ,() -> dataConverter.convert("safasgsag"));
    }
}