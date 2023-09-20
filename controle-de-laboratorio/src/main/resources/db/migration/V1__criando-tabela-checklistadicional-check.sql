create table checagemListAdicional(
    id bigint not null auto_increment,
    ativo boolean,
    
    primary key(id)
);

create table checagem(
    id bigint not null auto_increment,
    checagem varchar(255) not null,
    ativo boolean,
    checagem_list_adicional_id bigint,
    
    primary key(id),
    foreign key (checagem_list_adicional_id) references checagemListAdicional(id)
);