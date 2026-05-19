# Team Step-by-Step Guide — Group 7

Complete these steps in order. One person with **Git Lead** access should push branches; everyone else can follow along.

---

## Phase 1 — Push code (Git Lead: Marupeng)

### Step 1.1 — Review local changes

```powershell
cd C:\Users\onaha\OneDrive\Documents\GitHub\student-grade-calculator-group7
git status
mvn test
```

You should see **37 tests, 0 failures**.

### Step 1.2 — Push all branches

```powershell
git push -u origin main
git push -u origin feature/github-actions
git push -u origin feature/jenkins
git push -u origin feature/testing
git push -u origin bugfix/grade-formula
git push -u origin bugfix/grade-boundaries
git push -u origin bugfix/admission-rules
```

If `main` is protected, open PRs instead (Phase 2).

---

## Phase 2 — Pull requests (Git Lead)

Merge in this order (so CI tells a clear story):

| Order | Branch | Into | Owner |
|-------|--------|------|-------|
| 1 | `feature/github-actions` | `main` | Thandolwethu (CI) |
| 2 | `feature/testing` | `main` | Sanelisiwe (QA) — expect failing CI |
| 3 | `bugfix/grade-formula` | `main` | Sanelisiwe |
| 4 | `bugfix/grade-boundaries` | `main` | Sanelisiwe |
| 5 | `bugfix/admission-rules` | `main` | Sanelisiwe |
| 6 | `feature/jenkins` | `main` | Thandolwethu |

`feature/docker` is already merged (`feature/docker-render-deployment` PR #1–#2).

On GitHub: **Pull requests → New pull request** → choose base `main` and compare branch → **Create pull request** → after review, **Merge**.

---

## Phase 3 — GitHub repository settings (Git Lead)

### Step 3.1 — Add lecturer as collaborator

1. GitHub repo → **Settings** → **Collaborators** → **Add people**
2. Add your lecturer’s GitHub username
3. Screenshot for the written report

### Step 3.2 — Branch protection on `main`

1. **Settings** → **Branches** → **Add branch protection rule**
2. Branch name: `main`
3. Enable: **Require a pull request before merging**
4. Enable: **Require status checks to pass** → select **CI Pipeline**
5. Save → screenshot for report

### Step 3.3 — Render deploy hook secret (Deployment Lead: Seja)

1. Render → **student-grade-calculator-group7** → **Settings** → **Deploy Hook** → copy URL
2. GitHub → **Settings** → **Secrets and variables** → **Actions** → **New repository secret**
3. Name: `RENDER_DEPLOY_HOOK_URL`, value: paste hook URL
4. Confirm Render **Auto-Deploy** is **Off** (see [DEPLOYMENT.md](DEPLOYMENT.md))

---

## Phase 4 — Verify GitHub Actions (CI Engineer: Thandolwethu)

### Step 4.1 — Watch CI on a PR

1. Open any open PR → **Checks** tab
2. Confirm **CI Pipeline** runs `mvn clean package` and `mvn test`

### Step 4.2 — Verify deploy after merge to `main`

1. Merge final PRs to `main`
2. **Actions** → **CI Pipeline** → wait for green
3. **Actions** → **Deploy to Render** → should start automatically
4. Open https://student-grade-calculator-group7-lyrg.onrender.com and test a calculation

---

## Phase 5 — Jenkins (CI Engineer: Thandolwethu)

### Step 5.1 — Install tools in Jenkins

1. Open Jenkins → **Manage Jenkins** → **Tools**
2. **JDK** → Add **JDK11** (path to JDK 11 on the machine)
3. **Maven** → Add **Maven** (name must match `Jenkinsfile`: `Maven`)

### Step 5.2 — Create pipeline job

1. **New Item** → name: `student-grade-calculator-group7` → **Pipeline** → OK
2. **Pipeline** section:
   - Definition: **Pipeline script from SCM**
   - SCM: **Git**
   - Repository URL: `https://github.com/Hecktar/student-grade-calculator-group7.git`
   - Branch: `main`
   - Script Path: `Jenkinsfile`
3. **Save** → **Build Now**
4. Screenshot: blue build + test results + archived WAR

---

## Phase 6 — Docker local test (Deployment Lead: Seja)

```powershell
docker build -t student-grade-calculator .
docker run -p 8080:8080 student-grade-calculator
```

Open http://localhost:8080 — screenshot for report.

---

## Phase 7 — Written report & demo (Project Coordinator: Tefo)

Include in PDF/DOCX:

- [ ] Repo URL + collaborator screenshot
- [ ] Branch protection screenshot
- [ ] All PRs / merge history
- [ ] GitHub Actions CI green on `main`
- [ ] Deploy workflow + Render Events
- [ ] Jenkins pipeline screenshot
- [ ] Docker build/run screenshots
- [ ] Live app screenshot
- [ ] Full **BUG_REPORT.md** table
- [ ] Pipeline diagram (from README)

**Demo video (max 10 min):** push to `main` → CI → deploy → live app → show Jenkins run.

---

## Quick reference — who owns what

| Role | Name | Remaining actions |
|------|------|-------------------|
| Project Coordinator | Tefo | Report, demo, lecturer access check |
| Git Lead | Marupeng | Push branches, PRs, branch protection |
| CI Engineer | Thandolwethu | Jenkins install + job, CI screenshots |
| QA / Tester | Sanelisiwe | Confirm `mvn test` on `main`, BUG_REPORT in submission |
| Deployment Lead | Seja | Render secret, live URL test, Docker screenshots |

---

## Troubleshooting

| Problem | Fix |
|---------|-----|
| `mvn test` fails locally | `git pull origin main` and run again |
| CI fails on PR | Open Actions log; fix `GradeCalculator.java` or tests |
| Deploy workflow missing secret | Add `RENDER_DEPLOY_HOOK_URL` (Phase 3.3) |
| Jenkins `Maven` not found | Tool name in Jenkins must be exactly `Maven` |
| Render site shows old logic | Merge all bugfix PRs, push `main`, trigger deploy |
