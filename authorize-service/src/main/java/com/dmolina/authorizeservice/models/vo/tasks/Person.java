package com.dmolina.authorizeservice.models.vo.tasks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="personas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Serializable {


    private static final long serialVersionUID = -8194409926452458040L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long selectorId;

}