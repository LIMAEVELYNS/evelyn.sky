#Author: Evelyn Lima
#Data de Cria��o: 20/01/21
@Programacoes
Feature: Sky Programacoes
  Eu, como Tester
  Quero validar a funcionaliadde programa��es no site da SKY

  Background: 
    Given que seja selecionado Menu programacao

  @CY001
  Scenario: CY001_Selecionar programacao atual
    When seleciono passando agora
    And clico na programacao agora
    Then sera apresentado pop-up com programacao selecionada