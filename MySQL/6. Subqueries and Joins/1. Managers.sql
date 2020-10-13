SELECT
employee_id, 
concat_ws(' ', first_name, last_name) as `full_name`,
d.department_id,
d.`name` as `department_name`
FROM `departments` as d
JOIN `employees` as e ON d.manager_id = e.employee_id
ORDER BY employee_id
LIMIT 5;