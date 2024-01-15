package com.github.simulatan.sew.student_project.repository;

import com.github.simulatan.sew.student_project.dto.ProjectReport;
import com.github.simulatan.sew.student_project.dto.StudentWorkReport;
import com.github.simulatan.sew.student_project.dto.TeacherReport;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class ReportsRepository {
	@Inject
	EntityManager entityManager;

	public double getAverageHoursPerTask() {
		return entityManager
			.createQuery("SELECT AVG(task.hoursWorked) FROM Task task", Double.class)
			.getSingleResult();
	}

	public List<TeacherReport> getTeacherReports() {
		return entityManager
			.createQuery("SELECT NEW com.github.simulatan.sew.student_project.dto.TeacherReport(t.lastName, size(t.projects)) FROM Teacher t", TeacherReport.class)
			.getResultList();
	}

	public List<StudentWorkReport> getHardestWorkingStudents(int limit) {
		return entityManager
			.createQuery("SELECT NEW com.github.simulatan.sew.student_project.dto.StudentWorkReport(s.studentId.clazz, s.studentId.catalogNumber, s.lastName, SUM(task.hoursWorked)) FROM Student s JOIN s.tasks task GROUP BY s ORDER BY SUM(task.hoursWorked) DESC", StudentWorkReport.class)
			.setMaxResults(limit)
			.getResultList();
	}

	public List<ProjectReport> getProjectReports() {
		return entityManager
			.createQuery("SELECT NEW com.github.simulatan.sew.student_project.dto.ProjectReport(p.name, SUM(task.hoursWorked), COUNT(DISTINCT(task.student))) FROM Project p JOIN p.tasks task GROUP BY p", ProjectReport.class)
			.getResultList();
	}
}
