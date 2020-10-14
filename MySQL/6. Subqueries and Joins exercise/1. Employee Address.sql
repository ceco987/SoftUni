SELECT employee_id, job_title, e.address_id, address_text
FROM `employees` as e JOIN `addresses` as a on e.address_id = a.address_id
ORDER BY e.address_id
limit 5;