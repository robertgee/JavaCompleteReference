package jcr.chap15.MyStringOps;// Demonstrate a method reference for a static method.
 
// A functional interface for string operations. 
interface StringFunc { 
  String func(String n); 
} 
 
// This class defines a static method called strReverse(). 
class MyStringOps { 
  // A static method that reverses a string. 
  static String strReverse(String str) { 
      String result = ""; 
      int i; 
 
      for(i = str.length()-1; i >= 0; i--) 
        result += str.charAt(i); 
 
      return result; 
  } 
}     
