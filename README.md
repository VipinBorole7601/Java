# Java + Selenium + TestNG + Maven Cheat Sheet (Updated 2026)

Quick reference for modern **Selenium WebDriver 4 + TestNG** automation in Java.

## 1) Prerequisites

- Java 17+
- Maven 3.9+
- Selenium 4.x
- TestNG 7.x

```xml
<!-- pom.xml -->
<dependencies>
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.22.0</version>
  </dependency>
  <dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.9.2</version>
  </dependency>
</dependencies>
```

## 2) Driver Initialization

```java
WebDriver driver = new ChromeDriver();
WebDriver driver = new FirefoxDriver();
WebDriver driver = new EdgeDriver();
```

```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--start-maximized");
options.addArguments("--incognito");
options.addArguments("--disable-notifications");
options.addArguments("--headless=new"); // optional
WebDriver driver = new ChromeDriver(options);
```

## 3) Browser Commands

```java
driver.get("https://example.com");
driver.navigate().to("https://google.com");
driver.navigate().back();
driver.navigate().forward();
driver.navigate().refresh();

String title = driver.getTitle();
String url = driver.getCurrentUrl();
String pageSource = driver.getPageSource();

driver.manage().window().maximize();
driver.manage().window().fullscreen();

driver.close(); // current window
driver.quit();  // all windows + session
```

## 4) Locators

```java
driver.findElement(By.id("email"));
driver.findElement(By.name("password"));
driver.findElement(By.className("btn-primary"));
driver.findElement(By.tagName("input"));
driver.findElement(By.linkText("Login"));
driver.findElement(By.partialLinkText("Log"));
driver.findElement(By.cssSelector("input#email"));
driver.findElement(By.xpath("//input[@id='email']"));
```

### Relative Locators (Selenium 4)

```java
import static org.openqa.selenium.support.locators.RelativeLocator.with;

driver.findElement(with(By.tagName("input")).above(passwordField));
driver.findElement(with(By.tagName("input")).below(emailField));
driver.findElement(with(By.tagName("button")).toLeftOf(submitButton));
driver.findElement(with(By.tagName("button")).toRightOf(submitButton));
driver.findElement(with(By.tagName("input")).near(emailLabel));
```

## 5) WebElement Operations

```java
WebElement element = driver.findElement(By.id("username"));
element.click();
element.sendKeys("admin");
element.clear();
element.submit();

String text = element.getText();
String type = element.getAttribute("type");
boolean displayed = element.isDisplayed();
boolean enabled = element.isEnabled();
boolean selected = element.isSelected();
```

## 6) Dropdown (Select)

```java
Select select = new Select(driver.findElement(By.id("country")));
select.selectByVisibleText("India");
select.selectByValue("IN");
select.selectByIndex(2);

select.deselectByVisibleText("India"); // for multi-select only
select.deselectByValue("IN");
select.deselectByIndex(2);
select.deselectAll();
```

## 7) Waits (Use Explicit Wait by default)

