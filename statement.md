Problem Statement
Students at universities like VIT often encounter challenges in manually calculating their semester Grade Point Average (GPA) and overall Cumulative Grade Point Average (CGPA). The evaluation framework involves relative grading systems, varying course credit weights, and diverse subject classifications—such as graded, non-graded, and pass/fail courses. Without instant automated platforms like VTOP available at all times, calculating academic performance manually becomes complex, time-consuming, and prone to human calculation errors.
Scope of the Project :
The GPA and CGPA Calculator is designed as a lightweight, terminal-based tool built using Java to streamline academic tracking. 
In Scope:
Calculation of semester-wise GPA based on course credits, grades, and grade points. 
Sequential multi-semester performance aggregation to display dynamic, running CGPAs rounded to two decimal places. 
Differentiation between standard graded subjects and non-graded/pass-fail subjects. 
Integration of relative grading parameters (such as class averages and standard deviation) to map marks to grades.  
Terminal-level user input validation to capture out-of-bound or incorrect entry types. 
Out of Scope:
Direct database integration with official university academic portals (e.g., VTOP API integration).
Graphical user interfaces (GUI) or mobile/web applications in the current version. 
Persistent local storage using SQL or JSON files (currently utilizes in-memory session processing).
Target Users :
Undergraduate & Postgraduate Students: Primary users looking to evaluate semester results or track cumulative progress without manual math.  
Academic Advisors & Mentors: Faculty members who need a quick tool to verify student grade distributions and predicted performance.
Peer Study Groups: Students assessing target grade scenarios across different course credit configurations.  
High-Level Features :
Interactive Command-Line Workflow: Guides users step-by-step through entering student metadata, semester counts, subject details, and credit distributions.   Flexible Course Classification: Allows selection between graded and non-graded / pass-fail subjects to compute accurate credit points. 
Relative Grade Mapping: Maps raw student scores into academic letter grades (S, A, B, C, D, E, F, N) using class statistical metrics.  
Robust Input Sanitization: Detects erroneous inputs—such as invalid options, text in numeric fields, or out-of-range values—and prompts for immediate correction.   
Comprehensive Performance Summaries: Outputs detailed breakdowns including credit points per course, total graded vs. non-graded credits, semester GPAs, and overall cumulative CGPA
