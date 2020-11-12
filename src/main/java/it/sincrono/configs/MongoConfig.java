package it.sincrono.configs;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

	static final Properties db = new Properties();

	static {
		try {

			db.load(MongoConfig.class.getClassLoader()
					.getResourceAsStream("connection.properties"));

		} catch(IOException e) {
			Logger.getLogger(MongoConfig.class.getSimpleName())
					.log(Level.SEVERE, "Couldn't load db properties from file", e);
		}
	}

	@Override
	protected String getDatabaseName() {
		return db.getProperty("database");
	}

	@Override
	public MongoClient mongoClient() {

		ConnectionString connectionString = new ConnectionString(db.getProperty("url") + db.getProperty(
				"database"));

		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.credential(MongoCredential.createScramSha1Credential(db.getProperty("username"),
						db.getProperty("database"),
						db.getProperty("password").toCharArray()))
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	@SuppressWarnings("unused")
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), db.getProperty("database"));
	}

	@Override
	public Collection<String> getMappingBasePackages() {
		return Arrays.asList("it.sincrono.models", "it.sincrono.repositories");
	}

}