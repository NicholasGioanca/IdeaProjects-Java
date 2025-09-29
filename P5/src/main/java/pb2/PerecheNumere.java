package pb2;
import java.math.*;
public class PerecheNumere {
    public int a;
    public int b;

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public PerecheNumere() {}

    public void setA(int a) { this.a = a; }
    public void setB(int b) { this.b = b; }
    public int getA() { return a; }
    public int getB() { return b; }

    @Override
    public String toString() {
        return "[" + a + ", " + b + "]";
    }
    public boolean consecutiveFibonacci(int x, int y) {
        if((a == x && b == y) || (b == x && a == y)) {
            return true;
        }

        if(a < y || b < y) { return false; }

        return this.consecutiveFibonacci(y, x+y);
    }

    public int cmmmc() {
        int x = a, y = b;
        while(x != y) {
            if(x > y)
                x-=y;
            else
                y-=x;
        }
        int cmmdc = x;

        return a*b/cmmdc;
    }

    public boolean sumaCifEgala(){
        int x = a, y = b;
        int sumx = 0, sumy = 0;

        while(x != 0){
            sumx += x%10;
            x/=10;
        }

        while(y != 0) {
            sumy += y%10;
            y/=10;
        }


        return sumx == sumy;
    }

    public boolean acelasiNrCifPare() {
        int x = a, y = b;
        int nrx = 0, nry = 0;

        while(x != 0){
            if(x%2 == 0)
                nrx++;

            x=x/10;
        }

        while(y != 0) {
            if(y%2 == 0)
                nry++;
            y=y/10;
        }

        return nrx == nry;
    }

}
