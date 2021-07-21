import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Assignment1{
    //path for home directory
    private static final String path = System.getProperty("user.home");
    //creating a parent directory file
    private static File file = new File(path);

    public static void searchHomeDirectory(String regexPattern) {
        //gets all files in the path
        File[] files = file.listFiles();

        int patternMatches = 0;
        Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        for(File file : files) {
            Matcher matcher = null;
            try {
                //matching in the path
                matcher = pattern.matcher(file.getCanonicalPath());
            } catch (IOException e) {
                System.out.println("Some error has occurred while processing");
            }
            boolean matchFound = matcher.find();
            if(matchFound) {
                try {
                    //counting the no of matches found in the entire list
                    patternMatches++;
                    System.out.println(file.getCanonicalPath());
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        //if no files matched
        if(patternMatches == 0) {
            System.out.println("No files match the regex");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter regex pattern");
        while(true) {
            String regexPattern = sc.nextLine();

            if(regexPattern.equalsIgnoreCase("terminate"))
                break;

            searchHomeDirectory(regexPattern);
        }
    }
}