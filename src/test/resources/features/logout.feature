@logout
Feature: Authentification

  Background:
    Given Je suis sur la page de CONNEXION
    And Je me connecte avec mes accès
    And Je suis connecté et sur la page d'accueil

  Scenario: Se déconnecter avec succès
    Given Je suis connecté à la plateforme et j'ai une session en court
    When Je me deconnecte  grâce à l'option déconnexion
    Then Je suis deconnecté et redirigé à la page d'accueil public
