package ee.itcollege.aop.aspect;

import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UninvitedGuestAspect {

	@Pointcut("@annotation(ee.itcollege.aop.annot.Tracked)")
	public void tracked() {}
	
	@Around("execution(* ee.itcollege.aop.StartMe.getList())")
	public ArrayList<String> addSomeone(ProceedingJoinPoint jp) throws Throwable {
		ArrayList<String> result = new ArrayList<>();//(ArrayList<String>) jp.proceed();
		result.clear();
		result.add("Uninvited Tom");
		return result;
	}
	
	@Before("tracked()")
	public void track(JoinPoint jp) {
		System.out.println(jp.getSignature() + " was called");
	}
	
	
}
