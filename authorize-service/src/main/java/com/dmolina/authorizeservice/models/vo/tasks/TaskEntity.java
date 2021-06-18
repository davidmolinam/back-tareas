package com.dmolina.authorizeservice.models.vo.tasks;

import com.dmolina.authorizeservice.models.vo.users.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="tareas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskEntity implements Serializable {


    private static final long serialVersionUID = -4907402064091327516L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String taskName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "selectorId")
    private List<Actions> actions;

    @OneToOne(optional = true,fetch= FetchType.LAZY)
    @JoinColumn(name="selectorId")
    private Person person;

    private int minutes;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id")
    private UserEntity creatorId;

    @CreatedDate
    private LocalDateTime createdAt;

    @Builder.Default
    private LocalDateTime lastPasswordChangeAt = LocalDateTime.now();
}