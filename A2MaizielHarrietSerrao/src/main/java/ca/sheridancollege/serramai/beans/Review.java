package ca.sheridancollege.serramai.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String restaurantName;
	private String review;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfVisit;
	private double rating;
	private String city;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate reviewDate = LocalDate.now();
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime reviewTime = LocalTime.now();

}
