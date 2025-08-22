package qpm;

import java.util.*;
import qpm.lexing.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Q+- V1.0:");
        System.out.println("Type 'exit' to quit.\n");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine();

            if (Objects.equals(line, "exit")) {
                break;
            }

            Lexer tokenizer = new Lexer(line);
            List<Token> tokens = tokenizer.tokenize();

            System.out.println("Tokens:");
            for (Token token : tokens) {
                System.out.println(token);
            }

            System.out.println();
        }

        scanner.close();
    }
}
