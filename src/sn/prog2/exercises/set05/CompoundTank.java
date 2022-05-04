package sn.prog2.exercises.set05;

import java.util.ArrayList;
import java.util.Iterator;

public class CompoundTank {
    private double volume;
    private double surface;
    ArrayList<Tank> tankList;
    Iterator<Tank> tankIterator;

    public CompoundTank() {
        tankList = new ArrayList<>();
        tankIterator = tankList.iterator();
    }

    public void add(Tank tank) {
        tankList.add(tank);
        volume += tank.getVolume();
        surface += tank.getSurface();
    }

    public double getVolume() {
        return volume;
    }

    public double getSurface() {
        return surface;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.format("Compound Tank: " +
                        "Volume = %.2f, Surface = %.2f\n" +
                        "Tank-List:\n" + tankList +
                        "\nTank Iterator:\n" + tankIterator
                , getVolume(), getSurface());
    }
}
