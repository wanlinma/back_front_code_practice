package jxwy.mwl.mongo;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.*;
import org.bson.Document;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestMain {

    final MongoClient client = MongoClients.create("");
    @Test
    public void test() {
        /* Step 1: Start a client session. */
        final ClientSession clientSession = client.startSession();
        /* Step 2: Optional. Define options to use for the transaction. */
        TransactionOptions txnOptions = TransactionOptions.builder()
                .readPreference(ReadPreference.primaryPreferred())
                .readConcern(ReadConcern.LOCAL)
                .writeConcern(WriteConcern.MAJORITY)
                .build();
        /* Step 3: Define the sequence of operations to perform inside the transactions. */

        TransactionBody txnBody = new TransactionBody<String>() {
            public String execute() {
                MongoCollection<Document> coll1 = client.getDatabase("mydb1").getCollection("foo");
                MongoCollection<Document> coll2 = client.getDatabase("mydb2").getCollection("bar");
                /*
                   Important:: You must pass the session to the operations.
                 */
                coll1.insertOne(clientSession, new Document("abc", 1));
                coll2.insertOne(clientSession, new Document("xyz", 999));
                return "Inserted into collections in different databases";
            }
        };
        try {
        /*
           Step 4: Use .withTransaction() to start a transaction,
           execute the callback, and commit (or abort on error).
        */
            clientSession.withTransaction(txnBody, txnOptions);
        } catch (RuntimeException e) {
            // some error handling
        } finally {
            clientSession.close();
        }


    }

}
