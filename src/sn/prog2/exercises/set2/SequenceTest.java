package sn.prog2.exercises.set2;

import sn.prog2.exercises.set2.sequences.*;

public class SequenceTest {


    public static void main(String[] args) {
        System.out.print("Naturals:\t");
        println(new Naturals());
        System.out.print("\nRange:\t\t");
        println(new Range(7, 14));
        System.out.print("\nEvens:\t\t");
        println(new Evens(new Range(7, 14)));
        System.out.print("\nZapMulti:\t");
        println(new ZapMultiples(new Range(7, 14),3));
        System.out.print("\nMultiEvens: ");
        println(new ZapMultiples(new Evens(new Naturals()), 2));
    }

    public static void println(Sequence s) {
        while (s.hasNext()) {
            System.out.print(s.nextElement() + ". ");
        }
    }
}
