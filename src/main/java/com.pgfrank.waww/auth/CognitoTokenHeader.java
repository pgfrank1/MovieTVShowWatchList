package com.pgfrank.waww.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CognitoTokenHeader{

	@JsonProperty("kid")
	private String kid;

	@JsonProperty("alg")
	private String alg;

	public String getKid(){
		return kid;
	}

	public String getAlg(){
		return alg;
	}
}