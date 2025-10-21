package com.innogent.SpringProject.dto;

import java.util.List;

public class StudentResponse {
    private Integer id;
    private String name;
    private String email;
    private String city;
    private List<String> courseNames;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public List<String> getCourseNames() { return courseNames; }
    public void setCourseNames(List<String> courseNames) { this.courseNames = courseNames; }
}
