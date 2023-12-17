package com.example.academichubuiu;

import java.util.ArrayList;

public class Student {
    private String studentName;
    private String studentId;
    private String studentEmail;

    public Student(String studentName, String studentId, String studentEmail, ArrayList<String> courseCode) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.studentEmail = studentEmail;
        CourseCode = courseCode;
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

    ArrayList<String>CourseCode=new ArrayList<>();
public static ArrayList<Student>Student=new ArrayList<>();

}
