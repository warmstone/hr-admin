drop table if exists t_sys_role_permission;

create table if not exists t_sys_role_permission (
    id bigint unsigned auto_increment comment '主键',
    role_id bigint unsigned not null comment '角色ID',
    permission_id bigint unsigned not null comment '权限ID',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '修改时间',
    primary key (id)
) comment '用户角色表';