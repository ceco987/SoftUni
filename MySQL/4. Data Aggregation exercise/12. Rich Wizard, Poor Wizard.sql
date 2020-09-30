SELECT SUM(e1.deposit_amount-e2.deposit_amount) AS sum_difference
FROM wizzard_deposits AS e1, wizzard_deposits AS e2
WHERE e2.id = e1.id+1;