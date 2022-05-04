package sn.prog2.exercises.set05;

public class TankTest {
    public static void main(String[] args) {
        CuboidTank cuboidTank = new CuboidTank(4, 2, 6);
        CylindricalTank cylindricalTank = new CylindricalTank(5, 3);
        SphericalTank sphericalTank = new SphericalTank(2);

        CompoundTank compTank = new CompoundTank();
        compTank.add(new CuboidTank(2, 2, 2));
        compTank.add(new CylindricalTank(2, 2));
        compTank.add(new SphericalTank(2));

        System.out.println("Cuboid Tank:");
        System.out.println(cuboidTank + "\n");


        System.out.println("Cylindrical Tank:");
        System.out.println(cylindricalTank + "\n");


        System.out.println("Spherical Tank:");
        System.out.println(sphericalTank + "\n");


        System.out.println("Compound Tank:");
        System.out.println(compTank + "\n");
    }
}
