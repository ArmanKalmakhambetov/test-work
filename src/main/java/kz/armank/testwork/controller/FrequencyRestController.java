package kz.armank.testwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kz.armank.testwork.service.abstracts.FrequencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Api(value = "Количество вхождений")
public class FrequencyRestController {

    private final FrequencyService frequencyService;

    /**
     * Рассчитывает количество вхождений символов в заданной строке.
     *
     * @param input Строка для подсчета символов.
     * @return ResponseEntity с отсортированным по убыванию количеством вхождений символов.
     */

    @ApiOperation(value = "Посчитать количество вхождений ", response = Map.class)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "input",
                    value = "Вставить строку для подсчета символов",
                    required = true,
                    dataType = "string",
                    paramType = "query",
                    example = "aaaaabcccc"
            )
    })
    @GetMapping("/calculate-frequency")
    public ResponseEntity<Map<Character, Long>> calculateFrequency(@RequestParam String input) {

        return new ResponseEntity<>(frequencyService.calculateFrequency(input), HttpStatus.OK);
    }
}

