package com.example.todo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.todo.entities.Task;

public interface TaskRepository extends MongoRepository<Task, String> {}
