drop table if exists t_sys_role;

create table if not exists t_sys_role (
    id bigint unsigned auto_increment comment '主键',
    role_name varchar(50) not null comment '角色名称',
    role_code varchar(50) not null comment '角色编码',
    parent_id bigint unsigned default null comment '父角色ID',
    is_enabled tinyint(1) default 1 comment '是否启用,1-启用，0-禁用',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '修改时间',
    primary key (id)
    ) comment '角色表';