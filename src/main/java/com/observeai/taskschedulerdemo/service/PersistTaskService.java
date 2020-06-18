package com.observeai.taskschedulerdemo.service;

import com.observeai.taskschedulerdemo.model.TaskDTO;
import com.observeai.taskschedulerdemo.repository.PersistTaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersistTaskService {
    private final PersistTaskDAO persistTaskDao;

    @Autowired
    PersistTaskService(PersistTaskDAO persistTaskDAO) {
        this.persistTaskDao = persistTaskDAO;
    }

    /* use this for saving and updating status or pickedUpTime*/
    public void saveOrUpdateTask(TaskDTO task) {
        persistTaskDao.save(task);
    }

    public TaskDTO findTask(String id) {
        return persistTaskDao.findById(id).orElse(null);
    }

    /* use this for querying active objects at time t */
    public List<TaskDTO> getAllActiveTask(LocalDateTime currTime) {
        return persistTaskDao.findAllActiveQueries(currTime);
    }

    /* use this to find all tasks executing in timeframe */
    public List<TaskDTO> getAllTasksExecutingInTimeRange(LocalDateTime t1, LocalDateTime t2) {
        return persistTaskDao.findAllTasksBetweenTimeRange(t1, t2);
    }
}
