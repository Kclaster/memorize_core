package com.memorize.api.service;

import com.memorize.api.repository.NumberPerformanceRepositoryImpl;
import com.memorize.api.repository.NumberRepositoryImpl;
import com.memorize.model.number.NumberDto;
import com.memorize.model.number.NumberPerformanceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NumberServiceTest {
    @Mock
    private NumberRepositoryImpl mockNumberRepository;

    @Mock
    private NumberPerformanceRepositoryImpl mockNumberPerformanceRepository;

    @InjectMocks
    private NumberServiceImpl numberService;

    @BeforeEach
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        var dummyAthleteId = (UUID.fromString("a41111b1-e1d2-4ca8-b8d3-22628119893b"));
        var dummyNumberDtoId = (UUID.fromString("cc9cd455-7dcc-498e-9b06-a1555bde5673"));
        var dummyNumberPerformanceDtoId = (UUID.fromString("6a267371-14ca-440f-ac9e-80ae30f24e6a"));

        var mockNumberDto = dummyNumberDto(dummyNumberDtoId);
        var mockNumberPerformanceDto = dummyNumberPerformanceDto(dummyNumberPerformanceDtoId);

        when(mockNumberRepository.getNumberData(dummyAthleteId)).thenReturn(mockNumberDto);
        when(mockNumberPerformanceRepository.getNumberPerformance(dummyAthleteId))
                .thenReturn(mockNumberPerformanceDto);
    }

    @Test
    void getNumberData() throws Exception {
        var athleteId = UUID.fromString("a41111b1-e1d2-4ca8-b8d3-22628119893b");
        var numberDtoId = (UUID.fromString("cc9cd455-7dcc-498e-9b06-a1555bde5673"));

        var result = numberService.getNumberData(athleteId);

            verify(mockNumberRepository).getNumberData(athleteId);
            verify(mockNumberPerformanceRepository).getNumberPerformance(numberDtoId);

            assertNotNull(result);
            assertThat(result.getBestScore(), is(equalTo(100)));
    }

    private NumberDto dummyNumberDto(UUID numberDtoId) {
        var dummyNumberDto = new NumberDto();
        dummyNumberDto.setId(numberDtoId);
        dummyNumberDto.setBestScore(100);

        return dummyNumberDto;
    }

    private List<NumberPerformanceDto> dummyNumberPerformanceDto(UUID numberPerformanceDtoId) {
        var dummyNumberPerformanceDtoList = new ArrayList();
        var dummyNumberPerformanceDto = new NumberPerformanceDto();
        dummyNumberPerformanceDto.setAttemptScore(50);
        dummyNumberPerformanceDto.setId(numberPerformanceDtoId);

        dummyNumberPerformanceDtoList.add(dummyNumberPerformanceDto);

        return dummyNumberPerformanceDtoList;
    }
}
