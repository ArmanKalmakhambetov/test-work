package kz.armank.testwork.service.abstracts;

import java.util.Map;

public interface FrequencyService {

    Map<Character, Long> calculateFrequency(String input);
}
