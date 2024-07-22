# **Code_Security_Check**

### Author
Sanya Sinha

## Overview

**Code_Security_Check** is a simple Java application that checks code files for security vulnerabilities and provides recommendations to tackle these security issues using static analysis tools. This application supports Java, Python, C, C++, and JavaScript.

## Features

- **Java**: Uses SpotBugs for static analysis.
- **Python**: Uses Bandit for static analysis.
- **C/C++**: Uses Cppcheck for static analysis.
- **JavaScript**: Uses ESLint for static analysis.

## Prerequisites

### Linux

1. **Java Development Kit (JDK)**
2. **SpotBugs** (for Java analysis)
3. **Bandit** (for Python analysis)
4. **Cppcheck** (for C/C++ analysis)
5. **ESLint** (for JavaScript analysis)

### Windows

1. **Java Development Kit (JDK)**
2. **SpotBugs** (for Java analysis)
3. **Bandit** (for Python analysis)
4. **Cppcheck** (for C/C++ analysis)
5. **ESLint** (for JavaScript analysis)

## Installation

### Linux

#### 1. Install Java Development Kit (JDK)
```bash
sudo apt update
sudo apt install default-jdk
```
#### 2. Install SpotBugs
```bash
wget https://github.com/spotbugs/spotbugs/releases/download/4.7.3/spotbugs-4.7.3.tgz
tar xzf spotbugs-4.7.3.tgz
sudo mv spotbugs-4.7.3 /opt/spotbugs
echo 'export PATH=$PATH:/opt/spotbugs/bin' >> ~/.bashrc
source ~/.bashrc
```
#### 3. Install Bandit
```bash
sudo apt install python3-pip
pip3 install bandit
```
#### 4. Install Cppcheck
```bash
sudo apt install cppcheck
```
#### 5. Install ESLint
```bash
sudo apt install npm
npm install -g eslint
```

### Windows

#### 1. Install Java Development Kit (JDK)
- Download and install the JDK from Oracle's official website.

#### 2. Install SpotBugs
- Download the latest release from SpotBugs releases and extract it.
- Add the bin directory of SpotBugs to the system PATH.

#### 3. Install Bandit
- Download and install Python from Python's official website.
- Open Command Prompt and run:
  ```bash
  pip install bandit
  ```

#### 4. Install Cppcheck
- Download and install Cppcheck from Cppcheck's official website.

#### 5. Install ESLint
- Download and install Node.js from Node.js official website.
- Open Command Prompt and run:
  ```bash
  npm install -g eslint
  ```

## Usage

### Command-Line Arguments
The application requires two arguments:

1. Language: The programming language of the code to be checked (java, python, c, c++, javascript).
2. File Path: The path to the file to be checked.

   **Example**
   ```bash
   java Code_Security_Check java /path/to/your/code.java
   ```

## Code Structure

- **Main Method:**
  - Validates that exactly two arguments are provided (the language and file path).
  - Checks if the file exists and is a valid file.
  - Calls the appropriate method to analyze the file based on the provided language.

- **Static Analysis Methods:**
  - `checkCode_Java(String filePath)`
  - `checkCode_Python(String filePath)`
  - `checkCode_C_Cpp(String filePath)`
  - `checkCode_JS(String filePath)`

- **executeCmd(String[] command):** Executes the system command and processes its output.

- **reviewRecmd(String output):** Provides recommendations based on the tool's output.

## Recommendatiions

- General Recommendations:
  - Keep dependencies up to date to avoid known vulnerabilities.
  - Implement proper error handling to avoid leaking sensitive information.
  - Regularly perform security testing and code reviews.

## Support

For any issues or questions, please open an issue on the GitHub repository or contact the author.
