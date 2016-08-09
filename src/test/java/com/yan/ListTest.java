package com.yan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description: List测试类
 * @author Yanjingyang
 * @date 2016年8月9日 下午1:43:54
 * @version 1.0
 */
public class ListTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("===================Test begins==================");

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("===================Test ends==================");
	}

	@Test
	public void test1() {
		List<String> books = new ArrayList<String>();
		books.add(new String("轻量级Java EE企业应用实战"));
		books.add(new String("疯狂Java讲义"));
		books.add(new String("疯狂Android讲义"));

		System.out.println(books);

		books.add(1, new String("疯狂Ajax讲义")); // 插入到第2个元素，则之前的索引重新调整，性能差

		for (int i = 0; i < books.size(); i++) {
			System.out.println(i + ": " + books.get(i));

		}

		System.out.println("remove: " + books.remove(2));

		System.out.println(books);

		System.out.println(books.indexOf(new String("疯狂Ajax讲义")));

		books.set(1, new String("疯狂Java讲义"));

		System.out.println(books);

		System.out.println(books.subList(1, 2)); // 包括fromIndex，不包括toIndex
	}

	@Test
	public void test2() {
		List<String> books = new ArrayList<String>();
		books.add(new String("轻量级Java EE企业应用实战"));
		books.add(new String("疯狂Java讲义"));
		books.add(new String("疯狂Android讲义"));

		System.out.println(books);

		books.remove(new A());

		System.out.println(books);

		books.remove(new A());

		System.out.println(books);
	}

	@Test
	public void test3() {
		List<String> books = new ArrayList<String>();
		books.add(new String("轻量级Java EE企业应用实战"));
		books.add(new String("疯狂Java讲义"));
		books.add(new String("疯狂Android讲义"));
		books.add(new String("疯狂iOS讲义"));

		System.out.println(books);

		books.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		System.out.println(books);

		books.replaceAll(new UnaryOperator<String>() {

			@Override
			public String apply(String t) {
				return t.length() + "";
			}
		});

		System.out.println(books);
	}

	@Test
	public void test4() {
		String[] books = { "疯狂Java讲义", "疯狂iOS讲义", "轻量级Java EE企业应用实战" };
		List<String> bookList = new ArrayList<String>();
		for (int i = 0; i < books.length; i++) {
			bookList.add(books[i]);
		}
		ListIterator<String> lit = bookList.listIterator();
		while (lit.hasNext()) {
			System.out.println(lit.next());
		}

		System.out.println("===============开始反向迭代==============");

		while (lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
	}

	@Test
	public void test5() {
		ArrayList<Integer> list = new ArrayList<Integer>(20000);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 15000; i++) {
			list.add(i);
		}

		long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		start = System.currentTimeMillis();
		for (int i = 0; i < 15000; i++) {
			list2.add(i);
		}
		end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));

	}

	@Test
	public void test6() {
		// java.util.Arrays$ArrayList 此ArrayList是Arrays类的静态内部类
		List<String> fixedList = Arrays.asList("疯狂Java讲义", "轻量级Java EE企业应用实战");

		System.out.println(fixedList.getClass());

		fixedList.forEach(System.out::println);

		fixedList.add("疯狂Android讲义");
		fixedList.remove("疯狂Java讲义");
	}
}

class A {

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