```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
```

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement loginBtn = wait.until(
    ExpectedConditions.elementToBeClickable(By.id("loginBtn"))
);
```

## 8) Alerts, Frames, Windows

```java
Alert alert = driver.switchTo().alert();
alert.getText();
alert.sendKeys("hello");
alert.accept();
alert.dismiss();
```

```java
driver.switchTo().frame(0);
driver.switchTo().frame("frameName");
driver.switchTo().frame(driver.findElement(By.cssSelector("iframe")));
driver.switchTo().defaultContent();
```

```java
String parent = driver.getWindowHandle();
Set<String> all = driver.getWindowHandles();
for (String handle : all) {
    driver.switchTo().window(handle);
}
driver.switchTo().window(parent);
```

## 9) Actions Class (Mouse/Keyboard)

```java
Actions actions = new Actions(driver);
actions.moveToElement(menu).perform();
actions.doubleClick(button).perform();
actions.clickAndHold(source).moveToElement(target).release().perform();
actions.dragAndDrop(source, target).perform();
actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
```

## 10) JavaScriptExecutor

```java
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,500)");
js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
js.executeScript("arguments[0].scrollIntoView(true);", element);
```

## 11) Screenshot + File Upload + Cookies

```java
TakesScreenshot ts = (TakesScreenshot) driver;
File src = ts.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src, new File("target/screenshot.png"));
```

```java
driver.findElement(By.id("fileUpload")).sendKeys("C:\\files\\test.pdf");
```

```java
Cookie cookie = new Cookie("token", "abc123");
driver.manage().addCookie(cookie);
driver.manage().getCookies();
driver.manage().getCookieNamed("token");
driver.manage().deleteCookieNamed("token");
driver.manage().deleteAllCookies();
```

## 12) Selenium Grid (Quick)

```bash
# Start hub/node (Selenium Server 4)
java -jar selenium-server-<version>.jar standalone
```

Remote test:

```java
WebDriver driver = new RemoteWebDriver(
    new URL("http://localhost:4444"),
    new ChromeOptions()
);
```

## 13) TestNG Annotations

```java
@BeforeSuite @AfterSuite
@BeforeTest @AfterTest
@BeforeClass @AfterClass
@BeforeMethod @AfterMethod
@Test
```

Useful `@Test` options:

```java
@Test(enabled = false)
@Test(priority = 2)
@Test(dependsOnMethods = {"loginTest"}, alwaysRun = true)
@Test(groups = {"smoke", "regression"})
@Test(description = "Open Login Page", timeOut = 30000)
@Test(invocationCount = 3, threadPoolSize = 2)
```

## 14) TestNG DataProvider + Parameters

```java
@DataProvider(name = "users")
public Object[][] users() {
    return new Object[][] {{"admin", "admin123"}, {"user", "user123"}};
}

@Test(dataProvider = "users")
public void loginTest(String username, String password) { }
```

```java
@Parameters({"browser", "baseUrl"})
@Test
public void crossBrowserTest(String browser, String baseUrl) { }
```

## 15) Assertions

```java
Assert.assertEquals(actual, expected);
Assert.assertTrue(condition, "Condition failed");
Assert.assertFalse(condition);
Assert.assertNotNull(value);
```

```java
SoftAssert soft = new SoftAssert();
soft.assertEquals(actualTitle, "Dashboard");
soft.assertTrue(isProfileVisible);
soft.assertAll();
```

## 16) testng.xml Template

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Suite" parallel="methods" thread-count="4">
  <listeners>
    <listener class-name="com.example.listeners.TestListener"/>
  </listeners>

  <parameter name="browser" value="chrome"/>
  <parameter name="baseUrl" value="https://example.com"/>

  <test name="SmokeTests">
    <groups>
      <run>
        <include name="smoke"/>
      </run>
    </groups>
    <classes>
      <class name="com.example.tests.LoginTest"/>
    </classes>
  </test>
</suite>
```

## 17) Maven Commands (Most Used)

```bash
mvn -version
mvn clean
mvn compile
mvn test
mvn package
mvn clean test
mvn -Dtest=LoginTest test
mvn -Dsurefire.suiteXmlFiles=testng.xml test
mvn help:effective-pom
```

## 18) XPath vs CSS Quick Examples

| Use Case | XPath | CSS |
|---|---|---|
| By id | `//input[@id='email']` | `input#email` |
| By class | `//button[@class='btn primary']` | `button.btn.primary` |
| Contains | `//*[contains(@type,'sub')]` | `*[type*='sub']` |
| Starts with | `//*[starts-with(@id,'user_')]` | `*[id^='user_']` |
| Ends with | `//*[substring(@id,string-length(@id)-3)='_txt']` | `*[id$='_txt']` |
| nth child | `//ul[@id='list']/li[3]` | `ul#list li:nth-child(3)` |
| First/Last child | `//ul[@id='list']/li[1]` / `//ul[@id='list']/li[last()]` | `ul#list li:first-child` / `ul#list li:last-child` |

## 19) HTML Tags Often Used in UI Automation

`a`, `button`, `input`, `select`, `option`, `textarea`, `img`, `iframe`, `div`, `span`, `table`, `tr`, `td`, `th`, `ul`, `li`, `form`, `label`.

---

**Tip:** Prefer stable locators (`id`, `data-testid`, `name`) + explicit waits + Page Object Model for maintainable tests.
