public class TestProgramOctagon {
    public static void main(String[] args) {
        Octagon Object1 = new Octagon(5);
       System.out.println("Ocatgon1 :");
       System.out.println("Area: " + Object1.getArea());
       System.out.println("Perimeter :" + Object1.getPerimeter());
       Octagon Object2 = new Octagon();
       Object2 = (Octagon) Object1.howToClone();
       System.out.println(" Cloned Octagon1");
       System.out.println("Area : " + Object2.getArea());
       System.out.println("Perimeter :" + Object2.getPerimeter());
        //comparaison
        int result = Object1.howToCompare(Object2);
        if(result ==0){
            System.out.println("The two ocatgons are equal");
        }
        else if(result >0){
            System.out.println("The first ocatgon is larger");
        }
        else{
            System.out.println("The secong octagon is larger");
        }
    }
}    

