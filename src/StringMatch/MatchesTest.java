package StringMatch;
import java.util.regex.*;

public class MatchesTest
{
	public static void main(String[] args)
	{
		String[] mails =
		{
			"kongyeeku@163.com" ,
			"kongyeeku@gmail.com",
			"ligang@crazyit.org",
			"wawa@abc.xx",
			"abcdefghijklmnopqrstuvwxyz@111.com",
			"ab@111.com"
		};

		/** 电子邮箱正则*/
		String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
		/** 创建匹配正则表达式，编译后储存在内存中 */
		Pattern mailPattern = Pattern.compile(mailRegEx); 
		/** 创建Matcher匹配对象，用于保存匹配状态信息 */
		Matcher matcher = null;
		for (String mail : mails)
		{
			if (matcher == null)
			{
				/** 用 Pattern 的对象的matcher()方法进行匹配
				 * 将匹配的状态保存在 Match 的对象 matcher 中 */
				matcher = mailPattern.matcher(mail);
			} 
			else
			{
				matcher.reset(mail);
			}
			String result = mail + (matcher.matches() ? "是" : "不是")
				+ "一个有效的邮件地址！";
			System.out.println(result);
		}
	}
}

