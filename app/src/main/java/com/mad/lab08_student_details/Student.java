package com.mad.lab08_student_details;

public class Student {

    private int id;
    private String name;
    private int age;
    private String address;
    private String dpt;

    public Student(int id, String name, int age, String address, String dpt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.dpt = dpt;
    }

    public Student(String name, int age, String address, String dpt) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.dpt = dpt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }
}
