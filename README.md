# Необходимо реализовать проект удовлетворяющий изученному материалу. Проект содержит интерфейсы, реализован с использованием MVP паттерна, удовлетворяет всем принципам SOLID. Проект может быть реализован на любом ООП языке (в том числе Java). Проект с записной книжкой. Идея в том, что пользователь может делать записи на различные дни (например в 19:00 стоматолог), читать записи, сохранять и загружать в файл, сортировать, искать записи на конкретный день или неделю.

Приложение должно быть консольным

## Объяснение кода:

MVP: Приложение разделено на модель (NotebookImpl), представление (NotebookViewImpl) и контроллер (NotebookPresenterImpl).

SRP: Каждый класс имеет одну ответственность (Note, Notebook, NotebookView, NotebookPresenter).

OCP: Классы открыты для расширения, но закрыты для модификации.

LSP: Дочерние классы могут заменять родительские классы без нарушений.

ISP: Интерфейсы определены только с необходимыми методами.

DIP: Классы зависят от абстракций, а не от конкретных реализаций.

Консольное приложение: Приложение взаимодействует с пользователем через консоль.

Записи: Пользователь может добавлять, удалять, просматривать и сортировать записи по дате и неделе.

Сохранение и загрузка: Приложение позволяет сохранять и загружать записи в файл.

##Запуск приложения:

Сохраните все файлы в одной директории.

Скомпилируйте файлы Java: javac *.java

Запустите приложение: java NotebookApp

##Пример работы:

В меню выберите “1. Добавить запись”.

Введите текст записи и дату.

В меню выберите “2. Просмотреть записи”.

Выберите режим просмотра “1. Все записи”.

В меню выберите “3. Сохранить записи”.

Введите путь к файлу для сохранения (например, “notes.dat”).

Запустите приложение снова.

В меню выберите “4. Загрузить записи”.

Введите путь к файлу с сохраненными записями (например, “notes.dat”).

Выберите режим просмотра “1. Все записи”.

Приложение загрузит сохраненные записи.
