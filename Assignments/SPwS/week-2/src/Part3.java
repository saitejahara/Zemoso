public class Part3 {
    public boolean twoOccurrences(String a, String b){
        int first = b.indexOf(a);
        int second = b.lastIndexOf(a);
        if(first != second && (first!=-1 && second!=-1)) return true;
        return false;
    }
    public void testingTwoOccurrences(){
        String test = "a";
        String actual = "anagram";
        System.out.println("The String are : "+test+" and "+actual);
        System.out.println("Two occurrences is "+twoOccurrences(test,actual));

        test = "apple";
        actual = "anagram";
        System.out.println("The String are : "+test+" and "+actual);
        System.out.println("Two occurrences is "+twoOccurrences(test,actual));
    }
    public String lastPart(String test, String actual){
        if(actual.indexOf(test)==-1)return actual;
        else return actual.substring(actual.indexOf(test)+test.length());
    }
    public void testLastPart(){
        String test = "an";
        String actual = "banana";
        System.out.println("The part of the string after "+test+" in "+actual+" is "+ lastPart(test,actual) +".");
        test = "zoo";
        actual = "forest";
        System.out.println("The part of the string after "+test+" in "+actual+" is "+ lastPart(test,actual) +".");
    }
    public static void main(String[] args){
        Part3 p3=new Part3();
        p3.testingTwoOccurrences();
        p3.testLastPart();
    }
}