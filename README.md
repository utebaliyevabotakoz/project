<h2 align="center"> Проект по автоматизации тестирования мобильной версии сайта wikipedia.org </h2>
<p  align="center">
<img src="images/screens/wiki.PNG">

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
+ [Интеграция с Jira](#Интеграция-с-Jira)
+ [Видео запуска тестов](#Видео-запуска-тестов)



# <a name="Описание">Описание</a>
Проект состоит из автотестов для Android (BrowserStack, Android Studio) и iOS (BrowserStack).
Краткий список интересных фактов о проекте:
- [x] Параметризованные тесты: 'android' - запускается в BrowserStack, 'ios' - запускается в BrowserStack, 'mobile' - запускается в Android Studio
- [x] Различные файлы конфигурации для запуска теста в зависимости от параметров сборки
- [x] Конфигурация с библиотекой `Owner`
- [x] Интеграция с `Allure TestOps`
- [x] Автотесты как тестовая документация
- [x] Интеграция с `Jira`
- [x] Уведомления в Telegram


# <a name="Технологии и инструменты">Технологии и инструменты</a>
<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="./images/icons/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="./images/icons/java-logo.svg"></code>
  <code><img width="5%" title="Selenide" src="./images/icons/selenide-logo.svg"></code>
  <code><img width="5%" title="Selenoid" src="./images/icons/selenoid-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="./images/icons/gradle-logo.svg"></code>
  <code><img width="5%" title="JUnit5" src="./images/icons/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="./images/icons/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="./images/icons/allure-ee-logo.svg"></code>
  <code><img width="5%" title="Github" src="./images/icons/git-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="./images/icons/jenkins-logo.svg"></code>
  <code><img width="5%" title="Jira" src="./images/icons/jira-logo.svg"></code>
  <code><img width="5%" title="Telegram" src="./images/icons/Telegram.svg"></code>
  <code><img width="5%" title="Browserstack" src="./images/icons/browserstack.svg"></code>
  <code><img width="5%" title="Android Studio" src="https://upload.wikimedia.org/wikipedia/commons/9/95/Android_Studio_Icon_3.6.svg"></code>
  <code><img width="5%" title="Appium" src="./images/icons/appium.svg"></code>
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

Для запуска локально и в Jenkins используется следующая команда::
```bash
gradle clean
${deviceHost}
-DdeviceHost="${deviceHost}"
```

`deviceHost` - определяет среду для запуска этих тестов:
>- *android - запускается автотест для Android в BrowserStack*
>- *ios - запускается автотест для iOS в BrowserStack*
>- *mobile - запускается автотест для Android в Android Studio*
 

Дополнительные свойства извлекаются из соответствующего файла конфигурации (в зависимости от значения `runIn`):
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
