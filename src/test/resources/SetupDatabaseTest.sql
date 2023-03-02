-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-02-28 22:30:43.842

-- tables
-- Table: UserFriends
drop schema if exists IndieProjectTest;
create schema IndieProjectTest;
use IndieProjectTest;

CREATE TABLE UserFriends (
    user_id int  NOT NULL,
    Friend_id int  NOT NULL,
    CONSTRAINT UserFriends_pk PRIMARY KEY (user_id,Friend_id)
);

-- Table: UserMovie
CREATE TABLE UserMovie (
    movie_id int  NOT NULL,
    user_id int  NOT NULL,
    watched bool  NOT NULL,
    planned bool  NOT NULL,
    watching bool  NOT NULL,
    dropped bool  NOT NULL,
    CONSTRAINT UserMovie_pk PRIMARY KEY (movie_id,user_id)
);

-- Table: UserMovieComments
CREATE TABLE UserMovieComments (
    id int  NOT NULL AUTO_INCREMENT,
    comment varchar(255)  NOT NULL,
    movie_id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT UserMovieComments_pk PRIMARY KEY (id)
);

-- Table: UserMovieRating
CREATE TABLE UserMovieRating (
    user_id int  NOT NULL,
    movie_id int  NOT NULL,
    rating int  NOT NULL,
    CONSTRAINT UserMovieRating_pk PRIMARY KEY (movie_id,user_id)
);

-- Table: UserTVShow
CREATE TABLE UserTVShow (
    show_id int  NOT NULL,
    user_id int  NOT NULL,
    watched bool  NOT NULL,
    planned bool  NOT NULL,
    watching bool  NOT NULL,
    dropped bool  NOT NULL,
    CONSTRAINT UserTVShow_pk PRIMARY KEY (show_id,user_id)
);

-- Table: UserTVShowComments
CREATE TABLE UserTVShowComments (
    id int  NOT NULL AUTO_INCREMENT,
    comment varchar(255)  NOT NULL,
    show_id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT UserTVShowComments_pk PRIMARY KEY (id)
);

-- Table: UserTVShowRating
CREATE TABLE UserTVShowRating (
    user_id int  NOT NULL,
    show_id int  NOT NULL,
    rating int  NOT NULL,
    CONSTRAINT UserTVShowRating_pk PRIMARY KEY (user_id,show_id)
);

-- Table: User
CREATE TABLE User (
    id int  NOT NULL AUTO_INCREMENT,
    username varchar(50)  NOT NULL,
    password varchar(50)  NOT NULL,
    profile_photo_location varchar(50)  NOT NULL,
    firstName varchar(50)  NOT NULL,
    lastName varchar(50)  NOT NULL,
    CONSTRAINT _id PRIMARY KEY (id)
);

-- foreign keys
-- Reference: UserFriends_Friend_id (table: UserFriends)
ALTER TABLE UserFriends ADD CONSTRAINT UserFriends_Friend_id FOREIGN KEY UserFriends_Friend_id (Friend_id)
    REFERENCES User (id);

-- Reference: UserFriends_user_id (table: UserFriends)
ALTER TABLE UserFriends ADD CONSTRAINT UserFriends_user_id FOREIGN KEY UserFriends_user_id (user_id)
    REFERENCES User (id);

-- Reference: UserMovieComments_UserMovie (table: UserMovieComments)
ALTER TABLE UserMovieComments ADD CONSTRAINT UserMovieComments_UserMovie FOREIGN KEY UserMovieComments_UserMovie (movie_id,user_id)
    REFERENCES UserMovie (movie_id,user_id);

-- Reference: UserMovieRating_UserMovie (table: UserMovieRating)
ALTER TABLE UserMovieRating ADD CONSTRAINT UserMovieRating_UserMovie FOREIGN KEY UserMovieRating_UserMovie (movie_id,user_id)
    REFERENCES UserMovie (movie_id,user_id);

-- Reference: UserMovie_User (table: UserMovie)
ALTER TABLE UserMovie ADD CONSTRAINT UserMovie_User FOREIGN KEY UserMovie_User (user_id)
    REFERENCES User (id);

-- Reference: UserTVShowComments_UserTVShow (table: UserTVShowComments)
ALTER TABLE UserTVShowComments ADD CONSTRAINT UserTVShowComments_UserTVShow FOREIGN KEY UserTVShowComments_UserTVShow (show_id,user_id)
    REFERENCES UserTVShow (show_id,user_id);

-- Reference: UserTVShowRating_UserTVShow (table: UserTVShowRating)
ALTER TABLE UserTVShowRating ADD CONSTRAINT UserTVShowRating_UserTVShow FOREIGN KEY UserTVShowRating_UserTVShow (show_id,user_id)
    REFERENCES UserTVShow (show_id,user_id);

-- Reference: UserTVShow_User (table: UserTVShow)
ALTER TABLE UserTVShow ADD CONSTRAINT UserTVShow_User FOREIGN KEY UserTVShow_User (user_id)
    REFERENCES User (id);

insert into User (id, username, password, profile_photo_location, firstName, lastName)
    values (1, 'pgfrank', 'p@ssw0rd', '/testPhotoLocation', 'Patrick', 'Frank'),
           (2, 'user1', 'anotherPassword', '/anotherTestLocation', 'Jeremy', 'Smith');

insert into UserFriends (user_id, Friend_id) values (1, 2), (2, 1);

insert into UserTVShow (show_id, user_id, watched, planned, watching, dropped)
    values (123, 1, true, false, false, false),
           (456, 2, false, true, false, false);

insert into UserMovie (movie_id, user_id, watched, planned, watching, dropped)
    values (1234, 2, false, false, true, false),
           (5678, 1, false, false, false, true);

insert into UserMovieComments (comment, movie_id, user_id)
    values ('This is a comment from Patrick Frank for a Movie', 5678, 1),
           ('This is a comment from Jeremy Smith for a Movie', 1234, 2);

insert into UserTVShowComments (comment, show_id, user_id)
    values ('This is a comment from Patrick Frank for a TV Show', 123, 1),
           ('This is a comment from Jeremy Smith for a TV Show', 456, 2);

insert into UserMovieRating (user_id, movie_id, rating) values (1, 5678, 5), (2, 1234, 3);
insert into UserTVShowRating (user_id, show_id, rating) value (1, 123, 2), (2, 456, 4);

-- End of file.