package com.study.netflix.repository;

import com.study.netflix.entity.SampleEntity;

import java.util.List;

public interface SampleCustomRepository {
    List<SampleEntity> findAllByName();
}
