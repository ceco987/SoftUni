CREATE TABLE `task_14`
SELECT * FROM `employees`
WHERE salary > 30000;

DELETE from `task_14`
where manager_id = 42;

UPDATE `task_14`
SET `salary` = `salary` + 5000
WHERE `department_id` = 1;

SELECT `department_id`, avg(`salary`)
FROM `task_14`
GROUP BY `department_id`
ORDER BY `department_id`;