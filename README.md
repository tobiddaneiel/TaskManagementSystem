# Task Management System

A simple **Java-based Task Management System** that allows users to register, log in, and manage their personal tasks. Built using object-oriented design principles and equipped with basic Selenium UI testing and UML modeling.

---

## Features

### User Management
- Register new users
- Log in with existing credentials
- Secure access to task features

### Task Management
- Create, view, update, and delete tasks
- Task attributes: ID, Title, Description, Status
- Tasks are stored per user

### Data Handling
- Data is stored in memory (expandable to file-based persistence)

### Testing
- Selenium UI testing for simulating user interaction (future web/JavaFX support)

### UML Design
- UML Class and Use Case Diagrams included (created using draw.io)

---

## Project Structure

```
src/
├── Main.java
├── model/
│   ├── Task.java
│   └── User.java
├── manager/
│   └── TaskManager.java
└── test/
    └── TaskManagerUITest.java
```

---

## Requirements

- Java 17+ (or 11+ depending on your setup)
- IntelliJ IDEA or another Java IDE
- Selenium Java bindings
- ChromeDriver or appropriate browser driver

---

## Getting Started

### Installation
1. Clone the repo:
   ```bash
   git clone https://github.com/tobiddaneiel/TaskManagementSystem.git
   cd task-management-system
   ```

2. Open the project in IntelliJ.

3. Add Selenium library to your classpath or through Maven:
   ```xml
   <!-- in pom.xml -->
   <dependency>
     <groupId>org.seleniumhq.selenium</groupId>
     <artifactId>selenium-java</artifactId>
     <version>4.20.0</version>
   </dependency>
   ```

---

## 🧪 Running Tests with Selenium

1. Download and configure `chromedriver` for your system.

2. Run the test class:
   ```java
   TaskManagerUITest.java
   ```

> Note: Selenium is used for future UI support (JavaFX or web).

---

## 📊 UML Diagrams

- **Class Diagram**: Shows relationship between `User`, `Task`, and `TaskManager`.
- **Use Case Diagram**: Outlines user interaction with system features.

All diagrams are located in the `/diagrams` folder.

---

## 🔮 Future Enhancements

- File-based persistence
- Priority/Deadline features for tasks
- JavaFX GUI or Web-based interface
- Advanced search/filter
- User roles (admin/user)

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## ✍️ Author

Created by Oluwatobi Olowookere for academic and portfolio purposes.
