package com.dipesh.graphqlbackend.resolver.bank;

import com.dipesh.graphqlbackend.domain.bank.BankAccount;
import com.dipesh.graphqlbackend.domain.bank.Client;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

   private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

   public CompletableFuture<Client> client(BankAccount bankAccount) {

//      throw new GraphQLException("Client unavailable");

      return CompletableFuture.supplyAsync(()-> {
         log.info("Requesting client data for bank account is {}", bankAccount.getId());
         return Client.builder()
                 .id(UUID.randomUUID())
                 .firstName("Dipeshhhh")
                 .lastName("Pradhannnn")
                 .build();
      }, executorService);

   }
}
