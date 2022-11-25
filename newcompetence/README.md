# Microservice des personnes

Ce microservice permet de gérer les compétences et leurs persistances en base de données.

## Installation

### Prérequis

- Une instance mongoDB sur le port 27017
- Besoin du service de gestion des équipes

### Lancement

Lancer la commande suivante :

```bash
gradlew run
```

ou depuis un IDE, lancer la classe `CompetencesApplication`

## API

### Création d'une competence

```http
POST localhost:9090/api/competences
{
    "id": "UnId",
    "nom": "nomDeCompetence"
    "description": "description"
    "equipeId": "2"
}
```
Attention `equipeId` doit être composé de 12 caractères, de 24 caractères ou d'un integer.
### Récupération d'une competence

```http
GET localhost:9090/api/competences/{id}
```

Ou `{id}` représente l'identifiant de la competence.

### Récupération de toutes les competences

```http
GET localost:9090/api/competences/all
```

### Mise à jour d'une competence

```http
PUT localhost:9090/api/competences
{
    "nom": " nom de la competence"
    "description": "descirption"
    
}
```

### Suppression d'une competence

```http
DELETE localhost:9090/api/competences/{id}
```

### Ajouter une competence à une equipe


```http
POST localhost:9090/api/competences/ajouterCompetence/{id}
```

Ou `{id}` représente l'identifiant de la competence.


### Supprimer une competence à une equipe


```http
DELETE localhost:9090/api/competences/ajouterCompetence/{id}
```

Ou `{id}` représente l'identifiant de la competence.