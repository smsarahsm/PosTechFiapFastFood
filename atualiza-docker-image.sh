#!/bin/sh

# Variaveis do script
DOCKER_IMAGE_TAG=latest
PROJECT_NAME=fiap-fastfood
DOCKER_REGISTRY=maycondockeraccount/fiap-fastfood

# Definindo a variavel JAVA_HOME para o sistema operacional
export JAVA_HOME=/opt/java/jdk-21.0.6 # Ajustar de acordo com a necessidade

# Compilando o projeto para gerar o arquivo .JAR da aplicação
./mvnw -DskipTests clean package

# Gerando imagem Docker
docker build -f Dockerfile -t $PROJECT_NAME .

# Utilizando Docker TAG para configurar a imagem e assim, fazer o push dela
docker tag $PROJECT_NAME:$DOCKER_IMAGE_TAG $DOCKER_REGISTRY/$PROJECT_NAME:$DOCKER_IMAGE_TAG

# Fazendo o push da Imagem docker para o Docker Registry
docker push $DOCKER_REGISTRY/$PROJECT_NAME:$DOCKER_IMAGE_TAG