<h2 align="center"> Проект по автоматизации тестирования мобильной версии сайта wikipedia.org </h2>
<p  align="center">
<img src="images/logo/wiki.PNG">

</p>


# <a name="Содержание">Содержание</a>
+ [Описание](#Описание)
+ [Технологии и инструменты](#Технологии-и-инструменты)
+ [Варианты запуска](#Варианты-запуска)
    + [Команды для gradle](#команды-для-gradle)
    + [Запуск в Jenkins](#запуск-в-jenkins)
+ [Telegram уведомления](#Telegram-уведомления)
+ [Результаты тестов в Allure Report](#Результаты-тестов-в-Allure-Report)
+ [Интеграция с Allure TestOps](#Интеграция-с-Allure-TestOps)
+ [Видео запуска тестов](#Видео-запуска-тестов)



# <a name="Описание">Описание</a>
Проект состоит из автотестов для Android (BrowserStack, Android Studio) и iOS (BrowserStack).
Краткий список интересных фактов о проекте:
- [x] Параметризованные тесты: 'android' - запускается в BrowserStack, 'ios' - запускается в BrowserStack, 'mobile' - запускается в Android Studio
- [x] Различные файлы конфигурации для запуска теста в зависимости от параметров сборки
- [x] Конфигурация с библиотекой `Owner`
- [x] Интеграция с `Allure TestOps`
- [x] Автотесты как тестовая документация
- [x] Уведомления в Telegram


# <a name="Технологии и инструменты">Технологии и инструменты</a>
<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="./images/logo/Idea.svg"></code>
  <code><img width="5%" title="Java" src="./images/logo/Java.svg"></code>
  <code><img width="5%" title="Selenide" src="./images/logo/Selenide.svg"></code>
  <code><img width="5%" title="Gradle" src="./images/logo/Gradle.svg"></code>
  <code><img width="5%" title="JUnit5" src="./images/logo/Junit5.svg"></code>
  <code><img width="5%" title="Allure Report" src="./images/logo/Allure.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="./images/logo/TestOps.svg"></code>
  <code><img width="5%" title="Github" src="./images/logo/GitHub.svg"></code>
  <code><img width="5%" title="Jenkins" src="./images/logo/Jenkins.svg"></code>
  <code><img width="5%" title="Telegram" src="./images/logo/Telegram.svg"></code>
  <code><img width="5%" title="Browserstack" src="./images/logo/browserstack.svg"></code>
  <code><img width="5%" title="Appium-Inspector" src="./images/logo/appium-inspector.png"></code>
  <code><img width="5%" title="Android Studio" src="./images/logo/AndroidStudio.svg"></code>
  <code><img width="5%" title="Appium" src="./images/logo/appium.svg"></code>
</p>


`Java` - язык программирования автотестов \
`Selenide` - фреймворк, на котором написаны автотесты \
`Gradle` - инструмент автоматической сборки  \
`JUnit5` - фреймворк тестирования \
`Jenkins` - CI/CD для запуска тестов \
`Selenoid` - для удаленного запуска браузера в `Docker` контейнерах \
`Browserstack` - для запуска мобильных тестов удаленно.\
`Android Studio`, `Appium` - для запуска мобильных тестов локально на эмуляторе мобильных устройств.\
`Allure Report` - для построения графических отчетов \
`Telegram Bot` - для уведомлений о результатах тестирования в телеграм бот\
`Allure TestOps` - как система управления тестированием

[Вернуться к оглавлению ⬆](#Содержание)

# <a name="Варианты запуска">Варианты запуска</a>

## <a name="GradleCommand">Команды для Gradle</a>

Для запуска локально и в Jenkins используется следующая команда:
```bash
gradle clean
${deviceHost}
-DdeviceHost="${deviceHost}"
```

`deviceHost` - определяет среду для запуска этих тестов:
>- *android - запускается автотест для Android в BrowserStack*
>- *ios - запускается автотест для iOS в BrowserStack*
>- *mobile - запускается автотест для Android в Android Studio*
 

Дополнительные свойства извлекаются из соответствующего файла конфигурации (в зависимости от значения `deviceHost`):
```bash
./resources/${deviceHost}.properties
```

Допустимые комбинации:
```mermaid
graph LR
A[deviceHost] --> B[android]
A --> C[ios]
A --> D[mobile]
B --> K[BrowserStack]
C --> E[BrowserStack]
D --> G[Android Studio]
```

[Вернуться к оглавлению ⬆](#Содержание)

## <a name="Запуск в Jenkins">Запуск в [Jenkins](https://jenkins.autotests.cloud/job/utebaliyevabotakoz_project_mobile/)</a>


Сборка с параметрами в Jenkins запускается с необходимым ***deviceHost***:

<p  align="center"> <img src="images/screens/JenkinsMain.png" width="950"> </p>



Главная страница проекта:
<p  align="center">
<img src="images/screens/JenkinsHistory.PNG" width="950">
</p>


Результат сборки проекта доступен в:
>- <code><strong>*Allure Report*</strong></code>
>- <code><strong>*Telegram bot*</strong></code>
>- <code><strong>*Allure TestOps*</strong></code>


[Вернуться к оглавлению ⬆](#Содержание)


## <a name="Telegram">[Уведомление в Telegram о результатах прогона тестов](https://t.me/Qa_botakoz_bot)</a>

Telegram-бот Autotests bot отправляет графический отчет каждой сборки.
<p  align="center"> <img src="images/screens/Telegram1.PNG" width="650"></p>



# <a name="AllureReport">Результаты тестов в [Allure Report](https://jenkins.autotests.cloud/job/utebaliyevabotakoz_project_mobile/allure/allure)</a>

## Главное окно


<p align="center">
  <img src="images/screens/Allure1.PNG" width="950">
</p>

##  Тесты

<p align="center">
  <img src="images/screens/Allure2.PNG" width="950">
</p>

<p align="center">
  <img src="images/screens/Allure3.PNG" width="950">
</p>


##  Графики

<p align="center">
  <img src="images/screens/Allure4.PNG" width="950">
</p>

<p align="center">
  <img src="images/screens/Allure5.PNG" width="950">
</p>

<p align="center">
  <img src="images/screens/Allure6.PNG" width="950">
</p>


[Вернуться к оглавлению ⬆](#Содержание)

# <a>Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/20439/tree?treeId=0)</a>


## Allure TestOps Dashboard

<p align="center">
  <img src="images/screens/Testopps1.PNG" width="950">
</p>

## Allure TestOps Test Cases

<p align="center">
  <img src="images/screens/Testopps2.PNG" width="950">
</p>

<p align="center">
  <img src="images/screens/Testopps3.PNG" width="950">
</p>

<p align="center">
  <img src="images/screens/Testopps4.PNG" width="950">
</p>

[Вернуться к оглавлению ⬆](#Содержание)


# <a>Пример видео прохождения теста в Browserstack</a>

<p align="center">
  <img src="images/video/android.gif" >
</p>

[Вернуться к оглавлению ⬆](#Содержание)
