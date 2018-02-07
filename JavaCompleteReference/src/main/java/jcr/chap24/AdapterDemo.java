package jcr.chap24;

// Demonstrate adaptor classes.
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdapterDemo extends Frame {
  String msg = "";

  public AdapterDemo() {
     addMouseListener(new MyMouseAdapter2(this));
     addMouseMotionListener(new MyMouseAdapter2(this));
     addWindowListener(new MyWindowAdapter());
  }

  // Display the mouse information.
  public void paint(Graphics g) {
    g.drawString(msg, 20, 80);
  }    

  public static void main(String[] args) {
    AdapterDemo appwin = new AdapterDemo();

    appwin.setSize(new Dimension(200, 150));
    appwin.setTitle("AdapterDemo");
    appwin.setVisible(true);
  }
}

//Handle only mouse click and drag events. 
class MyMouseAdapter2 extends MouseAdapter {
AdapterDemo adapterDemo;

public MyMouseAdapter2(AdapterDemo adapterDemo) {
 this.adapterDemo = adapterDemo;
}

// Handle mouse clicked.
public void mouseClicked(MouseEvent me) {
 adapterDemo.msg = "Mouse clicked";
 adapterDemo.repaint();
}

// Handle mouse dragged.
public void mouseDragged(MouseEvent me) {
 adapterDemo.msg = "Mouse dragged";
 adapterDemo.repaint();
} 
}
