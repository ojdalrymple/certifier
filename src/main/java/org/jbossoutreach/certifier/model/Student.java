package org.jbossoutreach.certifier.model;

import java.util.Date;

public class Student {

    private String name;
    private String email;
    private String title;
    private int score;
    private Date awardDate;

    public Student() {

    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Student(String name, String email, String title) {
        this.name = name;
        this.email = email;
        this.title = title;
    }

    public Student(String name, String email, String title, int score) {
        this.name = name;
        this.email = email;
        this.title = title;
        this.score = score;
    }

    public Student(String name, String email, String title, int score, Date awardDate) {
        this.name = name;
        this.email = email;
        this.title = title;
        this.score = score;
        this.awardDate = awardDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static StudentCsv toStudentCsv(StudentCsv student) {
        return new StudentCsv();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(Date awardDate) {
        this.awardDate = awardDate;
    }
}
