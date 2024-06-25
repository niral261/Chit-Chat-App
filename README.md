# Chit-Chat-App
Chat App

# Description

This is a mobile chat application developed for Android using XML for frontend layout, Firebase for authentication and cloud storage, and Java for backend logic. The app allows users to authenticate via mobile number, receive OTP for verification, set a username, and engage in real-time messaging with other users.

# Features

•	Mobile Number Authentication:

  o	Authenticate using a mobile number.

  o	Receive OTP (One-Time Password) for verification.

  o	Set username after successful verification.

•	Real-time Messaging:

  o	Send text messages instantly to other users.

  o	View real-time updates for incoming messages.

  o	Display sender information and timestamps.

•	Profile Management:

  o	Update user profile information.
    
  o	Change profile picture using Firebase storage.

•	Additional Features:

  o	Error handling and validation for user inputs.
    
  o	Integration with Firebase Firestore for storing chat messages.
    
  o	Firebase Authentication for secure user authentication.


# Technologies Used

•	Frontend: XML for layout design.

•	Backend: Java for implementing business logic and Firebase SDK integration.

•	Database: Firebase Firestore for real-time database storage.

•	Authentication: Firebase Authentication for secure user authentication.

•	Storage: Firebase Storage for storing user profile pictures.


# Installation Instructions

1.	Clone Repository:

    git clone https://github.com/niral261/Chit-Chat-App

2.	Open Project in Android Studio:

  o	Launch Android Studio.
    
  o	Select "Open an existing Android Studio project."
    
  o	Navigate to the cloned repository and select the project directory.

3.	Set Up Firebase:

  o	Create a Firebase project at Firebase Console.
    
  o	Add an Android app to your Firebase project (package name should match your Android project).
    
  o	Download google-services.json and place it in the app/ directory of your Android project.
    
  o	Enable Firebase Authentication and Firebase Firestore in your Firebase project.

4.	Build and Run:

  o	Build and run the app on an Android emulator or a physical device connected via USB.


# Usage

•	Mobile Number Authentication:

  o	Open the app and enter your mobile number to receive an OTP.
    
  o	Enter the OTP received via SMS for verification.
    
  o	Set a username to complete account creation.

•	Chatting:

  o	In the chat interface, enter text in the message box at the bottom.
    
  o	Click "Send" to send the message to the recipient.
    
  o	Incoming messages will be displayed in real-time.

•	Profile Management:

  o	Click on your profile to update information or change your profile picture.

•	Logout:

  o	Click on the logout option in the menu to sign out of the app.


# Screenshots
![image](https://github.com/niral261/Chit-Chat-App/assets/102373223/98f351cf-6a68-4d63-9193-faf24118b83f)![image](https://github.com/niral261/Chit-Chat-App/assets/102373223/db4fc0f5-177d-4de3-8865-7ce1b4f94d4e)![image](https://github.com/niral261/Chit-Chat-App/assets/102373223/bf5677c5-e28f-4761-b68d-d40ab007875c)


# Contributing

•	Contributions are welcome! If you'd like to contribute to this project, please fork the repository and submit a pull request with your changes.


# License

•	This project is licensed under the MIT License.

