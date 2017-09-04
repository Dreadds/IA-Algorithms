
package simulated2;
public class Ciudad {
    int x;
    int y;
    public Ciudad(){
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }

    public Ciudad(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public double distanceTo(Ciudad city){
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    @Override
    public String toString(){
        return getX()+", "+getY();
    }
}
