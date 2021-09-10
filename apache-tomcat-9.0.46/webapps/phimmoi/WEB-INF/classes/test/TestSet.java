//package test;
//
//import java.util.HashSet;
//import java.util.LinkedHashSet;
//import java.util.Set;
//import java.util.TreeSet;
//
//class Student implements Comparable<Student> {
//
//	private int id;
//	private String name;
//	private int age;
//
//	public Student(int id, String name, int age) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.age = age;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		Student stu = (Student) obj;
//		return this.id == stu.getId();
//	}
//
//	@Override
//	public int hashCode() {
//		return this.id;
//	}
//
//	@Override
//	public int compareTo(Student student) {
//		// sort student's name by ASC
//		return this.id - student.id;
//	}
//}
//
//public class TestSet {
//	public static void main(String[] args) {
////		Set<Student> liSet = new HashSet<Student>();
////		Set<Student> liSet = new LinkedHashSet<Student>();
//		Set<Student> liSet = new TreeSet<Student>();
//		liSet.add(new Student(1, "w" + "", 20));
//		liSet.add(new Student(4, "Hòa", 20));
//		liSet.add(new Student(1, "Cường", 20));
//		liSet.add(new Student(3, "Tuấn", 20));
//		liSet.add(new Student(2, "Huyền Anh", 22));
//
//		for (Student stu : liSet) {
//			System.out.println(stu);
//		}
//	}
//}
