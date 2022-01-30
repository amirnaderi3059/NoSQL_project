package ir.ac.kntu.scrapping;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import ir.ac.kntu.Data.Query;
import org.bson.Document;

import java.util.Calendar;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws InterruptedException {
//        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
//        randomDataGenerator.generate(100);
        MongoCollection<Document> collection = MongoDBSetUp.getInstance().getDatabase("FlightDataBase").getCollection("flights");
        Query query = new Query();
        Date date = new Date(new Date().getYear(),Calendar.FEBRUARY,7,0,0);
        Document query11 = new Document("id","563");
        collection.aggregate(query.firstQuery(date))
                .forEach((Block<? super Document>)
                        doc -> System.out.println(doc.toJson()));
//        int cnt = 0;
//        Iter.forEach((Block<? super Document>)
//                doc -> System.out.println(doc.toJson()));
    }

}

