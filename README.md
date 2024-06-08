# Payment Service

A Spring Boot microservice for processing payments with different providers (PayPal, Stripe, Square) using the Strategy, Factory, and Observer design patterns. The service validates payment requests, checks for fraudulent transactions, and notifies various components about payment transactions.

## Features

- Process payments through multiple providers.
- Validate payment requests.
- Check for fraudulent transactions.
- Notify logging, analytics, and notification services about payment transactions.
- Use H2 in-memory database for local development.
- Externalize configuration using `application.yml`.

## Technologies Used

- Java 11
- Spring Boot
- Spring Data JPA
- Spring WebFlux
- Spring Validation
- H2 Database
- Maven

## Design Patterns

### Strategy Pattern
Used to define a family of algorithms (payment processing), encapsulate each one, and make them interchangeable. This pattern lets the algorithm vary independently from the clients that use it.

### Factory Pattern
Used to create objects without specifying the exact class of object that will be created. This pattern is used to return the appropriate `PaymentProvider` based on the provider type.

### Observer Pattern
Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. This pattern is used to notify different components (logging, analytics, notifications) about payment transactions.

## Prerequisites
### 1. JDK 11 or higher
#### 1.1 Windows

##### Step 1: Download the Java JDK
Go to the [Oracle JDK download page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and download the installer for Windows.

##### Step 2: Install the Java JDK
Run the downloaded installer and follow the on-screen instructions to complete the installation.

##### Step 3: Configure Environment Variables
1. Open the Start Search, type in "env", and select "Edit the system environment variables".
2. In the System Properties window, click on the "Environment Variables" button.
3. Under "System variables", click "New" to add a new variable.
   - Variable name: `JAVA_HOME`
   - Variable value: `C:\Program Files\Java\jdk-11.x.x` (replace with your actual JDK installation path)
4. Find the `Path` variable, select it, and click "Edit".
5. Click "New" and add the path to the `bin` directory of the JDK installation (e.g., `C:\Program Files\Java\jdk-11.x.x\bin`).
6. Click "OK" to close all windows.

##### Step 4: Verify the Installation
Open a new Command Prompt and run the following command to verify that Java is installed correctly:

```sh
java -version
```

You should see output similar to the following, which indicates Java is installed and ready to use:

```sh
java version "11.x.x" (where x.x is the version number)
Java(TM) SE Runtime Environment (build 11.x.x)
Java HotSpot(TM) 64-Bit Server VM (build 11.x.x, mixed mode)
```

##### Additional Information
- **Update Java JDK**: To update the Java JDK in the future, download the latest version from the [Oracle JDK download page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and repeat the installation steps.
- **Uninstall Java JDK**: To uninstall the Java JDK, go to "Programs and Features" in the Control Panel, find the Java SE Development Kit, and uninstall it.


#### 2.2 MacOS

##### Step 1: Download the Java JDK
Go to the [Oracle JDK download page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and download the installer for macOS.

##### Step 2: Install the Java JDK
Run the downloaded installer and follow the on-screen instructions to complete the installation.

##### Step 3: Configure Environment Variables
1. Open Terminal.
2. Open the profile file in a text editor. You can use nano for this:
   ```sh
   nano ~/.bash_profile
   ```
   If you are using zsh (default on macOS Catalina and later), edit the `.zshrc` file instead:
   ```sh
   nano ~/.zshrc
   ```
3. Add the following lines to set the `JAVA_HOME` environment variable:
   ```sh
   export JAVA_HOME=$(/usr/libexec/java_home)
   export PATH=$JAVA_HOME/bin:$PATH
   ```
4. Save the file and exit the text editor (Ctrl+O to save and Ctrl+X to exit in nano).
5. Apply the changes by running:
   ```sh
   source ~/.bash_profile
   ```
   Or for zsh:
   ```sh
   source ~/.zshrc
   ```

##### Step 4: Verify the Installation
Open a new Terminal window and run the following command to verify that Java is installed correctly:

```sh
java -version
```

You should see output similar to the following, which indicates Java is installed and ready to use:

```sh
java version "11.x.x" (where x.x is the version number)
Java(TM) SE Runtime Environment (build 11.x.x)
Java HotSpot(TM) 64-Bit Server VM (build 11.x.x, mixed mode)
```

##### Additional Information
- **Update Java JDK**: To update the Java JDK in the future, download the latest version from the [Oracle JDK download page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and repeat the installation steps.
- **Uninstall Java JDK**: To uninstall the Java JDK, delete the JDK directory from `/Library/Java/JavaVirtualMachines` and remove the `JAVA_HOME` entry from your profile file.



### 2. Maven
#### 2.1 Windows

##### Step 1: Download Maven
Go to the [Apache Maven download page](https://maven.apache.org/download.cgi) and download the binary zip archive.

##### Step 2: Extract the Archive
Extract the downloaded zip archive to the directory where you want Maven to be installed. For example, you can extract it to `C:\Program Files\Apache\maven`.

##### Step 3: Configure Environment Variables
1. Open the Start Search, type in "env", and select "Edit the system environment variables".
2. In the System Properties window, click on the "Environment Variables" button.
3. Under "System variables", find the `Path` variable, select it, and click "Edit".
4. Click "New" and add the path to the `bin` directory of the extracted Maven directory (e.g., `C:\Program Files\Apache\maven\bin`).
5. Click "OK" to close all windows.

##### Step 4: Verify the Installation
Open a new Command Prompt and run the following command to verify that Maven is installed correctly:

```sh
mvn -version
```

You should see output similar to the following, which indicates Maven is installed and ready to use:

```sh
Apache Maven 3.x.x (where x.x is the version number)
Maven home: C:\Program Files\Apache\maven
Java version: 11.x.x, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-11.x.x
Default locale: en_US, platform encoding: Cp1252
OS name: "windows", version: "10", arch: "amd64", family: "windows"
```

##### Additional Information
- **Update Maven**: To update Maven in the future, download the latest version from the [Apache Maven download page](https://maven.apache.org/download.cgi) and repeat the installation steps.
- **Uninstall Maven**: To uninstall Maven, simply delete the Maven directory and remove the Maven path from the `Path` environment variable.


#### 2.2 MacOS
To install Maven on a Mac, you can use Homebrew, which is a popular package manager for macOS. Here’s a step-by-step guide:

##### Step 1: Install Homebrew (if not already installed)
If you don't have Homebrew installed, open Terminal and run the following command:

```sh
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

Follow the on-screen instructions to complete the installation.

##### Step 2: Install Maven
Once Homebrew is installed, you can easily install Maven by running:

```sh
brew install maven
```

##### Step 3: Verify the Installation
After the installation is complete, verify that Maven is installed correctly by checking the version:

```sh
mvn -version
```

You should see output similar to the following, which indicates Maven is installed and ready to use:

```sh
Apache Maven 3.x.x (where x.x is the version number)
Maven home: /usr/local/Cellar/maven/3.x.x/libexec
Java version: 11.x.x, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk-11.x.x.jdk/Contents/Home
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.15.x", arch: "x86_64", family: "mac"
```

##### Additional Information
- **Update Maven**: To update Maven in the future, you can run `brew upgrade maven`.
- **Uninstall Maven**: If you ever need to uninstall Maven, you can do so with `brew uninstall maven`.


## Running the Application

### 1. Clone the Repository

```sh
git clone https://github.com/jlassiMo/payment-service.git
cd payment-service
```
### 2\. Configure the Application

Update application.yml with your configuration if needed.

### 3\. Run the Application

```sh
 ./mvnw spring-boot:run
```
### 4\. Access the H2 Console

*   Open your browser and go to [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

*   Use the JDBC URL jdbc:h2:mem:testdb, username sa, and leave the password blank.


API Endpoints
-------------

### Process Payment

```sh
 POST /api/payments/process  
```
#### Request Parameters

*   provider: The payment provider (PAYPAL, STRIPE, SQUARE).

*   amount: The amount to be processed.


#### Example Request

```sh
curl -X POST "http://localhost:8080/api/payments/process" -H "Content-Type: application/json" -d '{"provider": "PAYPAL", "amount": 100.0}'

```

Class Descriptions
------------------

### Configuration

#### PaymentProviderProperties.java

*   **Purpose**: Binds external configuration properties from application.yml for payment provider URLs.

*   **Usage**: Provides URLs for PayPal, Stripe, and Square APIs to the respective payment provider classes.


### Controller

#### PaymentController.java

*   **Purpose**: Handles incoming HTTP requests for processing payments.

*   **Endpoints**:

    *   POST /api/payments/process: Processes a payment request.

*   **Usage**: Validates the payment request, sets the payment provider, and processes the payment.


### Exception Handling

#### GlobalExceptionHandler.java

*   **Purpose**: Handles exceptions globally across the application.

*   **Usage**: Provides centralized exception handling to return appropriate HTTP responses for different types of exceptions.


### Model

#### PaymentProviderType.java

*   **Purpose**: Enum representing different payment providers (PAYPAL, STRIPE, SQUARE).

*   **Usage**: Used to identify and select the appropriate payment provider.


#### PaymentRequest.java

*   **Purpose**: Represents a payment request with provider and amount fields.

*   **Validation**: Uses annotations to validate that the provider is not null and the amount is non-negative.

*   **Usage**: Serves as the data transfer object (DTO) for payment requests.


#### PaymentTransaction.java

*   **Purpose**: Represents a payment transaction entity.

*   **Fields**: Includes transaction ID, provider, amount, and success status.

*   **Usage**: Persisted in the database to keep a record of all payment transactions.


### Observer

#### Observer.java

*   **Purpose**: Interface for observer classes that need to be notified of payment transactions.

*   **Method**: update(PaymentTransaction transaction): Updates the observer with transaction details.


#### LoggingObserver.java

*   **Purpose**: Logs payment transaction details.

*   **Method**: update(PaymentTransaction transaction): Logs the transaction.


#### AnalyticsObserver.java

*   **Purpose**: Updates analytics with payment transaction details.

*   **Method**: update(PaymentTransaction transaction): Updates analytics data.


#### NotificationObserver.java

*   **Purpose**: Sends notifications about payment transactions.

*   **Method**: update(PaymentTransaction transaction): Sends a notification.


### Repository

#### PaymentTransactionRepository.java

*   **Purpose**: JPA repository for PaymentTransaction entities.

*   **Usage**: Provides CRUD operations for PaymentTransaction entities.


### Service

#### PaymentService.java

*   **Purpose**: Core service class for processing payments.

*   **Methods**:

    *   setPaymentProvider(PaymentProviderType providerType): Sets the payment provider based on the provider type.

    *   processPayment(double amount): Processes the payment by using the selected provider and saves the transaction.

*   **Pattern**: Implements the Subject interface to notify observers about payment transactions.


#### FraudDetectionService.java

*   **Purpose**: Checks for fraudulent transactions.

*   **Methods**:

    *   isFraudulent(double amount): Returns true if the transaction amount is considered fraudulent.


### Provider

#### PaymentProvider.java

*   **Purpose**: Interface for payment provider classes.

*   **Method**: processPayment(double amount): Processes the payment with the given amount.


#### PaymentProviderFactory.java

*   **Purpose**: Factory class for creating PaymentProvider instances.

*   **Methods**:

    *   getPaymentProvider(PaymentProviderType providerType): Returns the appropriate PaymentProvider based on the provider type.


#### PayPalPaymentProvider.java

*   **Purpose**: Processes payments through PayPal.

*   **Methods**:

    *   processPayment(double amount): Makes an HTTP request to PayPal's API to process the payment.


#### StripePaymentProvider.java

*   **Purpose**: Processes payments through Stripe.

*   **Methods**:

    *   processPayment(double amount): Makes an HTTP request to Stripe's API to process the payment.


#### SquarePaymentProvider.java

*   **Purpose**: Processes payments through Square.

*   **Methods**:

    *   processPayment(double amount): Makes an HTTP request to Square's API to process the payment.


How the Application Works
-------------------------

1.  **Configuration**: application.yml contains configuration for payment provider URLs and database settings.

2.  **Controller**: PaymentController handles incoming payment requests, validates them, and delegates processing to PaymentService.

3.  **Service**:

    *   PaymentService sets the payment provider based on the request and processes the payment.

    *   It checks for fraudulent transactions using FraudDetectionService.

    *   Processes the payment through the selected PaymentProvider.

    *   Saves the transaction in the database H2 using PaymentTransactionRepository.

    *   Notifies registered observers (LoggingObserver, AnalyticsObserver, NotificationObserver) about the transaction.

4.  **Providers**: Different providers (PayPalProvider, StripeProvider, SquareProvider) process payments through their respective APIs.

5.  **Observers**: Observers are notified about the transaction and perform their specific actions (logging, analytics, notifications).

### Class Diagram

![img.png](img.png)
[classDiagramPaymentService.drawio.pdf](https://github.com/user-attachments/files/15687190/classDiagramPaymentService.drawio.pdf)
