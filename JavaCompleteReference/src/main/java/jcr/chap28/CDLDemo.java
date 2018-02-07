package jcr.chap28;

// An example of CountDownLatch. 
 
import java.util.concurrent.CountDownLatch; 
 
class CDLDemo { 
  public static void main(String args[]) { 
    CountDownLatch cdl = new CountDownLatch(5); 
 
    System.out.println("Starting"); 
 
    new Thread(new MyThread2(cdl)).start(); 
 
    try { 
      cdl.await(); 
    } catch (InterruptedException exc) { 
      System.out.println(exc); 
    } 
 
    System.out.println("Done"); 
  } 
} 
 
class MyThread2 implements Runnable { 
  CountDownLatch latch; 
 
  MyThread2(CountDownLatch c) { 
    latch = c; 
  } 
 
  public void run() { 
    for(int i = 0; i<5; i++) { 
      System.out.println(i); 
      latch.countDown(); // decrement count 
    } 
  } 
}
