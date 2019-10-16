create table users(
user_id serial primary key not null,
username text unique not null,
user_password text not null,
fname text not null,
lname text not null,
email text unique not null,
user_role_id int not null,
constraint user_roles_fk foreign key (user_role_id) references user_roles(user_role_id));

drop table users;


create table reimbursement(
reimb_id serial primary key not null,
reimb_amount int not null,
reimb_submitted timestamp not null,
reimb_resolved timestamp not null ,
reimb_description text,
--reimb_receipt
reimb_author int,
foreign key (reimb_author) references users(user_id),
reimb_resolver int,
foreign key (reimb_resolver) references users(user_id),
reimb_status_id int,
foreign key (reimb_status_id) references reimbursement_status(reimb_status_id),
reimb_type_id int,
foreign key (reimb_type_id) references reimbursement_type(reimb_type_id)
);

drop table reimbursement;

create table user_roles(
user_role_id serial primary key,
user_role text);
insert into user_roles(user_role) values('employee');
insert into user_roles(user_role) values('finance manager');
select * from user_roles;
drop table user_roles;

create table reimbursement_type(
reimb_type_id serial primary key,
reimb_type text);

insert into reimbursement_type(reimb_type) values('lodging');
insert into reimbursement_type(reimb_type) values('travel');
insert into reimbursement_type(reimb_type) values('food');
insert into reimbursement_type(reimb_type) values('other');
select * from reimbursement_type;
drop table reimbursement_type;

create table reimbursement_status(
reimb_status_id serial primary key,
reimb_status text);

insert into reimbursement_status(reimb_status) values('pending');
insert into reimbursement_status(reimb_status) values('approved');
insert into reimbursement_status(reimb_status) values('denied');
select * from reimbursement_status;
drop table reimbursement_status;
--updated