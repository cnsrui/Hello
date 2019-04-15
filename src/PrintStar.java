import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PrintStar {
	private int layer = 0;

	public void printStarLayerDown() {
		int layer = 5;
		for (int i = layer; i > 0; i--) {
			for (int j = i; j > 0; j--)
				System.out.print("*");

			System.out.println();
		}
	}

	public void printStarLayerUp() {
		int layer = 5;
		for (int i = 0; i < layer; i++) {
			for (int j = 0; j < i + 1; j++)
				System.out.print("*");

			System.out.println();
		}
	}

	public void printStarDiamond() {

	}

	public void printArrayMiddleStar() {
		int height = 5;
		int width = 5;
		String[][] array = new String[height][width];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) { // 打印二维数组
				// array[i][j] = Integer.toString(0); //把数组所有值变成 0 ，初始值为 null
				array[i][j] = "_";
				array[height / 2][width / 2] = "*";
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

	public void testArray() {
		int[] a = { 5, 3, 4, 1, 2 };
		int[] b = a;
		for (int tmp : a)
			System.out.print(tmp + ",");
		System.out.println();
		int[][] c = { { 3, 2, 1 }, { 4, 3, 2, 1 }, { 5, 4, 3, 2, 1 } };

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++)
				System.out.print(c[i][j] + " ");
		}
		System.out.println();
	}

	public void printProperties() throws FileNotFoundException, IOException {
		// 获取当前用户目录
		String path = System.getProperty("user.dir");
		System.out.println(path);
		// 获取系统所有的环境变量
		Map<String, String> env = System.getenv();
		for (String name : env.keySet()) {
			System.out.println(name + " ---> " + env.get(name));
		}
		// 获取指定环境变量的值
		// System.out.println(System.getenv("JAVA_HOME"));
		System.out.println(System.getenv("HOME"));
		// 获取所有的系统属性
		Properties props = System.getProperties();
		// 将所有系统属性保存到props.txt文件中
		props.store(new FileOutputStream("props.txt"), "System Properties");
		// 输出特定的系统属性
		System.out.println(System.getProperty("os.name"));
	}

}
