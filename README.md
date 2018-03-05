# Reviews Site, Full Stack
## Overview
In the week 7 capstone project I get to return the topic of nacho reviews. This time we are wiring up a full stack web app to serve the reviews.  The reviews are going to be stored in a H2 database.
![Screenshot of a review view](screenshot.png)
## Tasks
- [x] Add the following dependencies to build.gradle (or use Spring Initializr to create a new build.gradle)
	- [x] JPA (spring-boot-starter-data-jpa)
	- [x] H2
- [x] Create a Category class that:
	- [x] is a JPA entity.
	- [x] contains an instance variable referencing the Reviews it contains.
 	- [x] configures an appropriate JPA relationship to its reviews.
- [x] Update the Review class such that:
	- [x] it is a JPA entity.
	- [x] configures a JPA relationship to its associated category.
	- [x] allows for a description/content/body longer than 255 characters.
- [x] Update your view (templates/html/css) such that:
	- [x] there is a page that lists review categories, each of which links to the (details) page for a specific category.
	- [x] there is a page that lists the reviews for a chosen category, each of which links to the (details) page for a specific review.
	- [x] each review detail page has a link to the page for its category.