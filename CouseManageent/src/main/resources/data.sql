drop table if exists course CASCADE ;
drop table if exists review CASCADE ;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;

create table course (
       id bigint not null,
        course_inception_date date,
        course_state varchar(255),
        duration integer not null,
        fees integer not null,
        name varchar(255),
        primary key (id)
    );
	
	
	create table review (
       id bigint not null,
        description varchar(255),
        course_id bigint,
        primary key (id)
    );
	
	alter table review 
       add constraint FKprox8elgnr8u5wrq1983degk 
       foreign key (course_id) 
       references course;
	   
insert into COURSE(id, name, duration, fees, course_state, course_inception_date) 
values(1001,'JPA 100 steps one',12,5000,'ACTIVE','2020-08-15');
    
insert into COURSE(id, name, duration, fees, course_state, course_inception_date) 
values(1002,'JPA 50 steps two',6,3000,'NOT_ACTIVE','2019-04-15');

insert into COURSE(id, name, duration, fees, course_state, course_inception_date) 
values(1003,'JPA 25 steps three',3,1000,'ACTIVE','2018-02-17');


insert into review(id, description, course_id) 
values(2001,'Very nice Course',1001);

insert into review(id, description, course_id) 
values(2002,'Very Very nice Course',1001);


insert into review(id, description, course_id) 
values(2003,'Very bad Course',1002);

insert into review(id, description, course_id) 
values(2004,'Very very bad Course',1002);

insert into review(id, description, course_id) 
values(2005,'Very very very bad Course',1002);

