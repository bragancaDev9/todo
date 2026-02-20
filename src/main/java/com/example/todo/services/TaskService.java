package com.example.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entities.Task;
import com.example.todo.repositories.TaskRepository;
import com.example.todo.services.exceptions.ObjectNotFoundException;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	public Task insert(Task task) {
		return taskRepository.save(task);
	}
	
	public void delete(String id) {
		taskRepository.deleteById(id);
	}
	
	public List<Task> findAll() {	
		return taskRepository.findAll();
	}
	
	public Task findById(String id) {
		Optional<Task> task = taskRepository.findById(id);
		
		return task.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id));
	}
	
	public List<Task> findByTitle(String title) {
		return taskRepository.findByTitleContainingIgnoreCase(title);
	}
}
