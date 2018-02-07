package jcr.chap8.UseSuper;

// Using super to overcome name hiding.
class A8 {
  int i;
}

// Create a subclass by extending class A.
class B8 extends A8 {
  int i; // this i hides the i in A

  B8(int a, int b) {
    super.i = a; // i in A
    i = b; // i in B
  }

  void show() {
    System.out.println("i in superclass: " + super.i);
    System.out.println("i in subclass: " + i);
  }
}
  
class UseSuper {
  public static void main(String args[]) {
    B8 subOb = new B8(1, 2);

    subOb.show();
  }
}
