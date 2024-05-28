@register
Feature: Authentification

  Scenario: Création de compte avec succès
    Given Je suis sur la page de CREATION_COMPTE
    When Je renseigne mes informations correctes
    And Je confirme mon inscription grâce au lien reçu par mail
    Then Mon compte devrait être activé



