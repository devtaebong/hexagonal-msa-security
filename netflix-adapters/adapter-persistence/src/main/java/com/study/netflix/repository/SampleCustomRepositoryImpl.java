package com.study.netflix.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.netflix.entity.QSampleEntity;
import com.study.netflix.entity.SampleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SampleCustomRepositoryImpl implements SampleCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<SampleEntity> findAllByName() {
        return jpaQueryFactory.selectFrom(QSampleEntity.sampleEntity)
                .fetch();
    }
}
