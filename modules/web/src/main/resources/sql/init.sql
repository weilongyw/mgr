create table sys_user(
    id varchar(32) primary key ,
    user_name varchar(100),
    user_act varchar(32),
    user_pwd varchar(32),
    create_date date,
    create_time timestamp,
    last_login_date date,
    last_login_time timestamp
);
create table sys_role(
    id varchar(32) primary key,
    role_name varchar(100) unique
);
create table sys_menu(
    id varchar(32) primary key,
    menu_name varchar(100),
    menu_url varchar(100)
);
create table sys_permission(
    id varchar(32) primary key,
    per_name varchar(100) unique
);
create table sys_user_role(
    user_id varchar(32),
    role_id varchar(32)
);
create table sys_role_menu(
    role_id varchar(32),
    menu_id varchar(32)
);
create table sys_role_permission(
    role_id varchar(32) ,
    per_id varchar(32)
);


