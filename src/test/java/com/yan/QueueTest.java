package com.yan;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description: Queue测试类
 * @author Yanjingyang
 * @date 2016年8月9日 下午4:57:04
 * @version 1.0
 */
public class QueueTest {
	@Before
	public void setUp() throws Exception {
		System.out.println("====================Test begins==================");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("====================Test ends==================");
	}

	@Test
	public void test1() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(6);
		pq.offer(-3);
		pq.offer(20);
		pq.offer(18);

		System.out.println(pq);

		while (pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	@Test
	public void test2() {
		PriorityQueue<Person> pq = new PriorityQueue<Person>(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		Person p1 = new Person("张三", 15);
		Person p2 = new Person("李四", 6);
		Person p3 = new Person("王五", 80);

		pq.add(p1);
		pq.add(p2);
		pq.add(p3);

		System.out.println(pq);

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	@Test
	public void test3() {
		Deque<String> stack = new ArrayDeque<String>();
		stack.push("疯狂Java讲义");
		stack.push("轻量级Java EE企业应用实战");
		stack.push("疯狂Android讲义");

		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
	}

	@Test
	public void test4() {
		Deque<String> queue = new ArrayDeque<String>();
		queue.offer("疯狂Java讲义");
		queue.offer("轻量级Java EE企业应用实战");
		queue.offer("疯狂Android讲义");

		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
	}
}

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
