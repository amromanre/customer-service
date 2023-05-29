package com.nttdata.customer.models.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastNane;

    @NotEmpty
    private String birthDate;

    @NotEmpty
    private String dni;

    @NotEmpty
    private String clientType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
}
