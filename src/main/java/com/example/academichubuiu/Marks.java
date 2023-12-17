package com.example.academichubuiu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

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


    public static int ctmarkcount(String course, String id) {
        int avgmark = 0;

        for (int i = 0; i < Marks.marksarray.size(); i++) {

            if (course.equalsIgnoreCase(marksarray.get(i).getCoursecode()) && id.equals(marksarray.get(i).getStudentid())) {
               int count;
                System.out.println("Right");
                String[] ctt=new String[4];

               ctt[0]=marksarray.get(i).getCt1();
               ctt[1]=marksarray.get(i).getCt2();
               ctt[2]=marksarray.get(i).getCt3();
               ctt[3]=marksarray.get(i).getCt4();

                System.out.println(ctt[0]+ctt[1]+ctt[2]+ctt[3]);
                for(int m=0;m<4;m++) {
                    if(ctt[m].isEmpty()){
                        System.out.println("Check");
                        ctt[m]="0";
                    }
                }
                System.out.println("after null"+ctt[0]+ctt[1]+ctt[2]+ctt[3]);


     int [] ct=new int[4];

                    try {
                        ct[0] = Integer.parseInt(ctt[0]);
                        ct[1] = Integer.parseInt(ctt[1]);
                        ct[2] = Integer.parseInt(ctt[2]);
                        ct[3] = Integer.parseInt(ctt[3]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format");
                    }
               // Arrays.sort(ct);
                System.out.println("orginal"+ct[0]+ct[1]+ct[2]+ct[3]);

                 count = 0;
                for (int p = 0; p < 4; p++) {
                    if (ct[p]>0) {
                        count++;
                    }
                }
                    System.out.println(count);

                for (int p = 0; p < 4; p++) {

                        avgmark=avgmark+ct[p];
                    }

                avgmark=  avgmark/count;


                break;
                }


            }



        return avgmark+1;
    }

//    public static int assmarkcount(String course, String id){
//        int ass=0;
//
//
//        for (int i = 0; i < Marks.marksarray.size(); i++) {
//
//            if (course.equalsIgnoreCase(marksarray.get(i).getCoursecode()) && id.equals(marksarray.get(i).getStudentid())) {
//                int count;
//                //System.out.println("Right");
//                String[] ctt=new String[2];
//
//                ctt[0]=marksarray.get(i).getAssignment1();
//                ctt[1]=marksarray.get(i).getAssignment2();
//
//
//
//
//
//                int [] ct=new int[2];
//
//                try {
//                    ct[0] = Integer.parseInt(ctt[0]);
//                    ct[1] = Integer.parseInt(ctt[1]);
//
//                } catch (NumberFormatException e) {
//                    System.out.println("Invalid number format");
//                }
//
//
//
//
//              ass=ct[0]+ct[1];
//
//ass=ass/2;
//                break;
//            }
//
//
//        }
//
//
//
//        return ass;
//    }
//
//




}

