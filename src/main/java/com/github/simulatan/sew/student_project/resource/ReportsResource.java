package com.github.simulatan.sew.student_project.resource;

import com.github.simulatan.sew.student_project.dto.ProjectReport;
import com.github.simulatan.sew.student_project.dto.StudentWorkReport;
import com.github.simulatan.sew.student_project.dto.TeacherReport;
import com.github.simulatan.sew.student_project.repository.ReportsRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("reports")
public class ReportsResource {

	@Inject
	ReportsRepository reportsRepository;

	@Path("average-hours-per-task")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public double getAverageHoursPerTask() {
		return reportsRepository.getAverageHoursPerTask();
	}

	@Path("list/teacher-reports")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TeacherReport> getTeacherReports() {
		return reportsRepository.getTeacherReports();
	}

	@Path("list/hardest-working-students/{limit}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentWorkReport> getHardestWorkingStudents(@PathParam("limit") int limit) {
		return reportsRepository.getHardestWorkingStudents(limit);
	}

	@Path("list/project-reports")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProjectReport> getProjectReports() {
		return reportsRepository.getProjectReports();
	}
}
