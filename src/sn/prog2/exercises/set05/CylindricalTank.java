package sn.prog2.exercises.set05;

public class CylindricalTank implements Tank {
    private double radius;
    public double height;

    public CylindricalTank(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public double getVolume() {
        return Math.PI * height * Math.pow(radius, 2);
    }

    @Override
    public double getSurface() {
        return 2 * Math.PI * radius * (radius + height);
    }

    @Override
    public String toString() {
        return String.format("\nCylindrical Tank:\n" +
                        "radius = %.2f, height = %.2f\n" +
                        "Volume = %.2f, Surface = %.2f"
                , radius, height, getVolume(), getSurface());
    }
}
