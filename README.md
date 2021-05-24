# VoiceAssistant
1. Голосовой помощник "Аврора"
2. Идея проекта: Каждый день студент открывает десятки приложений и файлов, например Google, чтобы найти какую-то информацию в интернете, карты метро, чтобы спланировать свою поездку или смотрит погоду, чтобы одеться по погоде. Идея была сделать удобный голосовой помощник "Аврора", который бы отвечал всем этим запросам.
3. Чтобы запустить проект нужно скачать его APK файл из GitHub и запустить в Android Studio. Приложение будет работать на AVD Android Studio либо через APK файл.
4. minSdkVersion приложения 22, compileSdkVersion приложения 30.
5. Приложения работает таким образом: после вступительных анимаций на экране пользователя появлять кнопка со значком микрофона. 
<img width="412" alt="Screenshot 2021-05-23 at 21 52 03" src="https://user-images.githubusercontent.com/43888378/119273939-f246e680-bc15-11eb-85c5-991508027eb0.png">

Пользователь нажимает на микрофон и говорит команду. ВАЖНО! Телефон должен быть подключен к интернету. 

<img width="410" alt="Screenshot 2021-05-23 at 21 52 31" src="https://user-images.githubusercontent.com/43888378/119273977-36d28200-bc16-11eb-88ed-3248178e837f.png">

На данный момент работают несколько команд: "Google", "Открой Google", "Открой страницу Google", "Какая сейчас погода", "Какая погода сейчас", "Покажи карту метро". Если пользователь скажет одну из этих команд, то приложение сделает то или иное. В противном случае, если команда будет другая, пользователь услышит "This command i don't know".
