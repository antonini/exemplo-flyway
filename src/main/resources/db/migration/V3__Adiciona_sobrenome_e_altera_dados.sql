-- Troca o nome do Jose
ALTER TABLE PESSOA ADD COLUMN SOBRENOME CHAR(100);
UPDATE PESSOA SET SOBRENOME = TRIM(SUBSTRING(NOME, INSTR(NOME,' ')));
UPDATE PESSOA SET NOME = TRIM(SUBSTRING(NOME, 0, INSTR(NOME,' ')));