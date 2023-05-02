public class Course{
    private String subject;
    private Date examDay;
    private double score;
    private String teacher;
    public Course() {
    }

    public Course(String subject, Date examDay, double score, String teacher) {
        this.subject = subject;
        this.examDay = examDay;
        this.score = score;
        this.teacher = teacher;
    }

    /**
     * 获取
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 获取
     * @return examDay
     */
    public Date getExamDay() {
        return examDay;
    }

    /**
     * 设置
     * @param examDay
     */
    public void setExamDay(Date examDay) {
        this.examDay = examDay;
    }

    /**
     * 获取
     * @return score
     */
    public double getScore() {
        return score;
    }

    /**
     * 设置
     * @param score
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * 获取
     * @return teacher
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * 设置
     * @param teacher
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String toString(int num){
        return  "第" + num + "门课程信息：\n" +
                "考试科目：" + subject +
                "\n考试日期：" + examDay +
                "\n考试分数：" + score +
                "\n授课教师：" + teacher + "\n";
    }
}
