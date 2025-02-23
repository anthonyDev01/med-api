CREATE TABLE consultas(
    id BIGINT NOT NULL auto_increment,
    medico_id BIGINT NOT NULL,
    paciente_id BIGINT NOT NULL,
    data DATETIME NOT NULL,

    PRIMARY KEY(id)
    constraint fk_consultas_medico_id FOREIGN KEY(medico_id) REFERENCES medicos(id).
    constraint fk_consultas_paciente_id FOREIGN KEY(paciente_id) REFERENCES pacientes(id)
);