package kz.armank.testwork.controller;

import kz.armank.testwork.service.abstracts.FrequencyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FrequencyRestControllerTest {

    @Mock
    private FrequencyService frequencyService;

    @InjectMocks
    private FrequencyRestController frequencyController;

    @Test
    void testCalculateFrequency() {

        String input = "aaaaabcccc";
        Map<Character, Long> expectedFrequencyMap = new HashMap<>();
        expectedFrequencyMap.put('a', 5L);
        expectedFrequencyMap.put('b', 1L);
        expectedFrequencyMap.put('c', 4L);

        when(frequencyService.calculateFrequency(input)).thenReturn(expectedFrequencyMap);

        ResponseEntity<Map<Character, Long>> responseEntity = frequencyController.calculateFrequency(input);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedFrequencyMap, responseEntity.getBody());
    }
}

