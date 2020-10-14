SELECT count(*) as count from `employees`
WHERE salary >
(select avg(salary) from `employees`);