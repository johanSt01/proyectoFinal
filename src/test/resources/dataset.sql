INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (1, '884928fa', 'juan@email.com');
INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (2, '8452df4', 'sebas@email.com');
INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (3, '804929hf', 'Andres@email.com');
INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (4, '80345r2f', 'Manu@email.com');
INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (5, '803jfiu9', 'Lore@email.com');

INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (6, 'clave123', 'asparkesa@desdev.cn');
INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (7, 'secreto789', 'ymattiussig@ihg.com');
INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (8, '97439819', 'phailsm@usgs.gov');
INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (9, 'c83u92nm', 'tbovey5@imdb.com');
INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (10, '0198u4lka', 'phailsm@usgs.gov');

INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (11, '624tsa', 'ccordsp@quantcast.com');
INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (12, 'adfh8212', 'mcroallq@blinklist.com');
INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (13, 'dfajh9823', 'wjimer@furl.net');
INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (14, '50989i1lkd', 'dshewsmiths@spotify.com');
INSERT INTO Cuenta (codigo, contrasenia, correo) VALUES (15, '13498aag', 'aperringtont@indiegogo.com');


INSERT INTO Administrador (codigo) VALUES (6);
INSERT INTO Administrador (codigo) VALUES (7);
INSERT INTO Administrador (codigo) VALUES (8);
INSERT INTO Administrador (codigo) VALUES (9);
INSERT INTO Administrador (codigo) VALUES (10);


INSERT INTO Medico (urlfoto, cedula, ciudad, estado_usuario, nombre, telefono, especialidad, hora_fin, hora_inicio, codigo)
VALUES ('url', '12773', 4, 1, 'Dr. Juan', '555-1234', 0, '08:00:00', '16:00:00', 1);
INSERT INTO Medico (urlfoto, cedula, ciudad, estado_usuario, nombre, telefono, especialidad, hora_fin, hora_inicio, codigo)
VALUES ('url', '13982', 0, 0, 'Dr. Sebastian', '555-4321', 0, '08:00:00', '16:00:00', 2);
INSERT INTO Medico (urlfoto, cedula, ciudad, estado_usuario, nombre, telefono, especialidad, hora_fin, hora_inicio, codigo)
VALUES ('url', '181345', 3, 0, 'Dr. Andres', '555-6921', 2, '08:00:00', '16:00:00', 3);
INSERT INTO Medico (urlfoto, cedula, ciudad, estado_usuario, nombre, telefono, especialidad, hora_fin, hora_inicio, codigo)
VALUES ('url', '19921', 1, 0, 'Dra. Manuela', '555-5791', 1, '08:00:00', '16:00:00', 4);
INSERT INTO Medico (urlfoto, cedula, ciudad, estado_usuario, nombre, telefono, especialidad, hora_fin, hora_inicio, codigo)
VALUES ('url', '389134', 3, 0, 'Dra. Lorena', '555-5991', 0, '08:00:00', '16:00:00', 5);


INSERT INTO Paciente (urlfoto, cedula, ciudad, estado_usuario, nombre, telefono, alergias, codigo_tipo_sangre, codigo_eps, fecha_nacimiento, codigo)
VALUES ('url', '1234567890', 1, 1, 'Creighton', '555-5528', 'Ninguna', 0, 0, '2000-05-15', 11);
INSERT INTO Paciente (urlfoto, cedula, ciudad, estado_usuario, nombre, telefono, alergias, codigo_tipo_sangre, codigo_eps, fecha_nacimiento, codigo)
VALUES ('url', '248989451', 1, 1, 'Maureen', '555-9859', 'Ninguna', 1, 0, '2000-05-16', 12);
INSERT INTO Paciente (urlfoto, cedula, ciudad, estado_usuario, nombre, telefono, alergias, codigo_tipo_sangre, codigo_eps, fecha_nacimiento, codigo)
VALUES ('url', '3958798101', 1, 1, 'Waylon', '555-1234', 'Ninguna', 2, 1, '2000-05-17', 13);
INSERT INTO Paciente (urlfoto, cedula, ciudad, estado_usuario, nombre, telefono, alergias, codigo_tipo_sangre, codigo_eps, fecha_nacimiento, codigo)
VALUES ('url', '994891774', 1, 1, 'Delcine', '555-5548', 'Ninguna', 3, 2, '2000-05-18', 14);
INSERT INTO Paciente (urlfoto, cedula, ciudad, estado_usuario, nombre, telefono, alergias, codigo_tipo_sangre, codigo_eps, fecha_nacimiento, codigo)
VALUES ('url', '0499810311', 1, 1, 'Allyson', '555-5611', 'Ninguna', 4, 1, '2000-05-19', 15);


