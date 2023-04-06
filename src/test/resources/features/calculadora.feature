#language: pt


@regressivo
Funcionalidade: Calculadora de valores
  Eu como usuario
  Gostaria de utilizar a calculadora
  Para calcular e quitar as dívidas


  Contexto: Tela da Calculadora
    Dado que estou na tela principal

  @multiplicar
  Cenario: Multiplicar valores
    Quando insiro os valores "7" e "7"
    E clicar em igual
    Entao deve ser exibido o resultado "49"
