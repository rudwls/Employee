
drop table member;
create table member(
	id 				int,
	email 			varchar(255),
	name	 		varchar(255),
	password 		varchar(255),
	register_date	date,
	constraint pk_id primary key (id)
);

select * from dept;
select * from emp;

select *
  from dept d inner join emp e
    on d.deptno = e.deptno
 where d.deptno = 80

select * from country;
--DDL(Data Definition Language)
drop table member;
create table member(
	id 				int auto_increment,
	email 			varchar(255),
	name	 		varchar(255),
	password 		varchar(255),
	register_date	date,
	constraint pk_id primary key (id)
);
-- Member CRUD (create, read, update, delete )
--create

create sequence member_id_seq

insert into member
(id, email, name, password, register_date)
values
(member_id_seq.nextval,'xxx@yyy', '홍길은', '1234', '2015/11/12')

--read
select * from member
--deleate
delete from member;

--city

select id,
       name,
	   countrycode,
	   district,
	   population
from   city
--selectByCountryCode(String countryCode) 
select id,
       name,
	   countrycode,
	   district,
	   population
 from  city
where  countrycode = "KOR"
--
--city--
--

drop table city

create table city (
  id numeric(11),
  name char(50) not null,
  countrycode char(3) not null,
  district char(30) not null,
  population numeric(11) not null,
  constraint city_pk_id primary key (id)
)

delete from city

select count(*) from city

create sequence city_id_generator start with 4090;
drop sequence city_id_generator;

select city_id_generator.nextVal from dual;

insert into city
(
	id,
	name,
	countrycode,
	district,
	population
)
values
(
	city_id_generator.nextVal,
	'xxx',
	'KOR',
	'Asia',
	99998
)
select d.deptno as dept_deptno,
	d.dname as dept_dname,
	d.loc as dept_loc,
	e.empno as emp_empno,
	e.ename as emp_ename,
	e.job as emp_job
from dept d inner join emp e
  on d.deptno = e.deptno
  
select d.deptno as dept_deptno,
	d.dname as dept_dname,
	d.loc as dept_loc,
	e.empno as emp_empno,
	e.ename as emp_ename,
	e.job as emp_job
from dept d left outer join emp e
  on d.deptno = e.deptno
 
select deptno, 
        	   dname, 
        	   loc 
          from dept
