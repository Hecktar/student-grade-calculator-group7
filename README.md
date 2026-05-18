# VUT Student Grade Calculator

## ASSDX4A DevOps Practical Assessment – Semester 1, 2026

This is a Java web application that calculates student grades based on semester marks and exam marks. It is built with **Maven** and runs on **Apache Tomcat**.

### ⚠️ Important Notice

This application contains **intentional logic errors**. Your task is NOT to write code from scratch, but to:

1. Set up a complete CI/CD pipeline to build, test, and deploy this application.
2. Use the provided unit tests to identify the bugs.
3. Fix the logic errors so all tests pass.
4. Deploy the working application.

### Project Structure

```
student-grade-calculator/
├── pom.xml                          # Maven build file
├── src/
│   ├── main/
│   │   ├── java/com/vut/calculator/
│   │   │   ├── GradeCalculator.java     # ← CONTAINS BUGS
│   │   │   └── GradeServlet.java        # Web servlet
│   │   └── webapp/
│   │       ├── index.jsp                # Input form
│   │       ├── result.jsp               # Result display
│   │       └── WEB-INF/web.xml
│   └── test/
│       └── java/com/vut/calculator/
│           └── GradeCalculatorTest.java # ← Unit tests (some TODO)
```

### Your Tasks (NOT provided — you must create these)

- **Jenkinsfile** — Define your CI/CD pipeline stages
- **Dockerfile** — Containerize the application for deployment
- **.github/workflows/*.yml** — GitHub Actions workflow for automated CI

---

# Team Members and Roles

The project is completed collaboratively by a group of five members. Each member is assigned a primary role to ensure efficient project management and responsibility distribution.

| Name | Role | Responsibilities |
|---|---|---|
|TEFO MONYETSANE | Project Coordinator | Manages team tasks, tracks project progress, coordinates communication, and ensures all assessment requirements are completed|
| MARUPENG MAKGATO | Git Lead | Repository management, branch protection, pull requests, README maintenance |
| THANDOLWETHU SGALELANA| CI Engineer | Jenkins setup, GitHub Actions configuration, pipeline automation |
| SANELISIWE MAHLANGU | QA / Tester | Unit testing, bug identification, bug verification and reporting |
| SEJA ONALENNA HAMESE | Deployment Lead | Docker configuration, Render deployment, deployment workflow management |

Although responsibilities are divided, all members are expected to understand the complete CI/CD pipeline and contribute collaboratively to the project.

---

# Business Rules

The application follows the official VUT grading policy rules when calculating student academic results.

| Rule | Description |
|------|-------------|
| Final Mark | (Semester Mark × 0.4) + (Exam Mark × 0.6) |
| Exam Admission | Semester Mark ≥ 40 |
| Distinction | Final Mark 80–100 |
| Merit | Final Mark 70–79 |
| Credit | Final Mark 60–69 |
| Pass | Final Mark 50–59 |
| Fail | Final Mark 0–49 |
| Supplementary | Final Mark 45–49 |

### Building Locally

```bash
mvn clean package
```

### Running with Docker (once you create your Dockerfile)

```bash
mvn clean package
docker build -t grade-calculator .
docker run -p 8080:8080 grade-calculator
```

Then visit: http://localhost:8080

### Deploying to Render.com (once your Dockerfile is working locally)

1. Push your working Dockerfile to GitHub
2. Sign up at https://render.com (free, no credit card)
3. Create a **New → Web Service**, connect your GitHub repo
4. Select the **Free** instance type
5. Render detects your Dockerfile, builds, and deploys automatically
6. Your app will be live at `https://your-app-name.onrender.com`
