# Playwright Framework Cheat Sheet

Fast reference for day-to-day Playwright automation work.

## 1) Installation

```bash
npm init -y
npm i -D @playwright/test typescript ts-node @types/node
npx playwright install --with-deps
```

## 2) Most Used Commands

```bash
npx playwright test
npx playwright test --headed
npx playwright test --ui
npx playwright test --debug
npx playwright test --project=chromium
npx playwright test --grep @smoke
npx playwright test -g "login"
npx playwright test tests\smoke\login.smoke.spec.ts
npx playwright show-report
npx playwright show-trace test-results\<trace>.zip
```

## 3) Test Template

```ts
import { test, expect } from "@playwright/test";

test("user can login", async ({ page }) => {
  await page.goto("https://example.com/login");
  await page.getByTestId("login-email").fill("qa@example.com");
  await page.getByTestId("login-password").fill("Password@123");
  await page.getByTestId("login-submit").click();
  await expect(page.getByRole("heading", { name: "Dashboard" })).toBeVisible();
});
```

## 4) Locator Priority

1. `getByTestId()`
2. `getByRole()`
3. `getByLabel()`, `getByPlaceholder()`
4. CSS
5. XPath (last resort)

## 5) Core Actions

```ts
await page.click("[data-testid='save']");
await page.fill("[data-testid='email']", "a@b.com");
await page.press("[data-testid='search']", "Enter");
await page.check("[data-testid='terms']");
await page.uncheck("[data-testid='terms']");
await page.selectOption("[data-testid='country']", "IN");
await page.setInputFiles("[data-testid='upload']", "C:\\files\\doc.pdf");
```

## 6) Assertions

```ts
await expect(page).toHaveURL(/dashboard/);
await expect(page).toHaveTitle(/Dashboard/);
await expect(locator).toBeVisible();
await expect(locator).toBeHidden();
await expect(locator).toHaveText("Success");
await expect(locator).toContainText("Welcome");
await expect(locator).toHaveValue("admin");
await expect(locator).toBeEnabled();
await expect(locator).toBeDisabled();
```

## 7) Wait Patterns (Preferred)

```ts
await expect(page.getByTestId("status")).toHaveText("Completed");
await page.waitForURL("**/dashboard");
await page.waitForLoadState("networkidle");
```

Avoid:

```ts
await page.waitForTimeout(5000); // avoid unless strictly required
```

## 8) Frames, Tabs, Dialogs

```ts
const frame = page.frameLocator("iframe[title='payment']");
await frame.getByTestId("card-number").fill("4111111111111111");

const [newPage] = await Promise.all([
  page.waitForEvent("popup"),
  page.getByRole("link", { name: "Open details" }).click()
]);

page.on("dialog", async dialog => {
  await dialog.accept();
});
```

## 9) Network + API

```ts
await page.route("**/api/orders", async route => {
  await route.fulfill({ status: 200, body: JSON.stringify({ items: [] }) });
});

const response = await page.request.post("/api/login", {
  data: { email: "qa@example.com", password: "Password@123" }
});
expect(response.ok()).toBeTruthy();
```

## 10) File Download

```ts
const [download] = await Promise.all([
  page.waitForEvent("download"),
  page.getByTestId("download-report").click()
]);
await download.saveAs("test-results\\report.pdf");
```

## 11) Screenshot and Trace

```ts
await page.screenshot({ path: "test-results\\home.png", fullPage: true });
```

`playwright.config.ts` use block:

```ts
use: {
  trace: "on-first-retry",
  screenshot: "only-on-failure",
  video: "retain-on-failure"
}
```

## 12) Useful Config Snippet

```ts
import { defineConfig } from "@playwright/test";

export default defineConfig({
  retries: process.env.CI ? 2 : 0,
  workers: process.env.CI ? 3 : undefined,
  reporter: [["list"], ["html", { open: "never" }], ["junit", { outputFile: "test-results/junit.xml" }]],
  use: {
    baseURL: process.env.BASE_URL,
    actionTimeout: 15000,
    navigationTimeout: 30000,
    trace: "on-first-retry",
    screenshot: "only-on-failure"
  }
});
```

## 13) Tags / Grep

```ts
test("checkout flow @smoke @critical", async ({ page }) => {
  // ...
});
```

```bash
npx playwright test --grep @smoke
npx playwright test --grep "@smoke|@critical"
npx playwright test --grep-invert @wip
```

## 14) CI Essentials

```bash
npm ci
npx playwright install --with-deps
npx playwright test
```

Upload:

- `playwright-report`
- `test-results`

## 15) Golden Rules

1. Prefer stable `data-testid` selectors.
2. Keep assertions explicit and meaningful.
3. Keep each test independent.
4. Use API for setup/teardown where possible.
5. Keep retries in CI only, not for masking bad tests locally.
