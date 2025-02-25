package com.study.netflix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "sample")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SampleEntity {
    @Id
    @Column(name = "SAMPLE_ID")
    private String sampleId;

    @Column(name = "SAMPLE_NAME")
    private String sampleName;

    @Column(name = "SAMPLE_DESC")
    private String sampleDescription;
}
