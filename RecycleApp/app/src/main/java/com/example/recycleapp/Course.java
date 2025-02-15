package com.example.recycleapp;

import java.io.Serializable;

public class Course implements Serializable {
    private int courseID;
    private String courseName;
    private String courseDesc;
    private String eligibility;
    private double fees;
    private int image;

    public Course(int courseID, String courseName, String courseDesc, String eligibility, double fees, int image) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDesc = courseDesc;
        this.eligibility = eligibility;
        this.fees = fees;
        this.image = image;
    }

    public Course() {
    }



    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", eligibility='" + eligibility + '\'' +
                ", fees=" + fees +
                ", image=" + image +
                '}';
    }
}
