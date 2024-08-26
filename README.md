# TaskManagementSystem
This describes a system which enables a user to add new tasks, update existing tasks, delete tasks, and to view all tasks.

#  Requirements
## Functional Requirements
These are the core features and functionalities that the application must provide:
### Task Management Operations
Add Task: Users should be able to add a new task with the following details:
-Task ID (unique identifier)
-Task name
-Task description
-Task status (e.g., Pending, In Progress, Completed)

Update Task: Users should be able to update an existing task's details:
-Update the task name
-Update the task description
-Change the task status

Delete Task: Users should be able to delete a task by its ID.

View Tasks: Users should be able to view all tasks in the system. The view should include:
-Task ID
-Task name
-Task description
-Task status

Search Task (Optional): Users should be able to search for tasks by their ID or name (this can be an additional feature if time permits).

Sort Tasks (Optional): Users should be able to sort tasks based on different criteria like task name, task status, or creation date.

### User Interaction
-Command-Line Interface (CLI): The system should have a simple CLI that allows users to perform the above operations.
-A menu should be displayed to users with options to add, update, delete, view, search, and sort tasks.
-Users should be able to navigate through options using numeric or string inputs.
-Error Handling
-Validation: The system should validate user input:
-Ensure that task names and descriptions are not empty.
-Check for valid status values (e.g., only allow predefined status options).
-Prevent adding duplicate task IDs.
-Exception Handling: The system should handle exceptions gracefully (e.g., handling invalid inputs, non-existent task IDs for updates or deletions).

## Non-Functional Requirements
These define the quality attributes, performance, and other characteristics of the system:
Usability: The CLI should be user-friendly, with clear prompts and error messages.
Performance: The system should respond quickly to user inputs, with task operations (add, update, delete, view) completing in a timely manner.
Scalability: The initial implementation can manage a moderate number of tasks, but the design should allow for easy scaling if the number of tasks increases (e.g., by later integrating a database for storage).
Maintainability: The code should be modular, well-commented, and easy to maintain or extend.
Portability: The system should run on any machine with Java installed, ensuring platform independence.
Reliability: The system should handle incorrect inputs or exceptions without crashing, ensuring robust and reliable operation.

## Technical Requirements
These define the technical aspects needed to develop and run the project:
Programming Language: Java (Java SE 8 or higher).
Development Environment: Any IDE compatible with Java (e.g., IntelliJ IDEA, Eclipse, NetBeans).
Version Control: Git for version control, with a repository on GitHub.
Testing Framework: JUnit for writing unit tests to test the functionality of the application.
Java Collection Framework: Use ArrayList or HashMap for storing and managing tasks in memory.
Build Tools: Maven or Gradle (optional, for project management and dependency handling).
Optional Features (for future development)
Persistence: Storing tasks in a file (e.g., using Java's I/O classes) or a database for long-term storage.
User Authentication: Basic user login to restrict access to the task management system.
Priority Levels: Add priority levels to tasks and allow users to sort tasks by priority.
Notifications: Implement notification features (e.g., remind users of pending tasks).

## Conclusion
These requirements provide a comprehensive overview of what is needed to build a simple Task Management System using Java. The functional requirements outline what the system should do, non-functional requirements define how well it should perform these tasks, and technical requirements specify the tools and technologies to be used.
