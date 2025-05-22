# RestAssured Training Project 🧪

This project is a hands-on training on **API testing** using **RestAssured** as part of a complete course on [QACart](https://qacart.com/course/rest-assured-101). It covers how to automate API testing efficiently with Java and TestNG.

## 🔧 Technologies & Tools

- **Java 17**
- **Maven**
- **RestAssured 5.4.0**
- **TestNG 7.11.0**
- **Jackson Databind 2.18.2**

---

## 📚 What This Project Covers

The project is structured to follow the training modules. Each part of the project corresponds to a concept in the course:

### ✅ Headers in RestAssured
- Setting headers with `header()` and `headers()`
- Using `Header` and `Headers` classes
- Sending headers as a `HashMap`

### 🧩 Query Parameters
- Adding query parameters using `queryParam()` and `queryParams()`

### ✉️ Request Body
- Sending body as:
  - **String**
  - **File**
  - **HashMap**
  - **POJO Class**
  - **URL Encoded format**

### 🔐 Authorization
- Adding Authorization Header
- Using `auth().basic()` and similar methods

### ⚙️ Request Specification
- Reusing common request settings using `RequestSpecification`

---

## 📦 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/Emanmohamed291/Rest-Assured.git
   cd Rest-Assured
   ```

2. Run tests using Maven:
   ```bash
   mvn clean test
   ```

---

## 🧠 Learnings

Through this project, I practiced:

- Writing **clean and maintainable** API test cases.
- Using **POJOs** and serialization/deserialization.
- Understanding how to send different types of **headers**, **parameters**, and **body content**.
- Structuring API tests with **TestNG** and assertions.
- Working with **Authorization** and reusing specs with `RequestSpecification`.

---

## 🎓 Source Course

This project is based on the [Complete RestAssured Course by QACart](https://qacart.com/course/rest-assured-101).

