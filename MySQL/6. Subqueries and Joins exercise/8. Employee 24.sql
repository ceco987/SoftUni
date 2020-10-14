SELECT e.employee_id, e.first_name, if(year(p.start_date)>=2005,null,p.`name`) AS project_name
FROM employees AS e 
JOIN employees_projects AS ep
ON e.employee_id = ep.employee_id
JOIN projects AS p
ON ep.project_id = p.project_id
WHERE e.employee_id = 24
order by project_name;