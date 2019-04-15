package CaledarTime;

import java.util.*;
import static java.util.Calendar.*; 


/** 
 * import static java.util.Calendar.*; 
 * 静态导入 Calendar 类中所有类变量，就可以使用int型的field参数了
 * 包括 Calendar.YEAR ，Calendar.MONTH ， Calendar.DATE 
 * 其中 MONTH 表示 1月的值是0， 2月的值是1，12月的值是11
 */

public class CalendarTest
{
	public static void main(String[] args)
	{
		Calendar c = Calendar.getInstance();
		// 取出年
		System.out.println(c.get(YEAR));
		// 取出月份
		System.out.println(c.get(MONTH));
		// 取出日
		System.out.println(c.get(DATE));
		
		// 分别设置年、月、日、小时、分钟、秒
		c.set(2003 , 10 , 23 , 12, 32, 23); //2003-11-23 12:32:23
		System.out.println(c.getTime());
		// 将Calendar的年前推1年
		c.add(YEAR , -1); //2002-11-23 12:32:23
		System.out.println(c.getTime());
		// 将Calendar的月前推8个月
		c.roll(MONTH , -8); //2002-03-23 12:32:23
		System.out.println(c.getTime());
		System.out.println("----------");

		Calendar cal1 = Calendar.getInstance();
		cal1.set(2003, 7, 23, 0, 0 , 0); // 2003-8-23
		cal1.add(MONTH, 6); //2003-8-23 => 2004-2-23
		System.out.println(cal1.getTime());
		System.out.println("----------");


		Calendar cal2 = Calendar.getInstance();
		cal2.set(2003, 7, 31, 0, 0 , 0); // 2003-8-31
		// 因为进位到后月份改为2月，2月没有31日，自动变成29日
		// 会根据当年的月份来判断是否是 29天、30天、31天
		cal2.add(MONTH, 6); // 2003-8-31 => 2004-2-29
		System.out.println(cal2.getTime());
		System.out.println("----------");

		Calendar cal3 = Calendar.getInstance();
		cal3.set(2003, 7, 23, 0, 0 , 0); //2003-8-23
		// MONTH字段“进位”，但YEAR字段并不增加，只增加月份，不增加年份
		cal3.roll(MONTH, 6); //2003-8-23 => 2003-2-23
		System.out.println(cal3.getTime());
		System.out.println("----------");

		Calendar cal4 = Calendar.getInstance();
		cal4.set(2003, 7, 31, 0, 0 , 0); //2003-8-31
		// MONTH字段“进位”后变成2，2月没有31日，
		// YEAR字段不会改变，2003年2月只有28天
		cal4.roll(MONTH, 6); //2003-8-31 => 2003-2-28
		System.out.println(cal4.getTime());
		System.out.println("----------");
		
		Calendar cal5 = Calendar.getInstance();
		cal5.set(2003, 7, 31, 0, 0 , 0); //2003-8-31
		// 增加用 正数， 减少用 负数
		cal5.add(MONTH, -3); //2003-8-31 => 2003-6-28
		System.out.println(cal5.getTime());
	}
}

