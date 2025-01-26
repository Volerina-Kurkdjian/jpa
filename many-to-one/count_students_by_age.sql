DELIMITER $$

DROP PROCEDURE IF EXISTS count_student_by_age;
CREATE PROCEDURE count_student_by_age(IN  s_age CHAR(20), OUT s_count INT)
BEGIN
  SELECT COUNT(*) INTO s_count FROM student WHERE age = s_age;
END $$

DELIMITER ;