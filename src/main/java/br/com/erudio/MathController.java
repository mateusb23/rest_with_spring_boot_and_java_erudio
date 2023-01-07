package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	private static final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) { 
			return 0D; }
		
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) { 
			return Double.parseDouble(number); }
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) {
			return false;
		}
		String number = strNumber.replaceAll(",",".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
							  @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	@GetMapping(value = "/multip/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
								 @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@GetMapping(value = "/div/{numberOne}/{numberTwo}")
	public Double division(@PathVariable(value = "numberOne") String numberOne,
						   @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
			
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	@GetMapping(value = "/avg/{numberOne}/{numberTwo}")
	public Double average(@PathVariable(value = "numberOne") String numberOne,
						   @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
	}
	
	@GetMapping(value = "/sqrt/{number}")
	public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {
		
		if(!isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return Math.sqrt(convertToDouble(number));
	}

}