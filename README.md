GPA and CGPA Calculator
Project Overview :

The GPA and CGPA Calculator is a Java-based command-line tool designed to help university students manually calculate their semester Grade Point Average    (GPA) and overall Cumulative Grade Point Average (CGPA). Due to complex evaluation structures like relative grading, course credits, and non-graded/pass- fail   subjects, manual calculations can be confusing and error-prone. 
 This project automates the calculation process by taking inputs such as subject names, credits, types, and marks/grades, computing precise GPAs per semester,  and maintaining an updated running CGPA rounded to two decimal places.
Features :
Multi-Semester Calculations: 
 Allows continuous tracking of performance across multiple academic semesters.   
Course Type Support: 
 Accommodates both standard Graded courses and Non-Graded / Pass-Fail subjects. 
Relative Grading Logic:
 Incorporates class average and standard deviation rules to map marks directly into relative grades. 
Interactive Validation: 
Built-in error handling prevents invalid entries (such as marks over 100 or non-numeric entries) and prompts for re-entry. 
Detailed Terminal Summary: 
 Displays course credit points, total graded vs. non-graded credits, semester GPAs, and cumulative CGPA.   
Technologies & Tools Used
Programming Language: Java   
Development Environment (IDE): Visual Studio Code (VS Code)   Data Management: In-memory session data storage  
Steps to Install & Run the Project
Prerequisites
Ensure that Java Development Kit (JDK 8 or higher) is installed on your computer and configured in your system path.   
Execution Steps
Clone the repository:Download or clone the code repository to your local machine:git clone [https://github.com/YOUR_USERNAME/GPA-CGPA-Calculator.git](https://github.com/YOUR_USERNAME/GPA-CGPA-Calculator.git)
Navigate to the directory:cd GPA-CGPA-Calculator
Compile the source code:javac GPA_CGPA_Calculator.java
Run the program:java GPA_CGPA_Calculator
Instructions for Testing
Unit Testing: Input known mock dataset values to verify whether output GPAs match expected results. 
Boundary Testing: Enter extreme value cases, such as 0% attendance, maximum performance (S grade), or minimum passing thresholds. 
Error Handling Check: Intentionally enter invalid inputs (e.g., text instead of numbers, non-existent grades, or negative numbers) to verify that the validation error messages trigger correctly.
Multi-Semester Flow: Add 2 or more semesters in a single session to ensure the overall CGPA updates correctly as new credits are added
