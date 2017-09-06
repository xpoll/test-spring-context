package cn.blmdz.sp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.blmdz.model.Student;

public class TestSpring {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean-servlet.xml");
		Student st = ac.getBean(Student.class);
		System.out.println(st.getAge());
		System.out.println(st.getName());
	}
}
