USE intercollegiate_athletic1;

#INSERT a new row INTO the Facility table with facility name “Swimming Pool”.
INSERT INTO FACILITY(facNo,facName) VALUES ('F1099','Swimming Pool');

#INSERT a new row in the Location table related to the Facility row in modification problem 1. The new row should have “Door” for the location name.
INSERT INTO LOCATION(locNo,facNo,locName) VALUES ('L1099','F1099','Door');

#INSERT a new row in the Location table related to the Facility row in modification problem 1. The new row should have “Locker Room” for the location name.
INSERT INTO LOCATION(locNo,facNo,locName) VALUES ('L1100','F1099','Locker Room');

/*Change the location name of “Door” to “Gate” for the row INSERTed in modification problem 2. In MySQL, you need to place the UPDATE statement between two 
SET statements. set SQL_SAFE_UPDATES = 0; update statement set SQL_SAFE_UPDATES = 1;*/
SET SQL_SAFE_UPDATES = 0;
UPDATE LOCATION SET locName='Gate' WHERE locNo='L1099';
SET SQL_SAFE_UPDATES = 1;

#5.	Delete the row INSERTed in modification problem 3.
DELETE FROM LOCATION WHERE locNo = 'L1100';