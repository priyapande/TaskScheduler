package com.observeai.taskschedulerdemo.repository;

import com.observeai.taskschedulerdemo.model.TaskDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersistTaskDAO extends CrudRepository<TaskDTO, String> {

}
