import java.util.regex.*;

public class Assignment9 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[A-Z].*[.]");
        String testString = "Hello ZeMoSo.";
        Matcher matcher = pattern.matcher(testString);

        if(matcher.find())
            System.out.println("approved");
        else
            System.out.println("disapproved");
    }
}