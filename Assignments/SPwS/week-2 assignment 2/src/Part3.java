public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int nextIndex = dna.indexOf(stopCodon, startIndex + 1);
        while (nextIndex < dna.length()) {
            if (nextIndex == -1) return dna.length();
            if ((nextIndex - startIndex) % 3 == 0) return nextIndex;
            else nextIndex = dna.indexOf(stopCodon, nextIndex + 1);
        }
        return dna.length();
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
    public void printAllGenes(String dna){
        int start=0;
        while(true){
            String gene = findGene(dna, start);
            if(gene.equals(""))break;
            System.out.println("Gene : "+gene);
            start = dna.indexOf(gene,start)+ gene.length();
        }
    }
    public int countGenes(String dna){
        int count=0;
        int start=0;
        while(true){
            String gene = findGene(dna, start);
            if(gene.equals(""))break;
            count++;
            start = dna.indexOf(gene,start)+ gene.length();
        }
        return count;
    }
    public void testCountGenes(){
        System.out.println("No of genes "+countGenes("ATGAAATAGATGTGA"));
    }
    public static void main(String[] args){
        Part3 p3=new Part3();
        p3.testCountGenes();
        p3.printAllGenes("ATGAAATAGATGTAG");
    }
}