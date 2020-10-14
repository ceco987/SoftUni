SELECT e.employee_id, first_name
FROM `employees` as e left join `employees_projects` as e2 on e.employee_id = e2.employee_id
WHERE e2.project_id is null
order by e.employee_id desc
limit 3;