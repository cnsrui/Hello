import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectClass {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		/*
		 * 运用反射创建类的对象 
		 * 方式一：Class.forName("ClassName") 
		 * 方式二：ClassName.class
		 * 方式三：对象.getClass()
		 */
		Object obj = Class.forName("Hello").newInstance();
		System.out.println(((Hello) obj).getA());

		Class clazz = Hello.class;
		System.out.println(((Hello) clazz.newInstance()).getA());

		/*
		 * 获取类的方法
		 */
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			System.out.println(method + " ");
		}
		/*
		 * 获取类的构造函数
		 */
		Constructor[] contr = clazz.getConstructors();
		for (Constructor conr : contr) {
			System.out.println(conr + " ");
		}

	}
}
