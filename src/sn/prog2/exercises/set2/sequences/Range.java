package sn.prog2.exercises.set2.sequences;

import java.util.ArrayList;

public class Range implements Sequence {
    ArrayList<Integer> array = new ArrayList();

    public Range(int start, int end) {
        for (int i = start; i <= end; i++) {
            array.add(i);
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
}
