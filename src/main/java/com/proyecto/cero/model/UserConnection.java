package com.proyecto.cero.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userconnection")
public class UserConnection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5789770169863593745L;

	/**create table UserConnection (userId varchar(255) not null,
			providerId varchar(255) not null,
			providerUserId varchar(255),
			rank int not null,
			displayName varchar(255),
			profileUrl varchar(512),
			imageUrl varchar(512),
			accessToken varchar(255) not null,					
			secret varchar(255),
			refreshToken varchar(255),
			expireTime bigint,
			primary key (userId, providerId, providerUserId));
		create unique index UserConnectionRank on UserConnection(userId, providerId, rank);*/
	
	@Id @Column(name = "userId", unique = true, nullable = false, length=255)
	private String userId;
	
	@Id @Column(name = "providerId", unique = true, nullable = false, length=255)
	private String providerId;
	
	@Id @Column(name = "providerUserId", unique = false, nullable = true, length=255)
	private String providerUserId;
	
	@Column(name = "rank", unique = true, nullable = false)
	private int rank;
	
	@Column(name = "displayName", unique = false, nullable = true, length=255)
	private String displayName;
	
	@Column(name = "profileUrl", unique = false, nullable = true, length=512)
	private String profileUrl;
	
	@Column(name = "imageUrl", unique = false, nullable = true, length=512)
	private String imageUrl;
	
	@Column(name = "accessToken", unique = false, nullable = false, length=255)
	private String accessToken;
	
	@Column(name = "secret", unique = false, nullable = true, length=255)
	private String secret;
	
	@Column(name = "refreshToken", unique = false, nullable = true, length=255)
	private String refreshToken;
	
	@Column(name = "expireTime", unique = false, nullable = true)
	private BigInteger exprireTime;

	
	public UserConnection() {
		//VACIo
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProviderUserId() {
		return providerUserId;
	}

	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public BigInteger getExprireTime() {
		return exprireTime;
	}

	public void setExprireTime(BigInteger exprireTime) {
		this.exprireTime = exprireTime;
	} 

	
	
}
