import java.util.Scanner;

public class Second{
    public static void main(String[] args){ 
        // The following allows for user inputs.

	    Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        char operator = in.next().charAt(0);

        int c = in.nextInt();
        int d = in.nextInt();
        in.close();
        
        Rational x = new Rational(a,b);
        Rational y = new Rational(c,d);
        // The if chain determines what method should be used to give the user the desired output

        if (operator == '+') {
            x.increaseBy(y);
        } 
        if (operator == '-') {
            y.negate();
            x.increaseBy(y);
        } 
        if (operator == '*') {
            x.multiplyBy(y);
        } 
        if (operator == '/') {
            y.invert();
            x.multiplyBy(y);
        }
        System.out.println(x.toString());

        

	}
}
class Rational {
    // these members are private because they are only meant to be influenced within the class
    private int num;
    private int denom;

    public void negate() {
        num = -num;
    }
    public void invert() {
        int temp = num;
        num = denom;
        denom = temp;
    }
    public Rational(int a, int b){
        num = a;
        denom = b;
        reduce();
    }
    public void increaseBy(Rational other) {
        num *= other.denom + other.num * denom;
        denom *= other.denom;
        reduce();
    }
    public void multiplyBy(Rational other) {
        num *= other.num;
        denom *= other.denom;
        reduce();
    }

    private void reduce() {
        int GCD = GCD(num,denom);
        num= num/GCD;
        denom = denom/GCD;
    } 
    private int GCD(int a, int b){
        if (b == 0){
            return a;
        }
        else {
            return GCD(b, a%b);
        }
    }
    public String toString() {
        return num + "/" + denom;
    }
}


