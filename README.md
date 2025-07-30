
# Android(Kotlin) Weather App using MVVM Architecture (ViewModel + LiveData + Kotlin + volley)

## Introduction
 - MVVM Architecture is one of the most popular and latest architecture to develop a maintanable and managable codebase.
 - Weather App is an Android App build with MVVM Architecture using Kotlin language and Volley network calling library.
 - The app shows your current location, and a list of cities showing current temperature of the city. (I used a total of 20 cities to display on the recycler view).
 - When a city is clicked, it will direct user to detailed fragment whereby user will be able to see the current weather state 
 (Shown in the screenshots below) of the city and forecast of the next 6 days. User can add city to his/her favorite lists.
 - To add a city to favorite list, User will have to create an account so that data will not be lost if app is uninstalled or data is cleared.

Still in Active Development.

## Screenshots
<img src="https://github.com/SteveMugo/WeatherApp-Kotlin-/blob/main/screenshots/favorite-screenshot-1.png"
data-canonical-src="https://github.com/SteveMugo/WeatherApp-Kotlin-/blob/main/screenshots/favorite-screenshot-1.png"
width="220" height="450" />
<img src="https://github.com/SteveMugo/WeatherApp-Kotlin-/blob/main/screenshots/screenshot-3.jpeg"
data-canonical-src="https://github.com/SteveMugo/WeatherApp-Kotlin-/blob/main/screenshots/screenshot-3.jpeg"
width="220" height="450" />
<img src="https://github.com/SteveMugo/WeatherApp-Kotlin-/blob/main/screenshots/screenshot-4.jpeg"
data-canonical-src="https://github.com/SteveMugo/WeatherApp-Kotlin-/blob/main/screenshots/screenshot-4.jpeg"
width="220" height="450" />
<img src="https://github.com/SteveMugo/WeatherApp-Kotlin-/blob/main/screenshots/screenshot-5.jpeg"
data-canonical-src="https://github.com/SteveMugo/WeatherApp-Kotlin-/blob/main/screenshots/screenshot-5.jpeg"
width="220" height="450" />
<img src="https://github.com/SteveMugo/WeatherApp-Kotlin-/blob/main/screenshots/screenshot-6.jpeg"
data-canonical-src="https://github.com/SteveMugo/WeatherApp-Kotlin-/blob/main/screenshots/screenshot-6.jpeg"
width="220" height="450" />
       
## Running the project
 - Sync the Gradle and run the project. Install APK on your emulator or real device.
 - Turn on the internet of your testing device. For better understanding, please read the comments on the methods.
 - Hope, these comments will help you to feel the MVVM Architecture.

## Architecture
The app uses MVVM [Model-View-ViewModel] architecture to have a unidirectional flow of data, separation of concern, testability, and a lot more.

![Architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

## Libraries and tools 🛠
<li><a href="https://developer.android.com/topic/libraries/architecture/navigation/">Navigation</a></li>
<li><a href="https://developer.android.com/training/data-storage/shared-preferences">Shared Preferences</a></li>
<li><a href="https://developer.android.com/topic/libraries/architecture/viewmodel">ViewModel</a></li>
<li><a href="https://developer.android.com/topic/libraries/architecture/livedata">LiveData</a></li>

## TODO & Discalimer
 - There are some other ways of implementation of MVVM, using MVC, MVP, I chose MVVM as it best showcased the assignment implementation.
 - For example MVVM can be used with Rx and Dagger. But it's not mandatory to use Rx or Dagger in MVVM. 
 - Implementation to register on the application via Google SignIn/ Signup
 - Resolve Firebase issue currently for saving data in database (sqlite or Boom)
 - Deeper implementation of using Dependency Injection
 - Complete Unit Tests & Integration Tests


## License
```
MIT License

```
