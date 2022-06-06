# Cuzco hotel

[Instructions](INSTRUCTIONS.md)

[Event-storming](https://miro.com/app/board/uXjVOTn_Ln0=/)

## TODO

### Domaines

Liste des domaines de l'application

- Recherche
- Réservation

### DDD

[] Appliquer les patterns tactiques (agrégats, entités, value-objects, repositories)
[] Appliquer les patterns stratégiques (bounded-contexts, ubiquitous language, context map, bounded context canvas)
[] Identifier l'ubiquitous language
[] Générer la context map

### Infrastructure

[] Exposer sur une API
[] HATEOAS
[] Swagger
[] Implémenter la persistence
[] Définir la ci/cd
[] Dockeriser l'application
[] Déployer quelque part
[] Correlation-id
[] RabbitsMQ pour le messaging entre composants
[] Structured logging
[] Configuration/Environnement
[] Feature flags
[] S'isoler de springboot

### Architecture

[] Distinguer read/write
[] Faire de la clean architecture
[] Modulariser le monolithe en s'appuyant sur les bounded contexts
[] Déléguer aux bounded-context l'enregistrement des apis, gestionnaires, etc.
[] Implémenter de l'event sourcing
[] Persistence des messages
[] Optimistic concurrency
[] Versionner les agrégats

### Pattern

[] Implémenter le pattern memento
[] Implémenter le pattern factory
[] Implémenter le pattern Result

### Living documentation

[] Générer la documentation du bounded context
[] Faire des liens dans le summary vers la doc des patterns
[] Générer un site statique de documentation
[] Générer un bounded context Canvas
[] Associer les commandes aux évènements émis
[] Associer les questions aux modèles de lecture

### Tests

[] Faire des tests end to end
[] Avoir des tests utilisables par un QA