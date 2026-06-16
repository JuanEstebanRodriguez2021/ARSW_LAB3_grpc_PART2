package edu.eci.arsw.gateway;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: gateway/wellnessgateway.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WellnessGatewayGrpc {

  private WellnessGatewayGrpc() {}

  public static final java.lang.String SERVICE_NAME = "WellnessGateway";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.gateway.GatewayAppointmentRequest,
      edu.eci.arsw.gateway.GatewayAppointmentResponse> getCreateAppointmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAppointment",
      requestType = edu.eci.arsw.gateway.GatewayAppointmentRequest.class,
      responseType = edu.eci.arsw.gateway.GatewayAppointmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.gateway.GatewayAppointmentRequest,
      edu.eci.arsw.gateway.GatewayAppointmentResponse> getCreateAppointmentMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.gateway.GatewayAppointmentRequest, edu.eci.arsw.gateway.GatewayAppointmentResponse> getCreateAppointmentMethod;
    if ((getCreateAppointmentMethod = WellnessGatewayGrpc.getCreateAppointmentMethod) == null) {
      synchronized (WellnessGatewayGrpc.class) {
        if ((getCreateAppointmentMethod = WellnessGatewayGrpc.getCreateAppointmentMethod) == null) {
          WellnessGatewayGrpc.getCreateAppointmentMethod = getCreateAppointmentMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.gateway.GatewayAppointmentRequest, edu.eci.arsw.gateway.GatewayAppointmentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAppointment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.gateway.GatewayAppointmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.gateway.GatewayAppointmentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WellnessGatewayMethodDescriptorSupplier("CreateAppointment"))
              .build();
        }
      }
    }
    return getCreateAppointmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.eci.arsw.gateway.GatewayGymRequest,
      edu.eci.arsw.gateway.GatewayGymResponse> getReserveGymSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReserveGymSession",
      requestType = edu.eci.arsw.gateway.GatewayGymRequest.class,
      responseType = edu.eci.arsw.gateway.GatewayGymResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.eci.arsw.gateway.GatewayGymRequest,
      edu.eci.arsw.gateway.GatewayGymResponse> getReserveGymSessionMethod() {
    io.grpc.MethodDescriptor<edu.eci.arsw.gateway.GatewayGymRequest, edu.eci.arsw.gateway.GatewayGymResponse> getReserveGymSessionMethod;
    if ((getReserveGymSessionMethod = WellnessGatewayGrpc.getReserveGymSessionMethod) == null) {
      synchronized (WellnessGatewayGrpc.class) {
        if ((getReserveGymSessionMethod = WellnessGatewayGrpc.getReserveGymSessionMethod) == null) {
          WellnessGatewayGrpc.getReserveGymSessionMethod = getReserveGymSessionMethod =
              io.grpc.MethodDescriptor.<edu.eci.arsw.gateway.GatewayGymRequest, edu.eci.arsw.gateway.GatewayGymResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReserveGymSession"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.gateway.GatewayGymRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.eci.arsw.gateway.GatewayGymResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WellnessGatewayMethodDescriptorSupplier("ReserveGymSession"))
              .build();
        }
      }
    }
    return getReserveGymSessionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WellnessGatewayStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WellnessGatewayStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WellnessGatewayStub>() {
        @java.lang.Override
        public WellnessGatewayStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WellnessGatewayStub(channel, callOptions);
        }
      };
    return WellnessGatewayStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WellnessGatewayBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WellnessGatewayBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WellnessGatewayBlockingStub>() {
        @java.lang.Override
        public WellnessGatewayBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WellnessGatewayBlockingStub(channel, callOptions);
        }
      };
    return WellnessGatewayBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WellnessGatewayFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WellnessGatewayFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WellnessGatewayFutureStub>() {
        @java.lang.Override
        public WellnessGatewayFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WellnessGatewayFutureStub(channel, callOptions);
        }
      };
    return WellnessGatewayFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createAppointment(edu.eci.arsw.gateway.GatewayAppointmentRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.gateway.GatewayAppointmentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAppointmentMethod(), responseObserver);
    }

    /**
     */
    default void reserveGymSession(edu.eci.arsw.gateway.GatewayGymRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.gateway.GatewayGymResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReserveGymSessionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WellnessGateway.
   */
  public static abstract class WellnessGatewayImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WellnessGatewayGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WellnessGateway.
   */
  public static final class WellnessGatewayStub
      extends io.grpc.stub.AbstractAsyncStub<WellnessGatewayStub> {
    private WellnessGatewayStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WellnessGatewayStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WellnessGatewayStub(channel, callOptions);
    }

    /**
     */
    public void createAppointment(edu.eci.arsw.gateway.GatewayAppointmentRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.gateway.GatewayAppointmentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAppointmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reserveGymSession(edu.eci.arsw.gateway.GatewayGymRequest request,
        io.grpc.stub.StreamObserver<edu.eci.arsw.gateway.GatewayGymResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReserveGymSessionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WellnessGateway.
   */
  public static final class WellnessGatewayBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WellnessGatewayBlockingStub> {
    private WellnessGatewayBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WellnessGatewayBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WellnessGatewayBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.eci.arsw.gateway.GatewayAppointmentResponse createAppointment(edu.eci.arsw.gateway.GatewayAppointmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAppointmentMethod(), getCallOptions(), request);
    }

    /**
     */
    public edu.eci.arsw.gateway.GatewayGymResponse reserveGymSession(edu.eci.arsw.gateway.GatewayGymRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReserveGymSessionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WellnessGateway.
   */
  public static final class WellnessGatewayFutureStub
      extends io.grpc.stub.AbstractFutureStub<WellnessGatewayFutureStub> {
    private WellnessGatewayFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WellnessGatewayFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WellnessGatewayFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.gateway.GatewayAppointmentResponse> createAppointment(
        edu.eci.arsw.gateway.GatewayAppointmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAppointmentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.eci.arsw.gateway.GatewayGymResponse> reserveGymSession(
        edu.eci.arsw.gateway.GatewayGymRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReserveGymSessionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_APPOINTMENT = 0;
  private static final int METHODID_RESERVE_GYM_SESSION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_APPOINTMENT:
          serviceImpl.createAppointment((edu.eci.arsw.gateway.GatewayAppointmentRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.gateway.GatewayAppointmentResponse>) responseObserver);
          break;
        case METHODID_RESERVE_GYM_SESSION:
          serviceImpl.reserveGymSession((edu.eci.arsw.gateway.GatewayGymRequest) request,
              (io.grpc.stub.StreamObserver<edu.eci.arsw.gateway.GatewayGymResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateAppointmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.gateway.GatewayAppointmentRequest,
              edu.eci.arsw.gateway.GatewayAppointmentResponse>(
                service, METHODID_CREATE_APPOINTMENT)))
        .addMethod(
          getReserveGymSessionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.eci.arsw.gateway.GatewayGymRequest,
              edu.eci.arsw.gateway.GatewayGymResponse>(
                service, METHODID_RESERVE_GYM_SESSION)))
        .build();
  }

  private static abstract class WellnessGatewayBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WellnessGatewayBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.eci.arsw.gateway.WellnessGatewayProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WellnessGateway");
    }
  }

  private static final class WellnessGatewayFileDescriptorSupplier
      extends WellnessGatewayBaseDescriptorSupplier {
    WellnessGatewayFileDescriptorSupplier() {}
  }

  private static final class WellnessGatewayMethodDescriptorSupplier
      extends WellnessGatewayBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WellnessGatewayMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WellnessGatewayGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WellnessGatewayFileDescriptorSupplier())
              .addMethod(getCreateAppointmentMethod())
              .addMethod(getReserveGymSessionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
