-- remove os usuários com e-mail repetido (mantém o primeiro cadastro)
DELETE u1 FROM user u1
	JOIN user u2 ON u1.email = u2.email AND u1.id > u2.id;

-- o e-mail passa a ser único também no banco de dados
ALTER TABLE user ADD CONSTRAINT uk_user_email UNIQUE (email);

CREATE TABLE permission (
	id BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_permission (
	id_user BIGINT(20) NOT NULL,
	id_permission BIGINT(20) NOT NULL,
	PRIMARY KEY (id_user, id_permission),
	FOREIGN KEY (id_user) REFERENCES user(id),
	FOREIGN KEY (id_permission) REFERENCES permission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO permission (id, description) values
	(1, 'ROLE_SEARCH_USER'),
	(2, 'ROLE_ADMIN');

-- usuários já cadastrados: permissão de usuário comum
INSERT INTO user_permission (id_user, id_permission)
	SELECT u.id, p.id FROM user u, permission p WHERE p.id = 1;

-- administrador (senha: admin): todas as permissões
INSERT INTO user (name, email, password, birth_date, gender, active)
	values ('Administrador', 'admin@ifsp.edu.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', '2000-01-01', 'OUTRO', 1);

INSERT INTO user_permission (id_user, id_permission)
	SELECT u.id, p.id FROM user u, permission p WHERE u.email = 'admin@ifsp.edu.br';
