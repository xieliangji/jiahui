create table sugar_account
(
    id          int auto_increment comment '用户id',
    username    varchar(255)                        not null comment '用户名',
    email       varchar(128)                        not null comment '用户登录邮箱',
    password    varchar(255)                        not null comment '用户密码',
    salt        varchar(255)                        not null comment '密码盐值',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '注册时间',
    update_time timestamp                           null on update CURRENT_TIMESTAMP comment '用户信息更新时间',
    constraint sugar_account_email_uindex
        unique (email),
    constraint sugar_account_id_uindex
        unique (id)
)
    comment '用户表';

alter table sugar_account
    add primary key (id);

create table sugar_file
(
    id          int auto_increment comment '文件ID',
    name        varchar(36)                         not null comment '文件记录名',
    file_name   varchar(255)                        not null comment '存储文件名',
    remark      varchar(255)                        null comment '备注',
    file_type   tinyint                             not null comment '文件类型 1-jar、2-zip、3-js、4-py',
    uploader_id int                                 not null comment '文件上传用户ID',
    updater_id  int                                 null comment '更新人ID',
    upload_time timestamp default CURRENT_TIMESTAMP not null comment '文件上传时间',
    update_time timestamp                           null comment '更新记录时间',
    constraint sugar_file_id_uindex
        unique (id)
)
    comment '文件表';

alter table sugar_file
    add primary key (id);

create table sugar_jmx
(
    id          int auto_increment comment '测试计划ID'
        primary key,
    name        varchar(255)                        not null comment '测试计划保存名',
    project_id  int                                 null comment '测试计划所属项目ID',
    jmx_path    varchar(36)                         null comment '测试计划脚本内容',
    remark      varchar(255)                        null comment '测试计划备注',
    creator_id  int                                 not null comment '测试计划创建人',
    updater_id  int                                 null comment '测试计划更新人',
    create_time timestamp default CURRENT_TIMESTAMP null comment '测试计划创建时间',
    update_time timestamp                           null on update CURRENT_TIMESTAMP comment '测试计划最近一次更新时间'
)
    comment '测试计划文件表';

create table sugar_project
(
    id          int auto_increment comment '项目ID'
        primary key,
    name        varchar(255)                        not null comment '项目名称',
    remark      varchar(255)                        null comment '备注',
    creator_id  int                                 not null comment '项目创建人ID',
    create_time timestamp default CURRENT_TIMESTAMP null comment '项目创建时间',
    updater_id  int                                 null comment '项目最近的更新人',
    update_time timestamp                           null on update CURRENT_TIMESTAMP comment '项目最近更新时间'
)
    comment '项目表';

create table sugar_account_project
(
    id          int auto_increment comment '关联记录ID'
        primary key,
    account_id  int                                 null comment '用户ID',
    project_id  int                                 null comment '项目ID',
    create_time timestamp default CURRENT_TIMESTAMP null comment '关联记录创建时间',
    update_time timestamp                           null on update CURRENT_TIMESTAMP,
    constraint sugar_account_project_sugar_account_id_fk
        foreign key (account_id) references sugar_account (id)
            on delete cascade,
    constraint sugar_account_project_sugar_project_id_fk
        foreign key (project_id) references sugar_project (id)
            on delete cascade
)
    comment '用户项目关联表';

create table sugar_report
(
    id             int auto_increment comment '测试报告ID',
    name           varchar(255)                        not null comment '测试报告名称',
    test_plan_id   int                                 not null comment '测试计划ID',
    start_time     timestamp                           null comment '测试计划执行起始时间',
    end_time       timestamp                           null comment '测试计划执行结束时间',
    status         enum ('FAIL', 'SUCCESS')            not null comment '测试计划执行状态 FAIL-失败, SUCCES-成功',
    sample_results mediumtext                          not null comment '测试报告内容，取样器结果的json压缩后字符串',
    description    varchar(255)                        null comment '测试计划执行异常描述',
    creator_id     int                                 null comment '测试计划执行人ID',
    create_time    timestamp default CURRENT_TIMESTAMP not null,
    constraint sugar_report_id_uindex
        unique (id)
)
    comment '测试报告表';

alter table sugar_report
    add primary key (id);

create table sugar_test_plan
(
    id             int auto_increment comment '测试计划ID'
        primary key,
    name           varchar(255)                        not null comment '测试计划名',
    project_id     int                                 not null comment '测试计划关联项目ID',
    remark         varchar(255)                        null comment '测试计划备注',
    hash_tree_json mediumtext                          not null comment '测试计划内容',
    creator_id     int                                 not null comment '测试计划创建人ID',
    updater_id     int                                 null comment '测试计划更新人ID',
    create_time    timestamp default CURRENT_TIMESTAMP not null comment '测试计划创建时间',
    update_time    timestamp                           null on update CURRENT_TIMESTAMP comment '测试计划最近一次更新时间'
)
    comment '测试计划表';
