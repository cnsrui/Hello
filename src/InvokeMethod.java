
public class InvokeMethod {

    public static void showStaticMethod() {
        System.out.println("Static Method from InvokeMethod.");
    }



    public static void main(String[] args) {
        /**
         * 对象调用静态方法与成员方法的区别
         */
        InvokeMethod.showStaticMethod(); // 类直接调用类的静态方法

        InvokeMethod im = new InvokeMethod(); // 正常创建类的对象
        im.showStaticMethod(); // 对象也可以调用类的静态方法
        im.showCommonMethod();// 对象正常调用成员方法

        InvokeMethod imnull = null; // 只是定义类的对象，但将对象指向为空
        imnull.showStaticMethod(); // 即使是指向为空的对象，也可以调用类的静态方法
        imnull.showCommonMethod(); // 指向为空的对象，不能调用成员方法，但能调用静态方法

    }
    public void showCommonMethod() {
        System.out.println("Common Methond form InvokeMethod.");
    }
}
