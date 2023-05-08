package com.pgfrank.waww.entity.tvShow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastEpisodeToAir{

	@JsonProperty("production_code")
	private String productionCode;

	@JsonProperty("air_date")
	private String airDate;

	@JsonProperty("overview")
	private String overview;

	@JsonProperty("episode_number")
	private int episodeNumber;

	@JsonProperty("vote_average")
	private Object voteAverage;

	@JsonProperty("name")
	private String name;

	@JsonProperty("season_number")
	private int seasonNumber;

	@JsonProperty("show_id")
	private int showId;

	@JsonProperty("still_path")
	private String stillPath;

	@JsonProperty("vote_count")
	private int voteCount;

	@JsonProperty("runtime")
	private int runtime;

	public void setProductionCode(String productionCode){
		this.productionCode = productionCode;
	}

	public String getProductionCode(){
		return productionCode;
	}

	public void setAirDate(String airDate){
		this.airDate = airDate;
	}

	public String getAirDate(){
		return airDate;
	}

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setEpisodeNumber(int episodeNumber){
		this.episodeNumber = episodeNumber;
	}

	public int getEpisodeNumber(){
		return episodeNumber;
	}

	public void setVoteAverage(Object voteAverage){
		this.voteAverage = voteAverage;
	}

	public Object getVoteAverage(){
		return voteAverage;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSeasonNumber(int seasonNumber){
		this.seasonNumber = seasonNumber;
	}

	public int getSeasonNumber(){
		return seasonNumber;
	}

	public void setId(int id){
		this.showId = id;
	}

	public int getId(){
		return showId;
	}

	public void setStillPath(String stillPath){
		this.stillPath = stillPath;
	}

	public String getStillPath(){
		return stillPath;
	}

	public void setVoteCount(int voteCount){
		this.voteCount = voteCount;
	}

	public int getVoteCount(){
		return voteCount;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	@Override
	public String toString() {
		return "LastEpisodeToAir{" +
				"productionCode='" + productionCode + '\'' +
				", airDate='" + airDate + '\'' +
				", overview='" + overview + '\'' +
				", episodeNumber=" + episodeNumber +
				", voteAverage=" + voteAverage +
				", name='" + name + '\'' +
				", seasonNumber=" + seasonNumber +
				", id=" + showId +
				", stillPath='" + stillPath + '\'' +
				", voteCount=" + voteCount +
				", runtime=" + runtime +
				'}';
	}
}