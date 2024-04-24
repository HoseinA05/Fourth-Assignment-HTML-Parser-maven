# Fourth Assignment: HTML Parser 🌐

## Introduction 

This project delves into the practical application of HTML parsing techniques using Java and the JSoup library. The objective is to extract and manipulate data from a structured HTML document containing information about various countries. Key tasks include parsing the document, creating Java objects to represent the data, sorting the information based on different criteria, and presenting the results effectively.

## Why Learn Web Scraping? 📊

Mastering web scraping empowers individuals and businesses to glean valuable insights, automate tasks, and make informed decisions based on real-time data.

- In e-commerce, web scraping aids in monitoring competitors' prices, tracking product availability, and gathering customer reviews. In finance, it facilitates trend analysis, investment decisions, and risk assessment.

- Research, academia, journalism, and media professionals leverage web scraping for data collection, trend tracking, sentiment analysis, and investigative reporting.

By mastering web scraping, professionals can extract data efficiently, outperform competitors, and drive data-informed success in diverse industries.

## Prerequisites ✅

Before diving into this project, make sure you have the following tools and knowledge:

### Tools Needed:
- **Java 17 or higher** : Download the latest version from [Oracle's Java website](https://www.oracle.com/java/technologies/downloads/).
- **Git** : Install Git, a powerful version control system, from [Git's official website](https://git-scm.com/downloads).
- **Gradle** : Utilize Gradle (recommended version 7.6 or newer) as the build tool. You can find installation instructions [here](https://gradle.org/install/).

### Knowledge Required:
In addition to the tools mentioned above, familiarity with the following topics is crucial for successful project completion:
- **Jsoup** : Understanding how to access, parse, and manipulate HTML files using Jsoup.
- **HTML** : Knowledge of various HTML tags, their purposes, and how to identify and manipulate them using Jsoup.
- **CSS** : Understanding how to style HTML elements, work with CSS classes, and utilize selectors efficiently.

By having a solid grasp of these tools and concepts, you'll be well-equipped to excel in this project. 🚀

## Objectives 🎯

The primary objectives of this assignment are:

- Parsing an HTML file with country data.
- Extracting relevant information such as population, area, and other country attributes.
- Implementing Java classes to represent countries.
- Utilizing JSoup for HTML parsing.
- Applying sorting algorithms for organizing data by population, area, and country name.
- Displaying the sorted country information effectively.

## Tasks 📝

1. **Set Up the Project:**

    - Start by cloning the repository to your local machine.
    - Open the project in an IDE such as IntelliJ.

2. **Integrate JSoup Dependency:**

    - Include the JSoup dependency in your `build.gradle` file.

    ```gradle
    dependencies {

      testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'

      testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'

      implementation 'org.jsoup:jsoup:1.14.3'

    }
    ```


3. **Define the Country Class:**

    - Create a `Country` class in Java to encapsulate country-specific data.

5. **HTML Parsing using JSoup:**

   Utilize JSoup to parse the HTML file located in the Resources folder at this path: `Fourth-Assignment-HTML-Parser\src\Resources` and extract relevant information such as:

    - `<span class="country-capital">` = for country names
    - `<span class="country-population">` = for country populations
    - `<span class="country-area">` = for country areas

   **Note: The span tags are nested within other tags and div closures.**

6. **Implement Sorting Functionality:**

    - Develop sorting algorithms for various criteria like population, area, and name.

8. **Visualize Results:**

    - Clearly present the sorted country data.

## Bonus Objectives (For Advanced Users) 🌟

To enhance your project further:

- Expand data extraction to additional websites, such as [Hockey Teams](https://www.scrapethissite.com/pages/forms/).
- Develop a user interface for interactive querying and sorting.
- Utilize SQL or NoSQL databases to store the scraped data.

## Notes 📝

Here are some important points to keep in mind:

- there is a `Help` folder located at the root directory of the project which contains the sorted countries each by different priorities it is there just so you can see what you r output should look like in the end.
- The unit tests are provided to assist you in understanding the project requirements. Your final grade is not solely dependent on their results; they are meant to aid your learning process. Remember to enable GitHub Actions for the test workflow to run on GitHub.
- Feel free to leverage ChatGPT for learning web scraping and resolving any challenges that you may not find solutions to on the internet. Utilize its capabilities to enhance your understanding and overcome obstacles effectively.
**but It is strictly prohibited to use ChatGPT or any other AI generative model for completing any section of this assignment. Failure to comply will result in a score of 0 without any warnings.**

## Evaluation 🧐

Your success will be judged based on:

- Functionality of the code in parsing HTML, creating Java objects, and sorting data.
- Readability and maintainability of the code.
- Efficiency of sorting algorithms.
- Clarity of the output format.

## Submission 📁

To share your work:

1. Add your mentor as a contributor to the project.
2. Create a `develop` branch for implementing features.
3. Use Git for regular code commits.
4. Push your code to the remote repository.
5. Submit a pull request to merge the `develop` branch with `main`.

The deadline for submitting your code is **Wednesday, April 24** (5th of Ordibehesht).

If you have any further questions or need clarification, do not hesitate to reach out to your mentor. Good luck with your project! 🌟


## Resources 📚

- [Jsoup - Official website](https://jsoup.org/cookbook/)
- [Jsoup - Javapoint](https://www.javatpoint.com/jsoup-tutorial)
- [Jsoup - Baeldung](https://www.baeldung.com/java-with-jsoup)
- [HTML - W3](https://www.w3schools.com/html/)
- [CSS - W3](https://www.w3schools.com/css/default.asp)
- [HTML & CSS - SuperSimpleDev](https://youtu.be/G3e-cpL7ofc?si=n7VZ6-SzUMqPgYH4)
- [HTML & CSS - BroCode](https://youtu.be/HGTJBPNC-Gw?si=UIfbcK-raImMT129)
