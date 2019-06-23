--------------------------------------------------  
--             TABLA USUARIOS                   --
-------------------------------------------------- 
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO, FECHAULTIMOCAMBIOPASS) VALUES  ('user1','Reyna','Rondo','reyna@email.com','$2a$10$WW470h3a/SnE/9o3AWarr.zSKDseXv87rN11sQwtmCo.5Z8/oQg2.','admin','habilitado', timestamp '2019-06-21 21:22:23');
-- la pass para user1 es 123 
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO, FECHAULTIMOCAMBIOPASS) VALUES  ('user2','Juan','Perez','juan@email.com','$2a$10$WW470h3a/SnE/9o3AWarr.zSKDseXv87rN11sQwtmCo.5Z8/oQg2.','usuario','habilitado', timestamp '2019-06-21 21:22:23');
-- la pass para user2 es 123
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO, FECHAULTIMOCAMBIOPASS) VALUES  ('user3','Carlos','Sanchez','carlos@email.com','$2a$10$WW470h3a/SnE/9o3AWarr.zSKDseXv87rN11sQwtmCo.5Z8/oQg2.','usuario','deshabilitado', timestamp '2019-06-21 21:22:23');
-- la pass para user3 es 123
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO, FECHAULTIMOCAMBIOPASS) VALUES  ('user4','Raul','Lopez','raul@email.com','$2a$10$WW470h3a/SnE/9o3AWarr.zSKDseXv87rN11sQwtmCo.5Z8/oQg2.','usuario','habilitado', timestamp '2019-06-21 21:22:23');
-- la pass para user4 es 123
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO, FECHAULTIMOCAMBIOPASS) VALUES  ('user5','Juana','Castro','juana@email.com','$2a$10$WW470h3a/SnE/9o3AWarr.zSKDseXv87rN11sQwtmCo.5Z8/oQg2.','usuario','deshabilitado', timestamp '2019-06-21 21:22:23');
-- la pass para user5 es 123
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO, FECHAULTIMOCAMBIOPASS) VALUES  ('user6','Miguel','Martinez','miguel@email.com','$2a$10$WW470h3a/SnE/9o3AWarr.zSKDseXv87rN11sQwtmCo.5Z8/oQg2.','usuario','habilitado', timestamp '2019-01-03 01:02:03'); -- debe modificar pass al loguear
-- la pass para user6 es 123
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO, FECHAULTIMOCAMBIOPASS) VALUES  ('user7','Tomas','Gomez','tomas@email.com','$2a$10$WW470h3a/SnE/9o3AWarr.zSKDseXv87rN11sQwtmCo.5Z8/oQg2.','admin','habilitado', timestamp '2019-06-21 21:22:23');
-- la pass para user7 es 123
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO, FECHAULTIMOCAMBIOPASS) VALUES  ('root','','','root','','bloqueado','bloqueado', timestamp '2019-06-21 21:22:23');
-- la pass para user1 es 123 
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO, FECHAULTIMOCAMBIOPASS) VALUES  ('admin','','','admin','','bloqueado','bloqueado', timestamp '2019-06-21 21:22:23');
-- la pass para user1 es 123 
INSERT INTO USUARIO(NICKNAME, NOMBRE, APELLIDO, EMAIL, PASSWORD, ROL, ESTADO, FECHAULTIMOCAMBIOPASS) VALUES  ('sa','','','sa','','bloqueado','bloqueado', timestamp '2019-06-21 21:22:23');
-- la pass para user1 es 123 

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
INSERT INTO PASSWORD_VIEJO(PASSWORD, FECHA, ID_USUARIO) VALUES ('$2a$10$WW470h3a/SnE/9o3AWarr.zSKDseXv87rN11sQwtmCo.5Z8/oQg2.',timestamp '2017-10-12 21:22:23' ,2);
---------------------------------------------------------------------   




