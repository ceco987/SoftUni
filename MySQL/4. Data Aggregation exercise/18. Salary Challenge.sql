SELECT e.`first_name`, e.`last_name`, e.`department_id`
FROM `employees` as e
WHERE e.`salary` > 
(
SELECT AVG(e2.`salary`)
FROM `employees` as e2
WHERE e2.department_id = e.department_id
)
ORDER BY department_id, employee_id
limit 10;