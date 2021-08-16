drop table if exists course CASCADE;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;

create table course (
       id bigint not null,
        course_inception_date DATE,
        course_state varchar(255),
        duration integer not null,
        fees integer not null,
        name varchar(255),
        primary key (id)
    );
    
    
insert into COURSE(id, name, duration, fees, course_state, course_inception_date) 
values(1001,'JPA 100 steps one',12,5000,'ACTIVE','2020-08-15');
    
insert into COURSE(id, name, duration, fees, course_state, course_inception_date) 
values(1002,'JPA 50 steps two',6,3000,'NOT_ACTIVE','2019-04-15');

insert into COURSE(id, name, duration, fees, course_state, course_inception_date) 
values(1003,'JPA 25 steps three',3,1000,'ACTIVE','2018-02-17');