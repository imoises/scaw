--------------------------------------------------  
--             TABLA USUARIOS                   --
-------------------------------------------------- 
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user1','Reyna','Rondo','reyna@email.com','202cb962ac59075b964b07152d234b70','admin','habilitado');
-- la pass para user1 es 123 
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user2','Juan','Perez','juan@email.com','202cb962ac59075b964b07152d234b70','usuario','habilitado');
-- la pass para user1 es 1234
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user3','Carlos','Sanchez','carlos@email.com','1234','usuario','deshabilitado');
-- la pass para user1 es 1234
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user4','Raul','Lopez','raul@email.com','1234','usuario','habilitado');
-- la pass para user1 es 1234
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user5','Juana','Castro','juana@email.com','1234','usuario','deshabilitado');
-- la pass para user1 es 1234
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user6','Miguel','Martinez','miguel@email.com','1234','usuario','habilitado');
-- la pass para user1 es 1234
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user7','Tomas','Gomez','tomas@email.com','1234','admin','habilitado');
-- la pass para user1 es 1234
---------------------------------------------------------------------   
--             TABLA ACTIVIDADES DE LOS USUARIOS                   --
--------------------------------------------------------------------- 
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Se loguea',  timestamp '2017-10-12 21:22:23',2);

---------------------------------------------------------------------   
--             TABLA TEXTOS DE LOS USUARIOS                       --
---------------------------------------------------------------------
INSERT INTO TEXTO (DESCRIPCION,ID_USUARIO) VALUES ('se guarda texto',1);

---------------------------------------------------------------------   
--             TABLA CONTRASEÑAS VIEJAS                            --
---------------------------------------------------------------------
INSERT INTO PASSWORD_VIEJO(PASSWORD, FECHA, ID_USUARIO) VALUES ('202cb962ac59075b964b07152d234b70',timestamp '2017-10-12 21:22:23' ,2);
---------------------------------------------------------------------   
--             TABLA PREGUNTAS DE SEGURIDAD                        --
---------------------------------------------------------------------
INSERT INTO PREGUNTA(PREGUNTA ) VALUES('¿Preunta 1?');
INSERT INTO PREGUNTA(PREGUNTA ) VALUES('¿Preunta 2?');
INSERT INTO PREGUNTA(PREGUNTA ) VALUES('¿Preunta 3?');
---------------------------------------------------------------------   
--             TABLA SEGURIDAD                                    --
---------------------------------------------------------------------
INSERT INTO SEGURIDAD(RESPUESTA, ID_USUARIO) VALUES('Respuesta 1 user 1',1);
INSERT INTO SEGURIDAD(RESPUESTA, ID_USUARIO) VALUES('Respuesta 2 user 1',1);
INSERT INTO SEGURIDAD(RESPUESTA, ID_USUARIO) VALUES('Respuesta 3 user 1',1);
INSERT INTO SEGURIDAD(RESPUESTA, ID_USUARIO) VALUES('Respuesta 1 user 2',2);
INSERT INTO SEGURIDAD(RESPUESTA, ID_USUARIO) VALUES('Respuesta 2 user 2',2);
INSERT INTO SEGURIDAD(RESPUESTA, ID_USUARIO) VALUES('Respuesta 3 user 2',2);
---------------------------------------------------------------------   
--             TABLA INTERMEDIA ENTRE SEG-PREG                     --
---------------------------------------------------------------------
INSERT INTO SEGURIDAD_PREGUNTA(ID_SEGURIDAD,ID_PREGUNTA )	VALUES(1,1);
INSERT INTO SEGURIDAD_PREGUNTA(ID_SEGURIDAD,ID_PREGUNTA )	VALUES(2,2);
INSERT INTO SEGURIDAD_PREGUNTA(ID_SEGURIDAD,ID_PREGUNTA )	VALUES(3,3);
INSERT INTO SEGURIDAD_PREGUNTA(ID_SEGURIDAD,ID_PREGUNTA )	VALUES(4,1);
INSERT INTO SEGURIDAD_PREGUNTA(ID_SEGURIDAD,ID_PREGUNTA )	VALUES(5,2);
INSERT INTO SEGURIDAD_PREGUNTA(ID_SEGURIDAD,ID_PREGUNTA )	VALUES(6,3);



