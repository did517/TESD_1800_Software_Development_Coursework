public class Octagon extends GeometricObject implements Cloneable, Comparable  {
    private double side;
    
    public Octagon(){

    }
    public Octagon(double side){
        this.side = side;
    }
    
    public Octagon howToClone() {
        Octagon cloned = new Octagon(this.side);
        return cloned;
    }
    public int howToCompare(Octagon other){
       return Double.compare(this.getArea(),other.getArea());
    }
    public double getSide(){
        return side;
    }
    public void setSide(double side){
        this.side=side;
    }
    public double getArea(){
         return (2 + 4 / Math.sqrt(2)) * side * side;

    }
    public double getPerimeter(){
        return 8 * side;
    }
	public int compareTo(Octagon o){
        return howToCompare(o);
    }


}
