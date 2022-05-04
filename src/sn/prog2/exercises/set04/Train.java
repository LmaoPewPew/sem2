package sn.prog2.exercises.set04;

import java.util.LinkedList;

public class Train {

    private final Locomotive locomotive;

    public Train(Locomotive locomotive) {
        this.locomotive = locomotive;
    }


    public void revert() {
        LinkedList<Car> cache = new LinkedList<>();
        while (hasCars()) {
            cache.addFirst(locomotive.getFirst());
            removeFirst();
        }
        while (cache.size() != 0) {
            add(locomotive.getSize(), cache.getFirst());
            cache.removeFirst();
        }
    }


    public void relink(Train train) {
        while (train.hasCars()) {
            locomotive.setFirst(train.removeFirst());
        }
    }

    public Car removeFirst() {
        return locomotive.removeFirst();
    }

    public int getLength() {
        return locomotive.getLength();
    }

    public int getPassengers() {
        return locomotive.getPassengers();
    }

    public boolean hasCars() {
        return locomotive.getSize() > 0;
    }

    public void add(int index, Car car) {
        if (index == 0) locomotive.setFirst(car);
        else locomotive.add(index, car);
    }

    @Override
    public String toString() {
        return String.format("%s Total Passengers: %d Total Length: %d Total Cars: %d", locomotive, getPassengers(), getLength(), locomotive.getSize());
    }
}

