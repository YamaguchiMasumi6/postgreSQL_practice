package model;

/*
 *  TODO #402 一覧画面　一覧画面のBEAN
 */
public class ListView {
	private String userId;
	private String name;
	private int age;
	public ListView(String usersId,String names,int ages) {
		this.userId = usersId;
		this.name = names;
		this.age = ages;
	}
	public String getUserId() {return userId;}
	public String getName() {return name;}
	public int getAge() {return age;}
}
