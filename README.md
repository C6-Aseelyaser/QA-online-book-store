# QA Online Book Store
![img_1.png](img_1.png)

This repository contains an automated test suite for a sample online bookstore application. The tests are written using Selenium WebDriver and TestNG in Java. The suite covers the following functionalities of the bookstore:
- Viewing a list of books.
- Viewing book details.
- Adding a book to the cart.
- Viewing the cart and updating it when a book is added.
- Proceeding to checkout from the cart.

The tests target the following website:[Legenda Bookstore](https://legendabookstore.com/).

## Table of Contents

- [Technology Stack](#Technology-Stack)
- [Project Structure](#project-structure)
- [Test Scenarios](#test-scenarios)
- [Setup and Installation](#setup-and-installation)
- [Running the Tests](#running-the-tests)
- [Dependencies](#dependencies)
- [Demo](#demo)


## Technology Stack
1. Programming language - **`Java`** 
2. Build and project management tool - **`Maven`** 
3. Testing framework - **`TestNG`**
4. Automation framework - **`Selenium WebDriver`** 


## Project Structure

```bash
QA-online-book-store
├── drivers
│ └── chromedrivers.exe
├── src
│ └── test
│ └── java
│ └── test
│ ├── scenarios
│ │ ├── ViewListOfBooksTest.java
│ │ ├── ViewBookDetailsTest.java
│ │ ├── AddBookToCartTest.java
│ │ ├── ViewCartTest.java
│ │ └── ProceedToCheckoutTest.java
│ ├── actions
│ │ ├── ViewListOfBooks.java
│ │ ├── ViewBookDetails.java
│ │ ├── AddBookToCart.java
│ │ ├── ViewCart.java
│ │ └── ProceedToCheckout.java
│ ├── utils
│ └── └── WebDriverManager
└── pom.xml
```

## Test Scenarios

The test suite includes the following scenarios:

1. **View List of Books**: Verify that the list of books is displayed correctly.
2. **View Book Details**: Verify that book details can be viewed correctly.
3. **Add Book to Cart**: Verify that a user can add a book to the cart.
4. **View and Update Cart**: Verify that the cart updates correctly when a book is added.
5. **Proceed to Checkout**: Verify that the user can proceed to checkout from the cart.
## Setup and Installation

To set up and run the tests, follow these steps:

1. **Clone the repository**:
    ```bash
    git clone https://github.com/C6-Aseelyaser/QA-online-book-store.git
    cd QA-online-book-store
    ```

2. **Install Maven**: Ensure you have Maven installed on your system. If not, download and install it from [Maven's official website](https://maven.apache.org/install.html).

3. **Install ChromeDriver**: Download and install ChromeDriver from [ChromeDriver's official website](https://developer.chrome.com/docs/chromedriver/downloads). Ensure the ChromeDriver executable is in your system's PATH.

4. **Update the WebDriver path**: If necessary, update the path to the ChromeDriver executable in the test setup code:
    ```java
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    ```

5. **Set up WebDriverManager** (if used):
    ```java
    WebDriverManager.chromedriver().setup();
    ```

## Running the Tests

1. **Navigate to the project directory**:
    ```bash
    cd QA-online-book-store
    ```

2. **Run the tests**:
   - Open your IDE (e.g., IntelliJ IDEA or Eclipse).
   - Navigate to the src/test/java/test/scenarios folder.
   - Start with the following test files:
     - ViewListOfBooksTest
     - ViewBookDetailsTest 
     - AddBookToCartTest 
     - ViewCartTest 
     - ProceedToCheckoutTest
   - Click on the file to open it.
   - Press `Ctrl+Shift+F10` (or the equivalent shortcut in your IDE) to run the test.

## Dependencies

The project has the following dependencies:

- **Selenium WebDriver**: For browser automation.
- **TestNG**: For organizing the test cases and running the tests.
- **WebDriverManager**: For managing browser drivers automatically.

All dependencies are specified in the `pom.xml` file and will be downloaded automatically by Maven.

```xml
<dependencies>
    <!-- Selenium Java Dependency -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.22.0</version>
    </dependency>

    <!-- TestNG Dependency -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.9.0</version>
        <scope>test</scope>
    </dependency>
    
    <!-- WebDriverManager Dependency -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.9.2</version>
    </dependency>
</dependencies>
```
## Demo

Watch the demo below to see how the automated tests work:
```html
<iframe width="560" height="315" src="https://www.youtube.com/embed/dSwbmEWFmG0?autoplay=1" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
```




