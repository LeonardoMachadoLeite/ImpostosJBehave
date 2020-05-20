Scenario: Uma pessoa insere as informacoes sobre o seu salario
e pede o calculo dos impostos

Given o usuario insira <SALARIO> no campo salario
When o usuario clicar no botao calcular
Then o sistema deve exibir o valor <INSS> para o INSS
And o sistema deve exibir o valor <IRRF> para o IRRF

Examples:
|SALARIO|INSS|IRRF|
|1000.0|80.0|60.86|
|2000.0|180.0|60.86|
|3000.0|270.0|61.95|
|4000.0|440.0|179.2|
|5000.0|550.0|365.12|
|6000.0|660.0|599.14|