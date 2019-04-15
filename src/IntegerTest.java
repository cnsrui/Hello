
public class IntegerTest {

	public static void main(String[] args) {
		int intA10 = 10;
		int intA128 = 128;
		Integer intNewA10 = new Integer(10);
		Integer intNewB10 = new Integer(10);
		Integer intNewA128 = new Integer(128);
		Integer intNewB128 = new Integer(128);
		Integer intNoNewA10 = 10;
		Integer intNoNewB10 = 10;
		Integer intNoNewA128 = 128;
		Integer intNoNewB128 = 128;

		System.out.println("intA10 == intNewA10 : " + (intA10 == intNewA10)); // true
		System.out.println("intA128 == intNewA128 : " + (intA128 == intNewA128)); // true
		System.out.println("-----------");
		System.out.println("intNewA10 == intA10 : " + (intNewA10 == intA10)); // ture
		System.out.println("intNewA128 == intA128 : " + (intNewA128 == intA128)); // true
		System.out.println("intNewA10 == intNewB10 : " + (intNewA10 == intNewB10)); // false new出来的<128不相等
		System.out.println("intNewA128 == intNewB128 : " + (intNewA128 == intNewB128)); // false new出来的>=128不相等
		System.out.println("-----------");
		System.out.println("intNoNewA10 == intA10 : " + (intNoNewA10 == intA10)); // true
		System.out.println("intNoNewA128 == intA128 : " + (intNoNewA128 == intA128)); // true
		System.out.println("intNoNewA10 == intNoNewB10 : " + (intNoNewA10 == intNoNewB10)); // true 非new出来的<128相等
		System.out.println("intNoNewA128 == intNoNewB128 : " + (intNoNewA128 == intNoNewB128)); // false 非new出来的>=128不相等
		System.out.println("-----------");
		System.out.println("intNewA10 == intNoNewA10 : " + (intNewA10 == intNoNewA10)); // false 非new 与new
																						// 相比较不相等，因为是两个实例
		System.out.println("intNewA128 == intNoNewA128 : " + (intNewA128 == intNoNewA128)); // false 非new 与new
																							// 相比较不相等，因为是两个实例
	}

}
