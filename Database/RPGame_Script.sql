#create database RPGame;
use RPGame;
#CREATE USER bent IDENTIFIED BY 'bentpw';
#grant usage on *.* to bent@localhost identified by 'bentpw';
#grant all privileges on RPGame to bent@localhost;
#GRANT ALL privileges ON RPGame.* TO bent@localhost;
#create table items (id int, name varChar(20), class varChar(20), rLevel int, str int , dex int, intel int,
#			AtkDmg int, SpellDmg int, rStr int, rDex int, rInt int, quality int);
#show tables;
select * from items;
#INSERT INTO items values (5, 'test', 'test', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
#select * from items;
#delete from items;