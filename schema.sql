begin transaction;

DROP TABLE IF EXISTS build, talent, users,mantra, build_talent, build_mantra;

CREATE TYPE talent_weapon AS ENUM('LIGHT', 'MEDIUM', 'HEAVY');

create table users (
	user_id SERIAL PRIMARY KEY,
	hash varchar(200),
	user_name varchar(30)
	);

create table build(
	build_id SERIAL PRIMARY KEY,
	user_id BIGINT REFERENCES users(user_id) ON DELETE CASCADE,
	build_name varchar(20),
	strength BIGINT,
	fortitude BIGINT,
	agility BIGINT,
	willpower BIGINT,
	charisma BIGINT,
	songchant BIGINT,
	erudition BIGINT,
	proficiency BIGINT,
	vitality BIGINT

	);

	create table talent (
	talent_id SERIAL PRIMARY KEY,
	talent_name varchar(50),
	talent_desc varchar(500)
	);

	create table mantra (
	mantra_id SERIAL PRIMARY KEY,
	mantra_name varchar(15),
	mantra_desc varchar(200)
	);

			--JOIN TABLES--

	create table build_talent(
	build_id BIGINT REFERENCES build(build_id) ON DELETE CASCADE,
	talent_id BIGINT REFERENCES talent(talent_id) ON DELETE CASCADE,
	PRIMARY KEY(build_id, talent_id)
	);

	create table build_mantra(
	build_id BIGINT REFERENCES build(build_id) ON DELETE CASCADE,
	mantra_id BIGINT REFERENCES mantra(mantra_id) ON DELETE CASCADE,
	PRIMARY KEY(build_id, mantra_id)
	);

	create table talent_requirement(
	talent_id BIGINT REFERENCES talent(talent_id) ON DELETE CASCADE,
	stat varchar(25),
	value INT NOT NULL,
	PRIMARY KEY(talent_id, stat)
	);

	create table mantra_requirement(
	mantra_id BIGINT REFERENCES mantra(mantra_id) ON DELETE CASCADE,
	stat varchar(25),
	value INT NOT NULL,
	PRIMARY KEY(mantra_id, stat)
	);


    ALTER TABLE talent
    ADD COLUMN talent_weapon talent_weapon;

	commit;

	--rollback;