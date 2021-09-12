package com.dipesh.graphqlbackend.resolver.bank.mutations;

import com.dipesh.graphqlbackend.domain.bank.BankAccount;
import com.dipesh.graphqlbackend.domain.bank.Currency;
import com.dipesh.graphqlbackend.domain.bank.input.CreateBankAccountInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountMutation implements GraphQLMutationResolver {
   BankAccount createBankAccount(CreateBankAccountInput input) {
      log.info("Creating bank account for {}", input);
      return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.USD).build();
   }
}
