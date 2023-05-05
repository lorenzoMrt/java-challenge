package com.intelygenz.Services;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelygenz.Models.Numbers;
import com.intelygenz.Repositories.NumbersRepository;

@Service
public class NumberServiceImpl implements NumberService {

    @Autowired
    NumbersRepository numbersRepository;

    @Override
    public List<Integer> getOrderedList() {
        Numbers numbers = numbersRepository.findById(1);
        String[] numberArray = numbers.getIntegers().split(",");
        List<Integer> numberList = Arrays.stream(numberArray)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        Comparator<Integer> compareByBitCount = (Integer v1, Integer v2) -> {
            int onesV1 = Integer.bitCount(v1);
            int onesV2 = Integer.bitCount(v2);
            if (onesV1 != onesV2) {
                return onesV2 - onesV1;
            } else {
                return v1 - v2;
            }
        };
        Collections.sort(numberList, compareByBitCount);
        return numberList;
    }
}