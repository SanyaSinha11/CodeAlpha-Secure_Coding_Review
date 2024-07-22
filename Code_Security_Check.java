import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Code Reviewer: @Sanya_Sinha
/**
 * Secure-Code-Review, a Security_Checker, is a simple Java Application
 * that checks the code files for security vulnerabilities and provides
 * recommendations to tackle the security issues using static analysis tools.
 * This application supports Java, Python, C, C++ and JavaScript.
 */

public class Code_Security_Check {
    public static void main (String args[]) {
        //ensuring that the correct number of arguments are provided
        if (args.length != 2) {
            System.out.println("Usage: java Code-Security-Check <language> <file_path>");
            return;
        }
        String language = args[0];
        String filePath = args[1];
        File file = new File(filePath);

        //check if the given file path is valid or not
        if (!file.exists() || !file.isFile()) {
            System.out.println("INVALID File Path: Given file path does not exists!");
            return;
        }

        //analyze the code on the basis of it's provided language
        try {
            switch (language.toLowerCase()) {
                case "java" :
                    checkCode_Java(filePath);
                    break;
                case "python":
                    checkCode_Python(filePath);
                    break;
                case "c":
                    checkCode_C_Cpp(filePath);
                    break;
                case "c":
                    checkCode_C_Cpp(filePath);
                    break;
                case "c++":
                    checkCode_C_Cpp(filePath);
                    break;
                case "javascript":
                    checkCode_JS(filePath);
                    break;
                default:
                    System.out.println("Unsupported Language: " + language);
                    break;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace(); //prints the stack trace of a 'throwable' to standard error stream
        }
    }

    /**
     * checking Java code for security vulnerabilities using SpotBugs.
     * @param filePath - is the path to Java file.
     */
    private static void checkCode_Java (String filePath) throws IOException, InterruptedException {
        System.out.println("Scanning Java Code for any security vulnerabilities ... ");
        String[] command = {"spotbugs", "-textui", filePath};
        executeCmd(command);
    }

    /**
     * checking Python code for security vulnerabilities using Bandit.
     * @param filePath - is the path to Python file.
     */
    private static void checkCode_Python (String filePath) throws IOException, InterruptedException {
        System.out.println("Scanning Python Code for any security vulnerabilities ... ");
        String[] command = {"bandit", "-r", filePath};
        executeCmd(command);
    }

    /**
     * checking C/C++ code for security vulnerabilities using Cppcheck.
     * @param filePath - is the path to C/C++ file.
     */
    private static void checkCode_C_Cpp (String filePath) throws IOException, InterruptedException {
        System.out.println("Scanning C/C++ Code for any security vulnerabilities ... ");
        String[] command = {"cppcheck", "--enable=all", filePath};
        executeCmd(command);
    }

    /**
     * checking JavaScript code for security vulnerabilities using ESLint.
     * @param filePath - is the path to JavaScript file.
     */
    private static void checkCode_JS (String filePath) throws IOException, InterruptedException {
        System.out.println("Scanning JavaScript Code for any security vulnerabilities ... ");
        String[] command = {"eslint", filePath};
        executeCmd(command);
    }

    /*
     * executing system command and processing its output.
     * @param command - command to execute.
     * @throws IOException and InterruptedException.
     */
    private static void executeCmd (String[] command) throws IOException, InterruptedException {
        Process prcs = new ProcessBuilder(command).start();

        //reading output of the command
        BufferedReader reader = new BufferedReader(new InputStreamReader(prcs.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        //waiting for the process to complete
        prcs.waitFor();

        //print output to the console
        System.out.println(output.toString());

        //provide appropriate recommendations on the basis of the tool's output
        reviewRecmd(output.toString());
    }

    /**
     * providing recommendations for secure coding practices based on tool's output and analysis.
     * @param output = contains output of the static tool analysis.
     */
    private static void reviewRecmd (String output) {
        //return recommendations and reviews based on identified vulnerabilities in output

        if (output.contains("SQL Injection")) {
            System.out.println("Recommendation: Use parameterized queries to prevent SQL Injection.");
        }
        if (output.contains("XSS")) {
            System.out.println("Recommendation: Sanitize user inputs to prevent Cross-Site Scripting (XSS).");
        }
        if (output.contains("Command Injection")) {
            System.out.println("Recommendation: Validate and sanitize user inputs to prevent Command Injection.");
        }
        if (output.contains("Path Traversal")) {
            System.out.println("Recommendation: Validate file paths and restrict file access to prevent Path Traversal.");
        }
        if (output.contains("CSRF")) {
            System.out.println("Recommendation: IMplement CSRF protection to prevent Cross-Site Request Forgery (CSRF).");
        }
        if (output.contains("Buffer Overflow")) {
            System.out.println("Recommendation: Use safe functions and perform bounds checking to prevent Buffer Overflow.");
        }
        if (output.contains("Insecure Transport")) {
            System.out.println("Recommendation: Use TLS/SSL to encrypt data in transit and avoid using insecure protocols.");
        }
        if (output.contains("Weak Cryptography")) {
            System.out.println("Recommendation: Use strong, industry-standard cryptographic algorithms and libraries.");
        }
        if (output.contains("Unvalidated Redirects and Forwards")) {
            System.out.println("Recommendation: Validate URLs and use safe methods to handle redirects and forwards.");
        }
        if (output.contains("Security Misconfiguration")) {
            System.out.println("Recommendation: Ensure secure configuration for servers, database, and application framework.");
        }
        if (output.contains("Sensitive Data Exposure")) {
            System.out.println("Recommendation: Encrypt sensitive data at rest and in transit, and use secure storage mechanisms.");
        }
        if (output.contains("Improper Access Control")){
            System.out.println("Recommendation: Implement proper authentication and authorization checks to prevent unauthorized acce>
        }

        //general recommendation
        System.out.println("General Recommendation:- ");
        System.out.println("- Keep dependencies up to date to avoid known vulnerabilities.");
        System.out.println("- Implement proper error handling to avoid leaking sensitive informatin.");
        System.out.println("- Regularly perform security testing and code reviews.");
    }
}
 