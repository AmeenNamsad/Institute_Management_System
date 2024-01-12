Institute Management System
============

Welcome to the Institute Management System - CRUD Operations repository! This project focuses on the fundamental functionalities of registering, retrieving, and updating information within an institute. It provides a straightforward solution for managing essential data efficiently.

[Document](#Swagger UI)

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

As Prerequisites, you must have `docker` and `docker-compose` installed on your machine; see
[Docker Install](https://docs.docker.com/install/) and
[Docker Compose Install](https://docs.docker.com/compose/install/).

Alternatively, you can also use [Podman](https://github.com/containers/libpod)
(e.g. via `dnf install podman-docker`), and [Podman Compose](https://github.com/containers/podman-compose/)
(e.g. via `pip3 install podman-compose`) instead of Docker.

Now to run a new ims you can simply:

1. `git clone https://github.com/AmeenNamsad/Institute_Management_System.git`
2. `docker build . -t ims`
3. `docker-compose up -d`
4. `ims (back-end) is running at https://localhost:8443/institute/`

The [`docker-compose.yml`](docker-compose.yml) will build the `ims` container from the source based on the [`Dockerfile`](Dockerfile).  You could change that to use the pre-built container image instead of having to re-build it.

### Swagger UI

After running the application Access the [Swagger UI](https://localhost:8443/swagger-ui/index.html#/) for interactive documentation.

