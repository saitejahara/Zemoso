import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Assignment3 {

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter DNS or DNS mapping address : ");
        String ipAddress = sc.nextLine();

        pingHost(ipAddress);
    }

    public static void pingHost(String ipAddress) {
        try {
            List<Double> pingList = new ArrayList<>();
            //to invoke a command line exec environment
            Process process = Runtime.getRuntime().exec("ping " + ipAddress);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String stream = "";
            // reading output stream of the command
            while ((stream = inputStream.readLine()) != null) {

                //to print the entire CLI output for reference
                //System.out.println(stream);

                //for the first line of output
                if(stream.startsWith("PING")) {
                    continue;
                }

                //calculating median for odd and even values
                calculateMedian(stream,pingList);
                double med1 = pingList.get(pingList.size()/2);

                if(pingList.size() % 2 == 0) {
                    double med2 = pingList.get((pingList.size()/2) - 1);
                    System.out.println("Median :" + (med1 + med2)/2);
                }
                else {
                    System.out.println("Median :" + med1);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void calculateMedian(String stream,List<Double> pingList) {
        //considers input starting from the specified string
        String temp[] = stream.split("time=");

        //excludes the last 3 character bits from extracted string (" ms")
        double pingTime = Double.parseDouble(temp[1].substring(0,temp[1].length()-3));
        pingList.add(pingTime);
        Collections.sort(pingList);
    }
}