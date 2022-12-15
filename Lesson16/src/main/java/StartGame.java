import com.game.dto.Computer;
import com.game.dto.Player;
import com.game.service.DataConverter;
import com.game.service.GameController;
import com.game.service.impl.DataConverterImpl;
import com.game.service.impl.GameControllerImpl;
import java.util.Locale;
import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) {
        Player player = new Player();
        Computer computer = new Computer();

        GameController gameController = new GameControllerImpl(player, computer);

        Scanner scanner = new Scanner(System.in);
        System.out.println("------GAME------");
        System.out.print("\nEnter your name: ");
        player.setName(scanner.nextLine());

        DataConverter dataConverter = new DataConverterImpl();
        int countGame = 0;
        String endGame = "y";
        do {
            System.out.print("Enter number of games: ");
            countGame = scanner.nextInt();

            gameController.startGame();
            do {
                String value = "1";
                System.out.print("Enter your value: ");
                value = scanner.nextLine();
                if (value.isEmpty()) {
                    value = scanner.nextLine();
                }
                if (value.toLowerCase(Locale.ROOT).equals("stop")) {
                    break;
                }
                player.setGameItem(dataConverter.convert(value));
                gameController.winner();
                gameController.endRound();
                countGame--;
            } while (countGame > 0);
            gameController.endGame();

            System.out.println("Continue game [Y/N]: ");
            endGame = scanner.nextLine().charAt(0) + "";
        } while (!endGame.equalsIgnoreCase("n"));
        System.out.println("Game over !!!");
    }

}
