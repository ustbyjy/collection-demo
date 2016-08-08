package com.yan;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description: 集合测试类
 * @author Yanjingyang
 * @date 2016年8月8日 下午4:00:21
 * @version 1.0
 */
public class CollectionTest {
	private Collection<String> books;

	@Before
	public void setUp() throws Exception {
		System.out.println("===================Test begins==================");
		books = new HashSet<String>();
		books.add("轻量级Java EE企业应用实战");
		books.add("疯狂Java讲义");
		books.add("疯狂iOS讲义");
		books.add("疯狂Ajax讲义");
		books.add("疯狂Android讲义");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("===================Test ends==================");
	}

	/**
	 * @Description: 测试forEach方法
	 * @date 2016年8月8日 下午3:59:55
	 */
	@Test
	public void test1() {
		books.forEach(obj -> System.out.println("迭代集合元素: " + obj));
	}

	@Test
	public void test2() {
		Iterator<String> it = books.iterator();
		while (it.hasNext()) {
			String book = it.next();
			System.out.println(book);
			if (book.equals("book-2")) {
				it.remove();
			}
			book = "hello world";
		}
		System.out.println(books);
	}

	@Test
	public void test3() {
		// throw ConcurrentModificationException
		for (String book : books) {
			System.out.println(book);
			if (book.equals("book-2")) {
				books.remove(book);
			}
		}
		System.out.println(books);
	}

	@Test
	public void test4() {
		System.out.println(calAll(books, ele -> ele.contains("book")));
		System.out.println(calAll(books, ele -> ele.contains("3")));
		System.out.println(calAll(books, ele -> ele.length() > 4));
	}

	@Test
	public void test5() {
		books.removeIf(obj -> obj.length() == 6);
		System.out.println(books);
	}

	@Test
	public void test6() {
		IntStream is = IntStream.builder().add(20).add(13).add(-2).add(18).build();
		// 下面调用聚集方法的代码每次只能执行一次
		System.out.println("is所有元素的最大值: " + is.max().getAsInt());
		System.out.println("is所有元素的最小值: " + is.min().getAsInt());
		System.out.println("is所有元素的总和: " + is.sum());
		System.out.println("is所有元素的总数: " + is.count());
		System.out.println("is所有元素的平均数: " + is.average());
		System.out.println("is所有元素的平方都是否大于20: " + is.allMatch(ele -> ele * ele > 20));
		System.out.println("is是否包含任何元素的平方都是否大于20: " + is.anyMatch(ele -> ele * ele > 20));

		IntStream newIs = is.map(ele -> ele * 2 + 1);
		newIs.forEach(System.out::println);
	}

	@Test
	public void test7() {
		System.out.println(books.stream().filter(ele -> ele.contains("疯狂")).count());
		System.out.println(books.stream().filter(ele -> ele.contains("Java")).count());
		System.out.println(books.stream().filter(ele -> ele.length() > 10).count());

		books.stream().mapToInt(ele -> ele.length()).forEach(System.out::println);
	}

	public static int calAll(Collection<String> books, Predicate<String> p) {
		int total = 0;
		for (String str : books) {
			if (p.test(str)) {
				total++;
			}
		}
		return total;
	}
}
