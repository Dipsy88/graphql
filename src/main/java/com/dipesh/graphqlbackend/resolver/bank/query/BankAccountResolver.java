package com.dipesh.graphqlbackend.resolver.bank.query;

import com.dipesh.graphqlbackend.domain.bank.BankAccount;
import com.dipesh.graphqlbackend.domain.bank.Client;
import com.dipesh.graphqlbackend.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {
   public BankAccount bankAccount(UUID id){
      log.info("Retrieving ban account id: {}", id);
      log.info(id+"");
      Client clientA = Client.builder().id(UUID.randomUUID()).firstName("Dipesh").lastName("Pradhan").build();
      Client clientB = Client.builder().id(UUID.randomUUID()).firstName("Dipesh2").lastName("Pradhan2").build();

      clientA.setClient(clientB);
      clientB.setClient(clientA);

      return BankAccount.builder()
              .id(id)
              .currency(Currency.USD)
              //.client(clientA)
              .build();
   }
}
