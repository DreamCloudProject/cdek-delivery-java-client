# Java SDK для СДЭК [![stability][0]][1]

[![java version][2]][3] [![Spring Boot][4]][5]

## Официальная документация 
Ссылка на официальную документацию к Cdek-API на [сайте](https://api-docs.cdek.ru/29923741.html)

## Поддерживаемая версия Cdek-API
Данный SDK поддерживает протокол обмена данными Cdek версии 2.0 и выше.

## Возможности

#### 🔥 Управление заказами

>⭐️ Создание заказа.
>
>⭐️ Запрос информации о заказе.
>
>⭐️ Удаление заказа.

#### 🔥 Управление курьерской доставкой 

>⭐️ Создание заявки на курьерскую доставку.
>
>⭐️ Получение информации о заявке для доставки курьером.
>
>⭐️ Удаление заявки на курьерскую доставку.

#### 🔥 Создание квитанций для заказов

>⭐️ Формирование квитаций для заказов.
>
>⭐️ Получение квитанций к заказам.

#### 🔥 Генерация штрихкодов для заказов

>⭐️ Формирование штрихкод-места к заказу.
>
>⭐️ Получение штрихкод-места к заказу.

#### 🔥 Справочная информация

>⭐️ Запрос списка регионов.
>
>⭐️ Запрос списка городов.


## Установка и настройка

### Добавление зависимостей
Проект построен на основе Spring и Spring Boot компонентов

Добавить jitpack в качестве репозитория.
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Добавить зависимоть гит репозитория

```xml
<dependencies>
    <dependency>
        <groupId>com.github.DreamCloudProject</groupId>
        <artifactId>cdek-java-sdk</artifactId>
    </dependency>
</dependencies>
```

### Указание данных договора клиента Cdek

В папке resources вашего целевого Spring Boot приложения добавьте строчки, указанные ниже.

```yaml
client:
    id: 'yours_client_id' # Здесь указвается ваш уникальный идентификатор из договора
    secret: 'yours_client_secret' # Здесь указывается ваш секретный ключ из договора
```

[0]: https://img.shields.io/badge/stability-experemental-orange
[1]: https://nodejs.org/api/documentation.html#documentation_stability_index
[2]: https://img.shields.io/badge/java-11-blue
[3]: https://openjdk.java.net/projects/jdk/11/
[4]: https://img.shields.io/badge/Spring%20Boot-2.2.2.RELEASE-green
[5]: https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/html/
