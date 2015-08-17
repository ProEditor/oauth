package oauth;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;

public class MongoOAuth2AccessToken implements Serializable, OAuth2AccessToken  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6432009758094936924L;

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getScope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OAuth2RefreshToken getRefreshToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTokenType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Date getExpiration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getExpiresIn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
