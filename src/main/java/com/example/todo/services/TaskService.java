package com.example.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entities.Task;
import com.example.todo.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> findAll() {	
		return taskRepository.findAll();
	}
}
