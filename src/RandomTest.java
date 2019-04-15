
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {
	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println("rand.nextBoolean()：" + rand.nextBoolean());
		/*
		 * 利用Random对象的nextBytes()得到的byte[]型数组的值
		 */
		byte[] buffer = new byte[16];
		rand.nextBytes(buffer);
		System.out.println(Arrays.toString(buffer));

		/**
		 * 把利用Random得到的byte型数组的值，复制给int型数组
		 */
		int[] intBuffer = new int[16];
		for (int i = 0; i < buffer.length; i++) {
			intBuffer[i] = (int) buffer[i];
		}
		System.out.println(Arrays.toString(intBuffer));
		
		/** nextDouble nexeFloat 的伪随机数范围都在 0.0~1.0之间 */
		// 生成0.0~1.0之间的伪随机double数
		System.out.println("rand.nextDouble()：" + rand.nextDouble());
		// 生成0.0~1.0之间的伪随机float数
		System.out.println("rand.nextFloat()：" + rand.nextFloat());
		
		// 生成平均值是 0.0，标准差是 1.0的伪高斯数
		System.out.println("rand.nextGaussian()：" + rand.nextGaussian());
		
		/** nextInt(int) 可指定伪随机数范围  */
		// 生成一个处于int整数取值范围的伪随机整数
		System.out.println("rand.nextInt()：" + rand.nextInt());
		// 生成0~26之间的伪随机整数，前包后不包，包含0但不包含26
		System.out.println("rand.nextInt(26)：" + rand.nextInt(26));
		// 生成一个处于long整数取值范围的伪随机整数
		System.out.println("rand.nextLong()：" + rand.nextLong());
		
		System.out.println("--------");
		/** ThreadLocalRandom 可以指定伪随机数的前后（前包后不包）范围*/
		ThreadLocalRandom tlrand = ThreadLocalRandom.current();
		System.out.println("rand.nextInt(4，20)：" + tlrand.nextInt(4,20));
		System.out.println("rand.nextDouble(2.0，10.0)：" + tlrand.nextDouble(2.0,10.0));
		
	}
}
