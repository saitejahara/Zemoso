import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Assignment4 {
    public static void runner(LocalDate signUpDate, LocalDate currentDate, DateTimeFormatter formatter) {
        {
            if (signUpDate.isAfter(currentDate)) {
                System.out.println("No range");
            } else {
                LocalDate lowerLimit = LocalDate.of(currentDate.getYear(), signUpDate.getMonthValue(), signUpDate.getDayOfMonth()).minusDays(30);
                LocalDate UpperLimit = LocalDate.of(currentDate.getYear(), signUpDate.getMonthValue(), signUpDate.getDayOfMonth()).plusDays(30);

                if (currentDate.isBefore(UpperLimit))
                    System.out.println(lowerLimit.format(formatter) + " " + currentDate.format(formatter));

                else
                    System.out.println(lowerLimit.format(formatter) + " " + UpperLimit.format(formatter));
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hit 'terminate' to exit");
        System.out.println("dd-mm-yyyy dd-mm-yyyy");

        while(true) {
            String dates[] = sc.nextLine().split(" ");
            if (dates[dates.length-1].equalsIgnoreCase("terminate")) {
                System.out.println("Program terminated");
                break;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate signupDate = LocalDate.parse(dates[0], formatter);
            LocalDate currDate = LocalDate.parse(dates[1], formatter);

            runner(signupDate, currDate, formatter);
        }
    }
}