import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame implements ActionListener {
    JFrame frame;
    JLabel label_number;
    JLabel label_name;
    JLabel label_major;
    JLabel label_birthday;
    JLabel label_information;
    JLabel label_courseNumber;
    JLabel label_subject;
    JLabel label_examDay;
    JLabel label_score;
    JLabel label_teacher;
    JTextField text_number;
    JTextField text_name;
    JTextField text_major;
    JTextField text_birthday;
    JTextField text_courseNumber;
    JTextField text_subject;
    JTextField text_examDay;
    JTextField text_score;
    JTextField text_teacher;
    JButton button_inputConfirmation;
    JButton button_showThisStudent;
    JButton button_showAllStudent;
    JButton button_addStudent;
    JButton button_reviseStudent;
    JButton button_deleteStudent;
    JLabel label_show;
    JLabel label_star;
    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel label_operate;
    JTextField text_operate;
    JButton button_ok;
    int courseNumber = 1;
    int flag = 1;
    int init = 0;
    Course[] courses;
    Student student;
    String number;
    String name;
    String major;
    String birthday;
    String operate;
    ArrayList<Student> students = new ArrayList<Student>();

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button_inputConfirmation && flag <= courseNumber){
            if (flag == 1) {
                button_inputConfirmation.setEnabled(true);
                while (true) {
                    try {
                        Integer.parseInt(text_number.getText());
                    } catch (NumberFormatException a) {
                        number = JOptionPane.showInputDialog(null,
                                "请重新输入你的学号：","输入有误，参照输入:22072120",JOptionPane.WARNING_MESSAGE);		//输入对话框
                        text_number.setText(number);
                        continue;
                    }
                    break;
                }
                number = text_number.getText();
                name = text_name.getText();
                major = text_major.getText();
                while (true) {
                    try {
                        new Date(text_birthday.getText());
                    } catch (NumberFormatException a) {
                        String temp = JOptionPane.showInputDialog(null,
                                "请重新输入日期：","输入有误，参照输入:2004.07.02",JOptionPane.WARNING_MESSAGE);		//输入对话框
                        text_birthday.setText(temp);
                        continue;
                    }
                    if(new Date(text_birthday.getText()).birthdayCorrectnessCheck())
                    {
                        break;
                    } else{
                        String temp = JOptionPane.showInputDialog(null,
                                "请重新输入日期：","输入有误，参照输入:2004.07.02",JOptionPane.WARNING_MESSAGE);		//输入对话框
                        text_birthday.setText(temp);
                    }
                }
                birthday = text_birthday.getText();
                while (true) {
                    try {
                        Integer.parseInt(text_courseNumber.getText());
                    } catch (NumberFormatException a) {
                        String temp = JOptionPane.showInputDialog(null,
                                "请重新输入你的课程数量：","输入有误，参照输入:2",JOptionPane.WARNING_MESSAGE);		//输入对话框
                        text_courseNumber.setText(temp);
                        continue;
                    }
                    break;
                }
                courseNumber = Integer.parseInt(text_courseNumber.getText());
                courses = new Course[courseNumber];
            }
            String subject = text_subject.getText();
            while (true) {
                try {
                    new Date(text_examDay.getText());
                } catch (NumberFormatException a) {
                    String temp = JOptionPane.showInputDialog(null,
                            "请重新输入日期：","输入有误，参照输入:2004.07.02",JOptionPane.WARNING_MESSAGE);		//输入对话框
                    text_examDay.setText(temp);
                    continue;
                }
                if(new Date(text_examDay.getText()).examdayCorrectnessCheck())
                {
                    break;
                } else{
                    String temp = JOptionPane.showInputDialog(null,
                            "请重新输入日期：","输入有误，参照输入:2004.07.02",JOptionPane.WARNING_MESSAGE);		//输入对话框
                    text_examDay.setText(temp);
                }
            }
            String examDay = text_examDay.getText();
            while (true) {
                try {
                    Double.parseDouble(text_score.getText());
                } catch (NumberFormatException a) {
                    String temp = JOptionPane.showInputDialog(null,
                            "请重新输入你的分数：","输入有误，参照输入范围0 - 100",JOptionPane.WARNING_MESSAGE);		//输入对话框
                    text_score.setText(temp);
                    continue;
                }
                if(0 <= Double.parseDouble(text_score.getText()) &&  Double.parseDouble(text_score.getText()) <= 100)
                {
                    break;
                } else{
                    String temp = JOptionPane.showInputDialog(null,
                            "请重新输入你的分数：","输入有误，参照输入范围0 - 100",JOptionPane.WARNING_MESSAGE);		//输入对话框
                    text_score.setText(temp);
                }
            }
            double score = Double.parseDouble(text_score.getText());
            String teacher = text_teacher.getText();
            courses[flag-1] = new Course(subject, new Date(examDay), score, teacher);
            if(flag  == courseNumber && init == 1){
                for (int i = 0; i < students.size(); i++) {
                    if(operate.equals(students.get(i).getNumber())){
                        students.get(i).set_info(number, name, major, new Date(birthday), courses);
                        JOptionPane.showMessageDialog(null,
                                "学号为:" + students.get(i).getNumber() + "的同学\n已成功修改",
                                "操作提示",JOptionPane.WARNING_MESSAGE);
                    }
                }
                button_inputConfirmation.setEnabled(false);
                courseNumber = 1;
                flag = 1;
                init = 0;
                operate = "";
            }else if(flag  == courseNumber && init == 0){
                button_inputConfirmation.setEnabled(false);
                student = new Student(number, name, major, new Date(birthday), courses);
                students.add(student);
                courseNumber = 1;
                flag = 1;
                JOptionPane.showMessageDialog(null,
                        "该同学信息录入已完成\n请点击添加学生输入新的同学信息\n或是进行其他操作",
                        "操作提示",JOptionPane.WARNING_MESSAGE);
            }else if(flag <= courseNumber - 1){
                JOptionPane.showMessageDialog(null,
                        "请输入下一门课程",
                        "操作提示",JOptionPane.WARNING_MESSAGE);
                button_inputConfirmation.setText("确认第" + (++flag) + "门课程的信息");
                text_subject.setText("");
                text_examDay.setText("");
                text_score.setText("");
                text_teacher.setText("");
            }
        }else if (e.getSource() == button_showThisStudent){
            textArea.setText("");
            if (students.size() > 0) {
                textArea.setText(student.toString(students.size()));
            }
        }else if(e.getSource() == button_showAllStudent){
            textArea.setText("");
            if (students.size() > 0) {
                String str = "";
                for (int i = 0; i < students.size(); i++) {
                    str += students.get(i).toString(i + 1);
                }
                textArea.setText(str);
            }
        }else if(e.getSource() == button_addStudent){
            button_inputConfirmation.setText("确认学生及第1门课程的信息");
            button_inputConfirmation.setEnabled(true);
            text_number.setText("");
            text_name.setText("");
            text_major.setText("");
            text_birthday.setText("");
            text_courseNumber.setText("");
            text_subject.setText("");
            text_examDay.setText("");
            text_score.setText("");
            text_teacher.setText("");
        }else if(e.getSource() == button_reviseStudent){
            button_inputConfirmation.setText("确认学生及第1门课程的信息");
            text_number.setText("");
            text_name.setText("");
            text_major.setText("");
            text_birthday.setText("");
            text_courseNumber.setText("");
            text_subject.setText("");
            text_examDay.setText("");
            text_score.setText("");
            text_teacher.setText("");
            JOptionPane.showMessageDialog(null,
                    "请在下方输入框内输入要进行操作的学生学号\n并点击确定按钮确认完成",
                    "操作提示",JOptionPane.WARNING_MESSAGE);
            button_inputConfirmation.setEnabled(false);
        }else if (e.getSource() == button_deleteStudent){
            button_inputConfirmation.setText("确认学生及第1门课程的信息");
            text_number.setText("");
            text_name.setText("");
            text_major.setText("");
            text_birthday.setText("");
            text_courseNumber.setText("");
            text_subject.setText("");
            text_examDay.setText("");
            text_score.setText("");
            text_teacher.setText("");
            for (int i = 0; i < students.size(); i++) {
                if(operate.equals(students.get(i).getNumber())){
                    students.remove(i);
                    JOptionPane.showMessageDialog(null,
                            "学号为:" + students.get(i).getNumber() + "的同学\n已成功删除",
                            "操作提示",JOptionPane.WARNING_MESSAGE);
                    break;
                }
            }
        }else if (e.getSource() == button_ok) {
            button_inputConfirmation.setEnabled(true);
            operate = text_operate.getText();
            init = 1;
            text_operate.setText("");
        }
    }
    public Frame(){
        frame = new JFrame("学生信息管理系统");
        label_number = new JLabel("please input学生学号:");          text_number = new JTextField(15);
        label_name = new JLabel("please input学生姓名:");            text_name = new JTextField(15);
        label_major = new JLabel("please input所学专业:");         text_major = new JTextField(15);
        label_birthday = new JLabel("please input出生日期:");      text_birthday = new JTextField(15);
        label_information = new JLabel("*************以下输入该同学课程的信息*************");
        label_courseNumber = new JLabel("参加了几门课程的考试");   text_courseNumber = new JTextField(15);
        label_subject = new JLabel("please input考试科目:");        text_subject = new JTextField(15);
        label_examDay = new JLabel("please input考试日期:");        text_examDay = new JTextField(15);
        label_score = new JLabel("please input考试分数:");          text_score = new JTextField(15);
        label_teacher = new JLabel("please input授课教师:");        text_teacher = new JTextField(15);
        button_inputConfirmation = new JButton("确认学生及第1门课程的信息");
        button_showThisStudent = new JButton("显示该同学的基本信息和各科成绩");
        button_showAllStudent = new JButton("显示全班成绩");
        label_show = new JLabel("以下为同学的基本信息和各科成绩信息:");
        textArea = new JTextArea("", 5, 15);
        label_star = new JLabel("**************************************************************");
        button_addStudent = new JButton("添加学生");
        button_reviseStudent = new JButton("修改学生");
        button_deleteStudent = new JButton("删除学生");
        label_operate = new JLabel("输入需要操作学生的学号:");        text_operate = new JTextField(15);
        button_ok = new JButton("确定！");
        textArea.setLineWrap(true);
        scrollPane = new JScrollPane(textArea);
        Font font=new Font(Font.SANS_SERIF,Font.BOLD,20);

        label_number.setFont(font);             text_number.setFont(font);
        label_name.setFont(font);               text_name.setFont(font);
        label_major.setFont(font);              text_major.setFont(font);
        label_birthday.setFont(font);           text_birthday.setFont(font);
        label_information.setFont(font);
        label_courseNumber.setFont(font);       text_courseNumber.setFont(font);
        label_subject.setFont(font);            text_subject.setFont(font);
        label_examDay.setFont(font);            text_examDay.setFont(font);
        label_score.setFont(font);              text_score.setFont(font);
        label_teacher.setFont(font);            text_teacher.setFont(font);
        label_show.setFont(font);
        textArea.setFont(font);
        button_inputConfirmation.setFont(font);
        button_showThisStudent.setFont(font);   button_showAllStudent.setFont(font);
        label_star.setFont(font);
        button_addStudent.setFont(font);        button_reviseStudent.setFont(font);
        button_deleteStudent.setFont(font);
        label_operate.setFont(font);            text_operate.setFont(font);
        button_ok.setFont(font);
        Container contentPanel = frame.getContentPane();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        contentPanel.setLayout(flowLayout);

        contentPanel.add(label_number);               contentPanel.add(text_number);
        contentPanel.add(label_name);                  contentPanel.add(text_name);
        contentPanel.add(label_major);                 contentPanel.add(text_major);
        contentPanel.add(label_birthday);              contentPanel.add(text_birthday);
        contentPanel.add(label_information);
        contentPanel.add(label_courseNumber);          contentPanel.add(text_courseNumber);
        contentPanel.add(label_subject);               contentPanel.add(text_subject);
        contentPanel.add(label_examDay);               contentPanel.add(text_examDay);
        contentPanel.add(label_score);                 contentPanel.add(text_score);
        contentPanel.add(label_teacher);               contentPanel.add(text_teacher);
        contentPanel.add(label_show);
        contentPanel.add(scrollPane);
        contentPanel.add(button_inputConfirmation);
        contentPanel.add(button_showThisStudent);      contentPanel.add(button_showAllStudent);
        contentPanel.add(label_star);
        contentPanel.add(button_addStudent);           contentPanel.add(button_reviseStudent);
        contentPanel.add(button_deleteStudent);
        contentPanel.add(label_operate);                contentPanel.add(text_operate);
        contentPanel.add(button_ok);
        frame.setSize(550, 800);
        frame.setVisible(true);
        button_inputConfirmation.addActionListener(this);
        button_showThisStudent.addActionListener(this);
        button_showAllStudent.addActionListener(this);
        button_addStudent.addActionListener(this);
        button_reviseStudent.addActionListener(this);
        button_deleteStudent.addActionListener(this);
        button_ok.addActionListener(this);
    }
}
