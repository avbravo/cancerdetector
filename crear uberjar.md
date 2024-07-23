

# cancerdetector
sistema de flujo de trabajo


#Execute docker compose
docker-compose up -d

java -jar -Xmx512m target/cancerdetector.jar 



Para ejecutar uberjar
java -jar payara-micro-6.2024.7.jar --deploy cancerdetector.war --outputUberJar cancerdetector.jar


#Ejecutar el war


java -jar /home/avbravo/software/payara/payara-micro-6.2024.7.jar  --deploy /home/avbravo/NetBeansProjects/u/alcala/cancerdetector/cancerdetector/target/cancerdetector.war --nocluster --logo --port 8080

java -jar /home/avbravo/software/payara/payara-micro-6.2024.7.jar  --deploy  /home/avbravo/NetBeansProjects/u/alcala/cancerdetector/cancerdetector/target/cancerdetector.war --noHazelcast --logo --port 8080


#Crear  el Uberjar
java -jar   /home/avbravo/software/payara/payara-micro-6.2024.7.jar --deploy /home/avbravo/NetBeansProjects/u/alcala/cancerdetector/cancerdetector/target/cancerdetector.war --outputUberJar /home/avbravo/Descargas/cancerdetector.jar 



# Ejecutar JAR

 java -jar -Xmx512m cancerdetector.jar --noHazelcast --logo --port 8080 >>log.txt


## Mediante maven

Crear el war
```shell

mvn clean verify

cd target

````


Ejecutar 

```shell

mvn clean verify payara-micro:start

cd target

````

## Crear el uber jar

De esta manera el url solo tendria el ip , util para microservicios

```shell

mvn clean verify payara-micro:bundle

cd target

java -jar cancerdetector-bundle.jar
````