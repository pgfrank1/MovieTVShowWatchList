### Week 3 2/6/2023
I was able to complete my project screen design and I have a decent understanding of how I want the application to flow.
I want to add the ability to add comments to each movie and TV show, but I am a little worried about the time required
to make all that work. I would add those comments to the details page for the specified movie or TV show. If I find that I 
do have time, I'll update the design and have you take a look.

I've also been reading through the API documentation to make sure that I have enough knowledge about it before I start
coding. Fortunately, it seems to be a fairly simple API to use.

For my professional development choice, I've been looking through the documentation and issues but I can't seem
to find a good start for some of these issues that have been appearing. A lot of the good-for-first-contribution tags
are still open issues. I've been monitoring the issues to find one that is a good starting point.

### Week 4
This week I was able to get my 1st checkpoint finished on my project. I believe I was able to get the user
stories accurately for my application.

### Week 5
I didn't work too much on my project this week. I was still looking at The Movie Database API documentation
to make sure I know about all of the information I can gather from it and utilize that data in my
application.

### Week 6
This week I didn't work as much on the project as I went on a little snowboarding/Kalahari trip with
a few of my friends. When I came back, I was able to complete the week 6 exercise fairly quickly.

### Week 7
I was able to successfully use the API to get the poster images for each movie and TV show. It
can also get detailed information about each individual piece of content. I was able to get the
list to show in rows of 2 using JSTL tags. It took a good while, but I was able to get it working.

I was able to meet with John and got some great feedback from him. One he mentioned was to 
add a column for movies and tv shows that their friends like on the index page.
After coding some more on the project, I realized I'll need to make a lot of changes to the TV show part
of the application. Movies were pretty simple to get setup and show their own information. TV shows have
episodes and seasons that vary widly in runtime, episodes per season, and amount of seasons of 
the TV show. I'll really have to think about the design for the TV show information page. Maybe
different sections for seasons, and episodes of the season being viewed?

### Week 8
This week was a bit challenging to try and get AWS Cognito to work in the cloud. I had no
issues getting Cognito to work locally but in AWS was nearly impossible. I cannot get the SSL
function to work in the cloud. I've tried the OpenSSL method and an AWS generated certificate but neither
of them worked. I was at least able to get some of the DAO objects working.

### Spring Break
Starting to use POJO objects really helped my application flow better. I was easily able to adapt over to
them and adapted the JSP pages to the new attribute naming scheme. I updated the database table names as my
Test and Main databases had different table names which made it extremely confusing. I then decided to change my
entity package structure as there were a TON of classes generated from the POJO generator. I placed each class into
a Movie or TVShow package. I then made a SharedInfo package as there were a few generated classes that were the
same for a TVShow and Movie.

### 