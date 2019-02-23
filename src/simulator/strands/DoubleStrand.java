package simulator.strands;

import simulator.nucleotides.Nucleotide;

@SuppressWarnings({"unused", "WeakerAccess"})
public class DoubleStrand<T extends Nucleotide> {

    private SingleStrand<T> strand1;
    private SingleStrand<T> strand2;

    public DoubleStrand(SingleStrand<T> strand) {
        setStrand1(strand);
        setStrand2(strand.getComplementaryStrand());
    }

    public DoubleStrand(SingleStrand<T> strand1, SingleStrand<T> strand2) {
        setStrand1(strand1);
        setStrand2(strand2);
    }

    public SingleStrand<T> getStrand1() {
        return strand1;
    }
    public SingleStrand<T> getStrand2() {
        return strand2;
    }

    public void setStrand1(SingleStrand<T> newSeq) {
        this.strand1 = newSeq;
    }
    public void setStrand2(SingleStrand<T> newSeq) {
        this.strand2 = newSeq;
    }

    public boolean matches() {
        return getStrand1().equals(getStrand2().getComplementaryStrand()) &&
               getStrand2().equals(getStrand1().getComplementaryStrand());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (T n : getStrand1().getSequence())
            result.append(n);

        result.append("\n");

        for (T n : getStrand2().getSequence())
            result.append(n);

        return result.toString();
    }
}
