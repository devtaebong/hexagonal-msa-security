package com.study.netflix.sample;

import org.springframework.stereotype.Repository;

@Repository
public class SampleHttpAdapter implements SamplePort {
    @Override
    public SamplePortResponse getSample() {
        return new SamplePortResponse("hello world");
    }
}
