create table autores(
    id bigint not null auto_increment,
    login varchar(100) not null,
    clave varchar(300) not null,
    primary key(id)
);

insert into autores(id, login, clave) values(1, "jv290891@email.com", "$2a$10$cXXDOKAVQen.T/Ix2o1dh.QHYm9YijmXFl3JyigWiT50il1toTj3C");