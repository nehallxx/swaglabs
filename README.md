# Automation Testing Project

This project is a robust automation testing framework built using **Selenium**, **TestNG**, **Allure Reports**, and **Java**. It supports **Data-Driven Testing (DDT)** to ensure scalability and reusability of test cases.

---

## Technologies Used
- **Selenium**: For browser automation and interaction with web elements.
- **TestNG**: For test case management, parallel execution, and reporting.
- **Allure Reports**: For generating detailed and interactive test execution reports.
- **Java**: As the primary programming language.
- **Data-Driven Testing (DDT)**: Using external data sources (e.g., Excel, CSV, JSON) to drive test cases.

---

## Prerequisites
Before running the project, ensure you have the following installed:
1. **Java JDK 8 or higher**
2. **Maven** (for dependency management)
3. **ChromeDriver** or other browser drivers (ensure they match your browser version)
4. **Allure Commandline** (for generating Allure reports)

---

## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/nehallxx/DDT-Selenium.git
   cd DDT-Selenium

2. **Install Dependencies**:

   ```bash
   mvn clean install
3. **Update Configuration**:
   ```bash
   Update src/main/resources/allure.properties and src/main/resources/log412.properties with your environment details.

4. **Add test data files (e.g., Excel, CSV) to src/test/resources/.**

5. **Run Tests**


