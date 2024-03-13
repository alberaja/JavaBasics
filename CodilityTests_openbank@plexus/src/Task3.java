
---------------------- dado:
public class Task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Dado:
		//3
		package com.codility.tasks.hibernate.solution;

		import org.springframework.data.jpa.repository.*;
		import org.springframework.http.HttpStatus;
		import org.springframework.http.MediaType;
		import org.springframework.transaction.annotation.*;
		import org.springframework.web.bind.annotation.*;

		import javax.persistence.*;
		import java.util.logging.Logger;


		class Task {

		}

		class TaskController {
		  private static Logger log = Logger.getLogger("Solution");
		  // log.info("You can use 'log' for debug messages");
		}

		interface TaskRepository extends JpaRepository<Task, Long> {

		}
----------------------
		class TaskController {
			  private static Logger log = Logger.getLogger("Solution");
			  // log.info("You can use 'log' for debug messages");
			    @PutMapping("tasks/{id}")
				public ResponseDTO updateShip(@PathVariable @NotNull @Min(value = 1, message = "ID must be >=1") Integer id,
						@RequestBody @Valid final String description, @RequestBody @Valid final Long priority) throws NotFoundException {
					
					return shipService.update(id, updatedShip);
				}
			}

}

---------------------- envio:
	
	@RestController
	@RequestMapping("/tasks")
	class TaskController {
		private static Logger log = Logger.getLogger("Solution");
	 
		private final TaskRepository taskRepository;
	 
		@Autowired
		public TaskController(TaskRepository taskRepository) {
	    	this.taskRepository = taskRepository;
		}
	 
		@PutMapping("/{id}")
		public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task task) {
	    	if (task.getDescription() == null || task.getDescription().trim().isEmpty()) {
	        	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                             	.body(new CustomError("Task description is required", 400));
	    	}
	 
	    	return taskRepository.findById(id)
	            	.map(existingTask -> {
	                    existingTask.setDescription(task.getDescription());
	                    existingTask.setPriority(task.getPriority());
	                    taskRepository.save(existingTask);
	                	return ResponseEntity.ok(existingTask);
	                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
	                                        .body(new CustomError("Cannot find task with given id", 404)));
		}
	 
		static class CustomError {
	    	private String message;
	    	private int status;
	    	public CustomError(String message, int status) {
	        	this.message = message;
	this.status = status;
	}

	 
		// Getters (and setters if needed)
		public String getMessage() {
	    	return message;
		}
	 
		public int getStatus() {
	    	return status;
		}
	}
