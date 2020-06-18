package com.observeai.taskschedulerdemo.repository;

import com.observeai.taskschedulerdemo.model.TaskDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PersistTaskDAO extends CrudRepository<TaskDTO, String> {
    @Query(value="select * from TASKDTO where start_time <= ?1 and exec_status='ACTIVE'", nativeQuery = true)
    List<TaskDTO> findAllActiveQueries(LocalDateTime currentTime);

    @Query(value = "select * from taskdto t where picked_up_time >= ?1 and picked_up_time <= ?2", nativeQuery = true)
    List<TaskDTO> findAllTasksBetweenTimeRange(LocalDateTime t1, LocalDateTime t2);

}
