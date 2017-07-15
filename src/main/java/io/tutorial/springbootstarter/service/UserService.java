package io.tutorial.springbootstarter.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndex;
import com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazonaws.services.dynamodbv2.model.ProjectionType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;

import io.tutorial.springbootstarter.entities.User;
import io.tutorial.springbootstarter.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private AmazonDynamoDB dynamoDBClient;
	
	@Autowired
	UserRepository repository;
	
	public void saveUser(User entity) {
		repository.save(entity);
	}

	public void UpdateUser(User entity) {
		repository.save(entity);
	}

	public void deleteUser(int id) {
		repository.delete(id);
		
	}
	public User getUser(int id) {
		return repository.findOne(id);
	}
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}
	public void createtable(String tableName, long readCapacityUnits, long writeCapacityUnits, String partitionKeyName, String partitionKeyType) {

		DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
		try {
			ArrayList<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
			keySchema.add(new KeySchemaElement().withAttributeName(partitionKeyName).withKeyType(KeyType.HASH)); // Partition key

			ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
			attributeDefinitions.add(new AttributeDefinition().withAttributeName(partitionKeyName).withAttributeType(partitionKeyType));

			

			CreateTableRequest request = new CreateTableRequest().withTableName(tableName).withAttributeDefinitions(attributeDefinitions).withKeySchema(keySchema)
					.withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(readCapacityUnits).withWriteCapacityUnits(writeCapacityUnits));

			System.out.println("Issuing CreateTable request for " + tableName);
			Table table = dynamoDB.createTable(request);
			System.out.println("Waiting for " + tableName + " to be created...this may take a while...");
			table.waitForActive();
		} catch (Exception e) {
			System.err.println("CreateTable request failed for " + tableName);
			System.err.println(e.getMessage());
		}
	}
}
