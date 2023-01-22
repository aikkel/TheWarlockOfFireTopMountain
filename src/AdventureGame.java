import game.DBSql;
import game.Game;
import gameobjects.Actor;
import gameobjects.Thing;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AdventureGame {
    static Game game;


    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output = "";
        game = new Game();
        in = new BufferedReader(new InputStreamReader(System.in));
        game.showIntro();

        do {
            System.out.print("> ");
            input = in.readLine();
            switch (input) {
                default:
                    output = game.runCommand(input);
                    break;
            }

            System.out.println(output);
        } while (!"q".equals(input));
    }
}