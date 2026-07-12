# Java + Playwright - Framework Architecture

## Design Layers

\\\
TEST LAYER → PAGE OBJECT LAYER → UTILITY LAYER → CORE LAYER → PLAYWRIGHT API
\\\

## Components

- **BrowserFactory** - Creates & manages browsers
- **BaseTest** - Test setup/teardown
- **BasePage** - Common page methods
- **Page Objects** - LoginPage, DashboardPage, etc
- **Utilities** - WaitUtils, ConfigUtils, RandomUtils

## Thread Safety

ThreadLocal ensures each thread has its own:
- Playwright instance
- Browser instance  
- Page instance

---
Last Updated: 2026
