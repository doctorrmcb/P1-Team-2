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
	approval_id int4,
	initial_input_id int4,
	evaluation_id int4,
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
	event_attachment bytea,
	approval_attachment bytea,
	time_out_start timestamp,
	time_out_end timestamp,
	constraint PK_approvals primary key (initial_input_id)
);

create table p1_test.evaluations (
	evaluation_id serial,
	reimbursement_id int4,
	grade text,
	presentation bytea,
	approval bool,
	constraint PK_evaluations primary key (evaluation_id)
);

create table p1_test.event_types (
	event_type_id serial,
	reimbursement_id int4,
	type text,
	coverage numeric (5,2),
	constraint PK_approvals primary key (event_type_id)
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