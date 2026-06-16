package edu.eci.arsw.gym;

import edu.eci.arsw.wellbeing.*;
import edu.eci.arsw.gym.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class WellnessClient {

    public static void main(String[] args) {

        ManagedChannel appointmentChannel =
                ManagedChannelBuilder
                        .forAddress("localhost",50051)
                        .usePlaintext()
                        .build();

        AppointmentServiceGrpc
                .AppointmentServiceBlockingStub
                appointmentStub =
                AppointmentServiceGrpc
                        .newBlockingStub(
                                appointmentChannel);

        ManagedChannel gymChannel =
                ManagedChannelBuilder
                        .forAddress("localhost",50053)
                        .usePlaintext()
                        .build();

        GymServiceGrpc.GymServiceBlockingStub
                gymStub =
                GymServiceGrpc.newBlockingStub(
                        gymChannel);

        AppointmentRequest appointmentRequest =
                AppointmentRequest.newBuilder()
                        .setStudentId(1001)
                        .setServiceType(
                                ServiceType.PSYCHOLOGY)
                        .setDate(
                                "2026-06-25 09:00")
                        .build();

        AppointmentResponse appointmentResponse =
                appointmentStub
                        .requestAppointment(
                                appointmentRequest);

        System.out.println(
                "Cita creada: "
                        + appointmentResponse
                        .getAppointment()
                        .getId());

        GymReservationRequest gymRequest =
                GymReservationRequest.newBuilder()
                        .setStudentId(1001)
                        .setTimeSlot("18:00")
                        .build();

        GymReservationResponse gymResponse =
                gymStub.reserveSession(gymRequest);

        System.out.println(
                "Reserva gimnasio: "
                        + gymResponse
                        .getReservationId());

        appointmentChannel.shutdown();
        gymChannel.shutdown();
    }
}