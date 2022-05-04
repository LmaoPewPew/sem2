package sn.prog2.exercises.set2.sequences;

import java.util.ArrayList;

public class Naturals implements Sequence {
    ArrayList<Integer> array = new ArrayList();

    public Naturals() {
        for (int i = 1; i <= 10; i++) {
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
