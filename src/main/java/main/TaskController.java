package main;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
  @GetMapping("/tasks/")
  public List<Task> list(){
      return Storage.getAllTask();
  }

  @PutMapping("/tasks/")
  public int addTask(Task task){
    return Storage.addTask(task);
  }

  @DeleteMapping("/tasks/{id}")
  public ResponseEntity delete (@PathVariable int id){
    if (Storage.deleteTask(id)) return ResponseEntity.status(HttpStatus.OK).body(null);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }

  @GetMapping("/tasks/{id}")
  public ResponseEntity get (@PathVariable int id) {
    Task task = Storage.get(id);
    if (task == null)
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    return new ResponseEntity(task, HttpStatus.OK);

  }
}
