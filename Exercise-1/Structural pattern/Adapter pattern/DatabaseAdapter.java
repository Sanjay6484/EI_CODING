
interface Database {
    void connect();
    void disconnect();
    void executeQuery(String query);
}

// Adaptee 1: MySQL Database
class MySQLDatabase {
    public void mysqlConnect() {
        System.out.println("Connecting to MySQL database...");
    }

    public void mysqlDisconnect() {
        System.out.println("Disconnecting from MySQL database...");
    }

    public void mysqlExecuteQuery(String query) {
        System.out.println("Executing MySQL query: " + query);
    }
}

// Adapter 1: MySQL Adapter
class MySQLAdapter implements Database {
    private MySQLDatabase mySQLDatabase;

    public MySQLAdapter(MySQLDatabase mySQLDatabase) {
        this.mySQLDatabase = mySQLDatabase;
    }

    @Override
    public void connect() {
        mySQLDatabase.mysqlConnect();
    }

    @Override
    public void disconnect() {
        mySQLDatabase.mysqlDisconnect();
    }

    @Override
    public void executeQuery(String query) {
        mySQLDatabase.mysqlExecuteQuery(query);
    }
}

// Adaptee 2: MongoDB Database
class MongoDBDatabase {
    public void mongoConnect() {
        System.out.println("Connecting to MongoDB database...");
    }

    public void mongoDisconnect() {
        System.out.println("Disconnecting from MongoDB database...");
    }

    public void mongoExecuteQuery(String query) {
        System.out.println("Executing MongoDB query: db.collection.find(" + query + ")");
    }
}

// Adapter 2: MongoDB Adapter
class MongoDBAdapter implements Database {
    private MongoDBDatabase mongoDBDatabase;

    public MongoDBAdapter(MongoDBDatabase mongoDBDatabase) {
        this.mongoDBDatabase = mongoDBDatabase;
    }

    @Override
    public void connect() {
        mongoDBDatabase.mongoConnect();
    }

    @Override
    public void disconnect() {
        mongoDBDatabase.mongoDisconnect();
    }

    @Override
    public void executeQuery(String query) {
        mongoDBDatabase.mongoExecuteQuery(query);
    }
}

// Client
public class DatabaseAdapter{
    public static void main(String[] args) {
        // Using MySQL Adapter
        Database mySQLDatabase = new MySQLAdapter(new MySQLDatabase());
        mySQLDatabase.connect();
        mySQLDatabase.executeQuery("SELECT * FROM users");
        mySQLDatabase.disconnect();

        // Using MongoDB Adapter
	System.out.println();
        Database mongoDBDatabase = new MongoDBAdapter(new MongoDBDatabase());
        mongoDBDatabase.connect();
        mongoDBDatabase.executeQuery("{ name: 'John Doe' }");
        mongoDBDatabase.disconnect();
    }
}
