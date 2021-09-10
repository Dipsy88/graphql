package com.dipesh.graphqlbackend.domain.bank;

import lombok.Builder;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Builder
public class Client {
   UUID id;
   String firstName;
   String lastName;
   List<String> middleNames;
   Client client;
}
