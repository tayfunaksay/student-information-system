package com.studentinformationsystem.registrarservice.dto.semester;

import lombok.Builder;

import java.util.Date;

@Builder
public class SemesterDto {
    public SemesterDto() {
    }

    public SemesterDto(String name, Date startDate, Date finishDate) {
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    private String name;
    private Date startDate;
    private Date finishDate;

}
