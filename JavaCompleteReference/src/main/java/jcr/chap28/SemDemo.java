package jcr.chap28;

// A simple semaphore example. 
 
import java.util.concurrent.*; 
 
class SemDemo { 
 
  public static void main(String args[]) { 
    Semaphore sem = new Semaphore(1); 
 
    new Thread(new IncThread(sem, "A")).start(); 
    new Thread(new DecThread(sem, "B")).start();
 
  } 
} 
 
// A shared resource. 
class Shared4 { 
  static int count = 0; 
} 
 
// A thread of execution that increments count. 
class IncThread implements Runnable { 
  String name; 
  Semaphore sem; 
 
  IncThread(Semaphore s, String n) { 
    sem = s; 
    name = n; 
  } 
 
  public void run() { 
     
    System.out.println("Starting " + name); 
 
    try { 
      // First, get a permit. 
      System.out.println(name + " is waiting for a permit."); 
      sem.acquire(); 
      System.out.println(name + " gets a permit."); 
 
      // Now, access shared resource. 
      for(int i=0; i < 5; i++) { 
        Shared4.count++; 
        System.out.println(name + ": " + Shared4.count); 
 
        // Now, allow a context switch -- if possible. 
        Thread.sleep(10); 
      } 
    } catch (InterruptedException exc) { 
      System.out.println(exc); 
    } 
 
    // Release the permit. 
    System.out.println(name + " releases the permit."); 
    sem.release(); 
  } 
} 
 
// A thread of execution that deccrements count. 
class DecThread implements Runnable { 
  String name; 
  Semaphore sem; 
 
  DecThread(Semaphore s, String n) { 
    sem = s; 
    name = n; 
  } 
 
  public void run() { 
     
    System.out.println("Starting " + name); 
 
    try { 
      // First, get a permit. 
      System.out.println(name + " is waiting for a permit."); 
      sem.acquire(); 
      System.out.println(name + " gets a permit."); 
 
      // Now, access shared resource. 
      for(int i=0; i < 5; i++) { 
        Shared4.count--; 
        System.out.println(name + ": " + Shared4.count); 
 
        // Now, allow a context switch -- if possible. 
        Thread.sleep(10); 
      } 
    } catch (InterruptedException exc) { 
      System.out.println(exc); 
    } 
 
    // Release the permit. 
    System.out.println(name + " releases the permit."); 
    sem.release(); 
  } 
}
