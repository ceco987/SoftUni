DELIMITER //
create procedure usp_get_older(minion_id INT)
BEGIN
    update minions
        set age = age +1
    where id = minion_id;
END //
