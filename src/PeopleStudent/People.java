package PeopleStudent;

/**
 * People父类，用于被继承测试代码
 * @author cnsrui
 * @version 1.0
 */
public class People implements ReadBook{
	
	private String name = "";
	private int age = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	static {
		System.out.println("People's Static Block.");
	}
	{
		System.out.println("People's Common Block.");
	}
	public People() {
		System.out.println("People's Construnture.");
	}
	/**
	 * @param void
	 */
	public void showinfo() {
		System.out.println("People's Method.");
	}
	
	@Override
	public void readBook() {
		System.out.println("Interface Method from People.");
	}
}
