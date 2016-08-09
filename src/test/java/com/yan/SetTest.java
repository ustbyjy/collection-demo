package com.yan;

import java.util.Comparator;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yan.bean.A;
import com.yan.bean.B;
import com.yan.bean.C;

/**
 * @Description: Set测试类
 * @author Yanjingyang
 * @date 2016年8月8日 下午4:42:42
 * @version 1.0
 */
public class SetTest {

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
		HashSet<Object> books = new HashSet<Object>();
		books.add(new A());
		books.add(new A());
		books.add(new B());
		books.add(new B());
		books.add(new C());
		books.add(new C());
		System.out.println(books);
	}

	@Test
	public void test2() {
		Set<R> hs = new HashSet<R>();
		hs.add(new R(5));
		hs.add(new R(-3));
		hs.add(new R(9));
		hs.add(new R(-2));

		System.out.println(hs);

		Iterator<R> it = hs.iterator();
		R first = it.next();
		first.count = -3;

		System.out.println(hs);

		hs.remove(new R(-3));

		System.out.println(hs);
		System.out.println("hs是否包含count为-3的R对象: " + hs.contains(new R(-3)));
		System.out.println("hs是否包含count为-2的R对象: " + hs.contains(new R(-2)));
	}

	@Test
	public void test3() {
		Set<String> books = new LinkedHashSet<String>();
		books.add("疯狂Java讲义");
		books.add("轻量级Java EE企业应用实战");

		System.out.println(books);

		books.remove("疯狂Java讲义");

		System.out.println(books);

		books.add("疯狂Java讲义");

		System.out.println(books);
	}

	@Test
	public void test4() {
		TreeSet<Integer> nums = new TreeSet<Integer>();
		nums.add(5);
		nums.add(2);
		nums.add(10);
		nums.add(-9);

		System.out.println(nums);
		System.out.println(nums.first());
		System.out.println(nums.last());
		System.out.println(nums.headSet(4));
		System.out.println(nums.tailSet(5));
		System.out.println(nums.subSet(-3, 4));
	}

	@Test
	public void test5() {
		TreeSet ts = new TreeSet();
		ts.add(new Err());
		ts.add(new Err()); // Err类没有实现Comparable接口，添加第二个时会引发ClassCastException
	}

	@Test
	public void test6() {
		TreeSet ts = new TreeSet();
		ts.add(new String("疯狂Java讲义"));
		ts.add(new Date());
	}

	@Test
	public void test7() {
		TreeSet set = new TreeSet();
		Z z1 = new Z(6);
		set.add(z1);
		System.out.println(set.add(z1));
		System.out.println(set);

		((Z) set.first()).age = 9;
		System.out.println(((Z) set.last()).age);
	}

	@Test
	public void test8() {
		TreeSet<R> ts = new TreeSet<R>();
		ts.add(new R(5));
		ts.add(new R(-3));
		ts.add(new R(9));
		ts.add(new R(-2));

		System.out.println(ts);

		R first = ts.first();
		first.count = 20;
		R last = ts.last();
		last.count = -2;

		System.out.println(ts);
		System.out.println(ts.remove(new R(-2)));
		System.out.println(ts);
		System.out.println(ts.remove(new R(5)));
		System.out.println(ts);
	}

	@Test
	public void test9() {
		TreeSet<M> ts = new TreeSet<M>(new Comparator<M>() {

			@Override
			public int compare(M o1, M o2) {
				return o1.age > o2.age ? -1 : o1.age < o2.age ? 1 : 0;
			}
		});

		ts.add(new M(5));
		ts.add(new M(-3));
		ts.add(new M(9));

		System.out.println(ts);
	}

	@Test
	public void test10() {
		EnumSet<Season> es1 = EnumSet.allOf(Season.class);
		System.out.println(es1);

		EnumSet es2 = EnumSet.noneOf(Season.class);
		System.out.println(es2);

		es2.add(Season.WINTER);
		es2.add(Season.SPRING);

		System.out.println(es2);

		EnumSet es3 = EnumSet.of(Season.SUMMER, Season.WINTER);

		System.out.println(es3);

		EnumSet es4 = EnumSet.range(Season.SUMMER, Season.WINTER);

		System.out.println(es4);

		EnumSet es5 = EnumSet.complementOf(es4);

		System.out.println(es5);
	}
}

class Err {

}

class Z implements Comparable {
	int age;

	public Z(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String toString() {
		return "Z [age=" + age + "]";
	}

}

class R implements Comparable {
	int count;

	public R(int count) {
		this.count = count;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == R.class) {
			R r = (R) obj;
			return r.count == this.count;
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		R r = (R) o;
		return this.count > r.count ? 1 : this.count < r.count ? -1 : 0;
	}

	@Override
	public String toString() {
		return "R [count=" + count + "]";
	}

}

class M {
	int age;

	public M(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "M [age=" + age + "]";
	}

}

enum Season {
	SPRING, SUMMER, FALL, WINTER
}
