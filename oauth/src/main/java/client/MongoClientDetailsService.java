package client;

import java.util.List;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.NoSuchClientException;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoClientDetailsService implements ClientDetailsService,
		ClientRegistrationService {

	private final MongoClient mongoClient;
	private final String dataBaseName = "OAuthDatabase";
	private final BasicDAO<ClientDetails, String> basicDAO;

	public MongoClientDetailsService() {
		mongoClient = new MongoClient();
		Morphia morphia = new Morphia();
		basicDAO = new BasicDAO<ClientDetails, String>(ClientDetails.class,
				mongoClient, morphia, dataBaseName);
	}

	@Override
	public ClientDetails loadClientByClientId(String clientId)
			throws ClientRegistrationException {
		return basicDAO.get(clientId);
	}

	@Override
	public void addClientDetails(ClientDetails clientDetails)
			throws ClientAlreadyExistsException {
		basicDAO.save(clientDetails);
	}

	@Override
	public void updateClientDetails(ClientDetails clientDetails)
			throws NoSuchClientException {
		basicDAO.save(clientDetails);
	}

	@Override
	public void updateClientSecret(String clientId, String secret)
			throws NoSuchClientException {
		MongoClientDetails clientDetail = (MongoClientDetails) basicDAO
				.get(clientId);
		clientDetail.setClientSecret(secret);
		basicDAO.save(clientDetail);
	}

	@Override
	public void removeClientDetails(String clientId)
			throws NoSuchClientException {
		basicDAO.deleteById(clientId);
	}

	@Override
	public List<ClientDetails> listClientDetails() {
		return basicDAO.find().asList();
	}

}
