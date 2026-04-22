# Selenium Java Hybrid Framework

A scalable Selenium automation framework built using Java, TestNG, Maven, and Page Object Model. The framework is designed to support maintainable, reusable, and enterprise-ready UI automation.

---

## Project Overview

This framework demonstrates how to build a robust Selenium automation solution using industry-standard design principles and reusable components.

It includes:

* Selenium WebDriver integration
* Java-based automation framework
* TestNG for test execution and reporting
* Maven for dependency management
* Page Object Model (POM)
* Screenshot capture on failure
* Retry mechanism for flaky tests
* Configurable test execution
* Cross-browser support
* Reporting and logging support

---

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* Apache POI
* Log4j
* Extent Reports

---

## Framework Features

* Page Object Model implementation
* Reusable utility classes
* Centralized driver management
* Config file handling
* Screenshot capture on failure
* Retry logic for failed test cases
* TestNG listeners integration
* Data-driven testing support
* Cross-browser execution
* Parallel execution capability
* Extent reporting support

---

## Project Structure

```text
selenium-java-hybrid-framework
│
├── src
│   ├── main
│   │   └── java
│   │       ├── base
│   │       ├── pages
│   │       ├── utilities
│   │       └── tests
│
├── src/test/resources
│   ├── config.properties
│   └── log4j2.xml
│
├── reports
├── screenshots
├── testData
├── pom.xml
├── testng.xml
├── README.md

```

---

## Prerequisites

Before running the framework, make sure the following are installed:

* Java JDK 11 or above
* Maven
* IDE such as IntelliJ IDEA or Eclipse
* Chrome browser
* Git

---

## Sample Framework Components

### BaseTest

Responsible for browser setup and teardown.

### DriverFactory

Handles driver initialization for different browsers.

### ConfigReader

Reads configuration values from the properties file.

### ScreenshotUtils

Captures screenshots for failed test cases.

### RetryAnalyzer

Retries failed test cases automatically.

### TestListener

Captures test execution logs and screenshots.

---

## Reporting

The framework supports:

* TestNG default reports
* Extent Reports
* Console logs
* Failure screenshots
* Execution summary

Generated reports can be found inside:

```text
/reports
/screenshots
```

---

## Sample Scenarios Covered

* Login functionality
* Search functionality
* Checkout flow
* Data-driven login validation
* Negative test scenarios
* Cross-browser execution

---

## Future Enhancements

* Docker integration
* GitHub Actions integration
* API automation integration
* Database validation support
* Cloud execution using Selenium Grid
* BrowserStack integration
* Performance test integration

---

## Key Highlights

* Designed a scalable Selenium Java framework from scratch
* Implemented reusable components and utilities
* Added reporting, screenshots, and retry logic
* Followed Page Object Model architecture
* Built framework with enterprise-level design principles
* Prepared project for CI/CD integration

---

## Author

Senior QA Manager | Automation | Selenium | Java | TestNG | Salesforce QA | Enterprise Testing
