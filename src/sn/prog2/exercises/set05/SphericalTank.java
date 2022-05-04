package sn.prog2.exercises.set05;

public class SphericalTank implements Tank {
    private double radius;

    public SphericalTank(double radius) {
        this.radius = radius;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public double getVolume() {
        return (4 / 3) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getSurface() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return String.format("\nSpherical Tank:\n" +
                        "radius = %.2f\n" +
                        "Volume = %.2f, Surface = %.2f"
                , radius, getVolume(), getSurface());
    }
}
