# Playwright Framework - Industrial Standard README

A production-ready Playwright test automation framework template using TypeScript, Page Object Model, reusable fixtures, deterministic test data strategy, multi-environment execution, CI-ready reporting, and scalable test organization.

## Table of Contents

1. [Overview](#overview)
2. [Technology Stack](#technology-stack)
3. [Recommended Folder Structure](#recommended-folder-structure)
4. [Prerequisites](#prerequisites)
5. [Quick Start](#quick-start)
6. [Environment Configuration](#environment-configuration)
7. [Running Tests](#running-tests)
8. [Execution Strategy (Parallel, Sharding, Retries)](#execution-strategy-parallel-sharding-retries)
9. [Framework Design Standards](#framework-design-standards)
10. [Page Object Model Standards](#page-object-model-standards)
11. [Selectors and Stability Standards](#selectors-and-stability-standards)
12. [Test Data Strategy](#test-data-strategy)
13. [Authentication Strategy](#authentication-strategy)
14. [API + UI Hybrid Testing](#api--ui-hybrid-testing)
15. [Reporting, Artifacts, and Debugging](#reporting-artifacts-and-debugging)
16. [CI/CD Integration](#cicd-integration)
17. [Quality Gates](#quality-gates)
18. [Security and Compliance](#security-and-compliance)
19. [Common Commands](#common-commands)
20. [Troubleshooting](#troubleshooting)

---

## Overview

This framework is designed for enterprise-scale QA automation with:

- clear architecture and ownership boundaries
- stable and maintainable selector strategy
- support for smoke, regression, and release validation
- rich evidence capture (trace, video, screenshot, logs)
- consistent local and CI execution behavior

It prioritizes reliability, debuggability, and predictable execution over quick but brittle automation.

## Technology Stack

- **Language:** TypeScript (strict mode)
- **Test Runner:** Playwright Test
- **Pattern:** Page Object Model + Fixtures + Utility Layer
- **Reporting:** HTML + JUnit + optional Allure
- **CI:** GitHub Actions / Azure DevOps / Jenkins
- **Quality:** ESLint + Prettier + TypeScript checks

## Recommended Folder Structure

```text
playwright-framework/
  playwright.config.ts
  package.json
  tsconfig.json
  .env
  .env.qa
  .env.uat
  .env.prod
  src/
    pages/
      login.page.ts
      dashboard.page.ts
    components/
      navbar.component.ts
    fixtures/
      test-fixtures.ts
    data/
      users.json
    api/
      auth.api.ts
    utils/
      env.ts
      logger.ts
      random.ts
      wait.ts
  tests/
    smoke/
      login.smoke.spec.ts
    regression/
      checkout.regression.spec.ts
    api/
      auth.api.spec.ts
  auth/
    storageState.json
  test-results/
  playwright-report/
```

## Prerequisites

- Node.js 20+
- npm 10+ (or pnpm/yarn)
- Playwright-supported browsers
- Access to test environments and credentials through secrets manager

## Quick Start

```bash
npm init -y
npm i -D @playwright/test typescript ts-node @types/node dotenv
npx playwright install --with-deps
npx playwright test --init
```

Add scripts to `package.json`:

```json
{
  "scripts": {
    "test": "playwright test",
    "test:headed": "playwright test --headed",
    "test:ui": "playwright test --ui",
    "test:debug": "playwright test --debug",
    "test:smoke": "playwright test tests/smoke",
    "test:regression": "playwright test tests/regression",
    "test:chrome": "playwright test --project=chromium",
    "test:firefox": "playwright test --project=firefox",
    "test:webkit": "playwright test --project=webkit",
    "report": "playwright show-report",
    "lint": "eslint .",
    "typecheck": "tsc --noEmit"
  }
}
```

## Environment Configuration

Use environment-specific `.env` files and never hardcode sensitive values.

Example `.env.qa`:

```env
BASE_URL=https://qa.example.com
API_BASE_URL=https://qa-api.example.com
USER_EMAIL=qa_user@example.com
USER_PASSWORD=replace-from-secret-store
```

Load by environment key:

```ts
// src/utils/env.ts
import dotenv from "dotenv";

dotenv.config({ path: `.env.${process.env.TEST_ENV || "qa"}` });

export const env = {
  baseUrl: process.env.BASE_URL || "",
  apiBaseUrl: process.env.API_BASE_URL || "",
  userEmail: process.env.USER_EMAIL || "",
  userPassword: process.env.USER_PASSWORD || ""
};
```

## Running Tests

```bash
# Full suite
npm test

# Specific file
npx playwright test tests/smoke/login.smoke.spec.ts

# Specific test title
npx playwright test -g "valid user can login"

# Specific browser
npx playwright test --project=chromium

# Headed mode
npm run test:headed
```

## Execution Strategy (Parallel, Sharding, Retries)

Enterprise baseline:

- `fullyParallel: false` for better isolation control
- controlled `workers` in CI (for example 2-4)
- retries enabled only in CI
- shard larger regression suites for faster pipelines

`playwright.config.ts` example:

```ts
import { defineConfig, devices } from "@playwright/test";

export default defineConfig({
  testDir: "./tests",
  timeout: 60_000,
  expect: { timeout: 10_000 },
  fullyParallel: false,
  forbidOnly: !!process.env.CI,
  retries: process.env.CI ? 2 : 0,
  workers: process.env.CI ? 3 : undefined,
  reporter: [
    ["list"],
    ["html", { open: "never" }],
    ["junit", { outputFile: "test-results/junit.xml" }]
  ],
  use: {
    baseURL: process.env.BASE_URL,
    trace: "on-first-retry",
    screenshot: "only-on-failure",
    video: "retain-on-failure",
    actionTimeout: 15_000,
    navigationTimeout: 30_000
  },
  projects: [
    { name: "chromium", use: { ...devices["Desktop Chrome"] } },
    { name: "firefox", use: { ...devices["Desktop Firefox"] } },
    { name: "webkit", use: { ...devices["Desktop Safari"] } }
  ]
});
```

## Framework Design Standards

1. Keep tests intent-focused (business flow), not implementation-heavy.
2. Keep page-specific behavior in page objects only.
3. Keep assertions in tests unless assertion is reusable and business-meaningful.
4. Avoid cross-test dependency; each test should be independently executable.
5. Use deterministic test data and teardown strategy.
6. Tag tests consistently (`@smoke`, `@regression`, `@critical`).

## Page Object Model Standards

Minimal POM example:

```ts
// src/pages/login.page.ts
import { Page, expect } from "@playwright/test";

export class LoginPage {
  constructor(private readonly page: Page) {}

  private email = this.page.getByTestId("login-email");
  private password = this.page.getByTestId("login-password");
  private submit = this.page.getByTestId("login-submit");
  private header = this.page.getByRole("heading", { name: "Dashboard" });

  async goto() {
    await this.page.goto("/login");
  }

  async login(email: string, password: string) {
    await this.email.fill(email);
    await this.password.fill(password);
    await this.submit.click();
  }

  async assertUserIsLoggedIn() {
    await expect(this.header).toBeVisible();
  }
}
```

## Selectors and Stability Standards

Selector priority:

1. `getByTestId()` (preferred for stability)
2. `getByRole()` with accessible name
3. semantic locators (`getByLabel`, `getByPlaceholder`)
4. CSS selectors
5. XPath (last resort)

Rules:

- avoid brittle nth-child chains
- avoid text-only selectors for dynamic content
- ask developers to add stable `data-testid` hooks where needed

## Test Data Strategy

- keep static datasets in `src/data`
- generate unique runtime data for create/update flows
- isolate data by test run id where possible
- clean up via API when feasible

Simple utility:

```ts
export const uniqueEmail = (prefix = "qa") =>
  `${prefix}_${Date.now()}_${Math.floor(Math.random() * 10000)}@example.com`;
```

## Authentication Strategy

Use `storageState` for authenticated scenarios to reduce repetitive UI login.

Pattern:

1. run one setup test to authenticate
2. save `auth/storageState.json`
3. reuse in protected tests

## API + UI Hybrid Testing

Use API for setup/teardown and UI for behavioral validation.

Benefits:

- faster execution
- lower flakiness
- cleaner test isolation

## Reporting, Artifacts, and Debugging

Default artifacts:

- Playwright HTML report
- JUnit XML for CI
- trace on retry
- screenshot/video on failure

Debug tools:

```bash
npx playwright test --debug
npx playwright test --ui
npx playwright show-trace test-results/<trace-file>.zip
```

## CI/CD Integration

GitHub Actions example:

```yaml
name: Playwright Tests
on:
  push:
  pull_request:

jobs:
  e2e:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-node@v4
        with:
          node-version: 20
      - run: npm ci
      - run: npx playwright install --with-deps
      - run: npx playwright test
        env:
          TEST_ENV: qa
          BASE_URL: ${{ secrets.BASE_URL }}
          USER_EMAIL: ${{ secrets.USER_EMAIL }}
          USER_PASSWORD: ${{ secrets.USER_PASSWORD }}
      - uses: actions/upload-artifact@v4
        if: always()
        with:
          name: playwright-report
          path: |
            playwright-report
            test-results
```

## Quality Gates

Recommended PR checks:

1. lint pass
2. typecheck pass
3. smoke suite pass
4. no `.only` tests
5. artifacts attached for failures

## Security and Compliance

- keep credentials in secret manager/CI secrets
- mask sensitive logs
- never commit `.env` with real secrets
- sanitize PII in screenshots and logs when required

## Common Commands

```bash
npx playwright test
npx playwright test --project=chromium
npx playwright test --grep @smoke
npx playwright test --shard=1/3
npx playwright test --workers=4
npx playwright test --retries=2
npx playwright test tests\regression\checkout.regression.spec.ts
npx playwright show-report
```

## Troubleshooting

**Issue:** flaky timing failures  
**Fix:** replace hard waits with robust locators and Playwright assertions.

**Issue:** test passes locally, fails in CI  
**Fix:** align browser version, env config, and resource limits; keep retries only in CI.

**Issue:** element not found  
**Fix:** validate selector strategy, route readiness, and iframe/shadow-dom context.

---

For quick commands/snippets, use the companion file: **`README_CHEATSHEET.md`**.
