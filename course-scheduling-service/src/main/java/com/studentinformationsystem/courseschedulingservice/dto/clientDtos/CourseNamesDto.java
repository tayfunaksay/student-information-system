package com.studentinformationsystem.courseschedulingservice.dto.clientDtos;

import lombok.Builder;

import java.util.Objects;
@Builder
public class CourseNamesDto {
    private String originalName;
    private String turkishName;

    public CourseNamesDto() {
    }

    public CourseNamesDto(String originalName, String turkishName) {
        this.originalName = originalName;
        this.turkishName = turkishName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getTurkishName() {
        return turkishName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseNamesDto that = (CourseNamesDto) o;
        return Objects.equals(originalName, that.originalName) && Objects.equals(turkishName, that.turkishName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalName, turkishName);
    }

    @Override
    public String toString() {
        return "CourseNamesDto{" +
                "originalName='" + originalName + '\'' +
                ", turkishName='" + turkishName + '\'' +
                '}';
    }
}
