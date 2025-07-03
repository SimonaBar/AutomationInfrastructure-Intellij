 **FinalProject Test Automation 2025**

This project is a comprehensive automation framework designed for functional and regression testing
across multiple platforms and technologies, including Web, Mobile, Desktop, Electron, API, and Database layers.
It was developed as a final project for automation studies in 2025.

 🚀 Project Description

The framework provides automated tests for:
- **Web Testing:** Using Selenium WebDriver to test web applications like SauceDemo.
- **Mobile Testing:** Using Appium for native or hybrid mobile applications.
- **Desktop Testing:** Automation of Windows desktop applications such as Calculator.
- **Electron Testing:** Automation of Electron-based desktop apps.
- **API Testing:** Using RestAssured for HTTP requests and responses validation.
- **Database Testing:** Validating data using SQLite and JDBC connections.
All tests are managed and executed via TestNG with support for different execution profiles.

---
## 🛠 Technologies Used
- **Java**
- **Maven**
- **TestNG**
- **Selenium WebDriver**
- **Appium**
- **RestAssured**
- **SQLite JDBC**
- **Monte Screen Recorder**
- **Allure Reporting** 
---
## 💻 Project Structure

- **extensions/** → Actions for UI, Mobile, DB, API, and Verifications.
- **pageObjects/** → Page Object Model classes for various tested apps.
- **utilities/** → Base classes, screen recording, page management, listeners.
- **workflows/** → Business flows combining actions for meaningful scenarios.
- **sanity/** → TestNG test classes for sanity and regression testing.
- **helper/** → Helper classes for specific utilities or test data.

---


## 📊 Reporting

By default, TestNG generates HTML and XML reports under `target/surefire-reports`. Optionally, Allure can be integrated for more advanced reporting.

## Known Issues

- **API Testing:**  
  While testing API endpoints on the Dummy API website, there were multiple occasions when the external server was unavailable or returned no JSON response. This causes API tests to fail unpredictably.

- **Mobile Testing:**  
  Mobile test executions were sometimes unstable due to the need to frequently reconnect the physical device to the computer. Test execution was also noticeably slower compared to other environments.

- **Web Testing:**  
  When running web tests on Google Chrome, a browser pop-up related to saved passwords appeared during login. To avoid this issue, tests were executed in Incognito mode.

- **Sikuli Testing:**  
  During visual testing with Sikuli, some tests failed due to differences in image resolution or screen scaling settings. This caused Sikuli to be unable to locate UI elements based on screenshots.









