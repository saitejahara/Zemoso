import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Assignment1{
    //path for home directory
    private static final String path = System.getProperty("user.home");
    //creating a parent directory file
    private static File file = new File(path);

    public static void searchHomeDirectory(String regexPattern) {
        //gets all files in the path
        File[] files = file.listFiles();

        int patternMatches = 0;
        //defines a string as a pattern
        Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        for(File file : files) {
            //used to search the pattern generated above
            Matcher matcher = null;
            try {
                //matching in the path mentioned above
                matcher = pattern.matcher(file.getCanonicalPath());
            }
            catch (IOException e) {
                System.out.println(e);
            }
            boolean matchFound = matcher.find();
            if(matchFound) {
                try {
                    //counting the no of matches found in the entire list
                    patternMatches++;
                    System.out.println(file.getCanonicalPath());
                }
                catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        //no files found with matching pattern
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