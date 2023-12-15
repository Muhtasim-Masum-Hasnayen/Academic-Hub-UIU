package com.example.academichubuiu;

import java.io.Serializable;
import java.util.ArrayList;

public class Marks implements Serializable {
    private String coursecode;
    private String studentid;
    private String ct1;
    private String ct2;
    private String ct3;
    private String ct4;
    private String assignment1;
    private String assignment2;
    private String mid;
    private String aFinal;

    public Marks(String coursecode, String studentid, String ct1,
                 String ct2, String ct3, String ct4, String assignment1,
                 String assignment2, String mid, String aFinal) {
        this.coursecode = coursecode;
        this.studentid = studentid;
        this.ct1 = ct1;
        this.ct2 = ct2;
        this.ct3 = ct3;
        this.ct4 = ct4;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.mid = mid;
        this.aFinal = aFinal;
    }


    @Override
    public String toString() {
        return "Marks{" +
                "coursecode='" + coursecode + '\'' +
                ", studentid='" + studentid + '\'' +
                ", ct1='" + ct1 + '\'' +
                ", ct2='" + ct2 + '\'' +
                ", ct3='" + ct3 + '\'' +
                ", ct4='" + ct4 + '\'' +
                ", assignment1='" + assignment1 + '\'' +
                ", assignment2='" + assignment2 + '\'' +
                ", mid='" + mid + '\'' +
                ", Final='" + aFinal + '\'' +
                '}';
    }

    public String getCoursecode() {
        return coursecode;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getCt1() {
        return ct1;
    }

    public String getCt2() {
        return ct2;
    }

    public String getCt3() {
        return ct3;
    }

    public String getCt4() {
        return ct4;
    }

    public String getAssignment1() {
        return assignment1;
    }

    public String getAssignment2() {
        return assignment2;
    }

    public String getMid() {
        return mid;
    }

    public String getFinal() {
        return aFinal;
    }

    public static ArrayList<Marks> marksarray = new ArrayList<>();
}
