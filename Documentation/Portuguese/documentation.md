# Documentação da MainActivity

## Visão geral

A classe `MainActivity` é um componente central de uma aplicação Android escrita em Kotlin. Estende `ComponentActivity` e serve como ponto de entrada para a aplicação. A principal função desta atividade é configurar a interface do utilizador utilizando o Jetpack Compose e aplicar um tema à IU.

# Aplicação conversor de unidades

## Visão geral

Este código define uma UI do Jetpack Compose para uma aplicação de conversão de unidades em Kotlin. Fornece uma interface de utilizador para converter valores entre diferentes unidades de medida. A aplicação permite aos utilizadores introduzir um valor, selecionar unidades de entrada e saída nos menus suspensos e exibir o resultado convertido.

## Componentes principais

1. **Importações:**
- As bibliotecas Jetpack Compose e Material3 necessárias são importadas para facilitar o design e a interação da UI.

2. **Função Combinável:**
- **`@Composable`**: esta anotação é utilizada para definir funções que podem ser compostas e que podem ser utilizadas para criar elementos UI no Jetpack Compose.

## Função Composable: `UnitConverter`

A principal função que pode ser composta é `UnitConverter`, que encapsula toda a UI e lógica de conversão de unidades.

### Gestão do Estado

- **`inputValue`**: Mantém o valor introduzido pelo utilizador como uma `String`.
- **`outputValue`**: Armazena o resultado da conversão como uma `String`.
- **`inputUnit`**: rastreia a unidade selecionada pelo utilizador para entrada.
- **`outputUnit`**: rastreia a unidade selecionada pelo utilizador para saída.
- **`inputExpanded`**: Estado booleano para controlar a visibilidade do menu suspenso da unidade de entrada.
- **`outputExpanded`**: Estado booleano para controlar a visibilidade do menu suspenso da unidade de saída.
- **`outputUnitResult`**: Armazena a unidade de resultado que é apresentada com o valor convertido.
- **`conversionFactor`**: Representa o fator utilizado para converter o valor de entrada em metros.
- **`outputConversionFactor`**: Representa o fator utilizado para converter de metros para a unidade de saída desejada.

### Função: `convertUnits`

- **Finalidade**: Converte o valor de entrada na unidade de saída desejada utilizando os fatores de conversão.
- **Lógica**:
- Verifica se as unidades de entrada e saída estão selecionadas.
- Se nenhuma das unidades for selecionada, o valor de saída será definido como "0,0".
- Caso contrário, realiza a conversão através de uma fórmula:
- Arredonda o resultado às duas casas decimais e actualiza `outputValue`.

### Layout da IU

- **Coluna**: organiza os elementos filhos que podem ser compostos verticalmente com alinhamento central.
- **Texto**: Apresenta o título "Unit Converter" com um estilo personalizado.
- **Espaçador**: Adiciona espaço vertical entre os elementos da UI.
- **OutlinedTextField**: permite ao utilizador introduzir um valor.
- Personaliza as cores das margens e trata das alterações de entrada.
- Chama `convertUnits` para actualizar o valor convertido em cada alteração de entrada.
- **Linha**: Contém botões de seleção da unidade de entrada e saída.
- **Box**: Contém um `Button` e `DropdownMenu` para seleccionar as unidades de entrada.
- **DropdownMenuItem**: cada item representa uma unidade de medida. Clicar num item define a unidade de entrada e o seu fator de conversão.
- **Espaçador**: Adiciona espaço horizontal entre os seletores de unidades de entrada e de saída.
- **Box**: Contém um `Button` e `DropdownMenu` para seleccionar as unidades de saída.
- **DropdownMenuItem**: cada item representa uma unidade de medida. Clicar num item define a unidade de saída e o seu fator de conversão e desencadeia a conversão.
- **Texto**: Apresenta o valor convertido e a unidade de resultado.

A UI ajusta-se dinamicamente ao modo claro ou escuro do dispositivo, garantindo que a interface da aplicação é legível e visualmente apelativa em ambos os temas.

### Visualização

- **`UnitConverterPreview`**: Uma função de visualização anotada com `@Preview`, que permite visualizar o `UnitConverter` que pode ser composto no IDE com um fundo de exemplo.

