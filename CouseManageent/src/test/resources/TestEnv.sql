drop table if exists course CASCADE;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table course (id bigint not null, duration integer not null, fees integer not null, name varchar(255), primary key (id));


insert into COURSE(id, name, duration, fees) values(101,'JAP 100 steps',5,2000);
insert into COURSE(id, name, duration, fees) values(102,'Hibernate',1,3000);
insert into COURSE(id, name, duration, fees) values(103,'Full stack',9,4000);