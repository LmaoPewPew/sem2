package sn.prog2.exercises.set04;

public class Car {
    private final int length;
    private final int passengers;
    private Car next;

    public Car(int length, int passengers) {
        this.length = length;
        this.passengers = passengers;
    }

    public Car getNext() {
        return next;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setNext(Car next) {
        this.next = next;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Car{" + "length=" + length + ", passengers=" + passengers + ", next=" + next + '}';
    }
}
