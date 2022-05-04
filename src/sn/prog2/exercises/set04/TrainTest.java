package sn.prog2.exercises.set04;

public class TrainTest {
    public static void main(String[] args) {
        Locomotive bigChief = new Locomotive(23, 5311);

        Train santaFe = new Train(bigChief);
        santaFe.add(0, new Car(212, 231));
        santaFe.add(0, new Car(12, 50));
        santaFe.add(1, new Car(15, 75));
        santaFe.add(2, new Car(20, 100));
        santaFe.add(8, new Car(32, 125));

        Locomotive steelHorse = new Locomotive(21,5409);

        Train rioGrandeExpress = new Train(steelHorse);
        rioGrandeExpress.add(0,new Car(13,60));
        rioGrandeExpress.add(1,new Car(18,80));

        rioGrandeExpress.relink(santaFe);
        System.out.println("Rio Grande Express: " + rioGrandeExpress);
        System.out.println("Santa Fe: " + santaFe);

        rioGrandeExpress.revert();

        System.out.println(rioGrandeExpress);
        System.out.println(santaFe);


    }
}
