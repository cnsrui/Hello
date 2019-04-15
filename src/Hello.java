import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Hello {
    private int a = 10;

    public int getA() {
        return this.a;
    }

    public Hello() {
    }

    public Hello(int a) {
    }

    public Hello(String a, String b) {
    }

    protected int protectedDate = 99;

    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.out.println("------Progarm Start Line ------");

//		PrintStar printstar = new PrintStar();
//		printstar.printStarLayerUp();
//		printstar.printStarLayerDown();
//		printstar.printArrayMiddleStar();
//		printstar.testArray();
        System.out.println((new Hello()).protectedDate);

    }
}