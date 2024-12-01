package org.example.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private long id;
    private long petId;
    private int quantity;
    private Date shipDate;
    private String status;
    private Boolean complete;
}
