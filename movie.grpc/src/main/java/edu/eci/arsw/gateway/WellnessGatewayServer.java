package edu.eci.arsw.gateway;

import edu.eci.arsw.gym.*;
import edu.eci.arsw.wellbeing.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class WellnessGatewayServer {

    public static void main(String[] args)
            throws Exception {

        Server server = ServerBuilder
                .forPort(50055)
                .addService(new GatewayImpl())
                .build();

        server.start();

        System.out.println(
                "WellnessGateway iniciado en puerto 50055");

        server.awaitTermination();
    }

    static class GatewayImpl
            extends WellnessGatewayGrpc
            .WellnessGatewayImplBase {

        @Override
        public void createAppointment(
                GatewayAppointmentRequest request,
                StreamObserver<GatewayAppointmentResponse>
                        responseObserver) {

            ManagedChannel channel =
                    ManagedChannelBuilder
                            .forAddress("localhost", 50051)
                            .usePlaintext()
                            .build();

            AppointmentServiceGrpc
                    .AppointmentServiceBlockingStub stub =
                    AppointmentServiceGrpc
                            .newBlockingStub(channel);

            AppointmentRequest grpcRequest =
                    AppointmentRequest.newBuilder()
                            .setStudentId(
                                    request.getStudentId())
                            .setServiceType(
                                    ServiceType.valueOf(
                                            request.getServiceType()))
                            .setDate(
                                    request.getDate())
                            .build();

            AppointmentResponse response =
                    stub.requestAppointment(
                            grpcRequest);

            GatewayAppointmentResponse gatewayResponse =
                    GatewayAppointmentResponse
                            .newBuilder()
                            .setAppointmentId(
                                    response.getAppointment()
                                            .getId())
                            .setStatus(
                                    response.getAppointment()
                                            .getStatus()
                                            .name())
                            .build();

            responseObserver.onNext(
                    gatewayResponse);

            responseObserver.onCompleted();

            channel.shutdown();
        }

        @Override
        public void reserveGymSession(
                GatewayGymRequest request,
                StreamObserver<GatewayGymResponse>
                        responseObserver) {

            ManagedChannel channel =
                    ManagedChannelBuilder
                            .forAddress("localhost", 50053)
                            .usePlaintext()
                            .build();

            GymServiceGrpc
                    .GymServiceBlockingStub stub =
                    GymServiceGrpc
                            .newBlockingStub(channel);

            GymReservationRequest gymRequest =
                    GymReservationRequest
                            .newBuilder()
                            .setStudentId(
                                    request.getStudentId())
                            .setTimeSlot(
                                    request.getTimeSlot())
                            .build();

            GymReservationResponse response =
                    stub.reserveSession(
                            gymRequest);

            GatewayGymResponse gatewayResponse =
                    GatewayGymResponse
                            .newBuilder()
                            .setReservationId(
                                    response.getReservationId())
                            .setSuccess(
                                    response.getSuccess())
                            .build();

            responseObserver.onNext(
                    gatewayResponse);

            responseObserver.onCompleted();

            channel.shutdown();
        }
    }
}