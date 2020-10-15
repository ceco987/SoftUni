SELECT e.employee_id,
concat_ws(' ',e.first_name,e.last_name) as employee_name,
(SELECT concat_ws(' ',e2.first_name,e2.last_name)
from employees as e2 
where e.manager_id = e2.employee_id) as manager_name,
d.`name` as department_name
FROM `employees` as e join `departments` as d on e.department_id = d.department_id
order by e.employee_id
limit 5;