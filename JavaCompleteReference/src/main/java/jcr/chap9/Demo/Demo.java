// Demo package p1.
package jcr.chap9.Demo;

import jcr.chap9.Protection.Derived;
import jcr.chap9.Protection.Protection;
import jcr.chap9.Protection.SamePackage;

// Instantiate the various classes in p1.
public class Demo {
  public static void main(String args[]) {
    Protection ob1 = new Protection();
    Derived ob2 = new Derived();
    SamePackage ob3 = new SamePackage();
  }
}
