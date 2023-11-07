drop table if exists t_sys_permission;

create table if not exists t_sys_permission (
    id bigint unsigned auto_increment comment '主键',
    permission_name varchar(50) not null comment '权限名称',
    permission_code varchar(50) not null comment '权限编码',
    permission_level tinyint(1) not null comment '权限级别，1-菜单，2-按钮',
    url varchar(200) default null comment '权限url',
    is_enabled tinyint(1) default 1 comment '是否启用,1-启用，0-禁用',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '修改时间',
    primary key (id)
) comment '权限表';