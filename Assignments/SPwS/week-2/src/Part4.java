import edu.duke.*;

public class Part4 {
    public static void printUrls(String url) {
        URLResource myurl = new URLResource(url);
        for(String word : myurl.words()) {
            //System.out.println(word);
            if(word.toLowerCase().indexOf("youtube.com") != -1) {
                int firstQuoteIndex = word.indexOf("\"");
                int lastQuoteIndex = word.indexOf("\"", firstQuoteIndex+1);
                System.out.println(word.substring(firstQuoteIndex+1, lastQuoteIndex));

            }
        }
    }

    public static void main(String[] args) {
        String url="https://www.dukelearntoprogram.com//course2/data/manylinks.html";
        printUrls(url);
    }
}