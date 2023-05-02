SHELL=/bin/sh

.SHELLFLAGS = -e -c
.ONESHELL:
.PHONY: help

# This Makefile helps the team to dev/debug/act with this project.
# This Makefile is inspired by https://www.padok.fr/en/blog/beautiful-makefile-awk

##@ General
help: ## Show this help
	@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m<target>\033[0m\n"} /^[a-zA-Z_0-9-]+:.*?##/ { printf "  \033[36m%-50s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)


##@ Start a component
start-api: ## Start API
	./gradlew bootRun --args='--spring.profiles.active=local'

##@ Run the tests
test-api: ## Run API tests
	./gradlew test

##@ Format & fix
format-api: ## Format api files
	./gradlew spotlessApply

##@ Dependency management
check-updates: ## Check available updates
	./gradlew --build-cache dependencyUpdates

check-vulnerabilities: ## Check dependencies vulnerabilities
	./gradlew --build-cache dependencyCheckAnalyze
