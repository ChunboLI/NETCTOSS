set names utf8;
/*drop database if exists db_crm;*/
create database db_crm charset utf8;
use db_crm;

/*测试Demo*/
drop table if exists tb_user;
create table tb_user (
	id bigint primary key auto_increment, 
	username varchar(50) unique not null,
	password varchar(50) not null,
	name varchar(20),
	birthday date
) engine=InnoDB default charset=utf8;

/*创建用户表*/
create table Custom(/*客户表*/
	id bigint primary key auto_increment not null,
	name varchar(30) unique not null,
	job varchar(10) not null,
	gender int not null,
	birthday date ,
	qq varchar(13) not null,
	weibo varchar(10),
	msn varchar(10),
	creator bigint not null,
	status int(5) not null,
	source int(5) not null,
	type int(5) not null,
	email varchar(20) not null,
	mobliePhone varchar(12) not null,
	phone varchar(10),
	address varchar(30),
	company varchar(20) not null,
	modifier int(10),
	remarks varchar(100),
	createDate date not null,
	belongTo bigint
) engine=InnoDB default charset=utf8;
/*客户关怀表*/
create table CustomCare(
	id bigint primary key auto_increment not null,
	custom int(10) not null,
	theme varchar(40) not null,
	way varchar(20) not null,
	time date not null,
	nextTime date not null,
	remarks varchar(100),
	emp int(10),
	createDate date not null
) engine=InnoDB default charset=utf8;
/*客户类型表*/
create table CustomType(
	id bigint primary key auto_increment not null,
	type varchar(20) not null
) engine=InnoDB default charset=utf8;
/*客户状态表*/
create table CustomStatus(
	id bigint primary key auto_increment not null,
	status varchar(20) not null,
	described varchar(100)
)engine=InnoDB default charset=utf8;
/*客户来源*/
create table CustomSource(
	id bigint primary key auto_increment not null,
	source varchar(20) not null
)engine=InnoDB default charset=utf8;
/*联系记录*/
create table RelRecord(
	id bigint primary key auto_increment not null,
	custom bigint not null,
	time date not null,
	nextTime date not null,
	type varchar(20) not null,
	emp bigint not null,
	theme varchar(40) not null,
	remarks varchar(100)
)engine=InnoDB default charset=utf8;
/*联系人*/
create table Linkman(
	id bigint primary key auto_increment not null,
	custom bigint not null,
	name varchar(20) not null,
	gender bigint,
	job varchar(20),
	mobilePhone varchar(12) not null, 
	relationship varchar(10) not null
)engine=InnoDB default charset=utf8;

/*gender 性别*/
create table Gender(
	id int primary key not null,
	gender varchar(4) not null
) engine=InnoDB default charset=utf8;

/*员工表*/
create table Emp(/*员工表*/
	id bigint primary key auto_increment not null,
	name varchar(20) not null,
	gender int not null,
	nation varchar(10),
	education varchar(10),
	department int,
	phone varchar(10),
	payCard varchar(20) unique not null,
	idCard varchar(20) unique not null ,
	emp bigint not null,
	account varchar(20) unique not null,
	password varchar(20) not null,
	marriage varchar(10),
	role int not null,
	interest varchar(50),
	mobilePhone varchar(12) not null,
	address varchar(30),
	email varchar(20),
	createDate date not null,
	modifyier int,
	age int
) engine=InnoDB default charset=utf8;

/*部门表*/
create table Department(
	id int primary key auto_increment not null,
	name varchar(20) not null,
	description varchar(50)
)engine=InnoDB default charset=utf8;

/*房屋表*/
create table House(
	id int primary key auto_increment not null,
	type int not null,
	address varchar(30) not null,
	price double not null,
	environment varchar(50),
	emp bigint(10)  
) engine=InnoDB default charset=utf8;
/*房屋类型(户型)*/
create table HouseType(
	id int primary key auto_increment not null,
	type varchar(20) not null
) engine=InnoDB default charset=utf8;
/*公告*/
create table Notice(
	id bigint primary key auto_increment not null,
	emp int not null,
	theme varchar(20) not null,
	content varchar(50) not null,
	time date not null,
	endTime date not null
) engine=InnoDB default charset=utf8;
/*邮箱*/
create table Email(
	id bigint primary key auto_increment not null,
	sender bigint not null,
	receiver bigint not null,
	theme varchar(20) not null,
	content varchar(200) not null,
	time date not null,
	status boolean not null
) engine=InnoDB default charset=utf8;

alter table tb_emp drop e_department;
alter table House modify emp bigint not null;
alter table CustomStatus modify  varchar(13) not null;
alter table Emp add int age;

insert into CustomStatus (status,described) values ('aa','e');
update CustomStatus set status='110' where id=23;


insert into Custom
 (name,job,gender,birthday,qq,weibo,msn,creator,status,source,type,email,mobliePhone,phone,address,company,modifier,remarks,createDate,belongTo)
 values
 ('黄不换',"1",1,'1993-11-30',1,1,1,1,1,1,1,1,1,1,1,1,1,1,'1993-11-30',1);
 
<<<<<<< .mine

 
=======
 
 select * from CustomSource;
 
 insert into CustomSource
 (source)
 values('搜房网');
 
 
 select * from CustomType;
 
 
 insert into CustomType 
 (type)
 values
 ("供应商");
 
 
 
 
 
 select * from CustomStatus;
 
 desc  CustomStatus;
 
 delete from CustomStatus where status="黄步欢";
 
 insert into CustomStatus  (status,described) values ('12','12')
 
 
 delete from Custom where name = "a"
 
 select * from Custom;
>>>>>>> .r273
