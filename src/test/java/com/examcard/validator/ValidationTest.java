package com.examcard.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.examcard.form.customer.CustomerForm;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ValidationTest {

	@Test
	public void customerFormTest() {
		CustomerForm form = new CustomerForm();
		form.setFirstnameKana("タナカ");
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<CustomerForm>> result = validator.validate(form);
		for (ConstraintViolation<CustomerForm> e : result) {
			if ("firstnameKana".equals(e.getPropertyPath().toString())) {
//				assertThat(e.getMessage(), is("{validation.zenkaku.kana.message}"));
				throw new RuntimeException();
			}
		}
		
	}
	
	@Test
	public void paddingTest() {
		String result = String.format("%10s", 1, 10).replace(" ", "0");
		System.out.println(result);
	}
}
