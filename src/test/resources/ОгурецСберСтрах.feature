#language: ru


Функционал: Страхование

  Сценарий: Страхование выезжающих за рубеж

    Когда Выбран пункт меню "Страхование"
      И Выбран подпункт меню "Путешествия и покупки"
    Тогда Выполняем нажатие на кнопку - Оформить онлайн

    Когда Переходим на страницу "Страхование путешественников"
    Тогда Выбираем сумму страховки "Минимальная"
      И Нажимаем кнопку "Оформить" для перехода к заполнению полей

    Когда Заполняются поля
    |Фамилия застрахованного|IVANOV|
    |Имя застрахованного|IVAN|
    |Дата рождения застрахованного|01.01.2010|
    |Имя страхователя|Мария|
    |Фамилия страхователя|Петрова|
    |Отчество страхователя|Алексеевна|
    |Дата рождения страхователя|01.01.1990|
    |Серия паспорта страхователя|1234|
    |Номер паспорта страхователя|567890|
    |Дата выдачи паспорта страхователя|10.01.2010|
    |Место выдачи паспорта страхователя|Где-нибудь кем-то там|
    И Выбираем пол страхователя"Женский"
    Тогда Нажимаем на кнопку "Продолжить"
    И Проверяем наличие сообщения об ошибке на экране - "Заполнены не все обязательные поля"