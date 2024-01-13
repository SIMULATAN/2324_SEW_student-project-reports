package com.github.simulatan.sew.student_project.resource;

import com.github.simulatan.sew.student_project.entity.Student;
import com.github.simulatan.sew.student_project.entity.StudentId;
import com.github.simulatan.sew.student_project.repository.StudentsRepository;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/students")
public class StudentsResource {

	@Inject
	StudentsRepository studentsRepository;

	@GET
	@Path("list/{clazz}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> listByClass(@PathParam("clazz") String clazz) {
		return studentsRepository.listByClass(clazz);
	}

	@GET
	@Path("{clazz}/{catalogNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student findById(@PathParam("clazz") String clazz, @PathParam("catalogNumber") int catalogNumber) {
		Student student = studentsRepository.findById(new StudentId(clazz, catalogNumber));
		if (student == null) {
			throw new NotFoundException("Student not found!");
		}
		return student;
	}
}
