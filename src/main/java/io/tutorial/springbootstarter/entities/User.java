package io.tutorial.springbootstarter.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "ANPIUser")
public class User {
	
	private int userId;
	
	
	private int id;	
	
	private String title;
	
	private String body;
	
	@DynamoDBHashKey
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@DynamoDBAttribute
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@DynamoDBAttribute
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@DynamoDBAttribute
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		String s = "{\"userId\":"+userId+", \"id\":"+id+", \"title\":\""+title+"\", \"body\":\""+body+"\"}";
		return s;
	}
}
