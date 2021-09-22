package FindingUniqueIPAddresses;

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        la.printAll();
    }
    
    public void testUniqueIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        System.out.println("Total unique IPs = " + la.countUniqueIPs());
    }
    
    public void testPrintAllHigherThanNum() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        la.printAllHigherThanNum(200);
    }
    
    public void testUniqueIPVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        
        ArrayList<String> record = la.uniqueIPVisitsOnDay("Sep 14");
        System.out.println("Sep 14 = " + record);
        
        record = la.uniqueIPVisitsOnDay("Sep 30");
        System.out.println("Sep 30 = " + record);
    }
    
    public void testCountUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        System.out.println("countUniqueIPsInRange 200 - 299 = " + la.countUniqueIPsInRange(200, 299));
        System.out.println("countUniqueIPsInRange 300 - 399 = " + la.countUniqueIPsInRange(300, 399));
    }

    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.testLogEntry();
        tester.testLogAnalyzer();
        tester.testUniqueIP();
        tester.testPrintAllHigherThanNum();
        tester.testUniqueIPVisitsOnDay();
        tester.testCountUniqueIPsInRange();
    }
}
