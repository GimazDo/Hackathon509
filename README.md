<p align="center">
    <h1 align="center">Серверная часть</h1>
    </p>
    <p align="justify">Данный репозиторий содержит серверную часть проекта, которая обеспечивает работу клиент-приложения.</p>  
  <p align="justify"> Репозиторий клиент-приложения: https://github.com/uselesss/object-front/</p>


<h2>Функциональность</h2>
 <p align="justify">С помощью ORM создана база данных, которая хранит данные пользователей и информацию о лотах.</p>
 ![](https://github.com/GimazDo/Hackathon509/raw/master/images/db.png)

<h3>API<h3>
<p align="justify">Сервер имеет API через который происходит взаимодействие с фронтом. Реализованы следующие функции:</p>
<ul>
  <li>Авторизаций/Регистрация с JWT токеном</li>
	<li>Добавление/Получение лотов</li>
  <li>Добавление/Получение аукционов</li>
  <li>Добавление ставок</li>
  <li></li>
</ul>
<p align="justify">Реализована отправка электронного письма при наличии задолженности. Сервер взаимодействует со Smart-констрактом.</p>
<h2>Основной стек технологий:</h2>
<ul>
  <li>Java + Spring</li>
	<li>MySQL</li>
</ul>


<h2>Среда запуска</h2>

1) Развертывание сервиса производится на debian-like linux (debian 9+);
2) Требуется установленная JVM;
3) Требуется установленная СУБД Mysql (версия 8+);
4) Требуется установденный Maven


<h2>Установка</h4>


<h3>База данных</h3>
<p align = "justify">

~~~
sudo apt-get install mysql-server
sudo systemctl restart mysql
sudo mysql_secure_installation
mysql -u root -p
qort0408
CREATE DATABASE mydb;
quit
~~~
<h3>Запуск проекта</h3>

Для запуска проекта перейди в директрорию проекта и выполнить команды:
~~~
mvn clean package spring-boot:repackage
pgrep java | xargs kill -9
cd /targer
nohup java -jar Hackathon509-1.0.jar > log.txt &
~~~
