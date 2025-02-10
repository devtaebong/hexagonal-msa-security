package com.study.netflix.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final SamplePersistencePort samplePersistencePort;

    public String getSample() {
        String sampleName = samplePersistencePort.getSampleName("1");
        return sampleName;
    }
}
