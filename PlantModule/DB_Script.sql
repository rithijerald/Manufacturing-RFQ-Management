create database rfqManagement;
use rfqManagement;
create table plantReorderDetails(
partId int not null,
reorderDate date not null,
reorderStatus varchar(25) not null,
primary key(partId)
);

create table demand(
demandId int not null auto_increment,
demandCount int not null,
demandRaisedDtae date not null,
partId int not null,
primary key(demandId)
);

insert into plantReorderDetails (partId, reorderDate, reorderStatus) values (1, '2021-02-28', 'completed');
insert into plantReorderDetails (partId, reorderDate, reorderStatus) values (2, '2021-03-26', 'pending');
insert into plantReorderDetails (partId, reorderDate, reorderStatus) values (3, '2021-04-20', 'pending');
insert into plantReorderDetails (partId, reorderDate, reorderStatus) values (4, '2021-04-28', 'completed');


insert into demand (demandCount, demandRaisedId, partId) VALUES (301,'2021-03-17',1);
insert into demand (demandCount, demandRaisedId, partId) VALUES (805,'2021-02-27',2);
insert into demand (demandCount, demandRaisedId, partId) VALUES (514,'2021-02-15',3);
insert into demand (demandCount, demandRaisedId, partId) VALUES (278,'2021-03-07',4);