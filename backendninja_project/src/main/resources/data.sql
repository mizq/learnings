INSERT INTO contact ( firstname, lastname, telephone, city ) VALUES ( 'Perico', 'Palotes', '999888777', 'Albuquerque' );
INSERT INTO contact ( firstname, lastname, telephone, city ) VALUES ( 'Alberto', 'Gete', '987654321', 'Saucedilla' );
INSERT INTO contact ( firstname, lastname, telephone, city ) VALUES ( 'Federico', 'Gorzas', '987654987', 'Colmenarejo' );

INSERT INTO user ( username, password, enabled ) VALUES ( 'user', '$2a$10$WyXv27GxMIryHhkWGhnZ0u3xaMjFiA5jyQ40jQDPhnct24Ce6hVmC', true );

INSERT INTO user_role ( username, role ) VALUES  ( 'user', 'ROLE_USER' );