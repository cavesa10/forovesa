alter table topicos add activo tinyint;
update topicos set topicos.activo = 1;