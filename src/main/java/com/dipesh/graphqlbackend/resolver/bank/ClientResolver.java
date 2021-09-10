package com.dipesh.graphqlbackend.resolver.bank;

import com.dipesh.graphqlbackend.domain.bank.BankAccount;
import com.dipesh.graphqlbackend.domain.bank.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

   public DataFetcherResult<Client> client(BankAccount bankAccount) {
      log.info("Requesting client data for bank account is {}", bankAccount.getId());

//      throw new GraphQLException("Client unavailable");

      /*return DataFetcherResult.<Client>newResult()
              .data(Client.builder()
                      .id(UUID.randomUUID())
                      .firstName("Dipeshhhhh")
                      .lastName("Pradhannnn")
                      .build())
              .error(new GenericGraphQLError("Could not get sub client id"))
              .build();*/
      return DataFetcherResult.<Client>newResult()
              .data(Client.builder()
                      .id(UUID.randomUUID())
                      .firstName("Dipeshhhhh")
                      .lastName("Pradhannnn")
                      .build())
               .build();

   }
}
