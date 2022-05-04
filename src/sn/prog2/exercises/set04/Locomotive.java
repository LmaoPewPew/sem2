package sn.prog2.exercises.set04;

import java.util.LinkedList;

public class Locomotive {

    private final int length;
    private final int type;
    private final LinkedList<Car> cars;


    public Locomotive(int length, int type) {
        this.cars = new LinkedList<>();
        this.length = length;
        this.type = type;
    }

    public Car removeFirst() {
        Car temp = null;
        if (getSize() > 0) {
            temp = getFirst();
            cars.removeFirst();
        }
        return temp;
    }

    public void add(int index, Car car) {
        index = Math.min(cars.size() - 1, index);
        cars.add(index, car);
        updateCars();
    }

    private void updateCars() {
        if (getSize() > 0) {
            for (int i = 0; i < cars.size(); i++) {
                try {
                    cars.get(i).setNext(cars.get(i + 1));
                } catch (IndexOutOfBoundsException e) {
                    cars.get(i).setNext(null);
                } catch (NullPointerException ignored) {
                }
            }
        }
    }

    public int getLength() {
        int value = 0;
        for (Car car : cars) value += car.getLength();
        return length + value;
    }

    public int getPassengers() {
        int value = 0;
        for (Car car : cars) value += car.getLength();
        return value;
    }

    public int getSize() {
        return cars.size();
    }

    public Car getFirst() {
        return cars.getFirst();
    }

    public void setFirst(Car car) {
        cars.addFirst(car);
    }


    public int getType() {
        return type;
    }

    public String carOutput() {
        String output = "";
        for (Car car : cars) {
            output += car;
        }
        return output;
    }

    @Override
    public String toString() {
        return String.format("Type: %d Length: %d", type, length);
    }
}
