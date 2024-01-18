package org.example.repository;

import org.example.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.model.entity.Task;

import java.util.List;
@Repository

public interface TaskRepository extends JpaRepository<Task, Long> {

    void getTasksByStatus(Status status);
}
