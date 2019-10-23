package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import main.model.Task;

public class Storage {

  private static Integer index = 1;
  private static HashMap<Integer, Task> storage = new HashMap<>();

  public static List<Task> getAllTask() {
    return new ArrayList<>(storage.values());
  }

  public static Task get(int id) {
    if (storage.containsKey(id)) {
      return storage.get(id);
    }
    return null;
  }

  public static int addTask(Task task) {
    task.setId(index);
    storage.put(index, task);
    return index++;
  }

  public static boolean deleteTask(int id) {

    return storage.remove(id, storage.get(id));
  }


}
