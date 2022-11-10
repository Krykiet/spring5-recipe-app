-- docker run --name mysql_db_name -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

-- Databases
CREATE DATABASE krystian_dev;
CREATE DATABASE krystian_prod;

-- Accounts
CREATE USER 'krystian_dev_user'@'localhost' IDENTIFIED BY 'krystian';
CREATE USER 'krystian_prod_user'@'localhost' IDENTIFIED BY 'krystian';

-- Database grants
GRANT UPDATE ON krystian_dev.* TO 'krystian_dev_user'@'localhost';
GRANT SELECT ON krystian_dev.* TO 'krystian_dev_user'@'localhost';
GRANT INSERT ON krystian_dev.* TO 'krystian_dev_user'@'localhost';
GRANT DELETE ON krystian_dev.* TO 'krystian_dev_user'@'localhost';
GRANT UPDATE ON krystian_prod.* TO 'krystian_prod_user'@'localhost';
GRANT SELECT ON krystian_prod.* TO 'krystian_prod_user'@'localhost';
GRANT INSERT ON krystian_prod.* TO 'krystian_prod_user'@'localhost';
GRANT DELETE ON krystian_prod.* TO 'krystian_prod_user'@'localhost';

-- If using docker:
--GRANT UPDATE ON krystian_dev.* TO 'krystian_dev_user'@*;
--GRANT SELECT ON krystian_dev.* TO 'krystian_dev_user'@*;
--GRANT INSERT ON krystian_dev.* TO 'krystian_dev_user'@*;
--GRANT DELETE ON krystian_dev.* TO 'krystian_dev_user'@*;
--GRANT UPDATE ON krystian_prod.* TO 'krystian_prod_user'@*;
--GRANT SELECT ON krystian_prod.* TO 'krystian_prod_user'@*;
--GRANT INSERT ON krystian_prod.* TO 'krystian_prod_user'@*;
--GRANT DELETE ON krystian_prod.* TO 'krystian_prod_user'@*;