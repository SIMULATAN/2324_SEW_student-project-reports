package com.github.simulatan.sew.student_project.resource;

import com.github.simulatan.sew.student_project.entity.Project;
import com.github.simulatan.sew.student_project.repository.ProjectsRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/projects")
public class ProjectsResource {
	@Inject
	ProjectsRepository projectsRepository;

	@Path("list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> listProjects() {
		return projectsRepository.listProjects();
	}

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Project findProjectById(@PathParam("id") Long id) {
		Project project = projectsRepository.findProjectById(id);
		if (project == null)  {
			throw new NotFoundException("Project not found!");
		}
		return project;
	}
}
