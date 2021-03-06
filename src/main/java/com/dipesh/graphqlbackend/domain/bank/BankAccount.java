package com.dipesh.graphqlbackend.domain.bank;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@Value
public class BankAccount {
   UUID id;
   Currency currency;
   Client client;
   Asset asset;

}
