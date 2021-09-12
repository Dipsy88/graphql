package com.dipesh.graphqlbackend.resolver.bank;

import com.dipesh.graphqlbackend.domain.bank.Asset;
import com.dipesh.graphqlbackend.domain.bank.BankAccount;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class AssetResolver implements GraphQLResolver<BankAccount> {

   private final ExecutorService executorService =
           Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

   public CompletableFuture<Asset> assets(BankAccount bankAccount){
      return CompletableFuture.supplyAsync(
              ()->{
                 log.info("Getting assets for bank account id {}", bankAccount.getId());
                 return Asset.builder()
                         .id(UUID.randomUUID())
                         .build();
              },executorService);
   }

}
