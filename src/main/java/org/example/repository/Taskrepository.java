package org.example.repository;

import org.example.enums.Status;
import org.example.model.entity.Employee;
import org.example.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Taskrepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(Status status);
}
