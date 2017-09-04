
package simulated2;
import java.util.ArrayList;

public class SeguimientoCiudades {
    private static ArrayList destinationCities = new ArrayList<Ciudad>();
    public static void addCity(Ciudad city) {
        destinationCities.add(city);
    }
    public static Ciudad getCity(int index){
        return (Ciudad)destinationCities.get(index);
    }
    public static int numberOfCities(){
        return destinationCities.size();
    }
}
