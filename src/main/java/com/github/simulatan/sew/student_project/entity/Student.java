package com.github.simulatan.sew.student_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@NamedQuery(name = Student.LIST_BY_CLASS, query = "SELECT s FROM Student s WHERE s.studentId.clazz = :clazz")
public class Student {
	public static final String LIST_BY_CLASS = "Student.listByClass";

	@EmbeddedId
	@AttributeOverride(name = "clazz", column = @Column(name = "clazz"))
	@AttributeOverride(name = "catalogNumber", column = @Column(name = "catalog_number"))
	private StudentId studentId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@OneToMany(mappedBy = "student")
	@JsonIgnoreProperties({"student"})
	private Set<Task> tasks;
	@ManyToMany
	@JoinTable(
		name="task",
		joinColumns = {
			@JoinColumn(name="student_clazz", referencedColumnName = "clazz"),
			@JoinColumn(name="student_catalog_number", referencedColumnName = "catalog_number")
		},
		inverseJoinColumns = {
			@JoinColumn(name="id")
		}
	)
	private Set<Project> projects;

	public StudentId getStudentId() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public Set<Project> getProjects() {
		return projects;
	}
}
