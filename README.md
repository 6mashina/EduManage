# EduManage
This project is an Education Management Application built with Spring Boot, Hibernate, and PostgreSQL. It allows you to manage teachers and courses, where each course is associated with a teacher.

## Dependencies

### 1. Java Development Kit (JDK)
- **Version:** 21
- **Installation:**
  - Windows: Download from [Oracle JDK Downloads](https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe)
  - macOS: Use Homebrew - `brew install openjdk@21`
  - Linux: Use package manager - `sudo apt install openjdk-21-jdk` (Debian/Ubuntu)

### 2. Spring Boot
- **Version:** 3.3.1
- **Dependency Management:** Spring Boot Starter Parent

### 3. Hibernate
- **Version:** 6.5.2.Final
- **Dependency Management:** Managed by Spring Boot

### 4. PostgreSQL
- **Version:** 16
- **Installation:**
  - Windows/macOS: Download from [PostgreSQL Downloads](https://www.postgresql.org/download/)
  - Linux: Use package manager - `sudo apt install postgresql` (Debian/Ubuntu)

### 5. Maven
- **Version:** 4.0.0 
- **Installation:**
  - Windows: Download from [Maven Downloads](https://maven.apache.org/download.cgi)
  - macOS: Use Homebrew - `brew install maven`
  - Linux: Use package manager - `sudo apt install maven` (Debian/Ubuntu)

## Project Setup

### 1. Clone the Repository
```bash
git clone https://github.com/your-repo/eduManage.git
cd eduManage

### 2. Configure PostgreSQL Database

```sql
CREATE DATABASE eduManageDB;

CREATE TABLE teacher (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100)
);

CREATE TABLE course (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    teacher_id INTEGER,
    CONSTRAINT fk_course_teacher
    FOREIGN KEY (teacher_id)
    REFERENCES Teachers (id)
    ON DELETE CASCADE
);

INSERT INTO teacher (first_name, last_name, email) VALUES ('John', 'Doe', 'john.doe@example.com');
INSERT INTO teacher (first_name, last_name, email) VALUES ('Jane', 'Smith', 'jane.smith@example.com');
INSERT INTO teacher (first_name, last_name, email) VALUES ('Alice', 'Johnson', 'alice.johnson@example.com');
INSERT INTO teacher (first_name, last_name, email) VALUES ('Bob', 'Brown', 'bob.brown@example.com');
INSERT INTO teacher (first_name, last_name, email) VALUES ('Charlie', 'Davis', 'charlie.davis@example.com');

INSERT INTO course (name, description, teacher_id) VALUES ('Math 101', 'Basic Math Course', 1);
INSERT INTO course (name, description, teacher_id) VALUES ('English Literature', 'Introduction to English Literature', 2);
INSERT INTO course (name, description, teacher_id) VALUES ('Physics 201', 'Advanced Physics', 3);
INSERT INTO course (name, description, teacher_id) VALUES ('Chemistry 101', 'Basic Chemistry', 4);
INSERT INTO course (name, description, teacher_id) VALUES ('Biology 101', 'Introduction to Biology', 5);

### 3. Update the src/main/resources/application.properties file

### 4. Build the Project

```bash
mvn clean install

### 5. Run the app

```bash
mvn spring-boot:run
