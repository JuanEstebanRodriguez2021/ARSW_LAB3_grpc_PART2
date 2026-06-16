package edu.eci.arsw.gateway;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class WellnessGatewayClient {

    public static void main(String[] args) {

        ManagedChannel channel =
                ManagedChannelBuilder
                        .forAddress("localhost",50055)
                        .usePlaintext()
                        .build();

        WellnessGatewayGrpc
                .WellnessGatewayBlockingStub stub =
                WellnessGatewayGrpc
                        .newBlockingStub(channel);

        GatewayAppointmentRequest appointment =
                GatewayAppointmentRequest
                        .newBuilder()
                        .setStudentId(1001)
                        .setServiceType("PSYCHOLOGY")
                        .setDate("2026-06-17 09:00")
                        .build();

        GatewayAppointmentResponse response =
                stub.createAppointment(
                        appointment);

        System.out.println(
                "Cita creada: "
                        + response.getAppointmentId());

        GatewayGymRequest gym =
                GatewayGymRequest
                        .newBuilder()
                        .setStudentId(1001)
                        .setTimeSlot("18:00")
                        .build();

        GatewayGymResponse gymResponse =
                stub.reserveGymSession(
                        gym);

        System.out.println(
                "Reserva gimnasio: "
                        + gymResponse
                        .getReservationId());

        channel.shutdown();
    }
}