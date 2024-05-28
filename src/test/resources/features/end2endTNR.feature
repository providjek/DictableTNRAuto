@e2e
Feature: Campagne TNR

  Scenario: e2e
    Given Je suis sur la page de CREATION_COMPTE
    When Je renseigne mes informations correctes
    And Je confirme mon inscription grâce au lien reçu par mail

    Given Je suis sur la page de CONNEXION
    When Je me connecte avec mes accès
    Then Je remplie les informations de mon profil
    Then Je suis connecté et sur la page d'accueil

    When Je recherche une dictée
    Then Je peux accéder aux détails de cette dictée

    Given Je suis connecté et sur la page details d'une dictée
    When J écoutes la dictée et je réponds avec le paragraphe
    And Je soumets cette reponse pour la correction
    Then La dictée est corrigé, aucune faute n'est detectée
    And J'obtiens une note correcte

    Given Je suis connecté à la plateforme et j'ai une session en court
    When Je me deconnecte  grâce à l'option déconnexion
    Then Je suis deconnecté et redirigé à la page d'accueil public
