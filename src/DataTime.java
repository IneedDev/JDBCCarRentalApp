import java.time.LocalDateTime;
import java.util.Scanner;

import java.time.format.DateTimeFormatter;

public class DataTime {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("Podaj date ");
        String textData = scanner.nextLine();

        // LocalDate, Instant, LocalDateTime

        LocalDateTime time = LocalDateTime.parse(textData,dateTimeFormatter);
        System.out.println(time);

    }
}
