# Janitri Login Page Automation

This project automates the UI testing of the login page for the [Janitri Dashboard](https://dev-dash.janitri.in/) using Java, Selenium WebDriver, TestNG, and the Page Object Model (POM) design pattern.

---

## ✅ Objective

Automate and validate the login UI behavior for the Janitri Dashboard without using valid credentials. This includes:
- Verifying button states
- Error messages
- Password masking/unmasking
- Page element presence
- Notification permission handling

---

## 🛠️ Tech Stack

- **Language:** Java 17  
- **Automation Framework:** Selenium WebDriver  
- **Test Runner:** TestNG  
- **Build Tool:** Maven  
- **Design Pattern:** Page Object Model (POM)  
- **Driver Manager:** WebDriverManager

---

## 📂 Project Structure
├── base/
│ └── BaseTest.java # Handles WebDriver setup and teardown
├── pages/
│ └── LoginPage.java # POM class with locators and actions
├── tests/
│ └── LoginTests.java # Test class with automated test cases
├── pom.xml # Maven configuration and dependencies
├── testng.xml # TestNG suite file
└── README.md # Project documentation

---

## 🚦 Automated Test Cases

`testLoginButtonDisabledWhenFieldsAreEmpty()` - Ensures the login button is disabled when fields are empty 
`testPasswordMaskedButton()`                  - Validates the password masking and unmasking functionality 
`testInvalidLoginShowErrorMsg()`              - Enters invalid credentials and verifies the error message 
`testLoginPageElementsPresent()`              - Checks visibility of all key elements on the login page 

---

## 🔐 Notification Overlay Handling

The login page sometimes prompts users to allow notifications.  
This framework:
- Blocks browser notifications using Chrome preferences
- Detects and removes any custom overlay/pop-up using DOM manipulation

---

## ▶️ How to Run

### 1. Clone the repository:

git clone https://github.com/your-username/JanitriLoginAutomation.git
cd JanitriLoginAutomation

### 2. Run tests with Maven:
mvn clean test

### 3. Or run with TestNG:
Use the built-in testng.xml to run the suite:
mvn test -DsuiteXmlFile=testng.xml

### ⚙️ Dependencies
Managed via pom.xml. Key dependencies include:
selenium-java (v4.34.0)
testng (v7.10.1)
webdrivermanager (v5.8.0)
slf4j & logback for optional logging

### Final Notes
No real credentials are used.
Only negative scenarios are tested.
This is a UI-level test suite and not connected to backend validation.
