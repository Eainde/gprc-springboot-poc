package com.eainde.server.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eainde.proto.HelloWorldRequest;
import com.eainde.proto.HelloWorldResponse;
import com.eainde.proto.HelloWorldServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class GreeterServer extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {
    private static final Logger logger = LoggerFactory.getLogger(GreeterServer.class);

    @Override
    public void helloWorld(HelloWorldRequest request, StreamObserver<HelloWorldResponse> responseObserver) {
        HelloWorldResponse setResponseMessage = HelloWorldResponse.newBuilder()
                .setResponseMessage("Hello " + request.getClientName() + " !!!").build();
        logger.info(String.format("%1s sent a message: %1s", request.getClientName(),request.getRequestMessage()));
        responseObserver.onNext(setResponseMessage);
        responseObserver.onCompleted();
    }

}