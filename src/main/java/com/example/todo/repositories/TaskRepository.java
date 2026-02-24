package com.example.todo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.todo.entities.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
	public List<Task> findByTitleContainingIgnoreCase(String title);
	
	public List<Task> findByDescriptionContainingIgnoreCase(String description);
}
