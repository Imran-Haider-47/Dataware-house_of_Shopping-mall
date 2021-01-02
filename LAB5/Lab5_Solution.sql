




SET FOREIGN_KEY_CHECKS=0;
insert into countries 
values ('PK','Pakistan',1);

insert into departments
values (280,'Research and Development',100,3300);

insert into locations
values (3300,'“NU-FAST Islamabad Campus,Islamabad','44000','Islamabad','ICT','PK');

insert into employees
values (207,'Ahmed', 'Ali','AALI','515.123.1414','2020-10-01 00:00:00', 'IT_PROG',5000.00,null, 100,280);

insert into employees
values (208,'Akbar', 'Hussain','AHUSSAIN','515.123.1215','2020-10-01 00:00:00', 'IT_PROG',5000.00,null, 100,280);
insert into employees
values (209,'Fareed', 'Chaudhary','FCHAUDHARY','535.123.1214','2020-10-01 00:00:00', 'IT_PROG',5000.00,null, 100,280);
insert into employees
values (210,'Imran', 'Khan','IKHAN','515.153.1214','2020-10-01 00:00:00', 'IT_PROG',5000.00,null, 100,280);
insert into employees
values (211,'Rehamt', 'Ali','RALI','515.121.1214','2020-10-01 00:00:00', 'IT_PROG',5000.00,null, 100,280);

#Question.3
update employees
set commission_pct=0.05
where employee_id=210;
set FOREIGN_KEY_CHECKS=1;
COMMIT;

SELECT * FROM student;









