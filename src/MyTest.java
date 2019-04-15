import java.util.*;


public class MyTest {

    private static int intTest = 999;


    public static void main(String[] args) {

        /** HashMap key,value 都可以为空，（null,null),(111,null),(null,111)都可以，乱序存储，线程不安全不同步，效率高，适用于单线程 */
        Map map = new HashMap<>();
        map.put(11, "java");
        map.put(13, "python");
        map.put(15, "c++");
        map.put(16, "PHP");
        map.put(33, null);
        map.put(44, 55);
        map.put(null, 55);
        System.out.println(map.toString());
        Set set = map.keySet();

        /** 重写 toString 遍历*/
        System.out.println(set.toString());

        /** Iterator 迭代遍历*/
        Iterator ite = set.iterator();
        while (ite.hasNext()) {
            System.out.print(ite.next() + " ");
        }

        System.out.println("-----------");

        /** foreach Lambda 表达式遍历*/
        set.forEach(obj -> System.out.print(obj + " "));

        System.out.println("-----------");

        /** Hashtable key,value 都不能为null，（null,null),(111,null),(null,111)都不行，按存入顺序存储，线程安全同步，效率低，适用于多线程 */
        Map maptable = new Hashtable();
        maptable.put(11, "java");
        maptable.put(13, "python");
        maptable.put(15, "c++");
        maptable.put(16, "PHP");
//		maptable.put(null, null); //Hashtable不能为null
        maptable.put(44, 22);
        System.out.println(maptable.toString());
        Set settable = maptable.keySet();
        System.out.println(settable.toString());

        System.out.println("-----------");
        //按插入顺序存储
        LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
        lhs.add(32);
        lhs.add(12);
        lhs.add(42);
        lhs.add(2);
        lhs.add(8);
        System.out.println(lhs.toString());
        lhs.forEach(i -> System.out.print(i + " "));

        System.out.println("-----------");

        TreeSet ts = new TreeSet();
        ts.add(32);
        ts.add(12);
        ts.add(42);
        ts.add(2);
        ts.add(8);
        System.out.println(ts.toString());
        ts.forEach(i -> System.out.print(i + " "));


        System.out.println("----------");


        System.out.println("-------------");
        // 以下是 List 实例
        List list = new ArrayList();
        list.add("China");  //0
        list.add("America");//2
        list.add("Chicago");//3
        list.add("England");//4
        list.add(1, "USA");//1
        System.out.println(list.size()); // 5
        System.out.println(list.indexOf("America"));
        System.out.println(list.remove("America")); //true
        System.out.println(list.get(3)); // England ， America被删除，chicago与England向前移动1位
        list.forEach(obj -> System.out.print(obj + " ")); // 遍历
        System.out.println(list.subList(1, 3)); //  USA Chicago 前包后不包

        String[] books = {"1111111", "2222222", "333333333", "444444444"};
        List<String> bookList = new ArrayList<String>();
        for (String book : books) {
            bookList.add(book);
        }

        ListIterator lit = bookList.listIterator();
        while (lit.hasNext()) {
            System.out.print(lit.next() + " ");
        }
        System.out.println("--------");
        String[] reBookList = new String[bookList.size()];
        while (lit.hasPrevious()) {
//		System.out.print(lit.previous() + " ");
            for (int i = 0; i < reBookList.length; i++)
                reBookList[i] = (String) lit.previous();
        }
        for (String restrbook : reBookList) {
            System.out.println(restrbook);
        }


        System.out.println("\n--------");


        /**
         * Iterator 删除操作
         */
        List<String> listi = new ArrayList<>();
        listi.add("1");
        listi.add("2");
        listi.add("3");
        listi.add("4");
        listi.add("5");
        System.out.println("修改前" + listi.toString());
        // 在 Iterator 迭代里进行元素的 remove/add 操作，会被成功执行
        Iterator<String> iterator = listi.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("3".equals(item)) {
                iterator.remove();
            }
        }

        System.out.println("修改后" + Arrays.asList(listi));

        // 在 foreach 循环里进行元素的 remove/add 操作，会发生错误
        // 以下代码会发生错误
        /*
        for (String item : listi) {
            if ("5".equals(item)) {
                listi.remove(item);
            }
        }
        System.out.println(Arrays.asList(listi));
        */

        System.out.println(MyTest.threeCompare(9, 2));
        System.out.println(MyTest.threeCompare(8, 8));
        System.out.println(MyTest.threeCompare(3, 5));

        System.out.println(MyTest.twoCompare(9, 2));
        System.out.println(MyTest.twoCompare(8, 8));
        System.out.println(MyTest.twoCompare(3, 5));
    }

    public static int threeCompare(int a, int b) {
        return (a >= b) ? ((a > b) ? 1 : 0) : -1;
    }

    // 没有处理"相等"的情况，会出现异常
    public static int twoCompare(int a, int b) {
        return a > b ? 1 : -1;
    }
}