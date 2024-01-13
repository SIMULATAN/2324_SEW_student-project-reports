package com.github.simulatan.sew.student_project.repository;

import com.github.simulatan.sew.student_project.entity.Task;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class TaskRepository {
	@Inject
	EntityManager entityManager;

	public Task getById(Long id) {
		return entityManager.find(Task.class, id);
	}

	public List<Task> getByProject(Long projectId) {
		return entityManager.createNamedQuery(Task.QUERY_FIND_BY_PROJECT, Task.class)
			.setParameter("projectId", projectId)
			.getResultList();
	}
}
