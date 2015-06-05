package javaee.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

//@Component
public class MongoTemplateDao {
	
	private final MongoTemplate mongoTemplate;
	
	@Autowired
    public MongoTemplateDao(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
    }
	
	public void test(){
		
		System.out.println(mongoTemplate.getDb());
	}
	
	/*public void quickStart(){
		
		//Make a Connection
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient();
		
		*//**
		MongoClient mongoClient = new MongoClient( "localhost" );
		
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		
		// To connect to a replica set, with auto-discovery of the primary, supply a seed list of members
		MongoClient mongoClient = new MongoClient(
				  Arrays.asList(new ServerAddress("localhost", 27017),
				                new ServerAddress("localhost", 27018),
				                new ServerAddress("localhost", 27019)));
		
		// use a connection string
		MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017,localhost:27018,localhost:27019");
		MongoClient mongoClient = new MongoClient(connectionString);

		*//*
		
		//Get A List of Databases 遍历所有数据库
		for (String name: mongoClient.listDatabaseNames()) {
		    System.out.println(name);
		}
		
		//Get a Database 获取数据库
		MongoDatabase db = mongoClient.getDatabase("test");
		
		//Drop A Database 删除数据库
		mongoClient.getDatabase("databaseToBeDropped").drop();
		
		//Running a command
        Document buildInfo = db.runCommand(new Document("buildInfo", 1));
        System.out.println(buildInfo);
        
		//Get A List of Collections 遍历所有集合
		for (String name : db.listCollectionNames()) {
		    System.out.println(name);
		}
		
		//Get a Collection 获得集合 类似RDB的表
		MongoCollection<Document> collection = db.getCollection("person");
				
		//Drop A Collection 删除集合
		collection.drop();
		
		//Insert a Document 添加一条记录
		Document doc = new Document("name", "MongoDB");
		doc.append("type", "database");
        doc.append("count", 1);
        doc.append("info", new Document("x", 203).append("y", 102));
        
        collection.insertOne(doc);
        
        //Add Multiple Documents 添加多条记录
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 100; i++) {
            documents.add(new Document("i", i));
        }
        
        collection.insertMany(documents);
        
        //Updating documents 更新记录
        collection.updateOne(eq("i", 10), new Document("$set", new Document("i", 110)));
        
        UpdateResult updateResult = collection.updateMany(lt("i", 100),
                new Document("$inc", new Document("i", 100)));
        
        System.out.println(updateResult.getModifiedCount());
        
        //Deleting documents 删除记录
        collection.deleteOne(eq("i", 110));
        
        DeleteResult deleteResult = collection.deleteMany(gte("i", 100));
        System.out.println(deleteResult.getDeletedCount());
        
        //Count Documents in A Collection
        System.out.println(collection.count());
        
        //Query the Collection 
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
        
        //Find All Documents in a Collection
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
        
        for (Document cur : collection.find()) {
            System.out.println(cur.toJson());
        }
        
        //Get A Single Document with a Query Filter 
        myDoc = collection.find(eq("i", 71)).first();
        System.out.println(myDoc.toJson());
        
        //Get a Set of Documents with a Query ?
        Block<Document> printBlock = new Block<Document>() {
        	
        	public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };
        collection.find(gt("i", 50)).forEach(printBlock);
        
        collection.find(and(gt("i", 50), lte("i", 100))).forEach(printBlock);
        
        //Sorting documents
        //myDoc = collection.find(exists("i")).sort(descending("i")).first();
        System.out.println(myDoc.toJson());
        
        //Projecting fields 
        //myDoc = collection.find().projection(excludeId()).first();
        System.out.println(myDoc.toJson());
        
        //Create An Index
        collection.createIndex(new Document("i", 1));
        
        //Get a List of Indexes on a Collection
        for (final Document index : collection.listIndexes()) {
            System.out.println(index.toJson());
        }
        
        //Text indexes
        collection.createIndex(new Document("content", "text"));
        
        collection.insertOne(new Document("_id", 0).append("content", "textual content"));
        collection.insertOne(new Document("_id", 1).append("content", "additional content"));
        collection.insertOne(new Document("_id", 2).append("content", "irrelevant content"));

        long matchCount = collection.count(Filters.text("textual content -irrelevant"));
        System.out.println("Text search matches: " + matchCount);

        Bson textSearch = Filters.text("textual content -irrelevant", "english");
        matchCount = collection.count(textSearch);
        System.out.println("Text search matches (english): " + matchCount);

        Document projection = new Document("score", new Document("$meta", "textScore"));
        myDoc = collection.find(textSearch).projection(projection).first();
        System.out.println("Highest scoring document: " + myDoc.toJson());
        
        //Bulk operations 批量操作 jre1.7
        *//**
        collection.bulkWrite(
	     	Arrays.asList(
	    		new InsertOneModel<>(new Document("_id", 4)),
	    		new InsertOneModel<>(new Document("_id", 5)),
	          	new InsertOneModel<>(new Document("_id", 6)),
	      		new UpdateOneModel<>(new Document("_id", 1),
	          	new Document("$set", new Document("x", 2))),
	      		new DeleteOneModel<>(new Document("_id", 2)),
	     		new ReplaceOneModel<>(new Document("_id", 3),
	          	new Document("_id", 3).append("x", 4))
          	)
 		);

        collection.bulkWrite(
	    	Arrays.asList(
	    		new InsertOneModel<>(new Document("_id", 4)),
				new InsertOneModel<>(new Document("_id", 5)),
	   			new InsertOneModel<>(new Document("_id", 6)),
	         	new UpdateOneModel<>(new Document("_id", 1),
	         	new Document("$set", new Document("x", 2))),
	        	new DeleteOneModel<>(new Document("_id", 2)),
	       		new ReplaceOneModel<>(new Document("_id", 3),
	          	new Document("_id", 3).append("x", 4))
	        ),
	    	new BulkWriteOptions().ordered(false)
	 	);
	 	
        *//*
	}*/
}
