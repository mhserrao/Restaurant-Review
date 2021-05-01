CREATE TABLE Reviews (
id LONG PRIMARY KEY AUTO_INCREMENT,
restaurantName VARCHAR(255),
review VARCHAR(255),
dateOfVisit DATE,
rating DOUBLE,
city VARCHAR(255),
reviewDate DATE,
reviewTime TIME
);