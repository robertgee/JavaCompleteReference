package jcr.chap9.Protection2;

import jcr.chap9.Protection.Protection;

public class OtherPackage {
    public OtherPackage() {
        Protection p = new Protection();
        System.out.println("other package constructor");

//  class or package only
//  System.out.println("n = " + p.n);

//  class only
//  System.out.println("n_pri = " + p.n_pri);

//  class, subclass or package only
//  System.out.println("n_pro = " + p.n_pro);

        System.out.println("n_pub = " + p.n_pub);
    }
}
