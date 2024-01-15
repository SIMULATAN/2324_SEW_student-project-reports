package com.github.simulatan.sew.student_project.dto;

public record StudentWorkReport(
	String clazz,
	int catalogNumber,
	String lastName,
	long hoursWorked
) {}
