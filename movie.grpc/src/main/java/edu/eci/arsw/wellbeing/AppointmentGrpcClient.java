package edu.eci.arsw.wellbeing;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AppointmentGrpcClient {

    public static void main(String[] args) {

        ManagedChannel channel =
                ManagedChannelBuilder
                        .forAddress("localhost", 50051)
                        .usePlaintext()
                        .build();

        AppointmentServiceGrpc.AppointmentServiceBlockingStub stub =
                AppointmentServiceGrpc.newBlockingStub(channel);

        AppointmentRequest request =
                AppointmentRequest.newBuilder()
                        .setStudentId(1001)
                        .setServiceType(ServiceType.PSYCHOLOGY)
                        .setDate("2026-06-20 10:00")
                        .build();

        AppointmentResponse response =
                stub.requestAppointment(request);

        System.out.println("Cita creada:");
        System.out.println("Id: " +
                response.getAppointment().getId());

        System.out.println("Estado: " +
                response.getAppointment().getStatus());

        StudentRequest studentRequest =
                StudentRequest.newBuilder()
                        .setStudentId(1001)
                        .build();

        AppointmentList appointments =
                stub.getAppointments(studentRequest);

        System.out.println("\nCitas activas:");

        for (Appointment appointment :
                appointments.getAppointmentsList()) {

            System.out.println(
                    "Id: " + appointment.getId()
                            + " Servicio: " + appointment.getServiceType()
                            + " Fecha: " + appointment.getDate()
                            + " Estado: " + appointment.getStatus()
            );
        }

        CancelRequest cancelRequest =
                CancelRequest.newBuilder()
                        .setAppointmentId(
                                response.getAppointment().getId()
                        )
                        .build();

        CancelResponse cancelResponse =
                stub.cancelAppointment(cancelRequest);

        System.out.println("\nCancelación:");
        System.out.println(cancelResponse.getMessage());

        channel.shutdown();
    }
}