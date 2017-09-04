
package simulated2;
import java.util.ArrayList;
import java.util.Collections;

public class Tour {
    private ArrayList tour = new ArrayList<Ciudad>();
    private int distance = 0;
    public Tour(){
        for (int i = 0; i < SeguimientoCiudades.numberOfCities(); i++) {
            tour.add(null);
        }
    }
    public Tour(ArrayList tour){
        this.tour = (ArrayList) tour.clone();
    }
    public ArrayList getTour(){
        return tour;
    }
    public void generateIndividual() {
        for (int cityIndex = 0; cityIndex < SeguimientoCiudades.numberOfCities(); cityIndex++) {
          setCity(cityIndex, SeguimientoCiudades.getCity(cityIndex));
        }
        Collections.shuffle(tour);
    }
    public Ciudad getCity(int tourPosition) {
        return (Ciudad)tour.get(tourPosition);
    }
    public void setCity(int tourPosition, Ciudad city) {
        tour.set(tourPosition, city);
        distance = 0;
    }
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                Ciudad fromCity = getCity(cityIndex);
                Ciudad destinationCity;
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    //obtiene el numero de ciudades de nuestro tour
    public int tourSize() {
        return tour.size();
    }
    
    @Override
    public String toString() {
        String geneString = "-->";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"-->";
        }
        return geneString;
    }
}
