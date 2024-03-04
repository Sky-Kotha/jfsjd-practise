package com.cass1;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.stargate.grpc.StargateBearerToken;
import io.stargate.proto.QueryOuterClass;
import io.stargate.proto.StargateGrpc;

/**
 * Hello world!
 *
 */
public class App {

        private static final String ASTRA_DB_ID = "92ab13e3-cc4d-4e58-b362-f4061a317221";
        private static final String ASTRA_DB_REGION = "us-east1";
        private static final String ASTRA_TOKEN = "AstraCS:fSiQOffTPqKvuonKjDPyuBul:f42ab59e844d869d4ff56e8faa7f0a11023f7ede6b211d60de68291d0c150b21";
        // private static final String ASTRA_TOKEN =
        // "AstraCS:FdAWzDUysZHJuXwAdafgqEgN:f97b55365b3c9116e55e99071c5c8cbb5628c501abf377e4cbffd0e85d93fa1f";
        private static final String ASTRA_KEYSPACE = "cass1";

        public static void main(String[] args) throws Exception {
                System.out.println("Hello World!");

                // -------------------------------------
                // 1. Initializing Connectivity
                // -------------------------------------
                ManagedChannel channel = ManagedChannelBuilder
                                .forAddress(ASTRA_DB_ID + "-" + ASTRA_DB_REGION + ".apps.astra.datastax.com", 443)
                                .useTransportSecurity()
                                .build();

                // blocking stub version
                StargateGrpc.StargateBlockingStub blockingStub = StargateGrpc.newBlockingStub(channel)
                                .withDeadlineAfter(10, TimeUnit.SECONDS)
                                .withCallCredentials(new StargateBearerToken(ASTRA_TOKEN));

                QueryOuterClass.Response queryString = blockingStub.executeQuery(QueryOuterClass.Query.newBuilder()
                                .setCql("SELECT name, email FROM " + ASTRA_KEYSPACE + ".students")
                                .build());
        }
}
