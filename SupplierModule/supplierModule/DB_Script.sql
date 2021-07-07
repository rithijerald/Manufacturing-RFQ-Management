create database rfqManagement;
use rfqManagement;
create table supplier(
id int not null auto_increment,
partId int not null,
name varchar(25) not null,
email varchar(25) not null,
phone varchar(25) not null,
location varchar(20) not null,
feedback int not null,
quantity int not null,
timeToSupply int not null,
primary key (id) 
);

create table supplierPart(
partId int not null auto_increment,
partName varchar(20) not null,
primary key (partId) 
);

insert into supplier (partId,name,email,phone,location,feedback,quantity,timeToSupply)
values (1,'Himanshu','himanshu@gmail.com','9898763542','Delhi',10,100,3);
insert into supplier (partId,name,email,phone,location,feedback,quantity,timeToSupply)
values (2,'Rathor','rathor@gmail.com','9898712542','Delhi',8,200,7);
insert into supplier (partId,name,email,phone,location,feedback,quantity,timeToSupply)
values (3,'Mayank','mayank@gmail.com','989564542','Noida',7,300,4);
insert into supplier (partId,name,email,phone,location,feedback,quantity,timeToSupply)
values (2,'Aman','aman@gmail.com','9813443542','UP',9,100,3);
insert into supplier (partId,name,email,phone,location,feedback,quantity,timeToSupply)
values (4,'Abhay','abhay@gmail.com','9898723442','Bihar',7,100,3);


insert into supplierpart (partname) value ('Gearbox');
insert into supplierpart (partname) value ('Engine');
insert into supplierpart (partname) value ('Clutch');
insert into supplierpart (partname) value ('Brakes');
insert into supplierpart (partname) value ('Steering');
