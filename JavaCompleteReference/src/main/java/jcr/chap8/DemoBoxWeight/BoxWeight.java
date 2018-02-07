package jcr.chap8.DemoBoxWeight;


// Here, Box is extened to include weight.
public class BoxWeight extends Box {

    double weight; // weight of box

    // constructor for BoxWeight
    public BoxWeight(double w, double h, double d, double m) {
        width = w;
        height = h;
        depth = d;
        weight = m;
    }

    public double getWeight() {
        return weight;
    }

}
