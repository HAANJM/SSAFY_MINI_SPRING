package com.ssafy.mini.model.dto;

public class User {
	
	private String id; // 아이디
	private String password; // 비밀번호
	private String name; // 이름
	private String emailFirst; // 이메일 - 아이디부분
	private String emailLast; // 이메일 - 도메인부분
	private String email; // 이메일 합친 것
	private int age; // 나이
	private char gender; // 성별 ('F', 'M'과 같은 형식으로 입력하기 위해 char형
	private String phone; // 전화번호
	private int year; // 생년월일의 년도
	private int month; // 생년월일의 달
	private int day; // 생년월일의 일
	private String grade; // 회원 등급
	private String createTime; // 회원 생성 일자 (DB에서 default로 가입 시의 날짜를 입력)
	
	public User() {
		super();
	}

	public User(String id, String password, String name, String emailFirst, String emailLast, String email, int age,
			char gender, String phone, int year, int month, int day, String grade, String createTime) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.emailFirst = emailFirst;
		this.emailLast = emailLast;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
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
