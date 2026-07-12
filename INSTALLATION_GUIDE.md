# Complete Installation & Quick Start Guide

## Prerequisites
- Java 17+ - Check: \java -version\
- Maven 3.9+ - Check: \mvn -version\
- Git
- IDE: IntelliJ IDEA or VS Code

## Step-by-Step

### Step 1: Clone Repository
\\\ash
git clone <your-repo-url>
cd java-playwright-framework
\\\

### Step 2: Run Setup Script

**Windows:**
\\\ash
scripts\setup.bat
\\\

**Linux/Mac:**
\\\ash
chmod +x scripts/setup.sh
./scripts/setup.sh
\\\

### Step 3: Verify

\\\ash
mvn test -Dtest=LoginSmokeTest#testLoginPageLoads
\\\

## Quick Start

\\\ash
mvn test -DsuiteXmlFile=testng-smoke.xml
mvn allure:serve
\\\

---
Last Updated: 2026
