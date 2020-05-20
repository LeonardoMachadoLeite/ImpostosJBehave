Scenario: Uma pessoa insere as informações sobre o seu salário
e pede o calculo dos impostos

Given o usuario insira <SALARIO> no campo salario
When o usuario clicar no botao calcular
Then o sistema deve exibir o valor <INSS> para o INSS
And o sistema deve exibir o valor <IRRF> para o IRRF

Examples:
|SALARIO|INSS|IRRF|
|1000|80|0|
|2000|180|0|
|3000|270|54|
|4000|440|164.87|
|5000|550|364.39|
|6000|660|609.14|