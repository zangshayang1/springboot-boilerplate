package parking.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import parking.PaymentService;

@RestController
public class PaymentController {

	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@RequestMapping("/enter_parking")
	public long enterParking() {
		return paymentService.enterParking();
	}

	@RequestMapping("/calc_payment")
	public int calcPayment(@RequestParam long code) {
		return paymentService.calcPayment(code);
	}
	
}