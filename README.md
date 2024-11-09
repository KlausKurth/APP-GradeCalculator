# APP-GradeCalculator

###  **GIF de Demonstração**
Um **GIF** demonstrando o uso do aplicativo está disponível no diretório `app/images/app_example.gif`. O GIF pode ser utilizado para entender visualmente a funcionalidade do aplicativo e o fluxo de interação.


## Visão Geral

Este projeto é um **Aplicativo de Cálculo de Notas** para Android. O aplicativo permite calcular se o aluno foi aprovado ou reprovado com base nas suas notas e faltas. Ele utiliza **ViewBinding** para facilitar o acesso aos componentes da interface e **Kotlin** para a lógica do backend.

O usuário insere as notas do aluno e o número de faltas, e o aplicativo calcula a média das notas e determina se o aluno foi aprovado ou reprovado de acordo com as seguintes condições:
- **Aprovado**: Média das notas >= 7 e faltas < 20
- **Reprovado por nota baixa**: Média das notas < 7
- **Reprovado por faltas excessivas**: Faltas >= 20

## Funcionalidades

- **ViewBinding**: Facilita o acesso aos componentes da interface, eliminando a necessidade de usar `findViewById` e garantindo um código mais limpo e seguro.
- **Validação de Entrada**: Verifica se todos os campos obrigatórios (notas e faltas) foram preenchidos antes de realizar o cálculo.
- **Cálculo da Média**: O aplicativo calcula a média das quatro notas e verifica se o aluno foi aprovado ou reprovado, levando em conta também o número de faltas.
- **Exibição de Resultados**: O resultado é mostrado em um `TextView`, com a cor do texto alterada conforme o resultado (verde para aprovado, vermelho para reprovado).

## Estrutura do Projeto

### 1. **activity_main.xml**
O arquivo XML de layout define a interface do usuário, incluindo:
- Quatro campos **EditText** para a inserção das notas.
- Um campo **EditText** para a inserção do número de faltas.
- Um **Button** para acionar o cálculo da média.
- Um **TextView** para exibir o resultado do cálculo.

### 2. **MainActivity.kt**
A atividade principal do aplicativo contém a lógica para inicializar a interface do usuário e calcular a média do aluno com base nos dados inseridos.

- **ViewBinding** é utilizado para acessar os componentes da interface de forma segura e eficiente.
- O método **`calculateGradeAverage`** é criado fora do método `onCreate` para melhorar a organização e reutilização do código.
- Quando o usuário clica no botão **Calcular**, o aplicativo verifica se todos os campos foram preenchidos. Caso algum campo esteja vazio, uma mensagem é exibida solicitando o preenchimento dos dados.
- Caso todos os campos sejam preenchidos, os valores das notas e faltas são passados para o método `calculateGradeAverage`, que realiza o cálculo e exibe o resultado.




