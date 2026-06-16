package edu.eci.arsw.wellbeing;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AppointmentGrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder
                .forPort(50051)
                .addService(new AppointmentServiceImpl())
                .build();

        server.start();

        System.out.println("Servidor gRPC iniciado en puerto 50051");

        server.awaitTermination();
    }

    static class AppointmentServiceImpl extends AppointmentServiceGrpc.AppointmentServiceImplBase {

        private final Map<Integer, Appointment> appointments = new HashMap<>();
        private final AtomicInteger idGenerator = new AtomicInteger(1);

        @Override
        public void requestAppointment(
                AppointmentRequest request,
                StreamObserver<AppointmentResponse> responseObserver) {

            int appointmentId = idGenerator.getAndIncrement();

            Appointment appointment = Appointment.newBuilder()
                    .setId(appointmentId)
                    .setStudentId(request.getStudentId())
                    .setServiceType(request.getServiceType())
                    .setDate(request.getDate())
                    .setStatus(Status.REQUESTED)
                    .build();

            appointments.put(appointmentId, appointment);

            AppointmentResponse response = AppointmentResponse.newBuilder()
                    .setAppointment(appointment)
                    .setSuccess(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void cancelAppointment(
                CancelRequest request,
                StreamObserver<CancelResponse> responseObserver) {

            Appointment appointment =
                    appointments.get(request.getAppointmentId());

            CancelResponse response;

            if (appointment != null) {

                Appointment updatedAppointment =
                        appointment.toBuilder()
                                .setStatus(Status.CANCELLED)
                                .build();

                appointments.put(
                        updatedAppointment.getId(),
                        updatedAppointment
                );

                response = CancelResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Cita cancelada correctamente")
                        .build();

            } else {

                response = CancelResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Cita no encontrada")
                        .build();
            }

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void getAppointments(
                StudentRequest request,
                StreamObserver<AppointmentList> responseObserver) {

            AppointmentList.Builder builder =
                    AppointmentList.newBuilder();

            for (Appointment appointment : appointments.values()) {

                if (appointment.getStudentId() == request.getStudentId()
                        && appointment.getStatus() != Status.CANCELLED) {

                    builder.addAppointments(appointment);
                }
            }

            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        }
    }
}