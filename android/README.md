# 4-Score Fitness Android App

This directory contains the Android-specific code for the 4-Score Fitness application.

## Prerequisites

1. Android Studio (latest version)
2. JDK 11 or newer
3. Android SDK
4. Android Build Tools
5. Android Emulator or physical device for testing

## Setup Instructions

1. Install Android Studio from [https://developer.android.com/studio](https://developer.android.com/studio)
2. During installation, ensure you install:
   - Android SDK
   - Android SDK Platform
   - Android Virtual Device
   - Android Build Tools

3. Set up environment variables:
   ```bash
   ANDROID_HOME=C:\Users\USERNAME\AppData\Local\Android\Sdk
   PATH=%PATH%;%ANDROID_HOME%\tools;%ANDROID_HOME%\platform-tools
   ```

4. Open this project in Android Studio:
   - Open Android Studio
   - Select "Open an existing project"
   - Navigate to the `android` directory
   - Click OK

## Project Structure

```
android/
├── app/                    # Application module
│   ├── src/
│   │   ├── main/          # Main source set
│   │   ├── test/          # Unit tests
│   │   └── androidTest/   # Instrumentation tests
│   ├── build.gradle       # App-level build file
│   └── proguard-rules.pro # ProGuard rules
├── gradle/                # Gradle wrapper directory
├── build.gradle          # Project-level build file
└── settings.gradle       # Project settings
```

## Building the App

1. Open the project in Android Studio
2. Wait for Gradle sync to complete
3. Click "Build > Make Project"
4. To run on an emulator or device:
   - Click "Run > Run 'app'"
   - Select your target device
   - Click OK

## Development Guidelines

1. Follow Material Design 3 guidelines
2. Use Jetpack Compose for UI development
3. Implement MVVM architecture
4. Use Kotlin Coroutines for asynchronous operations
5. Follow clean architecture principles

## Key Android Features

- Material Design 3 theming
- Dark mode support
- Offline-first architecture
- Background sync
- Push notifications
- Biometric authentication
- Widget support
- Wear OS integration

## Testing

- Unit tests: `./gradlew test`
- Instrumentation tests: `./gradlew connectedAndroidTest`
- UI tests: `./gradlew executeScreenshotTests`
