INSERT INTO ROLE(ROLE) VALUES ('ROLE_ADMIN');
INSERT INTO ROLE(ROLE) VALUES ('ROLE_TURISTA');
INSERT INTO ROLE(ROLE) VALUES ('ROLE_TURISMOLOGO');

INSERT INTO CLIENT(NAME, CPF, DATA_NASCIMENTO, TEL_NUMBER, MAIL, USERNAME, PASSWORD) VALUES ('Douglas','123123',TO_DATE('07-08-200'),123123123,'doug@yahoo.com','doug','$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
-- INSERT INTO TURISTA(CLIENT_ID) VALUES (1);
INSERT INTO CLIENT_ROLE(CLIENT_ID, ROLE_ID) VALUES (1, 1);

INSERT INTO CLIENT(NAME, CPF, DATA_NASCIMENTO, TEL_NUMBER, MAIL, USERNAME, PASSWORD) VALUES ('Rafael','123123',TO_DATE('07-08-200'),123123123,'doug@yahoo.com','rafa','$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
-- INSERT INTO TURISTA(CLIENT_ID) VALUES (1);
INSERT INTO CLIENT_ROLE(CLIENT_ID, ROLE_ID) VALUES (2, 2);

INSERT INTO CLIENT(NAME, CPF, DATA_NASCIMENTO, TEL_NUMBER, MAIL, USERNAME, PASSWORD) VALUES ('Neide','123123',TO_DATE('07-08-200'),123123123,'doug@yahoo.com','neide','$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
-- INSERT INTO TURISTA(CLIENT_ID) VALUES (1);
INSERT INTO CLIENT_ROLE(CLIENT_ID, ROLE_ID) VALUES (3, 3);

-- INSERT INTO CLIENT(NAME, CPF, DATA_NASCIMENTO, TEL_NUMBER, MAIL, USERNAME, PASSWORD) VALUES ('Douglas',123123,'2022-07-07',123123123,'doug@yahoo.com','doug','$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
-- INSERT INTO CLIENT_ROLE(CLIENT_ID, ROLE_ID) VALUES (1, 3);

INSERT INTO CIDADE(NAME, CEP, LATITUDE, LONGITUDE) VALUES ('Florianópolis', '88000000', 27.5948, 48.5569);
INSERT INTO ATRACAO(NAME, TEL_NUMBER, ENDERECO, DESCRICAO, TIPO, LATITUDE, LONGITUDE, cidade_id) VALUES ('Praia Mole', 123123123, 'Rodovia Sc 403', 'Praia para surf', 'Praia', 27.6022, 48.4327, 1);
INSERT INTO ALIMENTACAO(local_name, phone_number, street_name, description, street_district, street_number, latitude, longitude, cidade_id) VALUES ('Bar do Boni', 123123123, 'Av. Rendeiras', 'Bar com frutos do mar', 'Lagoa da conceição', 2600, 27.607, 48.441, 1);
INSERT INTO HOTEL(hotel_name, phone_number, street_name, street_district, street_number, description_hotel, latitude, longitude, cidade_id) VALUES ('Hotel Praia Mole', 123123123, 'Rodovia Sc 403', 'Lagoa da Conceição', 260, 'Hotel a beira mar', 27.604, 48.436, 1);


