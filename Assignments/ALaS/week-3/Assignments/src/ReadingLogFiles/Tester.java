package ReadingLogFiles;


import edu.duke.FileResource;

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

    public static void main(String[] args) {
        Tester tester = new Tester();

        tester.testLogEntry();
        tester.testLogAnalyzer();
    }
}