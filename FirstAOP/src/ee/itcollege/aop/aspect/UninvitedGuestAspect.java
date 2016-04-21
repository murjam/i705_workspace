package ee.itcollege.aop.aspect;

import java.util.ArrayList;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class UninvitedGuestAspect {
	
	@Around("execution(* ee.itcollege.aop.StartMe.getList())")
	public ArrayList<String> addSomeone(ProceedingJoinPoint jp) throws Throwable {
		ArrayList<String> result = new ArrayList<>();//(ArrayList<String>) jp.proceed();
		result.clear();
		result.add("Uninvited Tom");
		return result;
	}
	
}
