package com.example.project.model;

public class Student {
    private int _id;
    private String stu_name;
    private String stu_address;
    private String stu_branch;
    private int stu_age;
    public int get_id(){
        return _id;
    }
    public void set_id(int _id)
    {
        this._id=_id;
    }
    public String getStu_name(){
        return stu_name;
    }
    public void setStu_name(String stu_name){
        this.stu_name=stu_name;
    }
    public String getStu_address(){
        return stu_address;
    }
    public void setStu_address(String stu_address){
        this.stu_address=stu_address;
    }
    public String getStu_branch(){
        return stu_branch;
    }
    public void setStu_branch(String stu_branch){
        this.stu_name=stu_branch;
    }
    public int getStu_age(){
        return stu_age;
    }
    public void setStu_age(int stu_age){
        this.stu_age=stu_age;
    }

}
