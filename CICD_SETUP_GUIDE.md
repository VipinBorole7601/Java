# CI/CD Setup Guide - GitHub Actions

## GitHub Secrets

Settings → Secrets and variables → Actions

Add:
- BASE_URL = https://qa.example.com
- APP_USER = qa_user@example.com
- APP_PASSWORD = your_password

## Pipelines

### PR Validation
- Trigger: Every pull request
- Tests: Smoke suite
- Duration: ~10 minutes

### Nightly Regression
- Trigger: Daily 1 AM UTC
- Tests: Full regression
- Duration: ~30 minutes

---
Last Updated: 2026
