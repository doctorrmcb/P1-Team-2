create table p1_test.employees (
	employee_id serial,
	reimbursement_id int4,
	username varchar(40),
	password varchar(40),
	name text,
	address text,
	email text,
	phone text,
	reports_to int4,
	title text,
	awarded_reimbursements numeric (8,2),
	constraint PK_employees primary key (employee_id)
);

create table p1_test.reimbursements (
	reimbursement_id serial,
	employee_id int4,
	approval_id serial,
	initial_input_id serial,
	evaluation_id serial,
	event_type_id int4,
	status text,
	constraint PK_reimbursements primary key (reimbursement_id)
);

create table p1_test.approvals (
	approval_id serial,
	reimbursement_id int4,
	dir_sup_app bool,
	dept_head_app bool,
	ben_co_app bool,
	approval_time timestamp,
	ben_co_alter_info text,
	additional_info text,
	denial_info text,
	constraint PK_approvals primary key (approval_id)
	--constraint FK_reimbursements foreign key (p1_test.reimbursements.)
);

create table p1_test.initial_inputs (
	--Required section
	initial_input_id serial,
	reimbursement_id int4,
	event_date timestamp,
	location text,
	description text,
	cost numeric(10,2),
	evaluation_format_id int4, 
	justification text,
	--Optional section
	event_file_name text,
	event_attachment bytea,
	approval_file_name text,
	approval_attachment bytea,
	time_out_start timestamp,
	time_out_end timestamp,
	constraint PK_initial_inputs primary key (initial_input_id)
);

create table p1_test.evaluations (
	evaluation_id serial,
	reimbursement_id int4,
	grade text,
	file_path text,
	presentation bytea,
	approval bool,
	constraint PK_evaluations primary key (evaluation_id)
);

create table p1_test.event_types (
	event_type_id serial,
	reimbursement_id int4,
	type text,
	coverage numeric (5,2),
	constraint PK_event_types primary key (event_type_id)
);

create table p1_test.evaluation_types (
	evaluation_type_id serial,
	reimbursement_id int4,
	type text,
	scale text,
	passing_grade text,
	presentation bool,
	constraint PK_evaluation_types primary key (evaluation_type_id)
);

-- Setting up inital coverage table.
--insert into p1_test.event_types values (1, 1, 'University Course', .8);
--insert into p1_test.event_types values (2, 1, 'Seminar', .6);
--insert into p1_test.event_types values (3, 1, 'Certification Preparation Class', .75);
--insert into p1_test.event_types values (4, 1, 'Certification', 1.0);
--insert into p1_test.event_types values (5, 1, 'Technical Training', .9);
--insert into p1_test.event_types values (6, 1, 'Other', .3);


--Drop tables section:
--drop table p1_test.approvals;
--drop table p1_test.employees;
--drop table p1_test.evaluation_types;
--drop table p1_test.evaluations;
--drop table p1_test.event_types;
--drop table p1_test.initial_inputs;
--drop table p1_test.reimbursements;

--Test insert section:
--insert into p1_test.employees values(1, 2, 'user', 'pass', 'testName', 'testAddress', 'testEmail', 'testPhone', 2, 'testTitle', 50);
--delete from p1_test.employees where employee_id = 1;