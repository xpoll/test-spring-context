package cn.blmdz.test.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.util.concurrent.AbstractIdleService;

import cn.blmdz.test.spring.model.TestModel;

public class TestBootStrap extends AbstractIdleService {

	private ClassPathXmlApplicationContext context;

	public static void main(String[] args) {
		TestBootStrap accountManagerStart = new TestBootStrap();
		accountManagerStart.startAsync();
		try {
			Object lock = new Object();
			synchronized (lock) {
				while (true) {
					lock.wait();
				}
			}
		} catch (InterruptedException ex) {
			System.out.println("ignore interruption");
		}
	}

	@Override
	protected void startUp() throws Exception {
		context = new ClassPathXmlApplicationContext("test-application.xml");
		context.start();
		context.registerShutdownHook();
		System.out.println(this.getClass().getSimpleName() + " started successfully");
		TestModel model = context.getBean(TestModel.class);
		System.out.println(model.getName() + ", " + model.getAge());
	}

	@Override
	protected void shutDown() throws Exception {
		context.stop();
		System.out.println(this.getClass().getSimpleName() + " stopped successfully");
	}

}
