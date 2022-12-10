package com.studentinformationsystem.registrarservice.dto.semester;

import java.util.Date;

public class UpdateSemesterRequest {
    private String id;
    private String name;
    private Date startDate;
    private Date finishDate;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }
}
