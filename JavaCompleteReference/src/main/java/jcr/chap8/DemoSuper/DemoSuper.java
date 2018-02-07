package jcr.chap8.DemoSuper;

// A complete implementation of BoxWeight3.
class Box3 {
  private double width;
  private double height;
  private double depth;

  // construct clone of an object
  Box3(Box3 ob) { // pass object to constructor
    width = ob.width;
    height = ob.height;
    depth = ob.depth;
  }

  // constructor used when all dimensions specified
  Box3(double w, double h, double d) {
    width = w;
    height = h;
    depth = d;
  }

  // constructor used when no dimensions specified
  Box3() {
    width = -1;  // use -1 to indicate
    height = -1; // an uninitialized
    depth = -1;  // box
  }

  // constructor used when cube is created
  Box3(double len) {
    width = height = depth = len;
  }

  // compute and return volume
  double volume() {
    return width * height * depth;
  }
}

// BoxWeight3 now fully implements all constructors.
class BoxWeight3 extends Box3 {
  double weight; // weight of box

  // construct clone of an object
  BoxWeight3(BoxWeight3 ob) { // pass object to constructor
    super(ob);
    weight = ob.weight;
  }

  // constructor when all parameters are specified
  BoxWeight3(double w, double h, double d, double m) {
    super(w, h, d); // call superclass constructor
    weight = m;
  }    

  // default constructor
  BoxWeight3() {
    super();
    weight = -1;
  }

  // constructor used when cube is created
  BoxWeight3(double len, double m) {
    super(len);
    weight = m;
  }
}
  
class DemoSuper {
  public static void main(String args[]) {
    BoxWeight3 mybox1 = new BoxWeight3(10, 20, 15, 34.3);
    BoxWeight3 mybox2 = new BoxWeight3(2, 3, 4, 0.076);
    BoxWeight3 mybox3 = new BoxWeight3(); // default
    BoxWeight3 mycube = new BoxWeight3(3, 2);
    BoxWeight3 myclone = new BoxWeight3(mybox1);
    double vol;

    vol = mybox1.volume();
    System.out.println("Volume of mybox1 is " + vol);
    System.out.println("Weight of mybox1 is " + mybox1.weight);
    System.out.println();

    vol = mybox2.volume();
    System.out.println("Volume of mybox2 is " + vol);
    System.out.println("Weight of mybox2 is " + mybox2.weight);
    System.out.println();

    vol = mybox3.volume();
    System.out.println("Volume of mybox3 is " + vol);
    System.out.println("Weight of mybox3 is " + mybox3.weight);
    System.out.println();
 
    vol = myclone.volume();
    System.out.println("Volume of myclone is " + vol);
    System.out.println("Weight of myclone is " + myclone.weight);
    System.out.println();

    vol = mycube.volume();
    System.out.println("Volume of mycube is " + vol);
    System.out.println("Weight of mycube is " + mycube.weight);
    System.out.println();
  }
}
