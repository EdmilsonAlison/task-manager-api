package com.machinesoftware.intelligentvampire.domain.model;

import com.machinesoftware.intelligentvampire.util.constant.TaskConst;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = TaskConst.TABLE_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = TaskConst.COLUMN_ID)
    private Integer id;

    @NotBlank
    @Column(name = TaskConst.COLUMN_NAME)
    private String name;

    @Column(name = TaskConst.COLUMN_DESCRIPTION)
    private String description;

    @Column(name = TaskConst.COLUMN_DATE_START)
    private LocalDate dateStart;

    @Column(name = TaskConst.COLUMN_DATE_END)
    private LocalDate dateEnd;

    @Column(name = TaskConst.COLUMN_COMPLETED)
    private Boolean completed;
}
