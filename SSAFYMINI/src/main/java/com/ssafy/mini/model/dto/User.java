package com.ssafy.mini.model.dto;

public class User {
	
	private String id;
	private String password;
	private String name;
	private String emailFirst;
	private String emailLast;
	private int age;
	private char gender;
	private int phone;
	private int year;
	private int month;
	private int day;
	private String grade;
	private String createTime;
	
	public User() {
		super();
	}
	
	public User(String id, String password, String name, String emailFirst, String emailLast, int age, char gender,
			int phone, int year, int month, int day, String grade, String createTime) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.emailFirst = emailFirst;
		this.emailLast = emailLast;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.year = year;
		this.month = month;
		this.day = day;
		this.grade = grade;
		this.createTime = createTime;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailFirst() {
		return emailFirst;
	}
	public void setEmailFirst(String emailFirst) {
		this.emailFirst = emailFirst;
	}
	public String getEmailLast() {
		return emailLast;
	}
	public void setEmailLast(String emailLast) {
		this.emailLast = emailLast;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", emailFirst=" + emailFirst
				+ ", emailLast=" + emailLast + ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", year="
				+ year + ", month=" + month + ", day=" + day + ", grade=" + grade + ", createTime=" + createTime + "]";
	}
	
}
