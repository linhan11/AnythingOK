
/* Drop Tables */

DROP TABLE history;
DROP TABLE loto;
DROP TABLE loto_user;




/* Create Tables */

CREATE TABLE history
(
	-- user id
	user_id decimal NOT NULL UNIQUE,
	-- 第*回
	loto_index decimal NOT NULL UNIQUE,
	purchased_no varchar,
	PRIMARY KEY (user_id, loto_index)
);


CREATE TABLE loto
(
	-- 第*回
	loto_index decimal NOT NULL UNIQUE,
	loto_date datetime,
	-- 当選番号
	victory_no varchar,
	PRIMARY KEY (loto_index)
);


CREATE TABLE loto_user
(
	-- user id
	user_id decimal DEFAULT 1 NOT NULL UNIQUE,
	name varchar DEFAULT 'null',
	emial varchar,
	password blob(8) NOT NULL,
	PRIMARY KEY (user_id)
);



/* Create Foreign Keys */

ALTER TABLE history
	ADD FOREIGN KEY (loto_index)
	REFERENCES loto (loto_index)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE history
	ADD FOREIGN KEY (user_id)
	REFERENCES loto_user (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



