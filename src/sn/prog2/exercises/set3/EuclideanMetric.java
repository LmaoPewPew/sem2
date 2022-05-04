package sn.prog2.exercises.set3;

public class EuclideanMetric  {

    RoundTrip locationList; //Problem / Punkte nacheinander
    RoundTrip tour; // Lösung


    public void createProblem1(){
        RoundTrip roundTrip = new RoundTrip (6);
        locationList.add (new Location("A", 1,1));
        locationList.add (new Location("B", 1,2));
        locationList.add (new Location("C", 2,1));
        locationList.add (new Location("D", 2,2));
        locationList.add (new Location("E", 3,1));
        locationList.add (new Location("F", 3,2));
    }
    public void createProblem2(){}

    private double getDistance (Location loc1, Location loc2){
        double distX = loc1.getX() - loc2.getX();
        double distY = loc1.getY() - loc2.getY();
        return Math.sqrt(Math.pow(distX,2) + distY*distY);
    }
    public void createTour () {
        tour = new RoundTrip(locationList.getSize());
        tour.add(locationList.get(0)); //Startpunkt bestimmen
        //jetzt folgt Greedy-Alg -> schauen, was nächste Punkt ist
        while (tour.getSize() != locationList.getSize()) {
            Location last = tour.get(tour.getSize()-1);
            Location next = null;
            double minDist = Double.MAX_VALUE;
            // minDist mit allen vergleichen// next überschreiben
            // über alle Locations vom Problem iterieren
            // Wir suchen den besten Nachfolger (kürzeste Entferung)
            // Dieser darf aber noch nicht in der Lösung vorhanden sein!
            // Überprüfung mit tour.contains()
        }
    }
}
