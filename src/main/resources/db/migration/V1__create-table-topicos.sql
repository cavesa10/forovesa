create table topicos
(
    id          bigint       not null auto_increment,
    titulo      varchar(100) not null,
    mensaje     varchar(100) not null,
    estatus      varchar(100),
    fecha       datetime,
    primary key (id)
);