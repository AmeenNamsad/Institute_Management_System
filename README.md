Institute Management System
============

Welcome to the Institute Management System - CRUD Operations repository! This project focuses on the fundamental functionalities of registering, retrieving, and updating information within an institute. It provides a straightforward solution for managing essential data efficiently.


Requirements
============
* Java >= 11 (OpenJDK JVM is tested by our CI on Travis)
* H2 database

Instructions how to run for local development
============

Run the following commands:
1. `./gradlew bootRun`


Instructions to build the JAR file
============
1. Clone the repository or download and extract the archive file to your local directory.
2. Run `./gradlew clean bootJar` to build a modern cloud native fully self contained JAR file which will be created at `build/libs` directory.
3. Start it using `java -jar build/libs/IMS-0.0.1-SNAPSHOT.jar` (does not require external Tomcat)

    java -jar IMS-0.0.1-SNAPSHOT.jar


Instructions to build a WAR file
============
1. Clone the repository or download and extract the archive file to your local directory.
2. Run `./gradlew clean war` to build a traditional WAR file which will be created at `build/libs` directory.
3. Deploy this WAR to your Tomcat v9 Servlet Container.

We recommend using the JAR instead of the WAR file deployment, because it's much easier.

Note that with the 1.4 release the tenants database pool configuration changed from Tomcat DBCP in XML to an embedded Hikari, configured by environment variables, see above.


Instructions to execute Integration Tests
============

Run the following commands, very similarly to how [.travis.yml](.travis.yml) does:
1. `./gradlew clean test`

Instructions to run using Docker and docker-compose
===================================================

It is possible to do a 'one-touch' installation of Fineract using containers (AKA "Docker").
Fineract now packs the mifos community-app web UI in it's docker deploy.
You can now run and test fineract with a GUI directly from the combined docker builds.
This includes the database running in a container.

As Prerequisites, you must have `docker` and `docker-compose` installed on your machine; see
[Docker Install](https://docs.docker.com/install/) and
[Docker Compose Install](https://docs.docker.com/compose/install/).

Alternatively, you can also use [Podman](https://github.com/containers/libpod)
(e.g. via `dnf install podman-docker`), and [Podman Compose](https://github.com/containers/podman-compose/)
(e.g. via `pip3 install podman-compose`) instead of Docker.

Now to run a new Fineract instance you can simply:

1. `git clone https://github.com/AmeenNamsad/Institute_Management_System.git`
1. `docker-compose build`
1. `docker-compose up -d`
1. fineract (back-end) is running at https://localhost:8443/fineract-provider/
1. wait for https://localhost:8443/fineract-provider/actuator/health to return `{"status":"UP"}`
1. you must go to https://localhost:8443 and remember to accept the self-signed SSL certificate of the API once in your browser, otherwise  you get a message that is rather misleading from the UI.
1. community-app (UI) is running at http://localhost:9090/?baseApiUrl=https://localhost:8443/fineract-provider&tenantIdentifier=default
1. login using default _username_ `mifos` and _password_ `password`

The [`docker-compose.yml`](docker-compose.yml) will build the `fineract` container from the source based on the [`Dockerfile`](Dockerfile).  You could change that to use the pre-built container image instead of having to re-build it.

https://hub.docker.com/r/apache/fineract has a pre-built container image of this project, built continuously.

You must specify the MySQL tenants database JDBC URL by passing it to the `fineract` container via environment
variables; please consult the [`docker-compose.yml`](docker-compose.yml) for exact details how to specify those.
_(Note that in previous versions, the `mysqlserver` environment variable used at `docker build` time instead of at
`docker run` time did something similar; this has changed in [FINERACT-773](https://issues.apache.org/jira/browse/FINERACT-773)),
and the `mysqlserver` environment variable is now no longer supported.)_