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
insert into member
(email, name, password, register_date)
values
('xxx@yyy', '홍길동', '1234', '2015/11/11')
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
where  countrycode = "web"

insert into city
(
   name,
   countrycode,
   district,
   population
)
values
(
	'java',
	'web',
	'programming',
	1000000
)


