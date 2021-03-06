package oauth;

import java.util.Collection;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.mongodb.MongoClient;

public class MongoTokenStore implements TokenStore {

	private final MongoClient mongoClient;
	private final String dataBaseName = "OAuthDatabase";
	private final BasicDAO<ClientDetails, String> basicDAO;

	public MongoTokenStore() {
		mongoClient = new MongoClient();
		Morphia morphia = new Morphia();
		basicDAO = new BasicDAO<ClientDetails, String>(ClientDetails.class,
				mongoClient, morphia, dataBaseName);
	}
	
	@Override
	public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
		if (token != null)
			return readAuthentication(token.getValue());
		return null;
	}

	@Override
	public OAuth2Authentication readAuthentication(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeAccessToken(OAuth2AccessToken token,
			OAuth2Authentication authentication) {
		// TODO Auto-generated method stub

	}

	@Override
	public OAuth2AccessToken readAccessToken(String tokenValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAccessToken(OAuth2AccessToken token) {
		// TODO Auto-generated method stub

	}

	@Override
	public void storeRefreshToken(OAuth2RefreshToken refreshToken,
			OAuth2Authentication authentication) {
		// TODO Auto-generated method stub

	}

	@Override
	public OAuth2RefreshToken readRefreshToken(String tokenValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OAuth2Authentication readAuthenticationForRefreshToken(
			OAuth2RefreshToken token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeRefreshToken(OAuth2RefreshToken token) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAccessTokenUsingRefreshToken(
			OAuth2RefreshToken refreshToken) {

	}

	@Override
	public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(
			String clientId, String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
		// TODO Auto-generated method stub
		return null;
	}

}
