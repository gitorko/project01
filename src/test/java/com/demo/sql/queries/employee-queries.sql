--SQL Query PostgreSQL

--first max salary
select distinct salary
from employee
order by salary desc
limit 1;

-- https://leetcode.com/problems/second-highest-salary/
-- second max salary
select distinct salary
from employee
order by salary desc
limit 1 offset 1;

-- second max salary
select max(salary)
from employee
where salary < (select max(salary) from employee);

-- if 2nd salary doesnt exist show null
select NULLIF(
               (select distinct salary
                from employee
                order by salary Desc
                limit 1 offset 1), null
           ) as SecondHighestSalary;

-- https://leetcode.com/problems/department-top-three-salaries/
-- top 3 salaries in each department
select d.name, e.id, e.name, e.salary
from employee e,
     department d
where e.department_id = d.id
  and (
          select count(distinct (e2.salary))
          from employee e2
          where e2.salary > e.salary
            and e2.department_id = e.department_id
      ) < 3
order by (d.name, e.name);

--max salary in each department
select d.name, max(e.salary)
from employee e,
     department d
where e.department_id = d.id
group by d.id;

--max salary in each department with employee name
select d.name, e.id, e.name, e.salary
from employee e,
     department d
where e.department_id = d.id
  and (
          select count(distinct (e2.salary))
          from employee e2
          where e2.salary > e.salary
            and e.department_id = e2.department_id
      ) < 1
order by (d.name, e.name);

--find all employee and department they work in, only show employees who have a department assigned.
SELECT e.name, d.name
FROM employee e
         INNER JOIN department d ON e.department_id = d.id;

--inner join
SELECT e.name, d.name
FROM employee e,
     department d
where e.department_id = d.id;

--find all employee who dont have a department
SELECT e.name, d.name
FROM employee e
         LEFT JOIN department d ON e.department_id = d.id
where d.name is null;

--find max salary in department even if no employee in it.
SELECT d.name, max(e.salary)
FROM employee e
         RIGHT JOIN department d ON e.department_id = d.id
GROUP BY d.name;

--find department without an employee
SELECT d.name, e.name
FROM employee e
         RIGHT JOIN department d ON e.department_id = d.id
where e.name is null;

--show all employee and department even if they dont have assignment
SELECT e.name, d.name
FROM employee e
         FULL JOIN department d ON e.department_id = d.id;

--find all employees having salary greater than average
SELECT e.name, e.salary
FROM employee e
WHERE salary > (SELECT AVG(salary) from employee);

-- find people with same name in same department
SELECT e.name as emp_name, d.name as department
FROM employee e,
     department d
where e.department_id = d.id
group by emp_name, department
having count(*) > 1;

-- find all employees and their manager
SELECT e.name, m.name
FROM employee e,
     employee m
WHERE e.manager = m.id;

-- find all employees who dont have a manager
SELECT e.name, m.name
FROM employee e
         LEFT JOIN employee m on e.manager = m.id
WHERE m.name is null;

-- find all employees and their manager, if they dont have manager show null
SELECT e.name, m.name
FROM employee e
         LEFT JOIN employee m on e.manager = m.id;

-- find all employees and the projects they are working in along with department.
-- one employee can work on multiple projects
select e.name, d.name department, p.name project
from employee e,
     department d,
     employee_project_mapping m,
     project p
where e.department_id = d.id
  and e.id = m.emp_id
  and m.project_id = p.id;

-- find employees who age is greater than 25
select e.name, e.dob, age(CURRENT_DATE, e.dob)
from employee e
where EXTRACT(YEAR FROM age(CURRENT_DATE, e.dob)) > 25;

-- find the oldest employee
select e.id, e.name, max(age(CURRENT_DATE, e.dob)) emp_age
from employee e group by e.id, e.name
order by emp_age desc limit 1;

--find the project and number of employees working on it.
select p.name project, count(*)
from project p,
     employee_project_mapping m,
     employee e
where p.id = m.project_id
  and m.emp_id = e.id
group by project;

--find the projects with no employees
select p.id, p.name
from project p
         left join employee_project_mapping m on p.id = m.project_id
where m.emp_id is null;

--find the employees with no project
select e.id, e.name
from employee e
         left join employee_project_mapping m on e.id = m.emp_id
where m.project_id is null;

--oldest person in each department
select d.name, e.id, e.name, e.dob
from employee e,
     department d
where e.department_id = d.id
  and (
          select count(distinct(e2.dob))
          from employee e2
          where e.dob > e2.dob
            and e.department_id = e2.department_id
      ) < 1
order by (d.name, e.name);

--current date
SELECT CURRENT_DATE;
SELECT extract(year from CURRENT_DATE) as "Year";

--find all employee born between 1980-1990
select *
from employee e
where e.dob between '01-01-1980' and '01-01-1990';

--find all employees who name begins with M
select *
from employee
where name like 'M%';

--find all employees other than Max
select *
from employee
where name <> 'Max';

--find all employees with name of Max
select *
from employee
where name = 'Max';

--find employees who are in project1 and project2
select e.id, e.name
from employee e,
     employee_project_mapping m,
     project p
where m.emp_id = e.id
  and m.project_id = p.id
  and p.name = 'Project 1'
INTERSECT
select e.id, e.name
from employee e,
     employee_project_mapping m,
     project p
where m.emp_id = e.id
  and m.project_id = p.id
  and p.name = 'Project 2';
