package com.eainde.client.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eainde.proto.HelloWorldRequest;
import com.eainde.proto.HelloWorldResponse;
import com.eainde.proto.HelloWorldServiceGrpc.HelloWorldServiceBlockingStub;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class ClientService {
    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    @GrpcClient("grpc-server")
    private HelloWorldServiceBlockingStub helloWorldServiceStub;

    public HelloWorldResponse sayHello(String message) {
        HelloWorldRequest helloWorldRequest = HelloWorldRequest.newBuilder().setClientName("Client")
                .setRequestMessage(message).build();
        HelloWorldResponse helloWorldResponse = this.helloWorldServiceStub.helloWorld(helloWorldRequest);
        logger.info(String.format("Server sent a response: %1s", helloWorldResponse.getResponseMessage()));
        return helloWorldResponse;
    }

}