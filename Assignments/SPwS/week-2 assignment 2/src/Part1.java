public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int nextIndex = dna.indexOf(stopCodon, startIndex+1);
        while(true) {
            if (nextIndex == -1) return dna.length();
            if((nextIndex-startIndex)%3 ==0)return nextIndex;
            else nextIndex = dna.indexOf(stopCodon, nextIndex+3);
        }

    }
    public void testFindStopCodon(){
        System.out.println(findStopCodon("ATAATGTAGCTACTATAG",3,"TAG"));
        System.out.println(findStopCodon("ATAAATGCTATAAG",4,"TAG"));
        System.out.println(findStopCodon("ATAATGACTATAG",3,"TAG"));
    }
    public String findGene(String dna, int index){
        dna = dna.toUpperCase();
        int atgCodon = dna.indexOf("ATG", index);
        if (atgCodon == -1) {
            return "";
        }
        int taaCodon = findStopCodon(dna, atgCodon, "TAA");
        int tagCodon = findStopCodon(dna, atgCodon, "TAG");
        int tgaCodon = findStopCodon(dna, atgCodon, "TGA");
        int closestStopCodon = Math.min(taaCodon, Math.min(tgaCodon,tagCodon));
        if (closestStopCodon == dna.length()) return "";
        return dna.substring(atgCodon, closestStopCodon+3);
    }
    public void testFindGene(){
        String dna= "AGDEGAASZZATAAAAA";
        System.out.println("DNA Strand:" + dna.toUpperCase());
        String gene = findGene(dna, 0);
        System.out.println("Gene :" + gene);

        dna= "aaaaaaATGaaaaaaaaaTAGaaaa";
        System.out.println("DNA Strand:" + dna.toUpperCase());
        gene = findGene(dna, 0);
        System.out.println("Gene :" + gene);

        dna= "aaaaaaATGaaaaaaaaaTAGTTATGAaaa";
        System.out.println("DNA Strand:" + dna.toUpperCase());
        gene = findGene(dna, 0);
        System.out.println("Gene :" + gene);

        dna= "aaaaaaATGaaaaaaaaaAAAAaaa";
        System.out.println("DNA Strand:" + dna.toUpperCase());
        gene = findGene(dna, 0);
        System.out.println("Gene :" + gene);
    }
    public void printAllGenes(String dna){
        int start=0;
        while(true){
            String gene = findGene(dna, start);
            if(gene.equals(""))break;
            System.out.println("Gene : "+gene);
            start = dna.indexOf(gene,start)+ gene.length();
        }
    }
    public static void main(String[] args){
        Part1 p1=new Part1();
        p1.testFindStopCodon();
        p1.testFindGene();
        p1.printAllGenes("ATGAAATAGATGTAG");
    }
}