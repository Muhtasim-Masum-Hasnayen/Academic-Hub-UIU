package com.example.academichubuiu;

import java.util.ArrayList;

public class Student {
    private String studentName;
    private String studentId;
    private String studentEmail;
    private String phonenumber;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Student(String studentName, String studentId, String studentEmail, String phonenumber) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.studentEmail = studentEmail;
        this.phonenumber = phonenumber;
        this.CourseCode = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public ArrayList<String> getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(ArrayList<String> courseCode) {
        CourseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", CourseCode=" + CourseCode +
                '}';
    }

    ArrayList<String>CourseCode=new ArrayList<>();
public static ArrayList<Student>Studentarray=new ArrayList<>();

}
