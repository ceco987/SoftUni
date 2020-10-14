SELECT employee_id, first_name, salary, d.`name` as department_name
FROM `employees` as e JOIN `departments` as d on e.department_id = d. department_id
where salary > 15000
order by e.department_id desc
limit 5;