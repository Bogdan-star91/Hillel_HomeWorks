HW24

Сделать JDBC подключение к БД, DDL которой были созданы в предыдущем ДЗ
написать методы которые будут
добавлять и удалять сущность Student

получать всех студентов, -> List<Student> getAll();
получать всех студентов по имени, -> List<Student> getByName(String name);
получать всех студентов по айди -> List<Student> getByIds(List<Integer> ids);

+ написать Юнит Тесты для этих методов (кто хочет)

StudentService {} - interface
|
StudentServiceImpl {} - class - Unit Test
|
DBService{} (3 или 5) - integration test - mock(getAll())
|
DB