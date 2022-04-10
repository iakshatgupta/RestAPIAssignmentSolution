insert into roles(role_id,name) values (default,'ADMIN');
insert into roles(role_id,name) values (default,'USER');

insert into users(user_id,username,password) values (default,'admin','$2a$12$rb.UjiFnzdg5PXWJpzn6uuN/HlC97.XjUlqFz6iFg0NIVSXLpkVwa');
insert into users(user_id,username,password) values (default,'user','$2a$12$Hwv3clhiNIO8kcINd/s3I.e4im5WTQr39u6vMQ2U2cmWXO65D.x/G');

insert into users_roles(role_id,user_id) values (1,1);
insert into users_roles(role_id,user_id) values (2,2);

insert into employee(id,first_name,last_name,email) values (default,'Herbert','Schlidt','herbert@gmail.com');
insert into employee(id,first_name,last_name,email) values (default,'Kathy','Sierra','kathy@gmail.com');