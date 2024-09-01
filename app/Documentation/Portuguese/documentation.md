# Documentação da MainActivity

## Visão Geral

A classe `MainActivity` é um componente central de um aplicativo Android escrito em Kotlin. Ela estende `ComponentActivity` e serve como ponto de entrada para o aplicativo. A função principal desta atividade é configurar a interface do usuário usando Jetpack Compose e aplicar um tema à interface.

# Aplicativo de Conversor de Unidades

## Visão Geral

Este código define uma interface de usuário Jetpack Compose para um aplicativo de conversor de unidades em Kotlin. Ele fornece uma interface para converter valores entre diferentes unidades de medida. O aplicativo permite que os usuários insiram um valor, selecionem unidades de entrada e saída a partir de menus suspensos e exibam o resultado convertido.

## Componentes Principais

1. **Imports:**
    - As bibliotecas necessárias do Jetpack Compose e Material3 são importadas para facilitar o design e a interação da interface.

2. **Função Composable:**
    - **`@Composable`**: Esta anotação é usada para definir funções composables que podem ser usadas para construir elementos de interface no Jetpack Compose.

## Função Composable: `UnitConverter`

A principal função composable é `UnitConverter`, que encapsula toda a interface e lógica de conversão de unidades.

### Gerenciamento de Estado

- **`inputValue`**: Armazena o valor inserido pelo usuário como uma `String`.
- **`outputValue`**: Armazena o resultado da conversão como uma `String`.
- **`inputUnit`**: Controla a unidade selecionada pelo usuário para entrada.
- **`outputUnit`**: Controla a unidade selecionada pelo usuário para saída.
- **`inputExpanded`**: Estado booleano para controlar a visibilidade do menu suspenso da unidade de entrada.
- **`outputExpanded`**: Estado booleano para controlar a visibilidade do menu suspenso da unidade de saída.
- **`outputUnitResult`**: Armazena a unidade de resultado que é exibida com o valor convertido.
- **`conversionFactor`**: Representa o fator usado para converter o valor de entrada para metros.
- **`outputConversionFactor`**: Representa o fator usado para converter de metros para a unidade de saída desejada.

### Função: `convertUnits`

- **Propósito**: Converte o valor de entrada para a unidade de saída desejada usando os fatores de conversão.
- **Lógica**:
    - Verifica se tanto a unidade de entrada quanto a de saída foram selecionadas.
    - Se uma das unidades não for selecionada, define o valor de saída como "0.0".
    - Caso contrário, realiza a conversão usando uma fórmula:
    - Arredonda o resultado para duas casas decimais e atualiza `outputValue`.

### Layout da Interface

- **Column**: Organiza os composables filhos verticalmente com alinhamento central.
    - **Text**: Exibe o título "Conversor de Unidades" com estilização personalizada.
    - **Spacer**: Adiciona espaço vertical entre os elementos da interface.
    - **OutlinedTextField**: Permite que o usuário insira um valor.
        - Personaliza as cores das bordas e lida com alterações de entrada.
        - Chama `convertUnits` para atualizar o valor convertido a cada alteração na entrada.
    - **Row**: Contém botões de seleção de unidades de entrada e saída.
        - **Box**: Contém um `Button` e um `DropdownMenu` para selecionar as unidades de entrada.
            - **DropdownMenuItem**: Cada item representa uma unidade de medida. Clicar em um item define a unidade de entrada e seu fator de conversão.
        - **Spacer**: Adiciona espaço horizontal entre os seletores de unidade de entrada e saída.
        - **Box**: Contém um `Button` e um `DropdownMenu` para selecionar as unidades de saída.
            - **DropdownMenuItem**: Cada item representa uma unidade de medida. Clicar em um item define a unidade de saída e seu fator de conversão, e aciona a conversão.
    - **Text**: Exibe o valor convertido e a unidade de resultado.

### Visualização

- **`UnitConverterPreview`**: Uma função de visualização anotada com `@Preview`, que permite visualizar o composable `UnitConverter` na IDE com um fundo de amostra.

### TODO

- **Valores Convertidos Histórico**: Há um comentário de placeholder indicando a intenção de adicionar funcionalidade para armazenar e exibir valores de conversão históricos.

## Uso

1. **Iniciar o Aplicativo**: Abra o aplicativo em seu dispositivo Android ou emulador.

2. **Inserir Valor**: Insira o valor que você deseja converter no campo de texto rotulado como "Enter the value" (Digite o valor).

3. **Selecionar Unidade de Entrada**: Toque no menu suspenso ao lado do botão de unidade de entrada para selecionar a unidade de medida para o valor de entrada.

4. **Selecionar Unidade de Saída**: Toque no menu suspenso ao lado do botão de unidade de saída para selecionar a unidade de medida para o valor convertido.

5. **Ver Resultado**: O valor convertido será exibido abaixo dos menus suspensos com a unidade de saída selecionada.

Aqui estão algumas capturas de tela mostrando a interface do usuário do aplicativo:

### Captura de Tela 1
![Tela do Conversor de Unidades](/src/App_Images/Captura%20de%20ecrã%202024-09-01%20143939.png)

### Captura de Tela 2
![Menu Suspenso](/src/App_Images/Captura%20de%20ecrã%202024-09-01%20144141.png)

### Captura de Tela 3
![Valor Convertido_1](/src/App_Images/Captura%20de%20ecrã%202024-09-01%20144222.png)

### Captura de Tela 4
![Valor Convertido_2](/src/App_Images/Captura%20de%20ecrã%202024-09-01%20144237.png)

### Captura de Tela 5
![Valor Convertido_3](/src/App_Images/Captura%20de%20ecrã%202024-09-01%20144305.png)
