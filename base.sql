create database db_feriado;

use db_feriado;

create table tbl_usuario(
   id_usuario  integer not null auto_increment,
   nome_usuario varchar(100) not null,
   racf         varchar(7)   not null unique,
   funcional    varchar(9)   not null unique,
   email        varchar(80)  not null unique,
   senha        varchar(20)  not null,
   link_foto    varchar(255),
   
   constraint pk_usuario primary key(id_usuario)
);

create table itmn330_agencia (
  id_agencia     integer not null auto_increment,
  numero_agencia integer not null unique,
  nome_agencia   varchar(100),
  
  constraint pk_agencia primary key (id_agencia)
);

create table itmn330_feriado(
    id_feriado integer not null auto_increment,
    nome_feriado varchar(50),
    data_inicio date,
    data_fim    date,
    id_agencia  integer not null,
    
    constraint pk_feriado primary key (id_feriado),
    constraint fk_agencia foreign key (id_agencia) references itmn330_agencia(id_agencia)
    
);


insert into itmn330_agencia values
    (null, 0, 'TODAS');
    
insert into itmn330_agencia values (null,1010,'Butantan-USP'), (null,'2002', 'Jau'),
                                   (null,3043,'Jabaquara'), (null,9823,'Pocos de Caldas'),
								   (null,7850,'Centro'),(null,2315,'Av Ipiranga');
                                   
insert into tbl_usuario values 
(null, 'Professor Isidro', 'pisidro','123456789','isidro@isidro.com', '1234','https://avatars2.githubusercontent.com/u/6184696?s=460&v=4');

insert into tbl_usuario values
(null, 'Mega Man', 'megaman','123456780','mega@man.com','1234','https://cdnstatic8.com/eaglepatches.com.br/image/cache/data-patch-bordado-megaman-570x570.jpg');




select * from itmn330_agencia;

insert into itmn330_feriado values
(null, 'Natal', '2020-12-25', '2020-12-25', 1); 