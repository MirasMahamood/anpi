package io.tutorial.springbootstarter.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "User")
public class User {
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private int userId;
	
	@DynamoDBAttribute
	private int id;
	
	@DynamoDBAttribute
	private String title;
	
	@DynamoDBAttribute
	private String body;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
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
