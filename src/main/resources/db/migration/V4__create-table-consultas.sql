create table consultas(

    id bigint not null auto_increment,
    medico_id bigint not null,
    data_consulta date not null,

    primary key(id),
    foreign key (medico_id) references medicos(id)
);