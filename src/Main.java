import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Q+- V1.0:");

        String line;
        while (true) {
            System.out.print("> ");
            line = scanner.nextLine();
            if (Objects.equals(line, "exit")) {
                break;
            }
            System.out.println(line);
        }
    }
}