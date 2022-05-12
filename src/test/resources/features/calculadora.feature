#language: pt

  Funcionalidade: Calculadora de valores
    Eu como usuario
  Gostaria de utilizar a calculadora
  Para calcular e quitar as dívidas


  Contexto: Tela da Calculadora
    Dado que estou na tela principal

    @multiplicar
  Cenario: Multiplicar valores
    Quando insiro os valores "50" e "10"
    Entao deve ser exibido o resultado "500"
