SELECT employee_id, first_name, last_name, d.`name` as department_name
FROM `employees` as e JOIN `departments` as d on e.department_id = d. department_id
WHERE d.`name` = 'Sales'
order by employee_id desc;