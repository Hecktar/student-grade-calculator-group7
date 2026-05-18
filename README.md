# Student Grade Calculator – DevOps Practical Assessment

## Project Overview

The Student Grade Calculator is a Java-based web application developed for the ASSDX4A DevOps Practical Assessment. The system is designed to calculate students’ final academic results according to the official VUT grading policy. Users enter semester and examination marks through a web interface, and the application processes the data to determine the final mark, grade classification, admission eligibility, and supplementary qualification status.

The main purpose of this project is not only to develop and maintain a functional academic grading application, but also to demonstrate practical implementation of modern DevOps principles and CI/CD practices. The project integrates version control, automated testing, continuous integration, continuous delivery, containerisation, and cloud deployment technologies into a complete software delivery pipeline.

The application is built using Java Servlets, JSP, Maven, and Apache Tomcat. The project repository is managed using Git and GitHub, while automation pipelines are implemented using GitHub Actions and Jenkins. Docker is used to containerise the application, and deployment is performed through Render.com using automated deployment hooks.

In addition to the DevOps implementation, the project also involves software testing and maintenance. The provided application contains intentional logic bugs within the grading calculations. These issues are identified through automated JUnit testing and resolved incrementally using collaborative Git workflows and pull request reviews.

---

# Project Objectives

The objectives of this project are to demonstrate practical understanding and implementation of DevOps tools, workflows, and software engineering best practices. The project focuses on automation, collaboration, testing, deployment, and continuous improvement throughout the software development lifecycle.

The main objectives include:

- Implementing version control using Git and GitHub
- Managing collaborative development using feature branches and pull requests
- Configuring Continuous Integration (CI) pipelines using GitHub Actions
- Creating Jenkins pipelines for automated build and testing processes
- Performing automated testing using Maven and JUnit
- Detecting and fixing logic errors within the application
- Implementing Continuous Delivery and Continuous Deployment (CD)
- Containerising the application using Docker
- Deploying the application online using Render.com
- Demonstrating real-world DevOps workflows and practices

---

# Technologies Used

| Technology | Purpose |
|---|---|
| Java 11 | Backend application development |
| Maven | Build automation and dependency management |
| JSP & Servlets | Dynamic web application development |
| Apache Tomcat 9 | Web server and servlet container |
| JUnit | Automated unit testing |
| Git | Version control |
| GitHub | Source code hosting and collaboration |
| GitHub Actions | Continuous Integration and Continuous Deployment |
| Jenkins | CI/CD pipeline automation |
| Docker | Application containerisation |
| Render.com | Cloud hosting and deployment platform |

---

# Project Structure

The project follows a standard Maven web application structure. The repository contains application source code, test files, web resources, and DevOps configuration files.

```text
student-grade-calculator/
├── pom.xml
├── Jenkinsfile
├── Dockerfile
├── README.md
├── DEPLOYMENT.md
├── .github/
│   └── workflows/
│       ├── ci.yml
│       └── deploy.yml
└── src/
    ├── main/
    │   ├── java/com/vut/calculator/
    │   │   ├── GradeCalculator.java
    │   │   └── GradeServlet.java
    │   └── webapp/
    │       ├── index.jsp
    │       ├── result.jsp
    │       └── WEB-INF/web.xml
    └── test/
        └── java/com/vut/calculator/
            └── GradeCalculatorTest.java
```

### File Descriptions

| File / Folder | Description |
|---|---|
| pom.xml | Maven configuration file containing dependencies and build settings |
| Jenkinsfile | Jenkins pipeline definition for CI/CD automation |
| Dockerfile | Docker configuration used to containerise the application |
| ci.yml | GitHub Actions workflow for Continuous Integration |
| deploy.yml | GitHub Actions workflow for automated deployment |
| GradeCalculator.java | Core business logic for grade calculations |
| GradeServlet.java | Servlet controller handling user requests |
| index.jsp | Main user interface page |
| result.jsp | Displays calculated student results |
| web.xml | Web application deployment descriptor |
| GradeCalculatorTest.java | Unit tests used for identifying and fixing bugs |

---

# Team Members and Roles

The project is completed collaboratively by a group of five members. Each member is assigned a primary role to ensure efficient project management and responsibility distribution.

