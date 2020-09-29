SELECT sum(e1.deposit_amount-e2.deposit_amount) as sum_difference
FROM wizzard_deposits AS `e1`, wizzard_deposits as e2
where e2.id = e1.id+1;