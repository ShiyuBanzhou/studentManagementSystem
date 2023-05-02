public class Student extends Person{
    private String number;
    private String major;
    private Course[] courses;
    public Student() {
    }

    public Student(String number, String major) {
        this.number = number;
        this.major = major;
    }

    public Student(String number, String name, String major, Date birthday, Course[] courses) {
        super(name, birthday);
        this.number = number;
        this.major = major;
        this.courses = courses;
    }

    public void set_info(String number, String name, String major, Date birthday, Course[] courses) {
        this.setNumber(number);
        this.setName(name);
        this.setMajor(major);
        this.setBirthday(birthday);
        this.setCourses(courses);
    }

    /**
     * 获取
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 获取
     * @return major
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 获取
     * @return courses
     */
    public Course[] getCourses() {
        return courses;
    }

    /**
     * 设置
     * @param courses
     */
    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public String toString(int num) {
        String str = "";
        for (int i = 0; i < courses.length; i++) {
            str += courses[i].toString(i + 1);
        }
        return "第" + num + "名学生基本个人信息：\n" +
                "学号：" + number +
                "\n姓名：" + super.getName() +
                "\n所学专业：" + major +
                "\n出生日期：" + super.getBirthday() + "\n" + str;
    }

}
