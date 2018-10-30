CREATE TABLE sys_user (
  id              VARCHAR(32) PRIMARY KEY,
  act             VARCHAR(32) COMMENT '用户账号',
  pwd             VARCHAR(32) COMMENT '登录密码',
  user_name       VARCHAR(100) COMMENT '用户姓名',
  nick            VARCHAR(100) COMMENT '用户昵称',
  e_mail          VARCHAR(32) COMMENT '邮箱',
  mobile_phone    VARCHAR(32) COMMENT '联系电话',
  status          VARCHAR(32) COMMENT '账号状态',
  act_type        VARCHAR(32) COMMENT '账号类型',
  parent_act      VARCHAR(32) COMMENT '父账号',
  create_time     timestamp       DEFAULT NOW()
  COMMENT '创建时间',
  last_login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP()
  COMMENT '最后登录时间',
  UNIQUE (act)
);

CREATE TABLE sys_role (
  id        VARCHAR(32) PRIMARY KEY,
  role_name VARCHAR(100) COMMENT '角色名称',
  UNIQUE (role_name)
);

CREATE TABLE sys_menu (
  id        VARCHAR(32) PRIMARY KEY,
  parent_id VARCHAR(32) COMMENT '父菜单ID',
  menu_name VARCHAR(100) COMMENT '菜单名称',
  url       VARCHAR(100) COMMENT '菜单地址' DEFAULT '',
  icon      VARCHAR(100) COMMENT '图标'   DEFAULT '',
  position  INT COMMENT '排序'            DEFAULT 0,
  UNIQUE (menu_name)
);

CREATE TABLE sys_permission (
  id       VARCHAR(32) PRIMARY KEY,
  per_name VARCHAR(100) COMMENT '权限名称',
  UNIQUE (per_name)
);

CREATE TABLE sys_user_role (
  user_id VARCHAR(32) COMMENT '',
  role_id VARCHAR(32) COMMENT '',
  UNIQUE (user_id, role_id)
);

CREATE TABLE sys_role_menu (
  role_id VARCHAR(32) COMMENT '',
  menu_id VARCHAR(32) COMMENT '',
  UNIQUE (role_id, menu_id)
);

CREATE TABLE sys_role_permission (
  role_id VARCHAR(32) COMMENT '',
  per_id  VARCHAR(32) COMMENT '',
  UNIQUE (role_id, per_id)
);



