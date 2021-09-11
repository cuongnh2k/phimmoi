package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class Student1 implements Comparable<Student1> {

	private String name;
	private int age;

	public Student1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Student1 [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Student1 o) {
		return this.age - o.getAge();
	}

}

public class TestMap {
	public static void main(String[] args) {
//		Map<Integer, Student1> liMap = new HashMap<Integer, Student1>();
//		Map<Integer, Student1> liMap = new LinkedHashMap<Integer, Student1>();
		Map<Integer, Student1> liMap = new TreeMap<Integer, Student1>();

		liMap.put(1, new Student1("w", 20));
		liMap.put(5, new Student1("Hòa", 29));
		liMap.put(4, new Student1("Cường", 21));
		liMap.put(2, new Student1("Tuấn", 19));
		liMap.put(3, new Student1("Huyền Anh", 22));

		for (Integer stu : liMap.keySet()) {
			System.out.println("key: " + stu + ";value:" + liMap.get(stu));
		}
	}
}
