# Reviews Site, Full Stack
## Overview
In the week 7 capstone project I get to return the topic of nacho reviews. This time we are wiring up a full stack web app to serve the reviews.  The reviews are going to be stored in a H2 database.

## Tasks
- [ ] Add the following dependencies to build.gradle (or use Spring Initializr to create a new build.gradle)
	- [ ] JPA (spring-boot-starter-data-jpa)
	- [ ] H2
- [ ] Create a Category class that:
	- [ ] is a JPA entity.
	- [ ] contains an instance variable referencing the Reviews it contains.
 	- [ ] configures an appropriate JPA relationship to its reviews.
- [ ] Update the Review class such that:
	- [ ] it is a JPA entity.
	- [ ] configures a JPA relationship to its associated category.
	- [ ] allows for a description/content/body longer than 255 characters.
-[ ] Update your view (templates/html/css) such that:
	-[ ] there is a page that lists review categories, each of which links to the (details) page for a specific category.
	-[ ] there is a page that lists the reviews for a chosen category, each of which links to the (details) page for a specific review.
	-[ ] each review detail page has a link to the page for its category.