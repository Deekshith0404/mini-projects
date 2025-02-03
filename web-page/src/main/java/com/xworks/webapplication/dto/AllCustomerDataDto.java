package com.xworks.webapplication.dto;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
@Table(name = "alldataofcustomer")
@NamedQuery(name = "datas",query = "select e from AllCustomerDataDto e where e.userName=:name")
@NamedQuery(name = "grandtotal",query = "select e.totalamount from AllCustomerDataDto e where e.userName=:name")
@NamedQuery(name="alldatas",query = "select e from AllCustomerDataDto e ")
public class AllCustomerDataDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private double quantity;
    private double price;
    private LocalTime time;
    private LocalDate data;
    private double totalamount;
}
