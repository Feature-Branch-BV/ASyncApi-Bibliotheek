# ASyncApi-Bibliotheek
POC Asynch-API met als model Bibliotheek

POC Om met behulp van AsyncAPI een bibliotheek op te kunnen zetten aanvullend met een schema registry en een event-catalog. Alsmede het auto-genereren van lavacode vanuit die AsyncAPI specifications.

## Genereer classes vanuit AsyncAPI specification m.b.v. Java Spring

**Leden Service**

```ag -o ./ledenservice ledenservice.yaml -p listenerPollTimeout=5000 -p javaPackage=nl.ind.gebeurtenissturingpoc.ledenservice @asyncapi/java-spring-template --force-write```

**Leden View Service**

```ag -o ./ledenviewservice ledenviewservice.yaml -p listenerPollTimeout=5000 -p inverseOperations=true -p javaPackage=nl.ind.gebeurtenissturingpoc.ledenviewservice @asyncapi/java-spring-template --force-write```
