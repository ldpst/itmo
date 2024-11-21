<h1>Лабораторная работа №1 по программированию</h1>
<div align="center"><img alt="rey on table" src="https://github.com/ldpst/itmo/blob/main/.data/rei-ayanami-rei-table.gif" style="width:700; height:auto;"></img></div>
<h2>Задание</h2>
<a href="https://github.com/ldpst/itmo/blob/main/sem-1-2_prog/labs/lab1/%D0%9B%D0%A01%20%D0%9F%D0%A0%D0%9E%D0%93%20%D0%97%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5.png">ЛР1 ПРОГ Задание</a>
<h2>Как сделать jar файл</h2>
Запускайте файл build.sh в терминале (с помощью ./build.sh). После этого команды, записанные в этом файле, последовательно выполнятся.
<h3>Подробнее по каждой команде:</h3>
javac Main.java - компилирует (создает файл Main.class)<br>
echo -e 'Main-Class: Main' > MANIFEST.mf - создает файл МАНИФЕСТ и вводит в него имя главного класса (в моем случае Main)<br>
jar -cmf MANIFEST.mf Main.jar . - использует МАНИФЕСТ для создания Main.jar, используя все классы в текущем каталоге (текущий каталог обозначается .)<br>
<br>
Для запуска используйте java -jar Main.jar
<h2>Примечание</h2>
Ничего сложного: почитать про Math, разобраться с jar файлом
