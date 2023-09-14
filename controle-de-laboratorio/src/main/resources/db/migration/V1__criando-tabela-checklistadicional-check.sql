create table checkListAdicional(
    id bigint not null auto_increment,
    ativo boolean,
    
    primary key(id)
);

create table `check`(
    id bigint not null auto_increment,
    `check` varchar(255) not null,
    ativo boolean,
    check_list_adicional_id bigint,
    
    primary key(id),
    foreign key (check_list_adicional_id) references checkListAdicional(id)
);