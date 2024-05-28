Feature:Login

  Background:
    Given Je suis sur la page de CONNEXION

  @login
  Scenario: Se connecter à la plateforme  avec succès
    When Je me connecte avec mes accès
    Then Je suis connecté et sur la page d'accueil

  @login-firstly
  Scenario: Se connecter à la plateforme  une première fois
    When Je me connecte avec mes accès
    And Je remplie les informations de mon profil
    Then Je suis connecté et sur la page d'accueil


