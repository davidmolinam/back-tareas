package com.dmolina.authorizeservice.models.dto.tasks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTaskDto {

    private String taskName;
    private List<Long> actions;
    private Long personId;
    private int minutes;

}
