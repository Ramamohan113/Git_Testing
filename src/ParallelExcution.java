

import org.testng.annotations.Test;

public class ParallelExcution {
 @Test(threadPoolSize = 2,invocationCount = 2,timeOut = 2000,priority = 2,groups = "funtionaltesting")
 public void test1() {
	 System.out.println("test1--->"+Thread.currentThread().getName());
 }
 @Test()
 public void test2() {
	 System.out.println("test2--->"+Thread.currentThread().getName());
 }
	
	
	
}
