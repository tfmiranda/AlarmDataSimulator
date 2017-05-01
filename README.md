# AlarmDataSimulator

*Projeto de Simulador de dados de alarmes industriais*
*A Industrial Alarms Data Simulator project*

Este projeto tem por funcionalidade disponibilizar um simulador de dados de alarmes industriais. Desenvolvido em Java, este simulador se utiliza de gerações de aleatória de ocorrências de alarmes industriais para gerar um arquivo CSV resultante, este sendo útil para importação em banco de dados de sistemas de alarmes industriais.

Os banco de dados de sistemas de alarmes armazenam as ocorrências dos alarmes em uma única tabela. Cada tupla desta tabela contém informações sobre:

- **Identificador do alarme (tag):** Nome do alarme ocorrente;
- **Horário de início (data):** Horário de início da ocorrência;
- **Horário de normalização (data_final):** Horário de normalização da ocorrência;
- **Duraçao (tempo_duracao):** Quantidade de tempo, em segundos, da duração da ocorrência.

Desta forma, o simulador tem por resultado um arquivo *.csv* que representa a lista de todas as ocorrências de alarmes simulados. O arquivo se encontra apto para importação em um banco de dados através do comando **SQL COPY**.

Exemplo de script SQL para criação e importação de dados simulados no banco de dados:

        CREATE TABLE alarmes (tag character varying(255), data timestamp without time zone, data_final timestamp without time zone, tempo_duracao integer NOT NULL);
        COPY alarmes FROM 'path\to\file.csv' DELIMITER ';' CSV;
        
****


