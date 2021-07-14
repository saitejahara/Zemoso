public class Part2 {
    public String findSimpleGene(String dna,String startCodon, String stopCodon){
        //checking if the dna string is lowercase
        char[] charDNA=dna.toCharArray();
        boolean lower=false;
        for(char c : charDNA){
            if(Character.isLetter(c) && Character.isLowerCase(c)) {
                lower=true;
            }
        }
        String newStartCodon=startCodon;
        String newStopCodon=stopCodon;
        if(lower){
            newStartCodon=startCodon.toLowerCase();
            newStopCodon=stopCodon.toLowerCase();
        }

        int startPosition = dna.indexOf(newStartCodon);
        if(startPosition == -1){
            return "";
        }
        int endPosition = dna.indexOf(newStopCodon,startPosition+3);
        if(endPosition == -1){
            return "";
        }
        String possibleDNA = dna.substring(startPosition, endPosition+3);
        if(possibleDNA.length()%3==0){
            return possibleDNA;
        }
        else return "";
    }
    public void testFindSimpleGene() {
        String gene = "";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String dna = "AATATGTAGTAGTAGG";
        System.out.println("DNA Strand = " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene = " + gene);

        dna = "GTAGTAGTAA";
        System.out.println("DNA Strand = " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene = " + gene);

        dna = "GATGATGATGATGATGAT";
        System.out.println("DNA Strand = " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene = " + gene);

        dna = "ATCGTCATGTCGTATTAA";
        System.out.println("DNA Strand = " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene = " + gene);

        dna = "atcgtcatgtcgtattaa";
        System.out.println("DNA Strand = " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene = " + gene);

        dna = "GATGGATAATGC";
        System.out.println("DNA Strand = " + dna);
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("Gene = " + gene);
    }
    public static void main(String[] args){
        Part2 p2=new Part2();
        p2.testFindSimpleGene();
    }
}