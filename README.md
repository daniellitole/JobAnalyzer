# JobAnalyzer

Application Description:
This application is called "Job Analyzer" and was created by Daniel Le in the summer of 2020 as a intern project. The purpose of this project is to allow his employer, Orange Coast Testing to track and produce control charts of jobs for the purposes of process improvement. These are the raw files that were then used to create a downloadable and executable application in a .exe format.

Features:
Upon opening, the user is greeted with a welcome message. After dismissing the message, the user is greeted with an input window. This window is where the user inputs their
job information, from start and end dates, to departments involved. For further details, click the "Help" button. Upon clicking the "Set Parameters" button, the user views a
window that allow them to generate a control chart based on filters/paramters. The user is able to filter by customer name, department, start and end date, and more. If fields
are left blank, these fields will not be used to filter data. Before generating the graph, the user has the option to save the graph as a .png file. Clicking "Generate Chart"
will show the user the generated contorl chart, complete with upper and lower control limits. For more information, click the "Help" button.

# Set Up Guide:

These instructions will help you to properly install your version of Job Analyzer. Please note, this appliciation may not make sense as it was create with a specific
user (Orange Coast Testing management staff) in mind. This repository is for demonstration purposes only.

Download Instructions:
1. Download the latest version of the Java Runtime Environment (JRE) at the following link: https://java.com/en/download/manual.jsp
   - Be sure to select the correct version for your system.
2. Download the latest version of the Java Development Kit (JDK) at the following link: https://www.oracle.com/java/technologies/javase-jdk15-downloads.html
   - Be sure to select the correct version for your system.
3. Download and unzip the JobAnalyzer repository (titled "JobAnalyzer-master") to a convinient location on your system.
4. Open the root folder in any IDE in a new Java project.
5. Add the correct libraries to the libraries section in the project (this process is slightly different for every IDE, detailed below are the instructions for NETBEANS and VSCode)
   - NETBEANS Instructions
      - On the left side of the screen, click the "Projects" tab
      - Expand the "ORANGE_COAST_TESTING_APP" project
      - Scroll down to the "Libraries" folder, most likely near the bottom
      - Right click on the "Libraries" folder and click "Add JAR/Folder..."
      - Navigate to JobAnalyzer-master/dist/lib/jfreechart-1.0.19.jar and click open
      - Right click on the "Libraries" folder and click "Add JAR/Folder..."
      - Navigate to JobAnalyzer-master/dist/lib/jcommon-1.0.23.jar and click open
   - VSCode Instructions
      - Click "File" in the toolbar at the top and click "Open Folder..."
      - Select the "JobAnalyzer-master" folder
      - If prompted to, install all of the recommended Java extensions for VSCode
      - In the Explorer overlay, expand the "Java Projects" section
      - Expand the JobAnalyzer-master project and scroll down to the "Referenced Libraries" tab
      - Click the "+" button next to the "Referenced Libraries"
      - Navigate to JobAnalyzer-master/dist/lib/jfreechart-1.0.19.jar and press enter
      - Click the "+" button next to the "Referenced Libraries"
      - Navigate to JobAnalyzer-master/dist/lib/jcommon-1.0.23.jar and press enter
6. All errors should have disappeared.

Start Up Instructions:
1. Run the program (as stated above, this is slightly different for every IDE, detailed below are the instructions for NETBEANS and VSCode)
   - NETBEANS Instructions
      - On the left side of the screen, click on the "ORANGE_COAST_TESTING_APP" project
      - At the top of the screen, select the "Run Project" icon, is shaped like a green play button
   - VSCode Instructions
      - In the Explorer overlay, nagivate to JobAnalyzer-master/src/orangeCoastTestingPackage/openingWindow.java
      - Click the run button located near the top-right of the window, should look like a play button
2. Upon running you will be greeted with a welcome message
3. After dismissing the welcome message, you will see a data input page
   - Before attempting to access other features of the application, be sure to input some dummy information. This is not needed when this application is being used in its
       intended situation, but due to confidentiality reasons, the .txt file storing the information had to be omitted from this repository
4. For questions regarding this application's capabilities, see the application description above.
