package org.jbossoutreach.certifier.model;

public class StudentCsv {

    private String  name;
    private String email;
    private String certificate;

    public StudentCsv(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public StudentCsv(){

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

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public static Student toStudent(StudentCsv studentCsv){
        return new Student();
    }
}
