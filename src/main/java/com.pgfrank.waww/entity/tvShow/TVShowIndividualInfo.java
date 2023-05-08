package com.pgfrank.waww.entity.tvShow;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pgfrank.waww.entity.sharedInfo.GenresItem;
import com.pgfrank.waww.entity.sharedInfo.ProductionCompaniesItem;
import com.pgfrank.waww.entity.sharedInfo.SpokenLanguagesItem;

public class TVShowIndividualInfo{

	@JsonProperty("adult")
	private Boolean adult;
	@JsonProperty("original_language")
	private String originalLanguage;

	@JsonProperty("number_of_episodes")
	private int numberOfEpisodes;

	@JsonProperty("networks")
	private List<NetworksItem> networks;

	@JsonProperty("type")
	private String type;

	@JsonProperty("backdrop_path")
	private String backdropPath;

	@JsonProperty("genres")
	private List<GenresItem> genres;

	@JsonProperty("popularity")
	private Object popularity;

	@JsonProperty("production_countries")
	private List<ProductionCountriesItem> productionCountries;

	@JsonProperty("id")
	private int id;

	@JsonProperty("number_of_seasons")
	private int numberOfSeasons;

	@JsonProperty("vote_count")
	private int voteCount;

	@JsonProperty("first_air_date")
	private String firstAirDate;

	@JsonProperty("overview")
	private String overview;

	@JsonProperty("seasons")
	private List<SeasonsItem> seasons;

	@JsonProperty("languages")
	private List<String> languages;

	@JsonProperty("created_by")
	private List<CreatedByItem> createdBy;

	@JsonProperty("last_episode_to_air")
	private LastEpisodeToAir lastEpisodeToAir;

	@JsonProperty("poster_path")
	private String posterPath;

	@JsonProperty("origin_country")
	private List<String> originCountry;

	@JsonProperty("spoken_languages")
	private List<SpokenLanguagesItem> spokenLanguages;

	@JsonProperty("production_companies")
	private List<ProductionCompaniesItem> productionCompanies;

	@JsonProperty("original_name")
	private String originalName;

	@JsonProperty("vote_average")
	private Object voteAverage;

	@JsonProperty("name")
	private String name;

	@JsonProperty("tagline")
	private String tagline;

	@JsonProperty("episode_run_time")
	private List<Integer> episodeRunTime;

	@JsonProperty("next_episode_to_air")
	private Object nextEpisodeToAir;

	@JsonProperty("in_production")
	private boolean inProduction;

	@JsonProperty("last_air_date")
	private String lastAirDate;

	@JsonProperty("homepage")
	private String homepage;

	@JsonProperty("status")
	private String status;

	public Boolean getAdult() {
		return adult;
	}

	public void setAdult(Boolean adult) {
		this.adult = adult;
	}

