CREATE DATABASE `final-project`;
USE final-project;

CREATE TABLE user(
	user_name VARCHAR(10) NOT NULL PRIMARY KEY,
	password VARCHAR(10) NOT NULL,
	first_name VARCHAR(10) NOT NULL,
	last_name VARCHAR(10) NOT NULL);

CREATE TABLE product(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(10) NOT NULL,
	category VARCHAR(20) NOT NULL,
	price INT NOT NULL,
	quantity INT NOT NULL);

CREATE TABLE usercart(
	id_user VARCHAR(10) NOT NULL,
	id_product INT NOT NULL, 
	product_quantity INT NOT NULL,
	FOREIGN KEY (id_user) REFERENCES user(user_name),
	FOREIGN KEY (id_product) REFERENCES product(id),
	PRIMARY KEY (id_user, id_product));


INSERT INTO product (name, category, price, quantity) VALUES ("name1", "category1", 2, 10); 
INSERT INTO product (name, category, price, quantity) VALUES ("name2", "category2", 4, 10); 
INSERT INTO product (name, category, price, quantity) VALUES ("name3", "category3", 6, 10); 
INSERT INTO product (name, category, price, quantity) VALUES ("name4", "category4", 8, 10); 
INSERT INTO product (name, category, price, quantity) VALUES ("name5", "category5", 10, 10);
INSERT INTO product (name, category, price, quantity) VALUES ("name1", "category6", 12, 10); 
INSERT INTO product (name, category, price, quantity) VALUES ("name6", "category1", 12, 10); 


INSERT INTO user (user_name, password, first_name, last_name) VALUES ("user1", "password1", "name1", "lastname1");
INSERT INTO user (user_name, password, first_name, last_name) VALUES ("user2", "password2", "name2", "lastname2");

INSERT INTO usercart (id_user, id_product, product_quantity) VALUES ("user1", 1, 5);
INSERT INTO usercart (id_user, id_product, product_quantity) VALUES ("user1", 3, 1);


