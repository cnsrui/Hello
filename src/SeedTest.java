
import java.util.*;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class SeedTest
{
	public static void main(String[] args)
	{
		
		/** 如果2个Random对象使用相同的种子（比如都是50），并且以相同的顺序调用相同的函数，那它们返回值完全相同。 */
		Random r1 = new Random(50);
		System.out.println("第一个种子为50的Random对象");
		System.out.println("r1.nextBoolean():\t" + r1.nextBoolean());
		System.out.println("r1.nextInt():\t\t" + r1.nextInt());
		System.out.println("r1.nextDouble():\t" + r1.nextDouble());
		System.out.println("r1.nextGaussian():\t" + r1.nextGaussian());
		System.out.println("---------------------------");
		Random r2 = new Random(50);
		System.out.println("第二个种子为50的Random对象");
		System.out.println("r2.nextBoolean():\t" + r2.nextBoolean());
		System.out.println("r2.nextInt():\t\t" + r2.nextInt());
		System.out.println("r2.nextDouble():\t" + r2.nextDouble());
		System.out.println("r2.nextGaussian():\t" + r2.nextGaussian());
		System.out.println("---------------------------");
		Random r3 = new Random(100);
		System.out.println("种子为100的Random对象");
		System.out.println("r3.nextBoolean():\t" + r3.nextBoolean());
		System.out.println("r3.nextInt():\t\t" + r3.nextInt());
		System.out.println("r3.nextDouble():\t" + r3.nextDouble());
		System.out.println("r3.nextGaussian():\t" + r3.nextGaussian());
		
		/** 通常以当前时间作为种子*/
		Random r4= new Random(System.currentTimeMillis());
	}
}
