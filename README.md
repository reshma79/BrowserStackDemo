# 📱 Mobile Automation Framework (Appium + BrowserStack)

## 📌 Overview

This project is a data-driven mobile automation framework built using:

* Appium
* TestNG
* BrowserStack

Test cases are maintained in Excel and executed dynamically using JSON.

---

## 🚀 Key Features

* Step-based execution engine
* Excel → JSON conversion
* Supports multiple actions:

  * Click
  * Type
  * Drag & Drop
* Reusable utility methods
* Runs on real devices via BrowserStack

---

## 🏗️ Project Structure

```id="k4t8da"
src/
 ├── tests/        → Test execution
 ├── pages/        → Page classes
 ├── utils/        → Actions & helpers
 ├── driver/       → Driver setup
 ├── data/         → Excel & JSON
```

---

## ⚙️ Prerequisites

* Java (JDK 8+)
* Maven
* Appium
* BrowserStack account

---

## 🔑 Setup

### Clone repo

```id="i7nq9p"
git clone <repo-url>
```

### Set BrowserStack credentials

```id="7q2q3g"
BROWSERSTACK_USERNAME=your_username
BROWSERSTACK_ACCESS_KEY=your_key
```

---

## ▶️ Run Tests

```id="xy7y6q"
mvn clean test
```

---

## 📊 Test Data Design

Each test case is divided into steps:

* Action
* Locator Type
* Locator Value
* Input
* Expected Result

---

## ☁️ Execution

Tests run on BrowserStack real devices.

---

## 📌 Future Improvements

* Reporting (Allure / Extent)
* Retry mechanism
* Screenshot on failure
* CI/CD integration

---

## 👩‍💻 Author

Reshma Pikle
