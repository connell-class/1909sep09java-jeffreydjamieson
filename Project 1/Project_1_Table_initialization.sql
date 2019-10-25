create table users(
user_id serial primary key not null,
username text unique not null,
user_password text not null,
fname text not null,
lname text not null,
email text unique not null,
user_role_id int not null,
constraint user_roles_fk foreign key (user_role_id) references user_roles(user_role_id));
select * from users;
drop table users;

insert into users(username, user_password, fname, lname, email, user_role_id)values ('snoopiedogg', 'doggpound', 'Snoop', 'Dogg', 'snoopdoggydogg@dogpound', 1);
insert into users(username, user_password, fname, lname, email, user_role_id)values ('notoriousbiggie', 'bigpoppa', 'Biggie', 'Smalls', 'notoriousbig@badboyrec', 2);
insert into users values (1, 'mpharoahe', 'pharoahe', 'Pharoahe', 'Monch', 'pharaohking@notegyptian', 1);
insert into users values (2, '2pakaday', 'gparty', 'Tupak', 'Shakur', 'californialove@westside', 1);

create table reimbursement(
reimb_id serial primary key not null,
reimb_amount int not null,
reimb_submitted timestamp not null,
reimb_resolved timestamp,
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

select * from reimbursement;
truncate table reimbursement;
drop table reimbursement;

insert into reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_type_id) values (250.00,'2018-06-22 12:10:00', 'Air Fare', 1, 2);
insert into reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_type_id) values (250.00,'2019-06-22 12:30:00', 'Hotel Lodging', 2, 1);
insert into reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_type_id) values (175.00,'2019-10-25 13:00:00', 'Jail Bail', 3, 4);
insert into reimbursement( reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_type_id) values (25.00,'2019-10-25 13:30:00', 'Munchies', 3, 3);
update reimbursement set reimb_description='Munchies' where reimb_id=4;

create table user_roles(
user_role_id serial primary key,
user_role text);

insert into user_roles(user_role) values('employee');
insert into user_roles(user_role) values('finance manager');

select * from user_roles;


create table reimbursement_type(
reimb_type_id serial primary key,
reimb_type text);

insert into reimbursement_type(reimb_type) values('lodging');
insert into reimbursement_type(reimb_type) values('travel');
insert into reimbursement_type(reimb_type) values('food');
insert into reimbursement_type(reimb_type) values('other');

select * from reimbursement_type;


create table reimbursement_status(
reimb_status_id serial primary key,
reimb_status text);
hiphop
insert into reimbursement_status(reimb_status) values('pending');
insert into reimbursement_status(reimb_status) values('approved');
insert into reimbursement_status(reimb_status) values('denied');

select * from reimbursement_status;



create or replace function hashPassword() returns trigger as $$
begin if(new.user_password=old.user_password)then return new; end if; 
new.user_password := md5(new.username||new.user_password||'hiphop'); 
return new; end; $$
language plpgsql; 

create trigger hashPass before insert or update on users 
for each row execute function hashPassword(); 

create or replace function pending() returns trigger as $$
begin
new.reimb_status_id:=1;
return new;
end;
$$
language plpgsql;

create trigger pend before insert on reimbursement
for each row execute function pending();