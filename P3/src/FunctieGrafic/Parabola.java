package FunctieGrafic;

public class Parabola {
    private int a;
    private int b;
    private int c;
    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public String toString() {
        return " f(x) = " + a + " x^2 + " + b + " x + " + c;
    }
}
