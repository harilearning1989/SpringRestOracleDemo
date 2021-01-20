package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MYTABLE")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "in_only_test",
                procedureName = "test_pkg.in_only_test",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "in_and_out_test",
                procedureName = "test_pkg.in_and_out_test",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam1", type = String.class)
                })
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyTable implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "PID")
    private int id;
    @Column(name = "PERSONNAME")
    private String name;
}