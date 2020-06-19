# TaskScheduler

To start the application run gradlew bootrun.
Open localhost:8080 in postman app to test out APIs.

##API 

(/api) initial url

1) /addTask 
  * Post API that accepts application/json in body
  * Give array of tasks in JSON as follows : [{
	  "taskType": "A",
	  "execTime": "2",
	  "priorityLevel": "MEDIUM",
	  "startOffset": "1"
}]
  * Here PriorityLevel can be ["HIGH", "MEDIUM, "LOW"]; taskType ["A", "B"]

2) /modifyTask
  * Post API that accepts application/json in body
  * pass JSON in body as follows: {
    "taskId": "1",
    "taskStatus": "ACTIVE"
  }
  * Here taskStatus can be ["INACTIVE", "ACTIVE"]

3) /activeTask
   * Get API that fetches all active objects waiting to be executed at current time.
   
4) /rangeTask/{startTime}/{endTime}   
   * Get API that takes start and end time as path variable
   * Give Time in format 'yyyy-MM-dd HH:mm'
