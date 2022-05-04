package sn.prog2.exercises.set05;

public class CuboidTank implements Tank {
    private double length;
    public double width;
    public double height;

    public CuboidTank(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public double getVolume() {
        return length * height * width;
    }

    @Override
    public double getSurface() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    @Override
    public String toString() {
        return String.format("\nCuboid Tank:\n" +
                        "length = %.2f, width = %.2f, height = %.2f\n" +
                        "Volume = %.2f, Surface = %.2f"
                , length, width, height, getVolume(), getSurface());
    }

}
