CREATE TABLE professor (
	prof_nome CHAR(60) PRIMARY KEY NOT NULL,
	prof_email CHAR(60),
	prof_sala CHAR(20)
);

CREATE TABLE disciplina (
	disc_id CHAR(20) PRIMARY KEY NOT NULL,
	disc_nome CHAR(60),
	fk_prof_nome CHAR(60),
	disc_sala CHAR(512),
	FOREIGN KEY (fk_prof_nome) REFERENCES professor(prof_nome)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);

CREATE TABLE bibliografia (
	bib_id INTEGER PRIMARY KEY AUTOINCREMENT,
	fk_disc_id CHAR(20),
	bib_texto CHAR(200),
	FOREIGN KEY (fk_disc_id) REFERENCES disciplina(disc_id) 
		ON DELETE CASCADE
);

CREATE TABLE evento (
	event_id INTEGER PRIMARY KEY AUTOINCREMENT,
	event_datahora DATETIME,
	event_duracao DATETIME,
	event_descricao CHAR(200)
);

CREATE TABLE evento_avaliativo (
	event_id INTEGER PRIMARY KEY AUTOINCREMENT,
	event_datahora DATETIME,
	event_duracao DATETIME,
	event_descricao CHAR(220),
	event_aval_tipo CHAR(20),
	event_aval_pontuacao FLOAT,
	fk_disc_id CHAR(20),
	FOREIGN KEY (fk_disc_id) REFERENCES disciplina(disc_id)
		ON DELETE CASCADE
);

CREATE TABLE sticky_notes (
	stk_id INTEGER PRIMARY KEY AUTOINCREMENT,
	stk_text CHAR(120),
	stk_xpos INTEGER,
	stk_ypos INTEGER
);

CREATE TABLE aula (
	aula_id INTEGER PRIMARY KEY AUTOINCREMENT,
	fk_disc_id CHAR(20),
	aula_horario CHAR(10),
	aula_diasemana CHAR(20),
	FOREIGN KEY(fk_disc_id) REFERENCES disciplina(disc_id)
		ON DELETE CASCADE		
);