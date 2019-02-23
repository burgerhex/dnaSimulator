package simulator.nucleotides;

@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class Nucleotide {

    private Base base;

    public Nucleotide(Base base) {
        setBase(base);
    }

    public Nucleotide(String base) {
        setBase(base);
    }

    public void setBase(Base base){
        this.base = base;
    }

    public void setBase(String base) {
        try {
            this.base = Base.valueOf(base);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("base '" + base + "' is not a valid base -- " +
                    "only A, T, G, C, U are allowed");
        }
    }

    public Base getBase() {
        return base;
    }

    public abstract Nucleotide pair();

    public int bonds() {
        if (base == Base.A || base == Base.T || base == Base.U)
            return 2;
        else if (base == Base.G || base == Base.C)
            return 3;
        else
            return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Nucleotide;
    }

    @Override
    public String toString() {
        return base.name();
    }
}
