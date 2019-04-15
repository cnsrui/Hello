package StringMatch;
import java.util.Arrays;
import java.util.regex.*;

public class ReplaceTest
{
	public static void main(String[] args)
	{
		String[] msgs =
		{
			"Java has regular expressions in 1.4",
			"regular expressions now expressing in Java",
			"Java represses oracular expressions"
		};
		Pattern p = Pattern.compile(" re\\w*");
		Matcher matcher = null;
		for (int i = 0 ; i < msgs.length ; i++)
		{
			if (matcher == null)
			{
				//如果 matcher 为 null,则创建
				// i = 0 时执行
				matcher = p.matcher(msgs[i]);
			}
			else
			{
				// reset()方法作用是将Matcher重新应用在新的字符序列
				// i > 0 时执行
				matcher.reset(msgs[i]);
			}
			// 把匹配到的字符都替换成“哈哈”
			System.out.println(matcher.replaceAll("哈哈:)"));
//			System.out.println(matcher.replaceFirst("哈哈:)"));
			System.out.println(Arrays.toString(msgs[i].split(" ")));
		}
	}
}
