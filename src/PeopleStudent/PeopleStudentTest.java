package PeopleStudent;

public class PeopleStudentTest {

	public static void main (String[] args) {
	/**
	 * 以下几种组合会有不同的显示效果。 
	 * 作用：验证类的静态代码块、普通代码块、构造函数在继承类中的加载顺序。 
	 * 组合1: new People(); 
	 * 组合2: new Student(); 
	 * 组合3: new People(); new Student(); 
	 * 组合4: new Student(); new Student();
	 */
//	new People();
//	new Student();
//	new Student();

	/**
	 * 对象调用重写的接口方法
	 */
	People people = new People();
	Student student = new Student();
	people.showinfo();
	student.showinfo();
	people.readBook();
	student.readBook();

	/*
	 * 多态性
	 */
	ReadBook rdpeople = new People();
	ReadBook rdstudent = new Student();
	rdpeople.readBook();
	rdstudent.readBook();
	
}
}