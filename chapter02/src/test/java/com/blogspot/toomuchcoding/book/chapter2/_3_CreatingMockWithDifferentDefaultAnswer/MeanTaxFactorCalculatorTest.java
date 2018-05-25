package com.blogspot.toomuchcoding.book.chapter2._3_CreatingMockWithDifferentDefaultAnswer;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.internal.stubbing.answers.ThrowsExceptionClass;

import com.blogspot.toomuchcoding.book.chapter2.common.MeanTaxFactorCalculator;
import com.blogspot.toomuchcoding.book.chapter2.common.TaxService;
import com.blogspot.toomuchcoding.person.Person;

public class MeanTaxFactorCalculatorTest {
	
//	To set a different default answer without annotations, you have to use the overloaded
//	Mockito.mock(Class<T> classToMock, Answer defaultAnswer) static method.
	TaxService taxService = mock(TaxService.class, new ThrowsExceptionClass(IllegalStateException.class));

	MeanTaxFactorCalculator systemUnderTest = new MeanTaxFactorCalculator(taxService);

	@Test
	public void should_throw_exception_when_calculating_mean_tax_factor() {
		// expect
		try {			
			systemUnderTest.calculateMeanTaxFactorFor(new Person());
			fail("Should throw exception");
		} catch (IllegalStateException exception) {}
	}
	
}
