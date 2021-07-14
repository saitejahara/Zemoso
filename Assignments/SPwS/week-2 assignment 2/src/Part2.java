public class Part2 {
    public int howMany(String a, String b){
        int count=0;
        while(b.indexOf(a)!=-1){
            b = b.substring(b.indexOf(a)+a.length());
            count++;
        }
        return count;
    }
    public void testHowMany(){
        System.out.println("The number of AA in ATAAAA are "+howMany("AA","ATAAAA"));
        System.out.println("The number of GAA in ATGAACGAATTGAATC are "+howMany("GAA","ATGAACGAATTGAATC"));
    }
    public static void main(String[] args){
        Part2 p2=new Part2();
        p2.testHowMany();
    }
}