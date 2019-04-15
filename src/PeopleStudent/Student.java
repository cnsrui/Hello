package PeopleStudent;

public class Student extends People implements ReadBook {
    private String school = "";

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    static {
        System.out.println("Student's Static Block.");
    }

    {
        System.out.println("Student's Common Block.");
    }

    public Student() {
        System.out.println("Student's Constructure.");
    }

    public void showinfo() {
        super.showinfo(); // 使用父类的方法。
        System.out.println("Student's Method.");
    }

    public void showstudent() {

    }

    @Override
        public void readBook() {
        System.out.println("Interface Method from Studnet.");
    }

}
