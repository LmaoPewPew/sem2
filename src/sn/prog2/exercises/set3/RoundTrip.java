package sn.prog2.exercises.set3;

//Verwaltung von Loc. für
//a) alle Punkte die besucht werden sollen
//b)Die Lösung (Rundreise), die wir schrittweise aufbauen
// Vwerwaltung mit array list


import java.util.Arrays;

public class RoundTrip {
    private Location[] locations;
    private int size;

    public RoundTrip(int size) {
        locations = new Location[size];

    }

    public void add(Location location) {
        locations[size++] = location;
        // Alle Plätze belegt -> Exception!
        // if size = array.length

    }

    public int getSize() {
        return size;
    }

    public Location get(int index) {
        return locations[index];
    }

    public boolean contains(Location location) {
        for (int i = 0; i < size; i++) {
            if (locations[i] == location) { // referenz vergleichen (Adresse)
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "RoundTrip{" +
                "locations=" + Arrays.toString(locations) +
                ", size=" + size +
                '}';
    }
}

