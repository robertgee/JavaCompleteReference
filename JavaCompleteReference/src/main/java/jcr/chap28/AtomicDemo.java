package jcr.chap28;

// A simple example of Atomic. 
 
import java.util.concurrent.atomic.*; 
 
class AtomicDemo { 
 
  public static void main(String args[]) { 
    new Thread(new AtomThread("A")).start(); 
    new Thread(new AtomThread("B")).start(); 
    new Thread(new AtomThread("C")).start(); 
  } 
} 
 
class Shared { 
  static AtomicInteger ai = new AtomicInteger(0); 
} 
 
// A thread of execution that increments count. 
class AtomThread implements Runnable { 
  String name; 
 
  AtomThread(String n) { 
    name = n; 
  } 
 
  public void run() { 
     
    System.out.println("Starting " + name); 
 
    for(int i=1; i <= 3; i++) 
      System.out.println(name + " got: " +  
             Shared.ai.getAndSet(i)); 
  } 
}
