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

Exemplo de script SQL para criação e importação de dados simulados no banco de dados a partir de arquivo *csv* resultante da simulação:

        CREATE TABLE alarmes (tag character varying(255), data timestamp without time zone, data_final timestamp without time zone, tempo_duracao integer NOT NULL);
        COPY alarmes FROM 'path\to\file.csv' DELIMITER ';' CSV;
        
****

A simulação se baseia em alguns parâmetros a serem configurados para a execução. Inicialmente, faz-se necessário informar quantos alarmes devem ser simulados. Para cada alarme, a informação da probabilidade de ocorrência e duração média das ocorrências deste alarme devem ser fornecidas. Sendo assim, conforme o código *Main.java* na pasta *AlarmDatSimulator*, o código inicia sua implementação criando o cenário a ser simulado, neste cenário são declarados os alarmes com seus respectivos parâmetros de probabilidade e duração média. 

Neste ponto, temos os alarmes industriais devidamente configurados. Entretanto, não há nenhuma informação de relações causais existentes. Desta forma, a próxima etapa da configuração do cenário de simulação é direcionada em configurar a relação causal entre cada alarme industrial previamente declarado.

Para cada relação causal, algumas informação devem ser fornecidas. A saber: a probabilidade causalidade e o atraso médio entre as ocorrências da relação causal. Desta forma, informamos, para cada relação de par de alarmes a ser configurada,  a probabilidade que dada a ocorrência da causa a consequência irá ocorrer e o atraso com que a ocorrência da consequência irá ocorrer após a ocorrência da causa. O arquivo *Main.java* contém um exemplo da criação das relações causais de acordo com os alarmes configurados.

Por fim, a informação da data inicial da simulação e a sua respectiva duração são requisitadas para a execução da simulação. Tais informações estão exemplificadas no código *Main.java*.

****

A pasta *database* contém cenários criados com propositos experimentais em projetos de pesquisa e publicações científicas. Em cada pasta são fornecidos os parâmetros de simulação utilizados, diagramas dos alarmes configurados e os resultados obtidos. 




