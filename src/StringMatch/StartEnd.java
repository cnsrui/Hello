package StringMatch;

import java.util.regex.*;

public class StartEnd {
	public static void main(String[] args) {
		// 创建一个Pattern对象，并用它建立一个Matcher对象
		String regStr = "Java is very easy!";
//		String regStr = "Java13500006666\n" + "phthon13611125565\n" + "VScode15899903312";
		System.out.println("目标字符串是：" + regStr);

		/** 分词匹配，默认按空白字符分隔 */
		Matcher m = Pattern.compile("\\w+").matcher(regStr);
		while (m.find()) {
			System.out.println(m.group() + "子串的起始位置：" + m.start() + "，其结束位置：" + m.end());
		}
	}
}
