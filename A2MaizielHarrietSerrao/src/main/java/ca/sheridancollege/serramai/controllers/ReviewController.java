package ca.sheridancollege.serramai.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ca.sheridancollege.serramai.beans.Review;
import ca.sheridancollege.serramai.database.DatabaseAccess;

@Controller
public class ReviewController {

	@Autowired
	private DatabaseAccess da;

	// takes us to the index page
	@GetMapping("/")
	public String goToIndex(Model model) {
		ArrayList<Review> reviews = da.getAllReviews();
		model.addAttribute("reviews", reviews);
		return "index";
	}

	// inserts review into the database
	@PostMapping("/")
	public String insertReview(@ModelAttribute Review review, Model model) {
		da.insertReview(review);
		ArrayList<Review> reviews = da.getAllReviews();
		model.addAttribute("reviews", reviews);
		return "index";
	}

	// takes us to the form to add reviews
	@GetMapping("/add")
	public String addReview(Model model) {
		Review r = new Review();
		model.addAttribute("review", r);
		return "add";
	}

}
