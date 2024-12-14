create database CinemaDB;
use CinemaDB;

create table filmes(
   id int auto_increment primary key,
   titulo varchar(100) not null,
   genero varchar(45) not null,
   ano_lancamento int not null,
   sinopse varchar(1000) not null
);

create table analises(
   id int auto_increment primary key,
   analise varchar(1000) not null,
   nota int not null,
   id_filme int not null,
   foreign key (id_filme) references filmes (id)
);

select*from filmes;
select*from analises;


SELECT f.id, f.titulo, f.titulo, f.genero, f.sinopse, a.analise, a.nota, a.id
FROM filmes f 
INNER JOIN analises a ON a.id_filme = f.id WHERE f.id=102;


