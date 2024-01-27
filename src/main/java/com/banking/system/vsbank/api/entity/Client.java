package com.banking.system.vsbank.api.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    @NotBlank(message ="id client is mandatory")
    private long id;
    @NotBlank(message = "client name cannot be blank")
    private String name;
    //private List<Account> accounts;
}