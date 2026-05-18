# Deployment Guide (Render.com)

This document describes the deployment setup for the Student Grade Calculator, as required by the ASSDX4A practical assessment.

## Live application

**URL:** https://student-grade-calculator-group7-lyrg.onrender.com

**Render service name:** `student-grade-calculator-group7`

**GitHub repository:** https://github.com/Hecktar/student-grade-calculator-group7

---

## Architecture

1. Developer pushes to `main` (or merges a PR).
2. **CI Pipeline** workflow (`ci.yml`) runs `mvn clean package` and `mvn test`.
3. On success, **Deploy to Render** workflow (`deploy.yml`) runs automatically.
4. The workflow sends a `POST` request to the Render **deploy hook** URL.
5. Render rebuilds the Docker image and redeploys the service.

Auto-Deploy on Render must be **disabled** so deployments are controlled by GitHub Actions only.

---

## One-time Render setup

1. Sign in at https://dashboard.render.com
2. Open web service **student-grade-calculator-group7**
3. **Settings → Build & Deploy**
   - **Auto-Deploy:** `No` (disabled)
   - **Branch:** `main`
   - **Runtime:** Docker
   - **Dockerfile path:** `Dockerfile`
4. **Settings → Deploy Hook**
   - Click **Create Deploy Hook**
   - Copy the hook URL (keep it secret)

---

## One-time GitHub setup

1. Open https://github.com/Hecktar/student-grade-calculator-group7/settings/secrets/actions
2. **New repository secret**
   - **Name:** `RENDER_DEPLOY_HOOK_URL`
   - **Value:** paste the Render deploy hook URL from above
3. Save

---

## Verify the pipeline

### Option A — Manual deploy workflow

1. GitHub → **Actions** → **Deploy to Render** → **Run workflow** (branch: `main`)
2. Confirm the job succeeds
3. Render → **Events** → new deploy appears

### Option B — Full CI/CD path

1. Push a commit to `main`
2. Wait for **CI Pipeline** to finish successfully
3. **Deploy to Render** should start automatically
4. Confirm the app at the live URL

---

## Docker (local testing)

```bash
docker build -t student-grade-calculator .
docker run -p 8080:8080 student-grade-calculator
```

Open http://localhost:8080

The Dockerfile uses a multi-stage build: Maven builds the WAR, then Tomcat 9 serves it as `ROOT.war`. `JAVA_OPTS="-Xmx256m"` limits heap for Render’s free tier (512 MB RAM).

---

## Troubleshooting

| Problem | Fix |
|--------|-----|
| `Missing repository secret: RENDER_DEPLOY_HOOK_URL` | Add the secret in GitHub (see above) |
| Deploy workflow never runs after push | CI Pipeline must succeed on `main` first |
| Render clone error (exit 128) | **Settings → Git Credentials** → re-authorize GitHub |
| Site slow on first visit | Free tier spins down after ~15 min idle (~50 s cold start) |

---

## Demonstration talking points

- **Dockerfile:** Stage 1 compiles with Maven; stage 2 runs Tomcat with the WAR at `/`.
- **Deploy hook:** GitHub Actions calls Render’s hook with `curl`; Render pulls latest `main` and rebuilds.
- **Why Auto-Deploy is off:** Ensures deploy only happens through the CI/CD pipeline after tests pass.