	public void setOriginalLanguage(String originalLanguage){
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public void setNumberOfEpisodes(int numberOfEpisodes){
		this.numberOfEpisodes = numberOfEpisodes;
	}

	public int getNumberOfEpisodes(){
		return numberOfEpisodes;
	}

	public void setNetworks(List<NetworksItem> networks){
		this.networks = networks;
	}

	public List<NetworksItem> getNetworks(){
		return networks;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setBackdropPath(String backdropPath){
		this.backdropPath = backdropPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public void setGenres(List<GenresItem> genres){
		this.genres = genres;
	}

	public List<GenresItem> getGenres(){
		return genres;
	}

	public void setPopularity(Object popularity){
		this.popularity = popularity;
	}

	public Object getPopularity(){
		return popularity;
	}

	public void setProductionCountries(List<ProductionCountriesItem> productionCountries){
		this.productionCountries = productionCountries;
	}

	public List<ProductionCountriesItem> getProductionCountries(){
		return productionCountries;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setNumberOfSeasons(int numberOfSeasons){
		this.numberOfSeasons = numberOfSeasons;
	}

	public int getNumberOfSeasons(){
		return numberOfSeasons;
	}

	public void setVoteCount(int voteCount){
		this.voteCount = voteCount;
	}

	public int getVoteCount(){
		return voteCount;
	}

	public void setFirstAirDate(String firstAirDate){
		this.firstAirDate = firstAirDate;
	}

	public String getFirstAirDate(){
		return firstAirDate;
	}

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setSeasons(List<SeasonsItem> seasons){
		this.seasons = seasons;
	}

	public List<SeasonsItem> getSeasons(){
		return seasons;
	}

	public void setLanguages(List<String> languages){
		this.languages = languages;
	}

	public List<String> getLanguages(){
		return languages;
	}

	public void setCreatedBy(List<CreatedByItem> createdBy){
		this.createdBy = createdBy;
	}

	public List<CreatedByItem> getCreatedBy(){
		return createdBy;
	}

	public void setLastEpisodeToAir(LastEpisodeToAir lastEpisodeToAir){
		this.lastEpisodeToAir = lastEpisodeToAir;
	}

	public LastEpisodeToAir getLastEpisodeToAir(){
		return lastEpisodeToAir;
	}

	public void setPosterPath(String posterPath){
		this.posterPath = posterPath;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public void setOriginCountry(List<String> originCountry){
		this.originCountry = originCountry;
	}

	public List<String> getOriginCountry(){
		return originCountry;
	}

	public void setSpokenLanguages(List<SpokenLanguagesItem> spokenLanguages){
		this.spokenLanguages = spokenLanguages;
	}

	public List<SpokenLanguagesItem> getSpokenLanguages(){
		return spokenLanguages;
	}

	public void setProductionCompanies(List<ProductionCompaniesItem> productionCompanies){
		this.productionCompanies = productionCompanies;
	}

	public List<ProductionCompaniesItem> getProductionCompanies(){
		return productionCompanies;
	}

	public void setOriginalName(String originalName){
		this.originalName = originalName;
	}

	public String getOriginalName(){
		return originalName;
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

	public void setTagline(String tagline){
		this.tagline = tagline;
	}

	public String getTagline(){
		return tagline;
	}

	public void setEpisodeRunTime(List<Integer> episodeRunTime){
		this.episodeRunTime = episodeRunTime;
	}

	public List<Integer> getEpisodeRunTime(){
		return episodeRunTime;
	}

	public void setNextEpisodeToAir(Object nextEpisodeToAir){
		this.nextEpisodeToAir = nextEpisodeToAir;
	}

	public Object getNextEpisodeToAir(){
		return nextEpisodeToAir;
	}

	public void setInProduction(boolean inProduction){
		this.inProduction = inProduction;
	}

	public boolean isInProduction(){
		return inProduction;
	}

	public void setLastAirDate(String lastAirDate){
		this.lastAirDate = lastAirDate;
	}

	public String getLastAirDate(){
		return lastAirDate;
	}

	public void setHomepage(String homepage){
		this.homepage = homepage;
	}

	public String getHomepage(){
		return homepage;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return "TVShowIndividualInfo{" +
				"adult=" + adult +
				", originalLanguage='" + originalLanguage + '\'' +
				", numberOfEpisodes=" + numberOfEpisodes +
				", networks=" + networks +
				", type='" + type + '\'' +
				", backdropPath='" + backdropPath + '\'' +
				", genres=" + genres +
				", popularity=" + popularity +
				", productionCountries=" + productionCountries +
				", id=" + id +
				", numberOfSeasons=" + numberOfSeasons +
				", voteCount=" + voteCount +
				", firstAirDate='" + firstAirDate + '\'' +
				", overview='" + overview + '\'' +
				", seasons=" + seasons +
				", languages=" + languages +
				", createdBy=" + createdBy +
				", lastEpisodeToAir=" + lastEpisodeToAir +
				", posterPath='" + posterPath + '\'' +
				", originCountry=" + originCountry +
				", spokenLanguages=" + spokenLanguages +
				", productionCompanies=" + productionCompanies +
				", originalName='" + originalName + '\'' +
				", voteAverage=" + voteAverage +
				", name='" + name + '\'' +
				", tagline='" + tagline + '\'' +
				", episodeRunTime=" + episodeRunTime +
				", nextEpisodeToAir=" + nextEpisodeToAir +
				", inProduction=" + inProduction +
				", lastAirDate='" + lastAirDate + '\'' +
				", homepage='" + homepage + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}