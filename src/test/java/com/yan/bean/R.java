package com.yan.bean;

public class R {
	public int count;

	public R(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "R [count=" + count + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == R.class) {
			R r = (R) obj;
			return this.count == r.count;
		}

		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.count;
	}

}
