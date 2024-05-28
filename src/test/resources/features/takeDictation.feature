@dictation
Feature:Réalisation d'une dictée

  Background:
    Given Je suis sur la page de CONNEXION
    And Je me connecte avec mes accès
    And Je suis connecté et sur la page d'accueil

  Scenario: Rechercher  une dictée existante
    Given Je suis connecté et sur la page details d'une dictée
    When J écoutes la dictée et je réponds avec le paragraphe
    And Je soumets cette reponse pour la correction
    Then La dictée est corrigé, aucune faute n'est detectée
    And J'obtiens une note correcte
