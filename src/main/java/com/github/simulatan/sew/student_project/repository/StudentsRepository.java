package com.github.simulatan.sew.student_project.repository;

import com.github.simulatan.sew.student_project.entity.Student;
import com.github.simulatan.sew.student_project.entity.StudentId;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class StudentsRepository {
	@Inject
	EntityManager entityManager;

	public List<Student> listByClass(String clazz) {
		return entityManager.createNamedQuery(Student.LIST_BY_CLASS, Student.class)
			.setParameter("clazz", clazz)
			.getResultList();
	}

	public Student findById(StudentId id) {
		return entityManager.find(Student.class, id);
	}
}
