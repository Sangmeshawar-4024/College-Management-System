import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
class Student{
    private int id;
    private String name;
    private String department;
    public Student(int id,String name,String department){
        this.id = id;
        this.name = name;
        this.department = department;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDepartment(){
        return department;
    }
    public String toString(){
        return "Student Id = " + id + "   Student Name = " + name + "   Student Department = " + department;
    }
}

class Course{
    private int courseid;
    private String coursename;
    public Course(int courseid,String coursename){
        this.courseid = courseid;
        this.coursename = coursename;
    }
    public int getCourseId(){
        return courseid;
    }
    public String getName(){
        return coursename;
    }
    public String toString(){
        return "Course Id    " + courseid +  " Course Name  " + coursename ;
    }
}

public class College extends JFrame{
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private JTextArea displayArea;
    public College(){
        setTitle("College Management System ");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        panel.setBackground(Color.CYAN);

        JButton addstudentbutton = new JButton("Add Student ");
        JButton addcoursebutton = new JButton("Add Course ");
        JButton displaystudentbutton = new JButton("Display Student ");
        JButton displaycoursebutton= new JButton("Display Course" );

        displayArea = new JTextArea();
        displayArea.setEditable(true);
        displayArea.setBackground(Color.GRAY);

        panel.add(addstudentbutton);
        panel.add(addcoursebutton);
        panel.add(displaystudentbutton);
        panel.add(displaycoursebutton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addstudentbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                addStudents();
            }
        });

        addcoursebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                addCourses();
            }
        });

        displaystudentbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                displaystudent();
            }
        });

        displaycoursebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                displaycourse();
            }
        });



    }

    private void addStudents(){
        try{
        int id = Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Student ID" ));
        String name = JOptionPane.showInputDialog(this,"Enter Student Name ");
        String department = JOptionPane.showInputDialog(this,"Enter Student Department ");

        students.add(new Student(id,name,department));
        JOptionPane.showInputDialog(this,"Student added successfully ");
    }
    catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid details.");
    }
}

private void addCourses(){
    try{
    int courseid = Integer.parseInt(JOptionPane.showInputDialog(this,"Enter Course Id "));
    String coursename = JOptionPane.showInputDialog(this,"Enter Course Name ");

    courses.add(new Course(courseid,coursename));
    JOptionPane.showInputDialog(this,"Course added successfully ");
}
catch(NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid details.");
}
}

private void displaystudent() {
    if (students.isEmpty()) {
        displayArea.setText("No students found.");
    } else {
        StringBuilder sb = new StringBuilder("List of Students ");
        for (Student student : students) {
            sb.append(student).append("\n ");
        }
        displayArea.setText(sb.toString());
    }
}

private void displaycourse() {
    if (courses.isEmpty()) {
        displayArea.setText("No courses found.");
    } else {
        StringBuilder sb = new StringBuilder("List of Courses " + " ");
        for (Course courses : courses) {
            sb.append(courses).append(" \n");
        }
        displayArea.setText(sb.toString());
    }
}

public static void main(String[] args) {
        new College().setVisible(true);

}
}




