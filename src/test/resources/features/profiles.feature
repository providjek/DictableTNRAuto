Feature:Gestion de compte et profiles

  Background:
    Given Je suis sur la page de CONNEXION
    And Je me connecte avec mes accès

  @add
  Scenario: Ajouter un profile avec succès
    Given Je suis sur la page de ADD_PROFILE
    When Je crée un nouveau profil avec les informations
    Then Le nouveau profil est créé avec succès

