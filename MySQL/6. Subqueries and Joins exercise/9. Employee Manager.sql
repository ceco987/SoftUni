SELECT e.employee_id,e.first_name,e.manager_id,
(SELECT e2.first_name 
from employees as e2 
where e.manager_id = e2.employee_id) as manager_name
FROM `employees` as e
where e.manager_id in (3,7)
order by e.first_name;