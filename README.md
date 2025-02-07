# ADT_PROGRAMMING_assignments_2
# TextAnalyzer

TextAnalyzer is a Java program designed to analyze a text file by computing various statistics. The program reads the file provided as a command-line argument and produces output that includes the total character count, number of palindromes, token count, emoticon count, newline count, longest token, average token size, and the execution time.

## Features

- **File Input from Command-Line:**  
  Reads the input file name from a command-line argument.
  
- **Character Count:**  
  Computes the total number of characters in the file (excluding newline characters unless part of the line).

- **Tokenization:**  
  Splits the text into tokens based on whitespace.

- **Palindrome Detection:**  
  Identifies tokens that are palindromes (ignoring punctuation and case).

- **Emoticon Recognition:**  
  Checks tokens against a predefined list of common emoticons.

- **Longest Token:**  
  Determines the longest token encountered in the file.

- **Average Token Size:**  
  Calculates the average length of all tokens.

- **Execution Time:**  
  Measures and reports the total execution time of the program.

## Prerequisites

- **Java Development Kit (JDK):**  
  Version 8 or higher is required to compile and run the program.
  
- **Input File:**  
  A text file (e.g., `input.txt`) containing the data to be analyzed.

## How to Compile and Run

1. **Compile the program:**

   Open your terminal or command prompt, navigate to the project directory, and run:

   ```bash
   javac TextAnalyzer.java
