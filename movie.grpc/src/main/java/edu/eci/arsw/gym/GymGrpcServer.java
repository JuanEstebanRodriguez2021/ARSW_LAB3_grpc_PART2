package edu.eci.arsw.gym;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class GymGrpcServer {

    public static void main(String[] args)
            throws Exception {

        Server server = ServerBuilder
                .forPort(50053)
                .addService(new GymServiceImpl())
                .build();

        server.start();

        System.out.println(
                "GymService iniciado en puerto 50053");

        server.awaitTermination();
    }

    static class GymServiceImpl
            extends GymServiceGrpc.GymServiceImplBase {

        private final List<GymReservation> reservations =
                new ArrayList<>();

        private int currentId = 1;

        @Override
        public void reserveSession(
                GymReservationRequest request,
                StreamObserver<GymReservationResponse>
                        responseObserver) {

            GymReservation reservation =
                    GymReservation.newBuilder()
                            .setReservationId(currentId)
                            .setStudentId(
                                    request.getStudentId())
                            .setTimeSlot(
                                    request.getTimeSlot())
                            .build();

            reservations.add(reservation);

            GymReservationResponse response =
                    GymReservationResponse.newBuilder()
                            .setReservationId(currentId++)
                            .setSuccess(true)
                            .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void getReservations(
                StudentGymRequest request,
                StreamObserver<GymReservationList>
                        responseObserver) {

            GymReservationList.Builder builder =
                    GymReservationList.newBuilder();

            for (GymReservation reservation :
                    reservations) {

                if (reservation.getStudentId()
                        == request.getStudentId()) {

                    builder.addReservations(reservation);
                }
            }

            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        }
    }
}