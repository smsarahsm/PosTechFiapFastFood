# PosTechFiapFastFood

## Stacks utilizadas:
 - Docker
 - Docker-compose
 - Banco de dados - MariaDB
 - Migration de dados - Flyway
 - Spring boot
 - Swagger

## Ambiente de Desenvolvimento:

Ao executar a aplicação utilizando o comando do Maven. 

`.\mvnw spring-boot:run`

Automaticamente será baixado a imagem Docker do MariaDB e criado um container com o Banco de Dados que será consumido pela 
Aplicação. Isso torna-se possível por causa da dependencia no pom.xml: `org.springframework.boot:spring-boot-docker-compose`.

## Ambiente de Produção

Para o ambiente de Produção, disponibilizamos um arquivo `docker-compose.yaml` para que automatize o processo de download
da imagem da aplicação assim como do banco de dados que será consumido pela aplicação.

## Geração de Imagem Docker

Visando a agilidade no desenvolvimento, geração de imagem docker, etc, foi adicionado um Shell Script na pasta raiz do
projeto chamado `atualiza-docker-image.sh` que contém todos os comandos necessários para geração e push da imagem docker.
Por ser um Shell Script, funciona apenas nos sistemas operacionais que contam com Shell "SH" como Linux, BSD, MacOS, etc.

Para gerar nova imagem docker, basta executar o script com o comando:

`./atualiza-docker-image.sh`

Ao executar o script, já será possível ver o retorno dos comandos. Caso erro de permissão de execução ocorra, será necessário
adicionar permissão de execução no script com o comando: `chmod +x ./atualiza-docker-image.sh`. Após o comando, tente executar
o script novamente.

## Documentação dos Endpoints: 

A aplicação possui Swagger que pode ser acessado através da URL `http://localhost:8080/swagger-ui/index.html`.

## Configuração do K8S:

1 - Instalar o docker desktop
2 - Instalar o WSL
3 - Instalar o Ubunto no WSL
4 - Iniciar o kubernets no docker
5 - Acessar o terminal do Ubunto, navegar até a pasta do projeto, e verificar a instalação do kubectl com "kubectl version /n kubectl cluster-info"
6 - Instalar o kind usando " curl -Lo ./kind https://kind.sigs.k8s.io/dl/v0.29.0/kind-linux-amd64 /n chmod +x ./kind /n sudo mv ./kind /usr/local/bin/kind"
7 - criar um cluster usando "kind create cluster --name fiap-fastfood --config kind/kind-cluster.yaml"
8 - verificar se a criação ocorreu com sucesso usando " kubectl cluster-info --context kind-fiap-fastfood"
9 - instalar o metrics-server utilizando "kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml"
10 -  kubectl apply -f ./k8s/secrets.yaml
11 -  kubectl apply -f ./k8s/configmap.yaml
12 -  kubectl apply -f ./k8s/deployment-db.yaml
13 -  kubectl apply -f ./k8s/deployment-app.yaml
14 -  kubectl apply -f ./k8s/service-db.yaml
15 -  kubectl apply -f ./k8s/service-app.yaml
16 -  kubectl apply -f ./k8s/HPA.yaml
17 - validar se a aplicação está de pé usando "kubectl get service fiap-fastfood"
18 - 