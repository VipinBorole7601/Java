# Troubleshooting Guide

## Tests Pass Locally, Fail in CI

\\\ash
mvn test -Dtimeout=60000
mvn test -X -e
\\\

## Element Not Found

- Validate selector
- Check visibility
- Use \page.pause()\ to debug

## Test Timeout

\\\ash
mvn test -Dtimeout=60000
mvn test -Dheadless=false
\\\

## Out of Memory

\\\ash
export MAVEN_OPTS="-Xmx2g"
mvn test -Dthreads=2
\\\

## Playwright Browsers Not Found

\\\ash
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install --with-deps"
\\\

---
Last Updated: 2026