INSERT INTO Cita (codigo, codigo_estado, fecha_cita, fecha_creacion, hora_cita, motivo, cedula_paciente_codigo, codigo_medico_codigo)
VALUES (1, 0, '2023-10-20', '2023-10-19 09:00:00', '09:30:00', 'Consulta de rutina', 11, 1);
INSERT INTO Cita (codigo, codigo_estado, fecha_cita, fecha_creacion, hora_cita, motivo, cedula_paciente_codigo, codigo_medico_codigo)
VALUES (2, 2, '2023-10-21', '2023-10-19 10:00:00', '10:30:00', 'Seguimiento de tratamiento', 12, 2);
INSERT INTO Cita (codigo, codigo_estado, fecha_cita, fecha_creacion, hora_cita, motivo, cedula_paciente_codigo, codigo_medico_codigo)
VALUES (3, 1, '2023-10-22', '2023-10-19 11:00:00', '11:30:00', 'Examen médico', 13, 3);
INSERT INTO Cita (codigo, codigo_estado, fecha_cita, fecha_creacion, hora_cita, motivo, cedula_paciente_codigo, codigo_medico_codigo)
VALUES (4, 2, '2023-10-23', '2023-10-19 12:00:00', '12:30:00', 'Consulta de seguimiento', 14, 4);
INSERT INTO Cita (codigo, codigo_estado, fecha_cita, fecha_creacion, hora_cita, motivo, cedula_paciente_codigo, codigo_medico_codigo)
VALUES (5, 0, '2023-10-24', '2023-10-19 13:00:00', '13:30:00', 'Chequeo anual', 15, 5);


INSERT INTO Atencion (codigo, diagnostico, notas_medicas, tratamiento, codigo_cita_codigo)
VALUES (1, 'Gripe común', 'El paciente debe descansar y tomar líquidos', 'Medicamento para reducir la fiebre', 1);
INSERT INTO Atencion (codigo, diagnostico, notas_medicas, tratamiento, codigo_cita_codigo)
VALUES (2, 'Dolor de espalda', 'Recomendado reposo y ejercicios de estiramiento', 'Analgésicos para el dolor', 2);
INSERT INTO Atencion (codigo, diagnostico, notas_medicas, tratamiento, codigo_cita_codigo)
VALUES (3, 'Presión arterial alta', 'Hacer cambios en la dieta y mantener un registro de la presión', 'Medicamentos antihipertensivos', 3);
INSERT INTO Atencion (codigo, diagnostico, notas_medicas, tratamiento, codigo_cita_codigo)
VALUES (4, 'Infección de garganta', 'Garganta irritada y fiebre', 'Antibióticos recetados', 4);
INSERT INTO Atencion (codigo, diagnostico, notas_medicas, tratamiento, codigo_cita_codigo)
VALUES (5, 'Consulta de seguimiento', 'El paciente se recupera según lo esperado', 'Seguir el tratamiento anterior', 5);

INSERT INTO dia_libre (codigo, dia, codigo_medico_codigo) VALUES (1, '2023-10-29', 1);
INSERT INTO dia_libre (codigo, dia, codigo_medico_codigo) VALUES (2, '2023-10-30', 2);
INSERT INTO dia_libre (codigo, dia, codigo_medico_codigo) VALUES (3, '2023-11-02', 3);
INSERT INTO dia_libre (codigo, dia, codigo_medico_codigo) VALUES (4, '2023-11-03', 4);
INSERT INTO dia_libre (codigo, dia, codigo_medico_codigo) VALUES (5, '2023-11-09', 5);


INSERT INTO PQRS (codigo, estado, fecha_creacion, motivo, tipo, codigo_cita_codigo)
VALUES (1, 1, '2023-10-19 10:00:00', 'Sugerencia para mejorar el servicio', 'Sugerencia', 1);
INSERT INTO PQRS (codigo, estado, fecha_creacion, motivo, tipo, codigo_cita_codigo)
VALUES (2, 2, '2023-10-20 11:30:00', 'Queja sobre el tiempo de espera', 'Queja', 2);
INSERT INTO PQRS (codigo, estado, fecha_creacion, motivo, tipo, codigo_cita_codigo)
VALUES (3, 1, '2023-10-21 14:15:00', 'Reclamo por error en la facturación', 'Reclamo', 3);
INSERT INTO PQRS (codigo, estado, fecha_creacion, motivo, tipo, codigo_cita_codigo)
VALUES (4, 2, '2023-10-22 15:45:00', 'Solicitud de cambio de cita', 'Solicitud', 4);
INSERT INTO PQRS (codigo, estado, fecha_creacion, motivo, tipo, codigo_cita_codigo)
VALUES (5, 1, '2023-10-23 16:30:00', 'Sugerencia para ampliar horarios de atención', 'Sugerencia', 5);


INSERT INTO mensaje (codigo, fecha_creacion, mensaje, codigo_cuenta_codigo, codigo_mensaje_codigo, codigo_pqrs_codigo)
VALUES (1, '2023-10-19 10:15:00', 'Hola, necesito información adicional sobre mi cita', 11, 1, 1);
INSERT INTO mensaje (codigo, fecha_creacion, mensaje, codigo_cuenta_codigo, codigo_mensaje_codigo, codigo_pqrs_codigo)
VALUES (2, '2023-10-20 11:30:00', 'Estoy experimentando síntomas adicionales', 12, 2, 2);
INSERT INTO mensaje (codigo, fecha_creacion, mensaje, codigo_cuenta_codigo, codigo_mensaje_codigo, codigo_pqrs_codigo)
VALUES (3, '2023-10-21 14:00:00', '¿Cuál es el costo del tratamiento?', 13, 3, 3);
INSERT INTO mensaje (codigo, fecha_creacion, mensaje, codigo_cuenta_codigo, codigo_mensaje_codigo, codigo_pqrs_codigo)
VALUES (4, '2023-10-22 15:45:00', '¿Puedo cambiar la fecha de mi cita?', 14, 4, 4);
INSERT INTO mensaje (codigo, fecha_creacion, mensaje, codigo_cuenta_codigo, codigo_mensaje_codigo, codigo_pqrs_codigo)
VALUES (5, '2023-10-23 16:30:00', '¿Puedo cancelar mi cita para la próxima semana?', 15, 5, 5);