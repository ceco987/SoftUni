SELECT first_name, last_name, hire_date, d.`name` as department_name
FROM `employees` as e JOIN `departments` as d on e.department_id = d. department_id
WHERE DATE(hire_date) > '1999-01-01' and d.`name` in ('Sales','Finance')
order by hire_date;