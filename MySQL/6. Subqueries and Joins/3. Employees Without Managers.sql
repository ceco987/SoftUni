SELECT
employee_id,first_name, last_name,department_id,salary
FROM `employees`
where manager_id is null;