
package simulated2;

public class Simulated2 {
    public static double ProbabilidadAceptacion(int Energia, int NuevaEnergia, double Temperatura) {
        if (NuevaEnergia < Energia) {
            return 1.0;
        }
        return Math.exp((Energia - NuevaEnergia) / Temperatura);
    }
    public static void main(String[] args) {
        Ciudad ciudad1 = new Ciudad(10, 30);
        SeguimientoCiudades.addCity(ciudad1);
        Ciudad ciudad2 = new Ciudad(20, 10);
        SeguimientoCiudades.addCity(ciudad2);
        Ciudad ciudad3 = new Ciudad(50, 10);
        SeguimientoCiudades.addCity(ciudad3);
        Ciudad ciudad4 = new Ciudad(50, 30);
        SeguimientoCiudades.addCity(ciudad4);
        Ciudad ciudad5 = new Ciudad(40, 40);
        SeguimientoCiudades.addCity(ciudad5);
        Ciudad ciudad6 = new Ciudad(30, 50);
        SeguimientoCiudades.addCity(ciudad6);
        Ciudad ciudad7 = new Ciudad(30, 30);
        SeguimientoCiudades.addCity(ciudad7);        
        
        double temp = 10000;

        double VelocidadEnfriamiento = 0.003;

        Tour SolucionActual = new Tour();
        SolucionActual.generateIndividual();
        
        Tour ElMejor = new Tour(SolucionActual.getTour());
        while (temp > 1) {
            Tour NuevaSolucion = new Tour(SolucionActual.getTour());

            int tourPos1 = (int) (NuevaSolucion.tourSize() * Math.random());
            int tourPos2 = (int) (NuevaSolucion.tourSize() * Math.random());

            Ciudad citySwap1 = NuevaSolucion.getCity(tourPos1);
            Ciudad citySwap2 = NuevaSolucion.getCity(tourPos2);
            
            NuevaSolucion.setCity(tourPos2, citySwap1);
            NuevaSolucion.setCity(tourPos1, citySwap2);
            
           
            int EnergiaActual = SolucionActual.getDistance();
            int EnergiaVecindad = NuevaSolucion.getDistance();


            double Prob = ProbabilidadAceptacion(EnergiaActual, EnergiaVecindad, temp);
            double Rand = Math.random();
            if (Prob > Rand) {
                SolucionActual = new Tour(NuevaSolucion.getTour());
            }

            if (SolucionActual.getDistance() < ElMejor.getDistance()) {
                ElMejor = new Tour(SolucionActual.getTour());
            }

            temp *= 1-VelocidadEnfriamiento;
        }
        System.out.println("Final solution distance: " + ElMejor.getDistance());
        System.out.println("Tour: " + ElMejor);
    }
    
    
}
