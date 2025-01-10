create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(300) not null,
    fecha_creacion datetime not null,
    status tinyint not null,
    curso_nombre varchar(100) not null,
    id_usuario bigint not null,

    primary key(id),
    constraint fk_topicos_usuario_id foreign key(id_usuario) references usuarios(id)
);