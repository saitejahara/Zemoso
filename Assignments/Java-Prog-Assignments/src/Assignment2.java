import java.util.*;
public class Assignment2 {
    //checking if string contains all alphabets
    public static boolean containsAtoZ(String str){
        Set<Character> charArray = new HashSet<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a' && str.charAt(i)<='z')
                charArray.add(str.charAt(i));
        }
        return charArray.size()==26;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");

        String testString = sc.nextLine();

        if(containsAtoZ(testString))
        {
            System.out.println(testString+ " contains a-z");
        }
        else
        {
            System.out.println(testString+ " doesn't contain a-z");
        }
    }
}

//Time complexity O(n)
//Space complexity O(1)