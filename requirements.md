# Project Requirements: Task Management System

## Functional Requirements

These describe what the system should do — the actual features a user interacts with.

### User Management

The system should allow a new user to register with a username and password.

The system should allow existing users to log in.

Users must be authenticated before they can access the task features.

### Task Management

Users can create new tasks.

Each task must have:

A unique ID

A title

A description

A status (e.g., Pending, In Progress, Completed)

Users can update the title, description, or status of a task.

Users can delete tasks.

Users can view a list of all their tasks.

### Data Persistence

The system should store user and task data in memory (for now, no database).

Optional: Persist to a file or use a simple database later.

### Error Handling

The system should handle invalid inputs gracefully.

Login should fail if credentials are incorrect.

Creating or updating tasks with missing required fields should not be allowed.

## Non-Functional Requirements

These describe how the system behaves, rather than what it does.

The system must be developed using Java.

Code should follow Object-Oriented Programming principles.

The system must be testable (Selenium tests required for core logic and interaction).

The system must be documented with comments and UML diagrams.

The code should be hosted on GitHub using version control (Git).

## Optional Stretch Features

Use a file-based system to store and retrieve task/user data.

Add a deadline or priority to tasks.

Build a basic UI (Swing or JavaFX).

Enable search or filter functionality.