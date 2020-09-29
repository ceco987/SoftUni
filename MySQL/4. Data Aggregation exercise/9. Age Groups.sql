SELECT (
    CASE
    WHEN `age` BETWEEN 0 AND 10 THEN '[0-10]'
	WHEN `age` BETWEEN 11 AND 20 THEN '[11-20]'
    WHEN `age` BETWEEN 21 AND 30 THEN '[21-30]'
    WHEN `age` BETWEEN 31 AND 40 THEN '[31-40]'
    WHEN `age` BETWEEN 41 AND 50 THEN '[41-50]'
    WHEN`age` BETWEEN 51 AND 60 THEN '[51-60]'
    ELSE '[61+]'
    END
    ) AS `age_group`,
	COUNT(`id`) as `wizard_count`
FROM `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `wizard_count`;

#Alternative solution with IF
SELECT
    IF(`age` BETWEEN 0 AND 10, '[0-10]',
    IF(`age` BETWEEN 11 AND 20, '[11-20]',
    IF(`age` BETWEEN 21 AND 30, '[21-30]',
    IF(`age` BETWEEN 31 AND 40, '[31-40]',
    IF(`age` BETWEEN 41 AND 50, '[41-50]',
    IF(`age` BETWEEN 51 AND 60, '[51-60]', '[61+]'
    )))))) AS `age_group`,
	COUNT(`id`) as `wizard_count`
FROM `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `wizard_count`;