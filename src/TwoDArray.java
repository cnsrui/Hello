import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 打印二维数组的 3 种方法
 * @auther cnsrui
 * @create 2019-04-12 23:07
 */
public class TwoDArray {

    public static void main(String[] args) {
        // 定义二维数组
        int[][] magicSquare =
                {
                        {16, 3, 2, 13},
                        {5, 10, 11, 8},
                        {22, 55, 88},
                        {9, 6, 7, 3}
                };
        // 二维数组打印方法 1
        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare[i].length; j++) {
                System.out.print(magicSquare[i][j] + "*");
            }
            System.out.println();
        }
        System.out.println("------------");
        // 二维数组打印方法 2
        for (int[] i : magicSquare) {
            for (int j : i) {
                System.out.print(j + "*");
            }
            System.out.println();
        }
        System.out.println("------------");
        // 二维数组打印方法 3
        for (int i = 0; i < magicSquare.length; i++) {
            System.out.println(Arrays.toString(magicSquare[i]));
        }

        System.out.println("---------以下是一维数组的打印---------");
        List<String> list2 = new ArrayList<String>(2);
        list2.add("Hello");
        list2.add("World");
        list2.add("World");
        list2.add("World");
        String[] strList = new String[list2.size()];
        // 直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，
        // 若强转其它类型数组将出现 ClassCastException 错误。
        strList = list2.toArray(strList);
        // 打印一维数组传统方法
        for (int i = 0; i < strList.length; i++) {
            System.out.print(strList[i] + "*");
        }
        System.out.println("\n---------");
        // 打印一维数组foreach方法
        for (String s : strList) {
            System.out.print(s + "*");
        }
        System.out.println("\n---------");
        // 利用Array类中的toString方法打印数组，需要参数
        System.out.print(Arrays.toString(strList));
        System.out.println("\n---------");
        // 利用Array类中的asList方法打印数组，需要参数
        System.out.print(Arrays.asList(strList));

    }
}
