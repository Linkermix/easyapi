Приложение easyapi:

запуск приложения: 
1. в командной строке выполняем команду: 
    java -version
Если вывод: "java version "17.0.7" 2023-04-18 LTS" то идем к шагу 2. Если джава другая или ее нет устанавливаем 
соответствующую версию и прописываем переменные окружения.

2. в командной строке переходим в папку с приложением: cd ./easyapi

3. gradlew clean

4. gradlew build

5. gradlew run

6. апи будет доступно по адресу: http://localhost:8080/easyapi/

7. документация по адресу: http://localhost:8080/easyapi/swagger
