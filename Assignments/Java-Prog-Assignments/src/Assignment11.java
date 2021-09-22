import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Assignment11
{
    public static void main(String args[]) throws IOException {
        File file = new File("src/Assignment11_dataSource");
        Scanner sc = new Scanner(file);

        HashMap<String,Integer> hashMap = new HashMap<>();

        while (sc.hasNext()) {
            String literal = sc.next();
            if(hashMap.containsKey(literal)) {
                hashMap.put(literal,hashMap.get(literal) +1);
            } else {
                hashMap.put(literal,1);
            }
        }

        FileWriter myWriter = new FileWriter("src/Assignment11_dataDest");

        for(String key : hashMap.keySet()) {
            myWriter.write(key + " : " + hashMap.get(key) + "\n");
        }

        myWriter.close();

        hashMap.forEach((key,value)->{ System.out.println(key+" "+value); });
    }
}