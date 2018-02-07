package jcr.chap13;

class MyClass13 {
  int a; 
  int b; 
 
  // initialize a and b individually 
  MyClass13(int i, int j) {
    a = i; 
    b = j; 
  } 
 
  // initialize a and b to the same value 
  MyClass13(int i) {
    a = i; 
    b = i; 
  } 
 
  // give a and b default values of 0 
  MyClass13( ) {
    a = 0; 
    b = 0; 
  } 
}
