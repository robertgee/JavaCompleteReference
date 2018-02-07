package jcr.chap9.TestBalance;

/* Now, the Balance class, its constructor, and its
   show() method are public.  This means that they can
   be used by non-subclass code outside their package.
*/
class Balance {
  String name;
  double bal;

  public Balance(String n, double b) {
    name = n;
    bal = b;
  }

  public void show() {
    if(bal<0) 
      System.out.print("-->> ");
    System.out.println(name + ": $" + bal);
  }
}

  
class TestBalance {
  public static void main(String args[]) {
    
    /* Because Balance is public, you may use Balance 
       class and call its constructor. */
    Balance test = new Balance("J. J. Jaspers", 99.88);

    test.show(); // you may also call show()
  }
}
