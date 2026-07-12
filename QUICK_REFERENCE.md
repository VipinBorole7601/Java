# Quick Reference - All Commands & Examples

## Installation

\\\ash
./scripts/setup.sh
scripts/setup.bat
\\\

## Running Tests

\\\ash
mvn test
mvn test -DsuiteXmlFile=testng-smoke.xml
mvn test -DsuiteXmlFile=testng-regression.xml
mvn -Dtest=LoginSmokeTest test
mvn -Dtest=LoginSmokeTest#testUserCanLogin test
\\\

## Advanced

\\\ash
mvn test -Denv=qa
mvn test -Dbrowser=firefox
mvn test -Dheadless=false
mvn test -Dslowmo=1000
mvn test -Dthreads=4
mvn test -Dtimeout=60000
mvn allure:serve
\\\

---
Last Updated: 2026
