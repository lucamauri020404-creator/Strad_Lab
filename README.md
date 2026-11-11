# Strad_Lab
E-commerce streetwear a microservizi realizzato con Spring Boot, Eureka e API REST.

StradLab è la piattaforma di un negozio di abbigliamento streetwear (scarpe, t-shirt, felpe, pantaloni, giacche e cappelli di brand come Nike, Adidas, Champion, Puma, Trapstar, The North Face, Under Armour, Bape). L'utente scorre il catalogo, sceglie un capo, lo mette nel carrello e completa l'acquisto.

Il progetto nasce come esercizio di architettura a microservizi: l'obiettivo è tenere il dominio semplice (un negozio online) per concentrarsi su ciò che che conta lato backend, cioè servizi indipendenti, service discovery, scalabilità e resilienza.

Stato del progetto: in sviluppo. I servizi segnati come completati nella roadmap sono funzionanti, gli altri sono in programma. Il risultato attuale è un'interfaccia web nella seguente immagine: 

<img width="1340" height="897" alt="Screenshot 2026-11-11 162755" src="https://github.com/user-attachments/assets/251ae845-158f-4d02-9d7f-ca60f1d0fb33" />


Architettura attuale: 

<img width="659" height="255" alt="Screenshot 2026-11-11 165224" src="https://github.com/user-attachments/assets/33d559a1-c091-4fa4-a188-439e391decab" />

Modello architetturale a progetto completo: 

<img width="730" height="512" alt="Screenshot 2026-11-11 165950" src="https://github.com/user-attachments/assets/3a5f8aef-c0f8-4f4e-80de-796ea4a439e0" />

Servizi

Servizio	Porta	Stato	Descrizione

eureka-server	8761	Completato	Service discovery (Spring Cloud Netflix Eureka)

catalog-service	8081	Completato	Catalogo prodotti con API REST e frontend web

user-service	n.d.	Da fare	Registrazione, login, emissione del token JWT

api-gateway	n.d.	Da fare	Punto d'ingresso unico e verifica del JWT

cart-service	n.d.	Da fare	Carrello dell'utente

order-service	n.d.	Da fare	Ordini e pagamento simulato

Stack tecnologico

Java 21

Spring Boot 3.3.5

Spring Cloud 2023.0.3 (Netflix Eureka)

Spring Data JPA con database H2 in memoria (per ora)
Maven

Frontend in HTML, CSS e JavaScript puro, servito da catalog-service
API del catalogo

Base URL: http://localhost:8081

Metodo	Endpoint	Descrizione

GET	/products	Elenco di tutti i prodotti

GET	/products?brand=nike	Filtra per brand (non distingue maiuscole)

GET	/products?category=felpe	Filtra per categoria

GET	/products/{id}	Dettaglio di un prodotto

POST	/products	Crea un nuovo prodotto

Esempio di prodotto: 

<img width="629" height="236" alt="Screenshot 2026-11-11 170310" src="https://github.com/user-attachments/assets/5ce01e53-62f8-4633-bfe1-15c7e29c8a05" />

All'avvio, il dataLoader carica un json ritraente un catalogo di esempio dati inseriti in locale così la pagina non è mai vuota.

Avvio del progetto: 

Requisiti: 

JDK 21

Un IDE con supporto Java e Maven 

Avvio

1. Clonare la repository:
   git clone https://github.com/lucamauri020404-creator/Strad_Lab.git
   cd NOME-REPO

2. Avviare Eureka: apri eureka-server ed esegui EurekaServerApplication. In alternativa, con Maven installato:
      cd eureka-server
      mvn spring-boot:run
   
4. Avviare il catalogo: esegui CatalogServiceApplication in catalog-service (oppure mvn spring-boot:run nella sua cartella).

5. Aprire nel browser:

Dashboard Eureka: http://localhost:8761

Frontend del negozio: http://localhost:8081

API: http://localhost:8081/products

Il database H2 è in memory: a ogni riavvio il catalogo riparte dai dati di esempio.

Struttura repository

<img width="636" height="438" alt="Screenshot 2026-11-11 171457" src="https://github.com/user-attachments/assets/99e22793-c260-46d1-9264-6d8ad7c845ef" />

Roadmap
 
 Service discovery con Eureka ✓
 
 Catalog-service con API REST e filtri ✓

 Caricamento dati di esempio ✓ 

 Frontend del catalogo con filtri per categoria ✓
 
 user-service con registrazione, login e JWT X
 
 API Gateway con autenticazione X 
 
 cart-service con comunicazione verso il catalogo (OpenFeign) X
 
 order-service con pagamento simulato X
 
 Circuit breaker con Resilience4j sulla chiamata carrello → catalogo X

 Un database PostgreSQL per ogni servizio X
 
 Avvio completo con Docker Compose X
 
 Documentazione API con Swagger/OpenAPI X
 
 Test automatici X

 Sviluppi futuri

 Messaggistica asincrona (Kafka o RabbitMQ), Config Server centralizzato, pagamenti reali e un frontend più ricco con login e carrello.

Autore
Progetto personale di Luca Mauri, sviluppato come esercizio di architettura a microservizi con Spring Boot.
