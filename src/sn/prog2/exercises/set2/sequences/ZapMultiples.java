package sn.prog2.exercises.set2.sequences;

import java.util.ArrayList;

public class ZapMultiples implements Sequence, Filter {

    ArrayList<Integer> array = new ArrayList();
    int index;

    public ZapMultiples(Sequence s, int index) {
        this.index = index;
        while (s.hasNext()) {
            int nextElement = s.nextElement();
            if (testPassCondition(nextElement)) {
                array.add(nextElement);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !array.isEmpty();
    }

    @Override
    public int nextElement() {
        return array.remove(0);
    }

    @Override
    public boolean testPassCondition(int element) {
        return element % index != 0;
    }
}
