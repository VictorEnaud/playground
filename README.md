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
[] Implémenter une authentification
[] Implémenter des rôles
[] HATEOAS
[] Swagger
[] Implémenter la persistence
[] Feature flags

### Front-end

[] Avoir un frontend SPA
[] Avoir un frontend MPA
[] Avoir un frontend avec hotwired
[] Comparer SPA, MPA et hotwired

### Séparation des bounded-contexts

[] Essayer JPMS
[] Essayer Modulith
[] Essayer le multi-modules
[] Comparer JPMS, Modulith et le multi-modules

### Déploiement

[] Définir la CI/CD
[] Dockeriser l'application
[] Déployer quelque part
[] Configuration/Environnement

### Outillage

[x] Pouvoir lister les dépendances à mettre à jour
[] Pouvoir lister les vulnérabilités
[] Avoir un linter
[] Imposer un format de commit
[x] Introduire un Makefile

### Observabilité

[] Correlation-id
[] Essayer OpenTelemetry
[] Structured logging

### Architecture

[] Distinguer read/write
[] Modulariser le monolithe en s'appuyant sur les bounded contexts
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
[] Générer automatiquement le changelog

### Tests

[] Documenter la pyramide de tests
[] Implémenter testcontainers
[] Contract testing
