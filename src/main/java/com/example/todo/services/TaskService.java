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
	
	// Create
	public Task insert(Task task) {
		return taskRepository.save(task);
	}
	
	// Read
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
	
	public List<Task> findByDescription(String description) {
		return taskRepository.findByDescriptionContainingIgnoreCase(description);
	}
	
	// Update
	public Task update(Task task) {
		Task newTask = taskRepository.findById(task.getId())
			.orElseThrow(() -> new ObjectNotFoundException("Object can't be found! Id: " + task.getId()));	
		updateData(newTask, task);
		return taskRepository.save(newTask);
	}
	
	private void updateData(Task newTask, Task task) {
		newTask.setTitle(task.getTitle());
		newTask.setDescription(task.getDescription());
	}
	
	// Delete
	public void delete(String id) {
		findById(id);
		taskRepository.deleteById(id);
	}
}
