package com.studentinformationsystem.registrarservice.dto.semester;

import lombok.Builder;

import java.util.Date;
import java.util.Objects;

@Builder
public class SemesterDto {
    private String id;
    private String name;
    private Date startDate;
    private Date finishDate;

    public SemesterDto() {
    }

    public SemesterDto(String id,String name, Date startDate, Date finishDate) {
        this.id=id;
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemesterDto that = (SemesterDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(startDate, that.startDate) && Objects.equals(finishDate, that.finishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, finishDate);
    }

    @Override
    public String toString() {
        return "SemesterDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
