package com.intelygenz;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.intelygenz.Models.Numbers;
import com.intelygenz.Repositories.NumbersRepository;
import com.intelygenz.Services.NumberServiceImpl;

@SpringBootTest
class ApplicationTests {


	@MockBean
	private NumbersRepository numbersRepository;

	@Autowired
	private NumberServiceImpl numberServiceImpl;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldReturnOrderedList() {
		List<Integer> expectedResult = new ArrayList<>(Arrays.asList(15, 7, 3, 5, 1));
		Numbers mockNumbersObject = new Numbers(1, "1,15,5,7,3");
		when(numbersRepository.findById(1)).thenReturn(mockNumbersObject);
		List<Integer> actualResult = numberServiceImpl.getOrderedList();

		assertThat(actualResult).isEqualTo(expectedResult);
	}
}
