SELECT `first_name` FROM `employees`
WHERE `department_id` in(3,10) and
year(`hire_date`) BETWEEN 1995 and 2005
ORDER BY `employee_id`;