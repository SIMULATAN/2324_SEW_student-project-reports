package com.github.simulatan.sew.student_project.repository;

import com.github.simulatan.sew.student_project.entity.Project;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class ProjectsRepository {
	@Inject
	EntityManager entityManager;

	public List<Project> listProjects() {
		return entityManager.createNamedQuery(Project.QUERY_FIND_ALL, Project.class)
			.getResultList();
	}

	public Project findProjectById(Long id) {
		return entityManager.find(Project.class, id);
	}
}
