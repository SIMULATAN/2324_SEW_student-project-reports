package com.github.simulatan.sew.student_project.resource;

import com.github.simulatan.sew.student_project.entity.Task;
import com.github.simulatan.sew.student_project.repository.TaskRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/tasks")
public class TasksResource {

	@Inject
	TaskRepository taskRepository;

	@Path("list/{projectId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Task listByProject(@PathParam("projectId") Long projectId) {
		return taskRepository.getById(projectId);
	}

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Task findById(@PathParam("id") Long id) {
		return taskRepository.getById(id);
	}
}
