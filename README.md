# Movie App
- Popular movies
- Search movies
- Movies Detail
## Features 

- Kotlin 
- Clean Architecture
- Jetpack Compose
- Hilt Dependency Injection
- Coroutines flow
- Retrofit Coil
## API Reference 

The app uses the [TMDB](https://developer.themoviedb.org/reference/intro/getting-started) 

## Screenshoots
| Splash | Home | Search | Detail | 
| ------ | ---- | ---- | ---- | 
|<img src="https://i.imgur.com/jqQQ3zO.png" width="250" height="500"/>|<img src="https://i.imgur.com/f75BxRw.gif" width="250" height="500"/>|<img src="https://i.imgur.com/F4ZckCx.gif" width="250" height="500"/>|<img src="https://i.imgur.com/NjSq9xi.png" width="250" height="500"/>|


</br>






## Getting Started 🚀

To run the Movie App locally, follow these steps:

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.

## What used in project?
- Only [Kotlin](https://kotlinlang.org/) based
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture)
  - [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) to manage composable transactions.
  - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - unique lifecycle in Jetpack Compose
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [Repository](https://developer.android.com/topic/architecture/data-layer) - Located in data layer that contains application data and business logic.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - is Android’s next generation and recommended modern toolkit for building native UI with declaritive style. It makes development UI simpler and more understandable on Android.
- [Android Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for async. operations.
- [Coil Compose](https://coil-kt.github.io/coil/compose/) to load image what comes from API.
- [Material Design 3](https://m3.material.io/) is the latest version of Google’s open-source design system.

## License ℹ️
MIT License
```
Copyright (c) 2024 Ismail Fatih Birak

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

