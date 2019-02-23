package simulator.nucleotides;

import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"unused", "WeakerAccess"})
public class DNANucleotide extends Nucleotide {

    private static final Map<Base, Base> PAIRS = new HashMap<>();

    static {
        PAIRS.put(Base.A, Base.T); PAIRS.put(Base.T, Base.A);
        PAIRS.put(Base.C, Base.G); PAIRS.put(Base.G, Base.C);
    }

    public DNANucleotide(Base base) {
        super(base);
        setBase(base);
    }

    public DNANucleotide(String base) {
        super(base);
        setBase(base);
    }

    @Override
    public void setBase(Base base) {
        if (base == Base.U)
            throw new IllegalArgumentException("base U is not allowed for DNANucleotide -- " +
                    "only A, T, G, C are allowed");

        super.setBase(base);
    }

    @Override
    public void setBase(String base) {
        if (base.equals("U"))
            throw new IllegalArgumentException("base U is not allowed in DNANucleotide -- " +
                    "only A, T, G, C are allowed");

        super.setBase(base);
    }

    @Override
    public DNANucleotide pair() {
        return new DNANucleotide(PAIRS.get(getBase()));
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof DNANucleotide && ((DNANucleotide) obj).getBase() == getBase();
    }
}
