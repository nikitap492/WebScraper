[![Build Status](https://travis-ci.org/nikitap492/WebScraper.svg?branch=master)](https://travis-ci.org/nikitap492/WebScraper)
[![codecov.io](https://codecov.io/github/nikitap492/WebScraper/coverage.svg?branch=master)](https://travis-ci.org/nikitap492/WebScraper?branch=master)
[![CodeFactor](https://www.codefactor.io/repository/github/nikitap492/webscraper/badge)](https://www.codefactor.io/repository/github/nikitap492/webscraper)
# WebScraper
**Simple data mining**
### Simple library for data scraping.
## How to try this project?
#### You must have gradle and jdk 8. In project directory create jar by command `gradle build`. When jar will be created in build/libs. Run it `java -jar scraper.jar uri words options `. URI this is web site url or path to file with URLs, words are searchable words separated by delimeter "," and options enables different type of analyze:
- -c for counting chars on web pages
- -w for counting words on web pages
- -e for scrapping sentences for searchable words
