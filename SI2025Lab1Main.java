import java.util.*;

enum Priority {
    LOW, MEDIUM, HIGH
}

class Task {
    private String name;
    private boolean isCompleted;
    private Priority priority;
    private String category;

    public Task(String name, Priority priority, String category) {
        this.name = name;
        this.priority = priority;
        this.category = category;
        this.isCompleted = false;
    }

    public void complete() {
        this.isCompleted = true;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " [" + category + "] - Priority: " + priority + (isCompleted ? " [Completed]" : " [Pending]");
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String name, Priority priority, String category) {
        tasks.add(new Task(name, priority, category));
    }

    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // MISSING FEATURES:

    // 1. Remove a task by name
    public void removeTask(String name) {
        // TODO: Implement removal logic
        tasks.removeIf(task -> task.getName().equalsIgnoreCase(name));
    }

    // 2. Find all completed tasks
    public List<Task> getCompletedTasks() {
        // TODO: Implement logic to return completed tasks
        List<Task> completed = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completed.add(task);
            }
        }
        return completed;
    }

    // 3. List tasks sorted by name
    public void sortTasksByName() {
        // TODO: Implement sorting logic
        tasks.sort(Comparator.comparing(Task::getName));
    }

    // 4. Sort tasks by priority
    public void sortTasksByPriority() {
        // TODO: Implement sorting by priority logic
        tasks.sort(Comparator.comparing(Task::getPriority).reversed());
    }

    // 5. Filter tasks by category
    public List<Task> filterByCategory(String category) {
        // TODO: Implement filtering logic
        List<Task> filtered = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getCategory().equalsIgnoreCase(category)) {
                filtered.add(task);
            }
        }
        return filtered;
    }

    // 6. Find the highest-priority unfinished task
    public List<Task> getMostUrgentTasks() {
        // TODO: Implement logic to find most urgent tasks
        Priority[] priorities = { Priority.HIGH, Priority.MEDIUM, Priority.LOW };
        for (Priority priority : priorities) {
            List<Task> result = new ArrayList<>();
            for (Task task : tasks) {
                if (!task.isCompleted() && task.getPriority() == priority) {
                    result.add(task);
                }
            }
            if (!result.isEmpty()) {
                return result;
            }
        }
        return new ArrayList<>();
    }

    // 7. Count tasks per category
    public Map<String, Integer> countTasksPerCategory() {
        // TODO: Implement counting logic
        Map<String, Integer> countMap = new HashMap<>();
        for (Task task : tasks) {
            countMap.put(task.getCategory(),
                    countMap.getOrDefault(task.getCategory(), 0) + 1);
        }
        return countMap;
    }

    // 8. Mark a task as completed by name
    public void markTaskCompleted(String name) {
        // TODO: Implement completion logic
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(name)) {
                task.complete();
                break;
            }
        }
    }

    // 9. Mark all tasks in a category as completed
    public void markCategoryCompleted(String category) {
        // TODO: Implement bulk completion logic
        for (Task task : tasks) {
            if (task.getCategory().equalsIgnoreCase(category)) {
                task.complete();
            }
        }
    }
}

public class SI2025Lab1Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask("Write report", Priority.HIGH, "Work");
        manager.addTask("Submit assignment", Priority.MEDIUM, "School");
        manager.addTask("Buy groceries", Priority.LOW, "Personal");

        // MISSING: Calls to the new methods that will be implemented
        System.out.println("\n=== All Tasks ===");
        manager.printTasks();

        System.out.println("\n=== Marking 'Buy groceries' as completed ===");
        manager.markTaskCompleted("Buy groceries");

        System.out.println("\n=== Completed Tasks ===");
        for (Task task : manager.getCompletedTasks()) {
            System.out.println(task);
        }

        System.out.println("\n=== Tasks Sorted by Name ===");
        manager.sortTasksByName();
        manager.printTasks();

        System.out.println("\n=== Tasks Sorted by Priority ===");
        manager.sortTasksByPriority();
        manager.printTasks();

        System.out.println("\n=== Tasks in 'Personal' Category ===");
        for (Task task : manager.filterByCategory("Personal")) {
            System.out.println(task);
        }

        System.out.println("\n=== Most Urgent Unfinished Tasks ===");
        for (Task task : manager.getMostUrgentTasks()) {
            System.out.println(task);
        }

        System.out.println("\n=== Task Count per Category ===");
        Map<String, Integer> countMap = manager.countTasksPerCategory();
        for (String category : countMap.keySet()) {
            System.out.println(category + ": " + countMap.get(category));
        }

        System.out.println("\n=== Marking all 'School' tasks completed ===");
        manager.markCategoryCompleted("School");

        System.out.println("\n=== Final Task List ===");

        manager.printTasks();
    }
}
