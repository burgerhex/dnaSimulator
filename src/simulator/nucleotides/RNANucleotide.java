package simulator.nucleotides;

import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"unused", "WeakerAccess"})
public class RNANucleotide extends Nucleotide {

    private static final Map<Base, Base> PAIRS = new HashMap<>() {
        {
            put(Base.A, Base.U); put(Base.U, Base.A);
            put(Base.C, Base.G); put(Base.G, Base.C);
        }
    };

    public RNANucleotide(Base base) {
        super(base);
        setBase(base);
    }

    public RNANucleotide(String base) {
        super(base);
        setBase(base);
    }

    @Override
    public void setBase(Base base) {
        if (base == Base.T)
            throw new IllegalArgumentException("base T is not allowed in RNANucleotide -- " +
                    "only A, U, G, C are allowed");

        super.setBase(base);
    }

    @Override
    public void setBase(String base) {
        if (base.equals("T"))
            throw new IllegalArgumentException("base T is not allowed in RNANucleotide -- " +
                    "only A, U, G, C are allowed");

        super.setBase(base);
    }

    @Override
    public RNANucleotide pair() {
        return new RNANucleotide(PAIRS.get(getBase()));
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RNANucleotide && ((RNANucleotide) obj).getBase() == getBase();
    }
}
