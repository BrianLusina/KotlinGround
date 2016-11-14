package FunctionalProg;

/**
 * FunctionalProg
 * Created by lusinabrian on 14/11/16.
 * Description:
 */
public class TrianglePojo {
    public final int height;
    public final int base;
    private double area;

    public TrianglePojo(int height, int base, double area) {
        this.height = height;
        this.base = base;
        this.area = area;
    }

    public void setArea(double a) {
        area = a;
    }
    public double getArea() {
        return area;
    }
}
