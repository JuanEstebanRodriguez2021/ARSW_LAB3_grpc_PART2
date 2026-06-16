# LAB3 Part 2 ARSW-I — gRPC, Microservices and API Gateway

**Juan Esteban Rodríguez**

## Overview

This laboratory explores modern communication mechanisms used in distributed architectures through the implementation of a University Wellness System.

The workshop is divided into three stages:

1. University Wellness Appointment Management using gRPC.
2. Decomposition of the system into Microservices.
3. Integration of services through an API Gateway.

The objective is to understand how service contracts, remote procedure calls, microservice decomposition, and gateway patterns can be used to build scalable distributed systems.

---

# Part I — University Wellness Management using gRPC

## Description

This implementation uses gRPC and Protocol Buffers to manage university wellness appointments.

The communication contract is defined in a `.proto` file, from which Java classes are automatically generated for both the client and the server.

The service provides three remote procedures:

* RequestAppointment
* CancelAppointment
* GetAppointments

Appointments are stored in memory and can be created, queried, and cancelled by students.

The use of gRPC allows strongly typed communication and language-independent service definitions.

## How to Run

Compile the project:

```bash
mvn clean compile
```

Run the server:

```bash
mvn exec:java -Dexec.mainClass=edu.eci.arsw.wellbeing.AppointmentGrpcServer
```

In another terminal, run the client:

```bash
mvn exec:java -Dexec.mainClass=edu.eci.arsw.wellbeing.AppointmentGrpcClient
```

## Evidence

![AppointmentServer.png](docs/AppointmentServer.png)

![AppointmentClient.png](docs/AppointmentClient.png)

## Reflection Questions

### Why is the .proto file considered a contract?

Because it formally defines the operations offered by the service, the request and response messages, and the data types exchanged between client and server. Both parties must follow this specification to communicate successfully.

### How easy would it be to create a client in another language?

Very easy. The same `.proto` file can generate client code for Java, Python, Go, C++, JavaScript, and many other languages without changing the service implementation.

### What differences do you find between RMI and gRPC?

RMI is Java-specific and relies on Java object serialization. gRPC is language-independent, uses Protocol Buffers for serialization, and is designed for modern distributed systems with better interoperability.

---

# Part II — University Wellness Microservices

## Description

The monolithic wellness system was decomposed into independent microservices.

Two services were implemented:

### AppointmentService

Responsible for:

* Creating appointments
* Cancelling appointments
* Retrieving student appointments

Runs on port:

```text
50051
```

### GymService

Responsible for:

* Reserving gym sessions
* Retrieving gym reservations

Runs on port:

```text
50053
```

Each service maintains its own data and business logic independently.

## How to Run

Compile:

```bash
mvn clean compile
```

Run AppointmentService:

```bash
mvn exec:java -Dexec.mainClass=edu.eci.arsw.wellbeing.AppointmentGrpcServer
```

Run GymService:

```bash
mvn exec:java -Dexec.mainClass=edu.eci.arsw.gym.GymGrpcServer
```

Run the client:

```bash
mvn exec:java -Dexec.mainClass=edu.eci.arsw.gym.WellnessClient
```

## Evidence

![AppointmentServer.png](docs/AppointmentServer.png)

![GymServer.png](docs/GymServer.png)

![WellnessClient.png](docs/WellnessClient.png)

## Architecture Diagram

![WellnessServices.jpg](docs/WellnessServices.jpg)

## Reflection Questions

### Why were these services separated?

Because appointment management and gym reservations belong to different business domains. Separating them reduces coupling and allows each service to evolve independently.

### What data belongs to each service?

AppointmentService stores appointment information, while GymService stores reservation information.

### What risk appears when the client knows all services?

The client becomes tightly coupled to service locations and ports. Any change in service deployment may require modifications in all clients.

---

# Part III — Wellness API Gateway

## Description

To reduce client coupling, a WellnessGateway service was introduced.

Instead of communicating directly with multiple microservices, clients interact with a single entry point.

The gateway forwards requests to the appropriate service and returns the corresponding response.

The gateway hides the internal service structure from clients.

## How to Run

Run AppointmentService:

```bash
mvn exec:java -Dexec.mainClass=edu.eci.arsw.wellbeing.AppointmentGrpcServer
```

Run GymService:

```bash
mvn exec:java -Dexec.mainClass=edu.eci.arsw.gym.GymGrpcServer
```

Run WellnessGateway:

```bash
mvn exec:java -Dexec.mainClass=edu.eci.arsw.gateway.WellnessGatewayServer
```

Run the gateway client:

```bash
mvn exec:java -Dexec.mainClass=edu.eci.arsw.gateway.WellnessGatewayClient
```

## Evidence

![GatewayServer.png](docs/GatewayServer.png)

![GatewayClient.png](docs/GatewayClient.png)

## Reflection Questions

### What advantage does the Gateway offer to clients?

Clients only need to know a single endpoint and do not need information about the internal microservice architecture.

### What new responsibility does the Gateway assume?

The Gateway becomes responsible for request routing, service orchestration, and centralizing access to backend services.

### What would happen if a new service were added?

Only the Gateway would need to be updated. Existing clients could continue using the same endpoint without modifications.

---

# Conclusions

This laboratory demonstrated the evolution from a simple RPC service to a microservice-based architecture and finally to an API Gateway pattern.

gRPC provides efficient communication through Protocol Buffers and strongly typed contracts. Microservices improve modularity and scalability by separating business responsibilities. Finally, the API Gateway simplifies client interaction and reduces coupling by exposing a unified entry point to the system.


