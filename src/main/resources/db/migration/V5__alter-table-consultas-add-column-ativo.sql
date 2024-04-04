alter table consultas add ativo tinyint not null;
update consultas set ativo = 1;