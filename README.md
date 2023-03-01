<a href="https://vivalo.ru/">
    <![Vivalo logo](https://user-images.githubusercontent.com/118796374/222272725-b8a13150-3752-4c81-b5c7-5151429e2572.png) align="left">
</a>

## Проект для маркет-плейса Vivalo.ru

[VlVALO](https://vivalo.ru/) –  онлайн-платформа для размещения услуг от центров по развитию детей в адрес родителей, которые заинтересованы в дополнительном развития ребенка. Маркет- плейс позволяет бизнесу привлекать новых клиентов из смежной сферы.

![Главная страница](https://user-images.githubusercontent.com/118796374/222267483-ffab1ad2-4cec-4db3-80eb-66772f12e85d.png)

## :point_right: Проект в Allure TestOps с ручными и автотестами с результатами их прохождения.
<a target="_blank" href="(https://allure.autotests.cloud/project/1934/)">Проект в Allure TestOps</a>

В Allure TestOps хранится информация по всем ручным и автотестам проекта, по запускам сборок, а также отчет по пройденным сборкам.
![Отчет Allure](https://user-images.githubusercontent.com/118796374/222268191-c619f172-c62f-4252-a0a8-a129043ea13b.png)


## :point_right:  Jenkins job c Allure Report с результатами пройденной сборки.
<a target="_blank" href="https://jenkins.autotests.cloud/job/08-sub_ekt-lesson13/">Сборка в jenkins</a>
В Jenkins запускается сборка с параметрами:
* Браузер (Chrome, Opera, Firefox, Safari)
* Разрешение браузера (1920x1080)
* Версия браузера (Chrome: 99)
* Адрес удаленного браузера (selenoid.autotests.cloud/wd/hub/)
* Выбор, какие тесты нужно проходить
    * test - выполнение всех тестов
    * mainpagetest - выполнение тестов для главной страницы
    * b2btest - выполнение тестов для страницы Для бизнеса
    * catalogtest - выполнение тестов для страницы Каталог
    * filterstest - выполнение тестов для Фильтра
* Выбор опции параллельного прохождения тест-кейсов
* Выбор количества тест-кейсов для параллельного запуска

В Allure Report отображается вся информация по пройденной сборке

![Allure Report](https://user-images.githubusercontent.com/118796374/222269137-fdaf7582-5e68-461b-a04d-6f6c3f98ba76.png)


## :point_right:  Jira Task с ручными и автотестами с результатами их прохождения.
<a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-558">Задача в Jira c результатами автотестов</a>

![Jira](https://user-images.githubusercontent.com/118796374/222269318-d9cb68e8-627e-471e-abdc-7e4c5ae931ac.png)


## :point_right: Уведомления о прохождении тестов в Телеграмм :v:
Уведомления о прохождении тестов приходит в телеграмм канал.

![Телеграмм](https://user-images.githubusercontent.com/118796374/222269476-9e647423-8549-4592-9dfd-6078b556bf2a.png)


## :point_right: USAGE examples

### For run remote tests need fill remote.properties or to pass value:

* browser (default chrome)
* browserVersion (default 100.0)
* browserSize (default 2100x1080)
* remoteUrl (selenoid.autotests.cloud/wd/hub/)
* runTest (default test)
* parallelRun (default true)
* threadsNumber (default 1)

Run tests with filled remote.properties:
```bash
gradle clean test
```
Run certain test:
```bash
gradle clean mainpagetest
gradle clean b2btest
gradle clean catalogtest
gradle clean filterstest
```
Serve report:
```bash
allure serve build/allure-results
```

## :point_right: Пример прогона одного из тест-кейсов

https://user-images.githubusercontent.com/118796374/222274412-d926f875-0a2e-452b-ae0e-6a8628f90bd8.mp4


## :point_right: Языки и инструменты
<h3 align="left">Языки и инструменты, используемые в данном проекте </h3>

| IntelliJ IDEA | Java | Gradle | Junit5 | Selenide |
|:------:|:----:|:----:|:------:|:------:|
| <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Intelij_IDEA.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Java.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Gradle.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/JUnit5.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Selenide.png" width="40" height="40"> |

| GitHub | Jenkins | Selenoid | Allure Report | Allure TestOps | Telegram | Jira |
|:------:|:----:|:----:|:------:|:------:|:--------:|:------:|
| <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Github.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Jenkins.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Selenoid.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Allure_Report.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/AllureTestOps.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Telegram.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/bip-test/blob/master/img/logo/Jira.png" width="40" height="40"> |

:arrow_right:: <a target="_blank" href="https://github.com/murugka31">github.com/DachAnna</a><br/>

