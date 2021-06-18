package com.dmolina.authorizeservice.models.vo.tasks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="relacion_tarea_accion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskActionRelation implements Serializable {


    private static final long serialVersionUID = 8507574263250687272L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long selectorId;

    @ManyToOne
    @JoinColumn(name = "FK_TASK")
    private TaskEntity task;

}