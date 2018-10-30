INSERT INTO sys_user (id, act, pwd) VALUES ('1', 'admin', '123456');
INSERT INTO sys_role (id, role_name) VALUES ('1', '超级管理员');

INSERT INTO sys_user_role(user_id,role_id) VALUES ('1','1');

INSERT INTO sys_menu (id, menu_name) VALUES (REPLACE(UUID(), '-', ''), '系统管理');
select @menu_id:=id from sys_menu where menu_name='系统管理';
INSERT INTO sys_menu (id, menu_name, url,parent_id) VALUES ('1', '菜单管理', '/setting/menu',@menu_id);
INSERT INTO sys_menu (id, menu_name, url,parent_id) VALUES ('2', '角色管理', '/setting/role',@menu_id);
INSERT INTO sys_menu (id, menu_name, url,parent_id) VALUES ('3', '权限管理', '/setting/permission',@menu_id);

INSERT INTO sys_role_menu(role_id,menu_id) value('1','1');
INSERT INTO sys_role_menu(role_id,menu_id) value('1','2');
INSERT INTO sys_role_menu(role_id,menu_id) value('1','3');








