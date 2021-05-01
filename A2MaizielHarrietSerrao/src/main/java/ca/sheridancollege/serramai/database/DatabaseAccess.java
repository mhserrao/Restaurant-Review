package ca.sheridancollege.serramai.database;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.serramai.beans.Review;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	// method that inserts reviews into the database
	public void insertReview(Review review) {
		String query = "INSERT INTO Reviews(restaurantName, review, dateOfVisit, "
				+ "rating, city, reviewDate, reviewTime) " + "VALUES (:restaurantName,"
				+ " :review, :dateOfVisit, :rating, :city, :reviewDate, :reviewTime)";

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("restaurantName", review.getRestaurantName());
		parameters.addValue("review", review.getReview());
		parameters.addValue("dateOfVisit", review.getDateOfVisit());
		parameters.addValue("rating", review.getRating());
		parameters.addValue("city", review.getCity());
		parameters.addValue("reviewDate", review.getReviewDate());
		parameters.addValue("reviewTime", review.getReviewTime());

		jdbc.update(query, parameters);
	}

	// method that returns all the reviews in the database
	public ArrayList<Review> getAllReviews() {
		String query = "SELECT id, restaurantName, review, dateOfVisit, "
				+ "rating, city, reviewDate, reviewTime FROM Reviews";
		ArrayList<Review> reviews = (ArrayList<Review>) jdbc.query(query,
				new BeanPropertyRowMapper<Review>(Review.class));
		return reviews;
	}

}