| Name | Role | Responsibilities |
|---|---|---|
|TEFO MONYETSANE | Project Coordinator | Manages team tasks, tracks project progress, coordinates communication, and ensures all assessment requirements are completed|
| MARUPENG MAKGATO | Git Lead | Repository management, branch protection, pull requests, README maintenance |
| THANDOLWETHU SGALELANA| CI Engineer | Jenkins setup, GitHub Actions configuration, pipeline automation |
| SANELISIWE MAHLANGU | QA / Tester | Unit testing, bug identification, bug verification and reporting |
| ONALENNA | Deployment Lead | Docker configuration, Render deployment, deployment workflow management |

Although responsibilities are divided, all members are expected to understand the complete CI/CD pipeline and contribute collaboratively to the project.

---

# Business Rules

The application follows the official VUT grading policy rules when calculating student academic results.

| Rule | Description |
|---|---|
| Final Mark Formula | (Semester Mark × 0.4) + (Exam Mark × 0.6) |
| Exam Admission Requirement | Semester mark must be greater than or equal to 40 |
| Distinction Classification | Final mark between 80 and 100 |
| Merit Classification | Final mark between 70 and 79 |
| Credit Classification | Final mark between 60 and 69 |
| Pass Classification | Final mark between 50 and 59 |
| Fail Classification | Final mark below 50 |
| Supplementary Eligibility | Final mark between 45 and 49 |
| Valid Mark Range | All marks must be between 0 and 100 |

These rules are validated through automated unit tests to ensure correct grading logic throughout the application.

---

# Git Workflow and Collaboration Strategy

The project uses GitHub for version control and collaborative development. A feature-branch workflow is implemented to ensure safe development practices and controlled code integration.

## Branch Strategy

```text
main
├── feature/github-actions
├── feature/jenkins
├── feature/docker
├── feature/testing
├── bugfix/grade-formula
├── bugfix/grade-boundaries
└── bugfix/admission-rules
```

## Workflow Process

1. A team member creates a feature or bug-fix branch from `main`
2. Changes are implemented locally
3. Code changes are committed with meaningful commit messages
4. The branch is pushed to GitHub
5. A Pull Request is created
6. Team members review the changes
7. CI pipelines automatically run tests and builds
8. Approved changes are merged into `main`

Branch protection rules are enabled to prevent direct pushes to the main branch and enforce pull request reviews.

---

# Continuous Integration – GitHub Actions

GitHub Actions is used to automate the Continuous Integration process. Whenever code is pushed to the repository or a pull request is created, GitHub Actions automatically executes the CI workflow.

The CI pipeline performs the following tasks:

- Checks out the repository source code
- Configures Java 11 environment
- Installs Maven dependencies
- Builds the Maven project
- Executes all JUnit tests
- Detects build or test failures
- Prevents broken code from being merged into the main branch

### Workflow File

```text
.github/workflows/ci.yml
```

The automated CI workflow improves software quality, reduces manual testing effort, and ensures early bug detection.

---

# Jenkins Pipeline

Jenkins is used as an additional CI/CD automation tool to demonstrate enterprise-level DevOps practices. A Jenkins declarative pipeline is implemented using a Jenkinsfile stored within the repository.

The Jenkins pipeline performs the following stages:

- Source code checkout from GitHub
- Maven dependency installation
- Application build process
- Automated JUnit test execution
- Generation of build artifacts
- Archiving of WAR deployment files

### Jenkinsfile

```text
Jenkinsfile
```

Jenkins provides an alternative CI/CD solution that complements GitHub Actions and demonstrates understanding of multiple automation platforms.

---

# Automated Testing and Bug Fixing

The provided application intentionally contains multiple logic bugs within the `GradeCalculator.java` file. These bugs affect grade calculations, grade classifications, admission rules, and supplementary eligibility checks.

JUnit automated testing is used to identify these issues systematically. Some test methods were incomplete and required additional implementation by the development team.

The bug fixing process followed these steps:

1. Execute failing tests using Maven
2. Identify the failing logic within the application
3. Create a dedicated bug-fix branch
4. Correct the logic error
5. Commit and push the fix
6. Verify all tests pass successfully
7. Merge changes through pull requests

### Examples of Bugs Fixed

- Incorrect weighting formula
- Wrong grade boundaries
- Invalid supplementary conditions
- Incorrect fail classification
- Inverted admission logic
- Incorrect mark validation conditions