#### Implementação da caixa de diálogo Histórico

1. **Ver histórico**: Quando o utilizador pressiona o botão para mostrar o histórico, aparece um `AlertDialog`, listando todas as entradas de conversão anteriores. A caixa de diálogo contém dois botões:
- **Botão Fechar**: Fecha a caixa de diálogo sem efetuar alterações.
- **Botão Limpar histórico**: Limpa todas as entradas do histórico e fecha a caixa de diálogo.

2. **Tratar histórico vazio**: Se o histórico estiver vazio, será mostrado um `AlertDialog` diferente para informar o utilizador de que não existem entradas. Esta caixa de diálogo fecha automaticamente após um pequeno atraso.

Aqui está o trecho de implementação para mostrar e gerir a caixa de diálogo do histórico:

```kotlin
if (showHistoryDialog) {
    if (conversionHistory.isEmpty()) {
        AlertDialog(
            onDismissRequest = { showHistoryDialog = false },
            title = { Text(text = "No History") },
            text = { Text("The conversion history is empty.") },
            confirmButton = {
                TextButton(onClick = { showHistoryDialog = false }) {
                    Text("Close")
                }
            }
        )
        LaunchedEffect(Unit) {
            kotlinx.coroutines.delay(3000) // Waits 3 seconds
            showHistoryDialog = false // Closes the dialog
        }
    } else {
        AlertDialog(
            onDismissRequest = { showHistoryDialog = false },
            title = { Text(text = "Conversion History") },
            text = {
                Column {
                    conversionHistory.forEach { entry -> Text(entry) }
                }
            },
            confirmButton = {
                TextButton(onClick = { showHistoryDialog = false }) {
                    Text("Close")

                }
            },
            dismissButton = {
                TextButton(onClick = {
                    conversionHistory.clear()
                    showHistoryDialog = false
                }) {
                    Text("Clear History")
                }
            }
        )
    }
}
```

## Uso

1. **Inicie a aplicação**: Abra a aplicação no seu dispositivo Android ou emulador.

2. **Valor de entrada**: Introduza o valor que pretende converter no campo de texto denominado "Introduza o valor".

3. **Selecionar unidade de entrada**: Toque no menu suspenso junto ao botão da unidade de entrada para selecionar a unidade de medida para o valor de entrada.

4. **Selecionar unidade de saída**: Toque no menu suspenso junto ao botão da unidade de saída para selecionar a unidade de medida para o valor convertido.

5. **Ver resultado**: O valor convertido será apresentado por baixo dos menus suspensos com a unidade de saída selecionada.

Aqui estão algumas capturas de ecrã mostrando a interface do utilizador da aplicação:

### Ecrã do conversor de unidades
![Ecrã do conversor de unidades](/src/App_Images/Captura%20de%20ecrã%202024-09-01%20143939.png)

### Menu suspenso
![Menu suspenso](/app/src/App_Images/Captura%20de%20ecrã%202024-09-01%20144141.png)

### Valor convertido_1
![Valor convertido_1](/app/src/App_Images/Captura%20de%20ecrã%202024-09-01%20144222.png)

### Valor convertido_2
![Valor convertido_2](/app/src/App_Images/Captura%20de%20ecrã%202024-09-01%20144237.png)

### Valor convertido_3
![Valor convertido_3](/app/src/App_Images/Captura%20de%20ecrã%202024-09-01%20144305.png)

### Ecrã DarkMode do conversor de unidades
![Ecrã DarkMode do conversor de unidades](/app/src/App_Images/Captura%20de%20ecrã%202024-09-01%20184308.png)

### Ecrã DarkMode do conversor de unidades_2
![Ecrã DarkMode do conversor de unidades_2](/app/src/App_Images/Captura%20de%20ecrã%202024-09-01%20184336.png)

### Vazio_Histórico
![Empty_Historic](/app/src/App_Images/Captura%20de%20ecrã%202024-09-01%20184351.png)

### Histórico com valores convertidos
![Histórico com valores convertidos](/app/src/App_Images/Captura%20de%20ecrã%202024-09-01%20184417.png)
