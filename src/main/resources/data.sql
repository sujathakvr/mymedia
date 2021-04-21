INSERT INTO users (username, password, enabled)
 values ('blah',
 		'blah',
 		true);

INSERT INTO users (username, password, enabled)
 values ('admin',
 		'admin',
 		true);
 		 		
INSERT INTO authorities (username, authority)
 values	('blah', 'ROLE_USER');

INSERT INTO authorities (username, authority)
 values	('admin', 'ROLE_ADMIN');
 	