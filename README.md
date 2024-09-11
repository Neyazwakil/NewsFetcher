# NewsFetcher API
## Overview
This project is a simple HTTP-based NewsFetcher built using Spring Boot and Selenium. It takes a search term as input, performs a search on Google News, and returns a list of news article URLs from the first page of the search results.

## Features
- Accepts a search term through a REST API endpoint.
- Uses Selenium to open Google News, perform a search, and scrape - article URLs from the first page of results.
- Excludes advertisements and non-article results.
- Returns the article URLs in JSON format.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Usage](#usage)




## Technologies Used
- Java with Spring Boot for the REST API.
- Selenium for web scraping.
- Maven for project management and dependencies.
- WebDriver Manager to handle the browser driver setup.
- Jackson for JSON processing.

## Setup
1. Java 11 or later installed.
2. Maven installed.
3. Google Chrome installed (required for Selenium).
4.  Clone the repository to your local machine.



## API Usage
* Endpoint: /search
* Method:- 	GET	           		
* Endpoint:-  /search?query=term
* Parameters:-  query
  Description:-   Performs a search on Google News for the given term and returns the article URLs.

## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them with descriptive commit messages.
4. Push your changes to your fork.
5. Submit a pull request to the main repository.

## Author
* neyaz Wakil
