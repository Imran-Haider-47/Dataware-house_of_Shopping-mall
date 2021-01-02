CREATE SCHEMA IF NOT EXISTS `lab` DEFAULT CHARACTER SET utf8 ;
USE `lab` ;

SET FOREIGN_KEY_CHECKS=0;
Create Table Lab.Course(
	Course_no varchar(4) NOT NULL,
	Course_name varchar(200) NOT NULL,
    Course_details varchar(255),
    CONSTRAINT PK_Course PRIMARY KEY (Course_no));

CREATE TABLE Lab.Grade(
	Student_no varchar(6) Not NULL,
    Course_no varchar(4) Not NULL,
    Grade decimal(2) Not NULL,
    Primary Key(Student_no,Course_no),
    CONSTRAINT FK1_G FOREIGN KEY (Student_no) References Student(Student_no),
    CONSTRAINT FK2_G FOREIGN KEY (Course_no ) References Course (Course_no)
    );
    

CREATE TABLE Student(
	Student_no varchar(10) NOT NULL,
    Student_name varchar(100) NOT NULL,          
    Student_address varchar(255),
    CONSTRAINT PK_Student PRIMARY KEY (Student_no));
SET FOREIGN_KEY_CHECKS=1;

Alter table Lab.Grade
Add check (Grade>=0);


ALTER TABLE Student
ADD UNIQUE (Student_no);

ALTER TABLE Lab.Course
ADD UNIQUE (Course_no);



#Question.2 
CREATE TABLE Lab.Store_Infromation(
	store_id varchar (3) not null,
	store_name varchar (20) not null,
    street_name varchar (20) ,
    city varchar (20),
    zip_code varchar (5),
    phone_nbr varchar(20),
    manager_name varchar(20),
    open_sunday_flag char(1),
    CONSTRAINT PK_store_info PRIMARY KEY (store_id));


CREATE TABLE Lab.Store_Visit(
	visit_id varchar (3) not null,
	store_id varchar (20) not null,
    membership_id varchar (20) ,
    Transaction_date date,
    tot_unique_itm_cnt int (2),
    tot_visit_amt  int(5),
    CONSTRAINT store_visit_PK PRIMARY KEY (visit_id));


CREATE TABLE Lab.Members_index(
	membership_id varchar(6),
    Customer_name varchar(20),
    address varchar(100),
    member_type varchar(10),
    join_date date,
    member_status char(1),
    member_points int,
    Constraint members_index_PK primary key(membership_id));
    
    

create table Lab.category(
	category_id varchar(2),
    category_name varchar(20),
    category_details varchar(100),
    constraint category_PK primary key(category_id));


create table Lab.item_desc(
	item_id varchar(6) not null,
    category_id varchar(2),
    primary_desc varchar(50),
    secondary_desc varchar(50),
    color_desc varchar(10),
    size_desc varchar(10),
    status_code char(1),
    production_date date,
    expiry_date date,
    brand_name varchar(20),
    Constraint item_desc_PK Primary key (item_id));    



create table Item_scan(
	visit_id varchar (6) not null,
    item_id varchar(6) not null,
    quantity int (2),
    unit_cost float(5,3),
    unit_tot_cost float (5,3),
    constraint Item_scan_PK primary key (visit_id, item_id));
    
ALTER TABLE store_visit
ADD FOREIGN KEY store_information_FK(store_id) REFERENCES store_infromation(store_id),
ADD foreign key members_index_FK(membership_id) References members_index(membership_id);


Alter table item_scan
Add foreign key item_scan_item_desc_FK (item_id) references item_desc(item_id),
Add foreign key item_scan_store_visit_FK(visit_id) references store_visit(visit_id);



Alter table item_desc
Add foreign key item_desc_category_FK(category_id) references category(category_id);































    
