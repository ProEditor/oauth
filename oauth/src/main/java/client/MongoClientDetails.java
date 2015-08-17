package client;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

@Entity("ClientDetails")
public class MongoClientDetails implements ClientDetails {

	@Id
	private ObjectId Id;

	@Property("ClientId")
	private String clientId;

	@Property("ClientSecret")
	private String clientSecret;

	@Property("Resources")
	private Set<String> resources;

	@Property("AdditionalInformation")
	private Map<String, Object> additionalInformation;

	private final int accessTokenValidity = 86400;
	private final int refreshTokenValidity = 86400;

	public MongoClientDetails(String clientId, String clientSecret,
			Set<String> resources, Map<String, Object> additionalInformation) {

		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.resources = resources;
		this.additionalInformation = additionalInformation;

	}

	@Override
	public String getClientId() {
		return clientId;
	}

	@Override
	public Set<String> getResourceIds() {
		return resources;
	}

	@Override
	public boolean isSecretRequired() {
		return true;
	}
	
	

	@Override
	public String getClientSecret() {
		return clientSecret;
	}
	
	public void setClientSecret(String clientSecret)
	{
		this.clientSecret=clientSecret;
	}

	@Override
	public boolean isScoped() {
		return false;
	}

	@Override
	public Set<String> getScope() {
		return null;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return null;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValidity;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValidity;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return false;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return additionalInformation;
	}

}
