package com.example.movies.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseMovies{

	@SerializedName("dates")
	private Dates dates;

	@SerializedName("page")
	private Integer page;

	@SerializedName("total_pages")
	private Integer totalPages;

	@SerializedName("results")
	private List<ResultsItem> results;

	@SerializedName("total_results")
	private Integer totalResults;

	public Dates getDates(){
		return dates;
	}

	public Integer getPage(){
		return page;
	}

	public Integer getTotalPages(){
		return totalPages;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public Integer getTotalResults(){
		return totalResults;
	}

	@Override
 	public String toString(){
		return 
			"ResponseMovies{" + 
			"dates = '" + dates + '\'' + 
			",page = '" + page + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			",results = '" + results + '\'' + 
			",total_results = '" + totalResults + '\'' + 
			"}";
		}
}