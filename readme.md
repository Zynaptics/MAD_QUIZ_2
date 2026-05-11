# Complaint Registration App

## Project Overview

The Complaint Registration App is an Android application that allows students to submit complaints to university administration. The app stores complaints in Firebase Firestore (cloud database) and displays them in an organized list with detailed views.

## Features Implemented

Core Features (All Working)

- Splash Screen - Shows app name for 2 seconds
- Complaint Form - Complete form with all required fields
- Input Validation - Checks all fields before submission
- 8 Categories - IT, Library, Transport, Hostel, Accounts, Examination, Cafeteria, Administration
- 4 Priority Levels - Low, Medium, High, Urgent
- Firebase Storage - Stores complaints in Firestore with "Pending" status
- Complaint List - RecyclerView showing all complaints
- Latest First - Newest complaints appear at top
- Empty Message - Shows "No complaints found" when list is empty
- Detail Screen - Click any complaint to see full details
- Back Navigation - Return to list from detail screen

## Project Structure


ComplaintApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/complaintapp/
│   │   │   │   ├── SplashActivity.kt
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── ComplaintListActivity.kt
│   │   │   │   ├── ComplaintDetailActivity.kt
│   │   │   │   ├── ComplaintAdapter.kt
│   │   │   │   └── Complaint.kt
│   │   │   └── res/
│   │   │       ├── layout/
│   │   │       │   ├── activity_splash.xml
│   │   │       │   ├── activity_main.xml
│   │   │       │   ├── activity_complaint_list.xml
│   │   │       │   ├── activity_complaint_detail.xml
│   │   │       │   └── item_complaint.xml
│   │   │       └── values/
│   │   │           ├── strings.xml
│   │   │           └── arrays.xml
│   │   └── google-services.json
│   └── build.gradle.kts
└── build.gradle.kts

## Technology Stack

- Language: Kotlin
- Database: Firebase Firestore
- UI Components: RecyclerView, CardView, Material Design
- Architecture: MVVM (Model-View-ViewModel)
- Dependencies: Firebase BoM, Coroutines

## Complaint Categories

1. IT - Internet, computer lab, software, or system issues
2. Library - Book, card, seating, or library service issues
3. Transport - Bus, route, timing, or driver-related issues
4. Hostel - Room, cleanliness, water, or maintenance issues
5. Accounts - Fee, challan, payment, or account issues
6. Examination - Roll number slip, marks, result, or exam-related issues
7. Cafeteria - Food quality, pricing, or service issues
8. Administration - General administrative complaints

## Priority Levels

- Low - Complaint is not urgent
- Medium - Complaint needs normal attention
- High - Complaint should be handled quickly
- Urgent - Complaint requires immediate action

## Setup Instructions

### Prerequisites

- Android Studio Hedgehog or newer
- Minimum SDK: API 24 (Android 7.0)
- Target SDK: API 34 (Android 14)
- Firebase account (free tier)

### Installation Steps

1. Clone or download the project
2. Open project in Android Studio
3. Create a Firebase project at console.firebase.google.com
4. Register Android app with package name: com.example.complaintapp
5. Download google-services.json and place in app folder
6. Enable Firestore Database in test mode
7. Sync Gradle files
8. Build and run the application

## How to Use

1. Submit a Complaint
   - Open the app (splash screen appears)
   - Fill in all fields: Student Name, Roll Number, Complaint Title, Category, Priority, Description
   - Click "Submit Complaint" button
   - Success message appears and form clears

2. View Complaints
   - Click "View Submitted Complaints" button
   - All complaints appear in a list (newest first)
   - Each card shows: Title, Student Name, Roll Number, Category, Priority

3. View Complaint Details
   - Click any complaint card
   - Detail screen shows complete complaint information
   - Includes: Title, Name, Roll No, Category, Priority, Description, Status, Date/Time
   - Click "Back" button to return to list

## Firebase Data Structure

Collection Name: complaints

Document Fields:
- studentName (String): Name of the student
- rollNumber (String): Student's roll number
- title (String): Complaint title
- category (String): Selected complaint category
- priority (String): Selected priority level
- description (String): Detailed complaint description
- status (String): Default "Pending"
- timestamp (Number): Unix timestamp in milliseconds

## Screenshots

(App includes)
- Splash Screen
- Complaint Registration Form
- Complaints List Screen
- Complaint Detail Screen

## Known Issues

None. All features are working as expected.

## Future Improvements

- Add user authentication with email/password
- Add image upload for complaint evidence
- Add push notifications for status updates
- Add complaint status update (In Progress, Resolved, Rejected)
- Add search and filter functionality
- Add offline support with Room database caching
- Export complaints to CSV/PDF
- Add admin panel for managing complaints

## Author

Student Name: Zainab Batool
Roll Number: 2024-CS-89/2023-CS-652
Course: Mobile Application Development
Date: May 11, 2026

## License

This project is submitted as part of academic requirements for Mobile Application Development course.

## Acknowledgments

- Firebase for cloud database services
- Android Material Design components
- JSONPlaceholder for API testing reference
