package com.example.todo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entities.Task;
import com.example.todo.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskResource {
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll() {
		List<Task> tasks = taskService.findAll();
		
		return ResponseEntity.ok().body(tasks);
	}
}
