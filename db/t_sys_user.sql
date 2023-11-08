drop table if exists t_sys_user;

create table if not exists t_sys_user (
    id bigint unsigned auto_increment comment '主键',
    username varchar(50) not null comment '用户名',
    password varchar(200) not null comment '密码',
    salt varchar(50) default null comment '盐',
    email varchar(100) default null comment '邮箱',
    phone varchar(20) default null comment '手机号',
    is_enabled tinyint(1) default 1 comment '是否启用,1-启用，0-禁用',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '修改时间',
    primary key (id),
    unique key (username)
) comment '用户表';