CREATE TABLE loto_users (user_id VARCHAR(30) PRIMARY KEY, user_name VARCHAR(30), user_email VARCHAR(30), encoded_password VARCHAR(255));

CREATE TABLE loto_masters (
	loto_index VARCHAR(30) PRIMARY KEY,
	loto_date VARCHAR(30),
	victory_number VARCHAR(30),
	victory_amount VARCHAR(255),
	victory_people VARCHAR(255),
	carry_over VARCHAR(255),
);

CREATE TABLE loto_historys (
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id VARCHAR(30),
	loto_index VARCHAR(30),
	loto_date VARCHAR(30),
	victory_number VARCHAR(30),
	purchased_no VARCHAR(30)
	);
