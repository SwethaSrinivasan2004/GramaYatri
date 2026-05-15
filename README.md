<h1 align="center">🚍 Grama Yatri</h1>

### Smart Rural Mobility Assistance Application
Grama Yatri is an Android-based rural mobility application designed to improve transportation accessibility for people living in villages and semi-urban areas.
The application helps users access transport-related information, route details, and essential travel services through a simple and user-friendly interface.

### Problem Statement
Many rural commuters face difficulties such as:
1. Lack of reliable transport information
2. Difficulty accessing route details
3. Limited digital transportation support
4. Poor communication regarding travel updates
Grama Yatri aims to bridge this gap by providing a digital platform that enhances transportation accessibility and convenience.

### Features
1. Responsive and modern UI
2. Route and transport information display
3. Firebase Realtime Database integration
4. Smooth screen navigation
5. User-friendly mobile experience
6. Scalable application architecture

### Tech Stack Used
1. Kotlin -	Android Application Development
2. Android Studio - Development Environment
3. Firebase Realtime Database	- Data Storage
4. Jetpack Components - UI & Navigation
5. Git & GitHub - Version Control

### Application Workflow
1.	User opens the application
2.	User signs in 
3.	Application fetches transport-related data
4.	User navigates through available features
5.	Data is updated and managed using Firebase

### Screenshots
### Splash Screen
<img src="screenshots/splash_screen.jpg" width="200">

### Login Screen
<img src="screenshots/login_screen.jpg" width="200">

### Home Screen
<img src="screenshots/home_screen.jpg" width="200">

### Ping Bus 
<img src="screenshots/ping_bus.jpg" width="200">

### Activity Screen
<img src="screenshots/activity_screen.jpg" width="200">

### Alerts Screen
<img src="screenshots/alerts_screen.jpg" width="200">

### Installation Steps
1. Clone the Repository
git clone https://github.com/SwethaSrinivasan2004/GramaYatri.git

3. Open in Android Studio
 a. Open Android Studio
 b. Select "Open Project"
 c.	Choose the cloned folder

4. Firebase Setup
   a. Create a Firebase project
   b. Add Android app to Firebase
   c. Download google-services.json
   d. Place the file inside:  app/google-services.json
    
5. Run the Project
  a. Sync Gradle files
  b. Connect emulator or Android device
  c. Click Run

### Folder Structure
```text
GramaYatri/
│
├── .idea/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/gramayatri/
│   │       │   ├── components/
│   │       │   ├── data/
│   │       │   ├── models/
│   │       │   ├── navigation/
│   │       │   ├── screens/
│   │       │   ├── shared/
│   │       │   ├── ui/theme/
│   │       │   └── MainActivity.kt
│   │       │
│   │       ├── res/
│   │       │   ├── drawable/
│   │       │   ├── mipmap/
│   │       │   ├── values/
│   │       │   └── xml/
│   │       │
│   │       ├── AndroidManifest.xml
│   │       └── google-services.json
│   │
│   ├── build.gradle.kts
│   └── proguard-rules.pro
│
├── gradle/
├── screenshots/
├── .gitignore
├── README.md
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts
```
### Future Enhancements
1. Emergency support features
2. AI-based route suggestions
3. Multilingual support
4. Offline access support

### Conclusion
Grama Yatri is a step toward improving rural transportation accessibility through technology. The application demonstrates practical implementation of 
Android development, Firebase integration, and modern mobile application design principles.

