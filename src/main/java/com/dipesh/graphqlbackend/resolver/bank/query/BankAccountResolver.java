package com.dipesh.graphqlbackend.resolver.bank.query;

import com.dipesh.graphqlbackend.domain.bank.BankAccount;
import com.dipesh.graphqlbackend.domain.bank.Client;
import com.dipesh.graphqlbackend.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.SelectedField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {
   public BankAccount bankAccount(UUID id, DataFetchingEnvironment environment){
      log.info("Retrieving ban account id: {}", id);
      log.info(id+"");
      Client clientA = Client.builder().id(UUID.randomUUID()).firstName("Dipesh").lastName("Pradhan").build();
      Client clientB = Client.builder().id(UUID.randomUUID()).firstName("Dipesh2").lastName("Pradhan2").build();

      clientA.setClient(clientB);
      clientB.setClient(clientA);

      Set<String> requestedFields = environment.getSelectionSet().getFields().stream()
              .map(SelectedField::getName)
              .collect(Collectors.toUnmodifiableSet());
      System.out.println(requestedFields);

      return BankAccount.builder()
              .id(id)
              .currency(Currency.USD)
              //.client(clientA)
              .build();
   }
}
