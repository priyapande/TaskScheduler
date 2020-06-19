package com.observeai.taskschedulerdemo.controller;

import com.observeai.taskschedulerdemo.model.ExecStatus;
import com.observeai.taskschedulerdemo.model.TaskDTO;
import com.observeai.taskschedulerdemo.model.TaskDataReceiver;
import com.observeai.taskschedulerdemo.model.TaskModel;
import com.observeai.taskschedulerdemo.service.PersistTaskService;
import com.observeai.taskschedulerdemo.service.PrioritySchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api")
public class ScheduleTaskController {

    private static final Logger logger = LoggerFactory.getLogger(PrioritySchedulerService.class);
    private PersistTaskService persistTaskService;

    @Autowired
    ScheduleTaskController(PersistTaskService persistTaskService) {
      this.persistTaskService = persistTaskService;
    }

    @PostMapping(path = "/modifyStatus")
    public HttpStatus modifyTaskStatus(@RequestBody TaskDataReceiver taskData) {
        TaskDTO task = persistTaskService.findTask(taskData.getTaskId());
        task.setExecStatus(taskData.getTaskStatus());
        persistTaskService.saveOrUpdateTask(task);
        return HttpStatus.OK;
    }

    @GetMapping(path = "/activeTask")
    public List<Integer> fetchAllActiveTasks() {
        List<TaskDTO> allActiveTask = persistTaskService.getAllActiveTask(LocalDateTime.now());
        List<Integer> namesOfActiveTask = new ArrayList<>();
        allActiveTask.forEach(task -> namesOfActiveTask.add(task.getTaskId()));
        return namesOfActiveTask;
    }

    @GetMapping(path = "/rangeTask/{startTime}/{endTime}")
    public List<Integer> fetchAllTasksInRange(@PathVariable String startTime, @PathVariable String endTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        List<TaskDTO> allTaskInRange = persistTaskService.getAllTasksExecutingInTimeRange(
                LocalDateTime.parse(startTime,dateTimeFormatter), LocalDateTime.parse(endTime, dateTimeFormatter));
        List<Integer> taskInRange = new ArrayList<>();
        allTaskInRange.forEach(task -> taskInRange.add(task.getTaskId()));
        return taskInRange;
    }

    @PostMapping(path = "/addTask")
    public HttpStatus addTask(@RequestBody List<TaskModel> tasks) {
        LocalDateTime arrival = LocalDateTime.now();
        tasks.forEach( taskData -> {
            LocalDateTime schedule = arrival.plusMinutes(taskData.getStartOffset());
            TaskDTO task = new TaskDTO(taskData.getTaskType(), taskData.getExecTime(),
                    taskData.getPriorityLevel(), ExecStatus.ACTIVE,schedule,arrival);
            persistTaskService.saveOrUpdateTask(task);
        });
        return HttpStatus.OK;
    }
}
