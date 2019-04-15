package PeopleStudent;
import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;



public class InputTest {

	private Scanner sc;

	public double getNumber() throws IOException {
//		以System.in节点流为基础，创建一个BufferedReader对象
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String mark = "999";
		// 逐行读取键盘输入
		while ((line = br.readLine()) != null) {
			if (line.contains(mark) == true) { // 包含“999”就停止
				return (new Double(line)).doubleValue();
			} else {
				System.out.println("用户键盘输入是:" + line);
			}
		}

		return (new Double(line)).doubleValue(); // 返回double型数值
	}

	public void getScanner() throws IOException {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			System.out.print(sc.nextLine());
		}

	}

	public void getScannerFile(File file) throws FileNotFoundException {
		sc = new Scanner(file);
		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}

	}

	public void outScannerFile(File file) throws FileNotFoundException {

	}

	public static void main(String args[]) throws IOException {
//		SquareNum ob = new SquareNum();
		int val = 0;
		System.out.println("Enter value to be squared: ");
		
		System.out.println("java.home : "+System.getProperty("java.home"));
		 
        System.out.println("java.class.version : "+System.getProperty("java.class.version"));

        System.out.println("java.class.path : "+System.getProperty("java.class.path"));

        System.out.println("java.library.path : "+System.getProperty("java.library.path"));

        System.out.println("java.io.tmpdir : "+System.getProperty("java.io.tmpdir"));

        System.out.println("java.compiler : "+System.getProperty("java.compiler"));

        System.out.println("java.ext.dirs : "+System.getProperty("java.ext.dirs"));

        System.out.println("user.name : "+System.getProperty("user.name"));

        System.out.println("user.home : "+System.getProperty("user.home"));

        System.out.println("user.dir : "+System.getProperty("user.dir"));

        System.out.println("package: "+InputTest.class.getPackage().getName()); //当前类的包名
        
        System.out.println("package absolute path : " +System.getProperty("user.dir")+"/"+(InputTest.class.getPackage().getName())+"/"); //当前类包名的绝对路径
        
		String fileInPath = new String("resource/abc.txt");
		String fileOutPath = new String("resource/def.txt");
		
		InputTest inputtest = new InputTest();
		File file = new File(fileInPath);
		inputtest.getScannerFile(file);
		
//		inputtest.getScanner();
//		inputtest.getNumber();
//		System.out.println("Squared value is " + val);
		
		try (FileInputStream fis = new FileInputStream(fileInPath);
				FileOutputStream fos = new FileOutputStream(fileOutPath)) {
			byte[] bbuf = new byte[32]; //读取的数据保存在bbuf里
			int hasRead = 0;	// 只保存读取字节数的数量
			while ((hasRead = fis.read(bbuf)) > 0) {
				fos.write(bbuf, 0, hasRead);//根据hasRead中保存读取字节数的数量，来输出bbuf中的实际字节数据
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		file= file.getParentFile();
		String[] fileList = file.list();
		System.out.println("====当前路径下所有文件和路径如下====");
		for (String fileName : fileList)
		{
			System.out.println(fileName);
		}
		
		// listRoots()静态方法列出所有的磁盘根路径。
		File[] roots = File.listRoots();
		System.out.println("====系统所有根路径如下====");
		for (File root : roots)
		{
			System.out.println(root);
		}
		
		
		
		
		/** FileWriter FielReader
		 * write字符输出流直接输出 
		 * \r\n是Windows平台的换行符
		 * \n是Linux平台的换行符
		 * */
		try(
				FileWriter fw = new FileWriter("resource/poem.txt"))
			{
				fw.write("锦瑟 - 李商隐\r\n");
				fw.write("锦瑟无端五十弦，一弦一柱思华年。\r\n");
				fw.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\r\n");
				fw.write("沧海月明珠有泪，蓝田日暖玉生烟。\r\n");
				fw.write("此情可待成追忆，只是当时已惘然。\r\n");
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}

		
		
		
		String src = "从明天起，做一个幸福的人\n"
				+ "喂马，劈柴，周游世界\n"
				+ "从明天起，关心粮食和蔬菜\n"
				+ "我有一所房子，面朝大海，春暖花开\n"
				+ "从明天起，和每一个亲人通信\n"
				+ "告诉他们我的幸福\n";
			char[] buffer = new char[32];
			int hasRead = 0;
			try(
				StringReader sr = new StringReader(src))
			{
				// 采用循环读取的访问读取字符串
				while((hasRead = sr.read(buffer)) > 0)
				{
					System.out.print(new String(buffer ,0 , hasRead));
				}
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
			
			
			
			
			/** StringWriter
			 * API说明：在字符串缓冲区中收集输出的字符流，可用于构造字符串， 关闭流无效，关闭后调用其他方法不会报异常
			 * StringWriter不是把数据写到某种形式的输出设备上，相反，它写到内存中。
			 * */
			try(
				StringWriter sw = new StringWriter())
			{
				// 调用StringWriter的方法执行输出
				sw.write("有一个美丽的新世界，\n");
				sw.write("她在远方等我,\n");
				sw.write("哪里有天真的孩子，\n");
				sw.write("还有姑娘的酒窝\n");
				System.out.println("----下面是sw的字符串节点里的内容----");
				// 使用toString()方法返回StringWriter的字符串节点的内容
				System.out.println(sw.toString());
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
			
			
			
			
			/** PrintStream 不但能输出字符到文件，还可以输出对象及其方法到文件。*/
			PrintStream psto = new PrintStream(new FileOutputStream("resource/printstream.txt"));
			psto.print("姓名：");
			psto.println("小猪");
			psto.println(new InputTest()); 
			psto.println(new InputTest().getClass());
			psto.close();
			
			
			
			
			/** RandomAccessFile */
			try(
					//以读、写方式打开一个RandomAccessFile对象
					RandomAccessFile raf = new RandomAccessFile("resource/ranout.txt" , "rw"))
				{
				System.out.println("RandomAccessFile的文件指针的初始位置："
						+ raf.getFilePointer());
				
					//将记录指针移动到out.txt文件的最后
					raf.seek(raf.length());
					System.out.println("RandomAccessFile的文件指针的位置："
							+ raf.getFilePointer());
					
					raf.write("追加的内容！\r\n".getBytes());
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
			System.out.println("------");
			
			
			
			
			
			
	        
	        
	        
			
		
	}
}
