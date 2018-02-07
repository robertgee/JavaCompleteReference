package jcr.chap15.ConstructorRefDemo2;// Demonstrate a constructor reference with a generic class.
 
// MyFunc is now a generic functional interface. 
interface MyFunc15<T> {
   MyClass15<T> func(T n);
} 
 
class MyClass15<T> {
  private T val; 
 
  // A constructor that takes an argument. 
  MyClass15(T v) { val = v; }
 
  // This is the default constructor. 
  MyClass15( ) { val = null;  }
 
  // ... 
 
  T getVal() { return val; };   
}     
 
class ConstructorRefDemo2 { 
 
  public static void main(String args[]) 
  { 
    // Create a reference to the MyClass<T> constructor. 
    MyFunc15<Integer> myClassCons = MyClass15<Integer>::new;
 
    // Create an instance of MyClass<T> via that constructor reference. 
    MyClass15<Integer> mc = myClassCons.func(100);
 
    // Use the instance of MyClass<T> just created. 
    System.out.println("val in mc is " + mc.getVal( )); 
  } 
}
