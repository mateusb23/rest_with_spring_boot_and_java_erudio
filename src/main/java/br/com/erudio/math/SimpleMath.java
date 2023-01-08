package br.com.erudio.math;

import org.springframework.stereotype.Component;

import br.com.erudio.converters.NumberConverter;

@Component
public class SimpleMath {

	public Double sum(String numberOne, String numberTwo) {
		return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
	}
	
	public Double subtraction(String numberOne, String numberTwo) {
		return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
	}
	
	public Double multiplication(String numberOne, String numberTwo) {
		return NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
	}
	
	public Double division(String numberOne, String numberTwo) {
		return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
	}
	
	public Double average(String numberOne, String numberTwo) {
		return (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo))/2;
	}
	
	public Double squareRoot(String number) {
		return Math.sqrt(NumberConverter.convertToDouble(number));
	}
	
}
