package simulator.strands;

import simulator.nucleotides.Base;
import simulator.nucleotides.Nucleotide;

import java.util.ArrayList;
import java.util.stream.Collectors;

@SuppressWarnings({"unused", "WeakerAccess"})
public class SingleStrand<T extends Nucleotide> {

    private ArrayList<T> seq = new ArrayList<>();

    public SingleStrand(ArrayList<T> seq) {
        setSequence(seq);
    }

    public SingleStrand(String seq, Class<T> cls) {
        ArrayList<Base> bases = new ArrayList<>();

        for (char c : seq.toCharArray())
            bases.add(Base.valueOf(Character.toString(c)));

        ArrayList<T> result =
                (ArrayList<T>)
                bases
                .stream()
                .map(b -> {
                    try {
                        return cls.getDeclaredConstructor(Base.class).newInstance(b);
                    } catch (Exception e) {
                        throw new IllegalArgumentException("base " + b.name() + " not allowed for "
                                + cls.getSimpleName() + "; did you input the correct class?");
                    }
                })
                .collect(Collectors.toList());

        setSequence(result);
    }

    public ArrayList<T> getSequence() {
        return seq;
    }

    public void setSequence(ArrayList<T> newSeq) {
        this.seq = newSeq;
    }

    public SingleStrand<T> getComplementaryStrand() {
        return new SingleStrand<>(
                (ArrayList<T>)
                getSequence()
                .stream()
                .map(T::pair)
                .collect(Collectors.toList())
        );
    }

    public boolean complements(SingleStrand<T> other) {
        return getComplementaryStrand().equals(other);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (T n : getSequence())
            result.append(n);

        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SingleStrand && ((SingleStrand) obj).getSequence().equals(getSequence());
    }
}
