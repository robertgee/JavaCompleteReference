package jcr.chap15.ConstructorRefDemo3;// Implement a simple class factory using a constructor reference.
 
interface MyFunc150<R, T> {
   R func(T n); 
} 
 
// A simple generic class. 
class MyClass150<T> {
  private T val; 
 
  // A constructor that takes an argument. 
  MyClass150(T v) { val = v; }
 
  // The default constructor. This constructor 
  // is NOT used by this program. 
  MyClass150() { val = null; }
  // ... 
 
  T getVal() { return val; };   
}     

 
class ConstructorRefDemo3 { 
 
  // A factory method for class objects. The class must <
  // have a constructor that takes one parameter of type T. 
  // R specifies the type of object being created. 
  static <R,T> R myClassFactory(MyFunc150<R, T> cons, T v) {
    return cons.func(v); 
  } 
  
  public static void main(String args[]) 
  { 
    // Create a reference to a MyClass constructor. 
    // In this case, new refers to the constructor that 
    // takes an argument. 
    MyFunc150<MyClass150<Double>, Double> myClassCons = MyClass150<Double>::new;
 
    // Create an instance of MyClass by use of the factory method. 
    MyClass150<Double> mc = myClassFactory(myClassCons, 100.1);
 
    // Use the instance of MyClass just created. 
    System.out.println("val in mc is " + mc.getVal( )); 
 
    // Now, create a different class by use of myClassFactory(). 
    MyFunc150<MyClass150, String> myClassCons2 = MyClass150::new;
 
    // Create an instance of MyClass2 by use of the factory method. 
    MyClass150 mc2 = myClassFactory(myClassCons2, "Lambda");
 
    // Use the instance of MyClass just created. 
    System.out.println("str in mc2 is " + mc2.getVal( )); 
  } 
}
