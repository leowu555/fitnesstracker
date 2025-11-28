# Fitness Tracker
## CPSC 210 Term Project
The personal project that I am going to design this term is a fitness tracker. 
The fitness tracker tracks the daily exercises that users complete in a day, such as how many steps or how many kilometers the user completes in a day, and it can log workouts with guided routines. It also allows users to record the daily fitness goals that the user aims for. Furthermore, it allows users to track their daily macro-nutrient consumption and allows users to set goals for *weight gain*, *weight loss*, *protein consumption*, and other nutrition goals. 

This fitness tracker is designed for beginners who wants to get into fitness and start tracking their fitness progress and 
have a clear idea of their fitness goals. It is also a great platform for anyone who wants a structured fitness plan.

I am interested in this project because I enjoy exercising and doing 
workouts to keep myself in shape. However, I tend to find myself struggling with tracking the exercises I need 
to complete, and the amount of protein I need to consume. Building this project helps people like me to have an
organized tracker that keeps everything in order and shows what exercise I need to complete to reach my physique goal.
## User Story

- As a user, I want to be able to add my workout to the list of workouts that I need to complete.
- As a user, I want to be able to view the list of workouts I need to complete.
- As a user, I want to be able to remove the workouts from list of workouts.
- As a user, I want to make today's workout as complete.
- As a user, I want to be able to edit or delete a planned workout routine.
- As a user, I want to set a nutrition goal.
- As a user, I want to be able to save my workout list to file.
- As a user, when I start the application, I want to be given the option to reload my to-do list from file and resume from where I left off.

# Instructions for End User

- You can view the panel that displays the workouts that have already been added to the workout list by clicking the button titled "View All" and look at the panel for the application titled "Workouts In Your List".
- You can generate the first required action related to the user story "adding multiple workouts to a workout list" by clicking "Add Workout" button at the top of the window.
- You can generate the second required action related to the user story "adding multiple workouts to the workout list" by clicking the "Show Completed" button that filters and displays only the workouts that are marked as completed.
- You can locate my visual component by clicking "View Graph" which displays a bar chart on the right of the panel with title: "Weekly Protein Intake Graph"
- You can save the state of my application by clicking the "Save" button located in the top of the panel.
- You can reload the state of my application by clicking the "Load" button in the top of the panel.

# Phase 4: Task 2

Thu Nov 27 22:39:08 PST 2025
Workout added: Push up

Thu Nov 27 22:39:16 PST 2025
Workout added: Pull up

Thu Nov 27 22:39:20 PST 2025
Workout marked as complete Push up

Thu Nov 27 22:39:22 PST 2025
Workout marked as complete Pull up

Thu Nov 27 22:39:29 PST 2025
Protein goal set to: 150 grams

Thu Nov 27 22:40:53 PST 2025
Logged 45g of protein for day 0

Thu Nov 27 22:41:17 PST 2025
Reset weekly protein intake log

# Phase 4: Task 3
The UML class diagram reflects the final structure of my application, it shows the relationships between the model package, the UI package, and persistence package. It uses the interface implementations and class associations to illustrate how each classes are connected and how to display the user interface.

If I had more time to work on the project, I would refactor some of the responsibilities from the FitnessApp and FitnessGUI class, because both classes handle a lot of tasks and have a lot of methods, I would refactor the functionalities that handle the protein tracking actions into a separate class to keep the UI code cleaner and easier to manage and debug. It would also make the app easier to improve and add additional functionalities.