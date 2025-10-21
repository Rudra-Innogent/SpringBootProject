package com.innogent.SpringProject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @JsonProperty("courseName")
    private String courseName;
    
    @Column
    @JsonProperty("instructor")
    private String instructor;

    @ManyToMany(mappedBy = "courses", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private Set<Student> students = new HashSet<>();

	public Set<Student> getStudents() {
		return students;
	}
	public Long getId() {
	    return id;
	}

	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public String getCourseName() {
		return this.courseName;
	}
	
	@Override
	public String toString() {
	    return "Course{" +
	            "id=" + id +
	            ", courseName='" + courseName + '\'' +
	            ", instructor='" + instructor + '\'' +
	            '}';
	}
	
}
