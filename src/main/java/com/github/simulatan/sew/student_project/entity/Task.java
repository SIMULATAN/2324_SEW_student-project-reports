package com.github.simulatan.sew.student_project.entity;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = Task.QUERY_FIND_BY_PROJECT, query = "SELECT t FROM Task t WHERE t.project.id = :projectId")
public class Task {
	public static final String QUERY_FIND_BY_PROJECT = "Task.findByProject";

	@Id
	private Long id;
	private String title;
	@Column(name = "hours_worked")
	private int hoursWorked;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	@ManyToOne
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
