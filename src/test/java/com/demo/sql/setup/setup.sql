create table department
(
    id serial not null
        constraint department_pk
            primary key,
    name varchar
);

alter table department owner to test;

create table employee
(
    id serial not null
        constraint employee_pk
            primary key,
    name varchar,
    salary integer,
    department_id integer,
    manager integer,
    dob date
);

alter table employee owner to test;

create table project
(
    id serial not null
        constraint project_pk
            primary key,
    name varchar
);

alter table project owner to test;

create table employee_project_mapping
(
    id serial not null
        constraint employee_project_mapping_pk
            primary key,
    emp_id integer
        constraint fk1
            references employee
            on update cascade on delete cascade,
    project_id integer
        constraint fk2
            references project
            on update cascade on delete cascade
);

alter table employee_project_mapping owner to test;

INSERT INTO department (id, name) VALUES (1, 'IT');
INSERT INTO department (id, name) VALUES (2, 'Sales');
INSERT INTO department (id, name) VALUES (3, 'Admin');

INSERT INTO employee (id, name, salary, department_id, manager, dob) VALUES (1, 'Joe', 85000, 1, 5, '1990-02-10');
INSERT INTO employee (id, name, salary, department_id, manager, dob) VALUES (2, 'Henry', 80000, 2, null, '1975-02-10');
INSERT INTO employee (id, name, salary, department_id, manager, dob) VALUES (3, 'Sam', 60000, 2, 4, '1975-02-10');
INSERT INTO employee (id, name, salary, department_id, manager, dob) VALUES (4, 'Max', 90000, 1, 5, '1981-02-10');
INSERT INTO employee (id, name, salary, department_id, manager, dob) VALUES (5, 'Janet', 69000, 1, 1, '1983-02-10');
INSERT INTO employee (id, name, salary, department_id, manager, dob) VALUES (6, 'Max', 84000, 1, 1, '2005-02-10');
INSERT INTO employee (id, name, salary, department_id, manager, dob) VALUES (7, 'Will', 70000, 1, 1, '1982-02-10');
INSERT INTO employee (id, name, salary, department_id, manager, dob) VALUES (8, 'Raj', 65000, null, 1, '1978-02-10');
INSERT INTO employee (id, name, salary, department_id, manager, dob) VALUES (9, 'Suresh', 62000, null, 1, '1978-02-10');
INSERT INTO employee (id, name, salary, department_id, manager, dob) VALUES (10, 'Sam', 61000, 2, 1, '1985-02-10');

INSERT INTO project (id, name) VALUES (1, 'Project 1');
INSERT INTO project (id, name) VALUES (2, 'Project 2');
INSERT INTO project (id, name) VALUES (3, 'Project 3');
INSERT INTO project (id, name) VALUES (4, 'Project 4');

INSERT INTO employee_project_mapping (id, emp_id, project_id) VALUES (1, 1, 1);
INSERT INTO employee_project_mapping (id, emp_id, project_id) VALUES (2, 1, 2);
INSERT INTO employee_project_mapping (id, emp_id, project_id) VALUES (3, 3, 3);
INSERT INTO employee_project_mapping (id, emp_id, project_id) VALUES (4, 4, 3);
INSERT INTO employee_project_mapping (id, emp_id, project_id) VALUES (5, 5, 2);
INSERT INTO employee_project_mapping (id, emp_id, project_id) VALUES (6, 6, 1);
INSERT INTO employee_project_mapping (id, emp_id, project_id) VALUES (7, 7, 2);
