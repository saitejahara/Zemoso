import edu.duke.*;
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
    public StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        while (true){
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) +
                    currentGene.length();
        }
        return geneList;
    }
    public void testGetAllGenes(){
        System.out.println(getAllGenes("ATGAAATAGATGTAG").data());
    }
    public float cgRatio (String dna){
        int indexC = dna.indexOf("C");
        int countC = 0;
        while( indexC != -1) {
            countC +=1;
            indexC=dna.indexOf("C", indexC + 1);
        }
        int indexG = dna.indexOf("G");
        int countG = 0;
        while( indexG != -1) {
            countG +=1;
            indexG=dna.indexOf("G", indexG + 1);
        }
        return (float) (countC+ countG)/ dna.length();
    }
    public void testcgRatio(){
        String dna="CCCCAAGCCC";
        System.out.println("Result: "+cgRatio(dna));
        dna="CCCGGGGGAAAGGG";
        System.out.println("Result : "+cgRatio(dna));
        dna = "AAACCCCAAGG";
        System.out.println("Result: "+cgRatio(dna));
    }
    public void processGenes(StorageResource sr){
        int count_1 = 0;
        int count_2 = 0;
        int max = 0;
        String maxStr ="";

        for (String str : sr.data()){
            if(str.length()> max){
                max = str.length();
                maxStr =str;
            }
            if( str.length() > 60){
                System.out.println(str);
                count_1++;
            }
            if (cgRatio (str) > 0.35) {
                System.out.println(str);
                count_2++;
            }
        }
        System.out.println("Longest gene is : " + max + " is " +maxStr);
        System.out.println("Greater than 9 characters: "+ count_1);
        System.out.println("Greater than 0.35 CG ratio :" + count_2);
    }
    public void testProcessGenes(){
        //processGenes(CreateSR());
        testStorageFinder();
    }

    public StorageResource CreateSR(){
        StorageResource sr = new StorageResource();
        sr.add("ATGCCCCGGTAA");
        sr.add("ATGCCCGGGTTTTTTTTTTTTTTTTAA");
        sr.add("ATGTTTTTTTTTTTTTTTTAA");
        for(String s : sr.data()){
            System.out.println("List of genes: " + s);
        }
        return sr;
    }
    public void testStorageFinder(){
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        StorageResource sr = getAllGenes(dna);

        System.out.println("Genes:");
        for(int i =0; i < sr.size(); i++){
            System.out.println("Genes:");
            processGenes(sr);
            System.out.println("Total number of genes: " + sr.size());
        }
    }
    public static void main(String[] args){
        Part1 p1=new Part1();
        p1.testFindStopCodon();
        p1.testFindGene();
        p1.printAllGenes("ATGAAATAGATGTAG");
        p1.testGetAllGenes();
        p1.testcgRatio();
        p1.testProcessGenes();
        p1.testStorageFinder();
    }
}