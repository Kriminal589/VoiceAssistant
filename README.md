# VoiceAssistant
1. Голосовой помощник "Аврора"
2. Идея проекта: Каждый день студент открывает десятки приложений и файлов, например Google, чтобы найти какую-то информацию в интернете, карты метро, чтобы спланировать свою поездку или смотрит погоду, чтобы одеться по погоде. Идея была сделать удобный голосовой помощник "Аврора", который бы отвечал всем этим запросам.
3. Чтобы запустить проект нужно скачать его APK файл из GitHub и запустить в Android Studio. Приложение будет работать на AVD Android Studio либо через APK файл.
4. minSdkVersion приложения 25, compileSdkVersion приложения 30.
5. Приложения работает таким образом: после вступительных анимаций на экране пользователя появлять кнопка со значком микрофон. ![alt text](Images for README/Screenshot 2021-05-23 at 21.52.03.png "Кнопка с микрофоном") Пользователь нажимает на микрофон и говорит команду. Важно! Телефон должен быть подключен к интернету. На данный момент работают несколько команд: "Google", "Открой Google", "Открой страницу Google", "Какая сейчас погода", "Какая погода сейчас", "Покажи карту метро". Если пользователь скажет одну из этих команд, то приложение сделает то или иное. В противном случае, если команда будет другая, пользователь услышит "This command i don't know".
