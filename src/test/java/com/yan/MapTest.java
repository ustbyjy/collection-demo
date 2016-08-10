package com.yan;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description: Map测试类
 * @author Yanjingyang
 * @date 2016年8月10日 上午9:33:00
 * @version 1.0
 */
public class MapTest {
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
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("疯狂Java讲义", 109);
		map.put("疯狂iOS讲义", 10);
		map.put("疯狂Ajax讲义", 79);
		map.put("轻量级Java EE企业应用实战", 99);

		System.out.println(map.put("疯狂iOS讲义", 99));
		System.out.println(map);
		System.out.println("是否包含key为疯狂iOS讲义: " + map.containsKey("疯狂iOS讲义"));
		System.out.println("是否包含value为99" + map.containsKey(99));

		for (String key : map.keySet()) {
			System.out.println(key + "-->" + map.get(key));
		}

		System.out.println("remove: " + map.remove("疯狂Ajax讲义"));

		System.out.println(map);
	}

	@Test
	public void test2() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		System.out.println(map.put(null, null));
		System.out.println(map.put(null, null));
		System.out.println(map.put("a", null));

		System.out.println(map);
	}

	@Test
	public void test3() {
		Hashtable ht = new Hashtable();
		ht.put(new AA(60000), "疯狂Java讲义");
		ht.put(new AA(87563), "轻量级Java EE企业应用实战");
		ht.put(new AA(1232), new BB());

		System.out.println(ht);
		System.out.println(ht.containsValue("测试字符串"));
		System.out.println(ht.containsKey(new AA(87563)));
		ht.remove(new AA(1232));
		System.out.println(ht);
	}
}

class AA {
	int count;

	public AA(int count) {
		this.count = count;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj != null && obj.getClass() == AA.class) {
			AA aa = (AA) obj;
			return this.count == aa.count;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.count;
	}

	@Override
	public String toString() {
		return "AA [count=" + count + "]";
	}

}

class BB {
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
