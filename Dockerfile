# Используем многоступенчатую сборку (multi-stage build)

# ---- Стадия 1: Сборка приложения ----
FROM maven:3.8-openjdk-17 AS builder

# Создаем директорию для сборки
WORKDIR /build

# Проверяем доступность GitHub и клонируем
RUN git clone -v -b master  https://github.com/gaginUriy/DateBasePetsCrudApp .

# Собираем WAR файл (скачиваем зависимости и компилируем)
RUN mvn clean package -DskipTests && \
    echo "Собранные файлы:" && \
    ls -la target/

# ---- Стадия 2: Финальный образ с Tomcat ----
FROM tomcat:9.0-jdk17-openjdk-slim

# Удаляем стандартные приложения Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Копируем WAR файл из стадии сборки в папку webapps Tomcat
COPY --from=builder /build/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Открываем порт Tomcat
EXPOSE 8080

# Запускаем Tomcat
CMD ["catalina.sh", "run"]