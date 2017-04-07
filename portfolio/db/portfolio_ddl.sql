CREATE USER 'portfolio'@'localhost' IDENTIFIED BY 'portfolio';

GRANT CREATE,DELETE,INSERT,SELECT,UPDATE ON portfolio.* TO 'portfolio'@'localhost';


REVOKE CREATE,DELETE,INSERT ON *.* FROM 'portfolio'@'localhost';


DROP USER 'porfolio'@'localhost';