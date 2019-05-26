--------------------------------------------------  
--             TABLA USUARIOS                   --
-------------------------------------------------- 
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user1','Reyna','Rondo','reyna@email.com','202cb962ac59075b964b07152d234b70','admin','habilitado');
-- la pass para user1 es 123 
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user2','Juan','Perez','juan@email.com','202cb962ac59075b964b07152d234b70','usuario','habilitado');
-- la pass para user2 es 123
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user3','Carlos','Sanchez','carlos@email.com','202cb962ac59075b964b07152d234b70','usuario','deshabilitado');
-- la pass para user3 es 123
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user4','Raul','Lopez','raul@email.com','202cb962ac59075b964b07152d234b70','usuario','habilitado');
-- la pass para user4 es 123
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user5','Juana','Castro','juana@email.com','202cb962ac59075b964b07152d234b70','usuario','deshabilitado');
-- la pass para user5 es 123
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user6','Miguel','Martinez','miguel@email.com','202cb962ac59075b964b07152d234b70','usuario','habilitado');
-- la pass para user6 es 123
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO  ) VALUES  ('user7','Tomas','Gomez','tomas@email.com','202cb962ac59075b964b07152d234b70','admin','habilitado');
-- la pass para user7 es 123
---------------------------------------------------------------------   
--             TABLA ACTIVIDADES DE LOS USUARIOS                   --
--------------------------------------------------------------------- 
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Inicia sesión',  timestamp '2019-05-25 21:22:23',2);
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Guarda texto',  timestamp '2019-05-25 21:22:34',2);
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Cierra sesión',  timestamp '2019-05-25 21:22:58',2);
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Inicia sesión',  timestamp '2019-05-26 11:09:02',2);
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Guarda texto',  timestamp '2019-05-26 11:09:19',2);
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Guarda texto',  timestamp '2019-05-26 11:09:40',2);
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Guarda texto',  timestamp '2019-05-26 11:10:05',2);
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Cierra sesión',  timestamp '2019-05-26 11:10:25',2);
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Inicia sesión',  timestamp '2019-05-20 14:36:48',3);
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Guarda texto',  timestamp '2019-05-20 14:37:04',3);
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Guarda texto',  timestamp '2019-05-20 14:37:35',3);
INSERT INTO ACTIVIDAD (DESCRIPCION, FECHA, ID_USUARIO)VALUES ('Cierra sesión',  timestamp '2019-05-20 14:37:58',3);

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
INSERT INTO PREGUNTA(PREGUNTA ) VALUES('¿Pregunta 1?');
INSERT INTO PREGUNTA(PREGUNTA ) VALUES('¿Pregunta 2?');
INSERT INTO PREGUNTA(PREGUNTA ) VALUES('¿Pregunta 3?');
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



