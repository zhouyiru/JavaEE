package gz.itcast.g_convert;

import java.util.Date;

public class User {
	/**
	 * struts2�ڲ���String�����Զ�ת���ɲ�ͬ�������͡�  String->int  String->double ....
	 * 				String -> Date
	 */
	private String name;
	private int age;
	private double score;
	private Date birth;
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "User [age=" + age + ", birth=" + birth + ", name=" + name
				+ ", score=" + score + "]";
	}
	
}