Automated testing ensures that future code changes do not reintroduce previously fixed issues.

---

# Docker Containerisation

The application is containerised using Docker to ensure portability, consistency, and simplified deployment across environments.

The Docker container includes:

- Apache Tomcat 9
- Java 11 runtime
- The packaged WAR application

The Dockerfile configures the container environment and copies the application WAR file into the Tomcat webapps directory.

### Dockerfile

```text
Dockerfile
```

### Build Docker Image

```bash
docker build -t student-grade-calculator .
```

### Run Docker Container

```bash
docker run -p 8080:8080 student-grade-calculator
```

Containerisation ensures that the application runs consistently regardless of the host operating system or environment configuration.

---

# Deployment – Render.com

The application is deployed to the internet using [Render.com](https://render.com) cloud hosting.

A deployment pipeline uses GitHub Actions and a Render **deploy hook**. After the CI workflow passes on `main`, the **Deploy to Render** workflow calls the hook; Render rebuilds the Docker image and redeploys. **Auto-Deploy is disabled** on Render so only the pipeline triggers production deploys.

See [DEPLOYMENT.md](DEPLOYMENT.md) for setup steps (deploy hook secret, Render settings, troubleshooting).

## Deployment Process

1. Developer pushes changes to `main`
2. **CI Pipeline** workflow runs `mvn clean package` and `mvn test`
3. On success, **Deploy to Render** workflow runs automatically
4. GitHub Actions `POST`s the Render deploy hook URL
5. Render rebuilds and redeploys the Docker container
6. The updated application is available at the live URL

### Live Application URL

```text
https://student-grade-calculator-group7-lyrg.onrender.com
```

Render deployment demonstrates practical implementation of Continuous Deployment principles.

---

# Running the Project Locally

## Prerequisites

The following software must be installed:

- Java JDK 11
- Apache Maven
- Git
- Docker Desktop (optional)

## Clone the Repository

```bash
git clone https://github.com/Hecktar/student-grade-calculator-group7.git
```

## Navigate into the Project

```bash
cd student-grade-calculator
```

## Build the Application

```bash
mvn clean package
```

## Run Unit Tests

```bash
mvn test
```

## Run with Docker

```bash
docker build -t student-grade-calculator .
docker run -p 8080:8080 student-grade-calculator
```

---

# CI/CD Pipeline Overview

The following workflow demonstrates the automated DevOps pipeline implemented in this project:

```text
Developer Push
       ↓
GitHub Repository
       ↓
GitHub Actions CI
(Build + Test)
       ↓
Jenkins Pipeline
       ↓
Docker Build
       ↓
Render Deployment
       ↓
Live Application
```

This pipeline automates software integration, testing, packaging, and deployment processes.

---

# Screenshots and Evidence

The following screenshots should be included in the final report:

- GitHub repository overview
- Collaborator configuration
- Branch protection rules
- Pull requests and merges
- GitHub Actions workflow runs
- Jenkins pipeline execution
- Docker image build process
- Docker container execution
- Render deployment dashboard
- Live application interface

These screenshots provide evidence of successful implementation of the DevOps pipeline.

---

# Assessment Requirements Covered

This project successfully demonstrates all required assessment outcomes, including:

- Version Control using Git and GitHub
- Team Collaboration using feature branches
- Continuous Integration pipelines
- Continuous Delivery and Deployment
- Automated Testing with JUnit
- Jenkins CI/CD implementation
- Docker containerisation
- Cloud deployment using Render.com
- Bug identification and correction
- Software delivery automation

---

# Conclusion

This project demonstrates the successful implementation of modern DevOps practices within a Java web application environment. Through the integration of GitHub, Jenkins, Docker, GitHub Actions, Maven, and Render.com, the project achieves a complete CI/CD pipeline capable of automated building, testing, containerisation, and deployment.

The assessment also highlights the importance of collaborative development, automated testing, version control, and deployment automation in modern software engineering environments. By identifying and fixing intentional logic bugs using structured testing approaches, the project further demonstrates the value of quality assurance within DevOps workflows.

Overall, the Student Grade Calculator project provides practical experience with industry-standard DevOps tools and methodologies while reinforcing collaborative software development principles.

---

# License

This project is developed for academic purposes as part of the ASSDX4A DevOps module.
