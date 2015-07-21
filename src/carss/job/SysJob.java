package carss.job;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import carss.service.BankCardInfoService;
import carss.service.PostInfoService;
@Component
public class SysJob {

//	
	@Resource
	private PostInfoService postInfoService;
//	
	@Resource
	private BankCardInfoService bankCardInfoService;
 
	public void run() {
		postInfoService.clearDayMoney();
		bankCardInfoService.clearDayMoney();
		System.out.println("Íê³É²Ù×÷£¡");
		
	}
}
