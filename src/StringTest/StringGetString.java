package StringTest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description
 * @auther cnsrui
 * @create 2019-04-13 10:53
 */
public class StringGetString {

    // 模拟String类的toString方法
    public static String getString(Object[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length -1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuffer b = new StringBuffer();
        b.append('[');
        // 在循环体里面控制结束
        for (int i = 0; ; i++) {
            b.append(String.valueOf(a[i]));
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }

    }

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("hello");
        al.add("world");
        al.add("Java");
        al.add("phthon");
        al.add("Kito");
        al.add("Ruby");
        al.add("Mysql");
        Object[] a = al.toArray();
        System.out.println(Arrays.asList(a));
        System.out.println(StringGetString.getString(a));

        ArrayList<String> al2 = new ArrayList<>();
        Object[] b = al2.toArray();
        System.out.println(StringGetString.getString(b));

        Object[] c = null;
        System.out.println(StringGetString.getString(c));
    }
}
