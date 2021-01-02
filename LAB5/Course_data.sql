insert into university.course
values ("ML","Machine Learning","NULL");

insert into university.course
values ("P1","Programming 1","NULL");

insert into university.course
values ("LDD","Logical Database","NULL");

set FOREIGN_KEY_CHECKS=0;
ALTER TABLE LAB.course
DROP column course_no;