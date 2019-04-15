package StringTest;

/**
 * @Description
 * @auther cnsrui
 * @create 2019-04-12 22:00
 */
public class StringSplitTest {
    public static void main(String[] args) {

        /**
         * 用 String 的 split 分隔字符时，需做最后一个分隔符后有无内容的检查，
         * 否则会有抛 IndexOutOfBoundsException 的风险。
         */
        String str1 = "a,b,c,,";
        System.out.println(str1.toString());
        String[] arrays1 = str1.split(",");
        // 结果是 3
        System.out.println(arrays1.length);
        for (String ar : arrays1) {
            System.out.print(ar + "*");
        }

        System.out.println("\n-------");

        String str2 = "a,b,c,,d";
        System.out.println(str2.toString());
        String[] arrays2 = str2.split(",");
        // 结果是 5
        System.out.println(arrays2.length);
        for (String ar : arrays2) {
            System.out.print(ar + "*");
        }
    }
}
