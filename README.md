# Algemeen
POC ASync-API met als model Bibliotheek

POC Om met behulp van AsyncAPI een bibliotheek op te kunnen zetten aanvullend met een schema registry en een event-catalog. Alsmede het auto-genereren van lavacode vanuit die AsyncAPI specifications.

## Genereer classes vanuit AsyncAPI specification m.b.v. Java Spring

**Leden Service**

```ag -o ./ledendienst ledendienst.yaml -p listenerPollTimeout=5000 -p javaPackage=nl.ind.gebeurtenissturingpoc.ledendienst @asyncapi/java-spring-template --force-write```
```ag -o ./ledendienst ledendienst.yaml -p javaPackage=nl.ind.gebeurtenissturingpoc.ledenservice @asyncapi/java-spring-cloud-stream-template --force-write```

```ag -o ./ledendienst ledendienst.yaml -p listenerPollTimeout=5000 -p javaPackage=nl.ind.gebeurtenissturingpoc.ledendienst ~/iCloud/Coding\ /java-spring-template --force-write```


**Leden View Service**

```ag -o ./rapportagedienst rapportagedienst.yaml -p listenerPollTimeout=5000 -p javaPackage=nl.ind.gebeurtenissturingpoc.rapportagedienst ~/java-spring-template/ --force-write```

# Stappenplanclear
### 1. Omgevingsvariabelen aanpassen aan lokale waarden
   - .env file aanpassen aan lokale IP-adres
   - 
### 2. Opstarten Apicurio Registry en bouwen keycloak
cd docker-compose && docker-compose -f docker-compose.keycloak.yml build && cd..

docker-compose -f docker-compose/docker-compose-apicurio.yaml up
of d.m.v. >> button in IntelliJ

### 3. Gebruikers aanmaken in keycloak 

Standaard op http://<IP>:8090

### 4. Inloggen in registry en uploaden data
Anonymous access toestaan of uitvogelen hoe te uploaden naar de registry met een wachtwoord via de command line.
[Documentatielink]

**Web manier**
Standaard op http://<IP>:8080
- Als redirect niet lukt dient de redirect-url misscien aangepast te worden in keycloak (uitleg waar)

Uploaden van de schema's en de gebeurtenissen onder hun respectievelijke identifiers en grouping. Voorzetje:
- bibliotheek-schema
  - Models / objecten 
- bibliotheek-gebeurtenissen
  - Gebeurtenissen, shared en niet
- bibliotheek-diensten
  - Diensten bestanden ASyncAPI

**Command line**
Een mogelijkheid is, na het opvragen van de oauth2 access token bij keycloak (standaard lokaal op poort 8090), de artifacts
los via curl te pushen.

    curl -X POST -H "Content-Type: application/json; artifactType=AVRO" \
    -H "X-Registry-ArtifactId: toet" \
    -H "Authorization: Bearer <CODE>> \
    --data-binary "<FILE_LOCATION>" \
    <REGISTRY_URL>/apis/registry/v2/groups/default/artifacts

Je kan de default group wijzigen in een aangemaakte group. 
Het is echter eenvoudiger de web ui te gebruiken van de registry zelf.

Alle API documentatie is overigens te vinden op https://www.apicur.io/registry/docs/apicurio-registry/2.4.x/assets-attachments/registry-rest-api.htm

### 5. Mavenbouwstap ophalen ASyncAPI specificatie versie
TODO: Vanuit apicurio registry documentatie maven plugin vinden.

### 6. Genereren van de broncode voor de service
TODO: Uitzoeken wat de spring cloud streaming template voor elkaar bokst.

### 7: Lokaal starten van kafka cluster
docker-compose -f docker-compose/docker-compose-kafka-axon.yaml

### 8. Starten service
etc.
