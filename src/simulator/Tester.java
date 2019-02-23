package simulator;

import simulator.nucleotides.*;
import simulator.strands.*;

public class Tester {

    public static void main(String[] args) {

        // ssRNA
        SingleStrand<RNANucleotide> rna = new SingleStrand<>("AUGCAGC", RNANucleotide.class);

        System.out.println("rna  = " + rna);
        System.out.println("comp = " + rna.getComplementaryStrand());
        System.out.println();

        // ssDNA
        SingleStrand<DNANucleotide> dna = new SingleStrand<>("GTCACGT", DNANucleotide.class);

        System.out.println("dna  = " + dna);
        System.out.println("comp = " + dna.getComplementaryStrand());
        System.out.println();

        // dsRNA (1 input)
        DoubleStrand<RNANucleotide> rna2 = new DoubleStrand<>(new SingleStrand<>("AUGCCG", RNANucleotide.class));

        System.out.println("rna2 (matches? " + (rna2.matches()? "yes" : "no") + ") = \n" + rna2);
        System.out.println();

        // dsDNA (1 input)
        DoubleStrand<DNANucleotide> dna2 = new DoubleStrand<>(new SingleStrand<>("TATCGA", DNANucleotide.class));

        System.out.println("dna2 (matches? " + (dna2.matches()? "yes" : "no") + ") = \n" + dna2);
        System.out.println();

        // dsRNA (2 inputs)
        DoubleStrand<RNANucleotide> rna3 = new DoubleStrand<>(
                new SingleStrand<>("AUGCCG", RNANucleotide.class),
                new SingleStrand<>("UACGGG", RNANucleotide.class)
        );

        System.out.println("rna3 (matches? " + (rna3.matches()? "yes" : "no") + ") = \n" + rna3);
        System.out.println();

        // dsDNA (2 inputs)
        DoubleStrand<DNANucleotide> dna3 = new DoubleStrand<>(
                new SingleStrand<>("TATCGA", DNANucleotide.class),
                new SingleStrand<>("ATAGCA", DNANucleotide.class)
        );

        System.out.println("dna3 (matches? " + (dna3.matches()? "yes" : "no") + ") = \n" + dna3);
        System.out.println();

    }

}
