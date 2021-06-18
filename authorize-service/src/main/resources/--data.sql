drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1000 increment by 1;

insert into personas (id, name) values (1, 'David');
insert into personas (id, name) values (2, 'Violeta');
insert into personas (id, name) values (3, 'Otro');


insert into acciones (id, name) values (1, 'Lavar la ropa');
insert into acciones (id, name) values (2, 'Planchar');
insert into acciones (id, name) values (3, 'Coser');
insert into acciones (id, name) values (4, 'Cocinar');
insert into acciones (id, name) values (5, 'Lavar los platos');

-- Contraseña: admin
insert into usuarios (id, full_name, email, username, password, avatar, created_at, last_password_change_at)
values (1, 'david admin', 'admin@david.net','david','$2y$10$PlQQJMst5Zy6m1qJTLoanuMwayFnY0UgF.q2uipititrHcoSu5vXG','',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_entity_roles (user_entity_id, roles) values (1,'USER');
insert into user_entity_roles (user_entity_id, roles) values (1,'ADMIN');


-- Contraseña: Marialopez1
insert into usuarios (id, full_name, email, username, password, avatar, created_at, last_password_change_at)
values (2, 'María López', 'maria.lopez@openwebinars.net','marialopez','$2a$10$ev.rv6yUA.UE9.Ndw4aSC.wRo6UlP6OkjAe48SmEN.elw4WAyfT0S','https://api.adorable.io/avatars/285/maria.lopez@openwebinars.net.png',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_entity_roles (user_entity_id, roles) values (2,'USER');

-- Contraseña: Angelmartinez1
insert into usuarios (id, full_name, email, username, password, avatar, created_at, last_password_change_at)
values (3, 'Ángel Martínez', 'angel.martinez@openwebinars.net','angelmartinez','$2a$10$9joAo0/q0z2vYgdKUYQ7kuahy7xRBRZF9GNkmOsd6hbCvqFmH6Ueu','https://api.adorable.io/avatars/285/angel.martinez@openwebinars.net.png',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_entity_roles (user_entity_id, roles) values (3,'USER');

-- Contraseña: Anajimenez1
insert into usuarios (id, full_name, email, username, password, avatar, created_at, last_password_change_at)
values (4, 'Ana Jiménez', 'ana.jimenez@openwebinars.net','anajimenez','$2a$10$IF4e6GpTAO5pQOLwy.Bn7.hBGgeOOMCIyEhvEkeikkrlBY5emp6vy','https://api.adorable.io/avatars/285/ana.jimenez@openwebinars.net.png',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_entity_roles (user_entity_id, roles) values (4,'USER');