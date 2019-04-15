interface A {}
class B implements A {}
class C extends B {}


public class InstanceOfTest {

	public static void main(String[] args) {
		
		String intStr = "123";
		// 把一个特定字符串转换成int变量
		int it1 = Integer.parseInt(intStr); // 方法一
		System.out.println(it1);
		int it2 = Integer.valueOf(intStr); // 方法二
		System.out.println(it2);
		int it3 = new Integer(intStr); // 方法三
		System.out.println(it3);

		float floatNum = 1.23f;
		// 把一个float变量转换成String变量
		String ftStr1 = String.valueOf(floatNum); // 方法一
		System.out.println(ftStr1);
		String ftStr2 = Float.toString(floatNum); // 方法二
		System.out.println(ftStr2);
		String ftStr3 = floatNum + ""; // 方法三
		System.out.println(ftStr3);

		// 把一个boolean变量转换成String变量
		String boolStr = String.valueOf(true);
		System.out.println(boolStr);
		System.out.println(boolStr.toUpperCase()); // 字符串全变大写
		System.out.println(boolStr.toLowerCase()); // 字符串全变小写
		
		// 直接把一个boolean类型变量赋给一个Object类型的变量
		Object boolObj = true;
		if (boolObj instanceof Boolean) {
			boolean bool = (Boolean)boolObj; 
			System.out.println(bool);
		}
		/**
		 *  强制转换object对象时，应先用 instanceof 进行判断
		 *  instanceof通过返回一个布尔值来指出，这个对象是否是这个特定类或它的子类的一个实例。
		 *  主要用来判断  对象与类之间的关系。
		 *  如果 object 是 class 的一个实例，则返回 true。
		 *  如果 object 不是指定类的一个实例，或者 object 是 null，则返回 false。
		 *  instanceof 的判定，可作用于类之间的继承关系中。即，子类的对象instanceof父类的对象，返回true
		 */
		System.out.println("---------");
		// instanceof测试用例
			A a = null;
			B b = null;
			boolean res;
			System.out.println("a instanceof A : " + (a instanceof A) );// false a指向null
			System.out.println("a instanceof B : " + (a instanceof B) );// false b指向null
			System.out.println("---------");
			
			a = new B();
			b = new B();
			System.out.println("a instanceof A : " + (a instanceof A) );// true
			System.out.println("a instanceof B : " + (a instanceof B) );// true
			System.out.println("b instanceof A : " + (b instanceof A) );// true
			System.out.println("b instanceof B : " + (b instanceof B) );// true
			System.out.println("---------");
			
			B bb = new B();
			C c =new C();
			System.out.println("c instanceof A : " + (c instanceof A) );// true
			System.out.println("c instanceof B : " + (c instanceof B) );// true
			System.out.println("c instanceof C : " + (c instanceof C) );// true
			System.out.println("bb instanceof B : " + (bb instanceof B) );// true
			System.out.println("bb instanceof C : " + (bb instanceof C) );// false
			System.out.println("---------");
			
			B bc = (C) new C(); //多态
			System.out.println("bc instanceof A : " + (bc instanceof A) );// true
			System.out.println("bc instanceof B : " + (bc instanceof B) );// true
			System.out.println("bc instanceof C : " + (bc instanceof C) );// true
			System.out.println("---------");
			
			/**
			 * getClass 用于获取在运行时期对象的类。
			 * getClass的判定，只作用于准确的具体的运行类，不能作用于继承关系的类中。
			 * 即，子类对象.getClass().equals(父类class)，返回false
			 * 任何接口都不行
			 * 多态可以
			 */
			System.out.println("a.getClass().equals(A.class) : " + a.getClass().equals(A.class)); //flase 接口不可用
			System.out.println("a.getClass().equals(B.class) : " + a.getClass().equals(B.class)); //true  <======接口对象属于实现类，属于运行类
			System.out.println("a.getClass().equals(C.class) : " + a.getClass().equals(C.class)); //false
			System.out.println("---------");
			System.out.println("b.getClass().equals(A.class) : " + b.getClass().equals(A.class)); //false 接口不可用
			System.out.println("b.getClass().equals(B.class) : " + b.getClass().equals(B.class)); //true
			System.out.println("b.getClass().equals(C.class) : " + b.getClass().equals(C.class)); //false
			System.out.println("---------");
			System.out.println("c.getClass().equals(A.class) : " + c.getClass().equals(A.class)); //false 接口不可用
			System.out.println("c.getClass().equals(B.class) : " + c.getClass().equals(B.class)); //false
			System.out.println("c.getClass().equals(C.class) : " + c.getClass().equals(C.class)); //true
			System.out.println("---------");
			System.out.println("bc.getClass().equals(A.class) : " + bc.getClass().equals(A.class)); //false 接口不可用
			System.out.println("bc.getClass().equals(B.class) : " + bc.getClass().equals(B.class)); //false
			System.out.println("bc.getClass().equals(C.class) : " + bc.getClass().equals(C.class)); //true <=======多态，属于运行类
			
			
			
	}

}



