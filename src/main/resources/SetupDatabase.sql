-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-02-28 22:30:43.842

-- tables
-- Table: UserFriends
drop schema if exists IndieProject;
create schema IndieProject;
use IndieProject;

CREATE TABLE UserFriends (
    UserId int  NOT NULL,
    FriendId int  NOT NULL,
    CONSTRAINT UserFriends_pk PRIMARY KEY (UserId,FriendId)
);

-- Table: UserMovie
CREATE TABLE UserMovie (
    movieId int  NOT NULL,
    userId int  NOT NULL,
    watched bool  NOT NULL,
    planned bool  NOT NULL,
    watching bool  NOT NULL,
    dropped bool  NOT NULL,
    CONSTRAINT UserMovie_pk PRIMARY KEY (movieId,userId)
);

-- Table: UserMovieComments
CREATE TABLE UserMovieComments (
    id int  NOT NULL AUTO_INCREMENT,
    comment varchar(255)  NOT NULL,
    movieId int  NOT NULL,
    userId int  NOT NULL,
    CONSTRAINT UserMovieComments_pk PRIMARY KEY (id)
);

-- Table: UserMovieRating
CREATE TABLE UserMovieRating (
    userId int  NOT NULL,
    movieId int  NOT NULL,
    rating int  NOT NULL,
    CONSTRAINT UserMovieRating_pk PRIMARY KEY (movieId,userId)
);

-- Table: UserTVShow
CREATE TABLE UserTVShow (
    showId int  NOT NULL,
    userId int  NOT NULL,
    watched bool  NOT NULL,
    planned bool  NOT NULL,
    watching bool  NOT NULL,
    dropped bool  NOT NULL,
    CONSTRAINT UserTVShow_pk PRIMARY KEY (showId,userId)
);

-- Table: UserTVShowComments
CREATE TABLE UserTVShowComments (
    id int  NOT NULL AUTO_INCREMENT,
    comment varchar(255)  NOT NULL,
    showId int  NOT NULL,
    userId int  NOT NULL,
    CONSTRAINT UserTVShowComments_pk PRIMARY KEY (id)
);

-- Table: UserTVShowRating
CREATE TABLE UserTVShowRating (
    userId int  NOT NULL,
    showId int  NOT NULL,
    rating int  NOT NULL,
    CONSTRAINT UserTVShowRating_pk PRIMARY KEY (userId,showId)
);

-- Table: Users
CREATE TABLE Users (
    id int  NOT NULL AUTO_INCREMENT,
    username varchar(50)  NOT NULL,
    password varchar(50)  NOT NULL,
    profilePhotoLocation varchar(50)  NOT NULL,
    firstName varchar(50)  NOT NULL,
    lastName varchar(50)  NOT NULL,
    CONSTRAINT Id PRIMARY KEY (id)
);

-- foreign keys
-- Reference: UserFriends_FriendId (table: UserFriends)
ALTER TABLE UserFriends ADD CONSTRAINT UserFriends_FriendId FOREIGN KEY UserFriends_FriendId (FriendId)
    REFERENCES Users (id);

-- Reference: UserFriends_UserId (table: UserFriends)
ALTER TABLE UserFriends ADD CONSTRAINT UserFriends_UserId FOREIGN KEY UserFriends_UserId (UserId)
    REFERENCES Users (id);

-- Reference: UserMovieComments_UserMovie (table: UserMovieComments)
ALTER TABLE UserMovieComments ADD CONSTRAINT UserMovieComments_UserMovie FOREIGN KEY UserMovieComments_UserMovie (movieId,userId)
    REFERENCES UserMovie (movieId,userId);

-- Reference: UserMovieRating_UserMovie (table: UserMovieRating)
ALTER TABLE UserMovieRating ADD CONSTRAINT UserMovieRating_UserMovie FOREIGN KEY UserMovieRating_UserMovie (movieId,userId)
    REFERENCES UserMovie (movieId,userId);

-- Reference: UserMovie_Users (table: UserMovie)
ALTER TABLE UserMovie ADD CONSTRAINT UserMovie_Users FOREIGN KEY UserMovie_Users (userId)
    REFERENCES Users (id);

-- Reference: UserTVShowComments_UserTVShow (table: UserTVShowComments)
ALTER TABLE UserTVShowComments ADD CONSTRAINT UserTVShowComments_UserTVShow FOREIGN KEY UserTVShowComments_UserTVShow (showId,userId)
    REFERENCES UserTVShow (showId,userId);

-- Reference: UserTVShowRating_UserTVShow (table: UserTVShowRating)
ALTER TABLE UserTVShowRating ADD CONSTRAINT UserTVShowRating_UserTVShow FOREIGN KEY UserTVShowRating_UserTVShow (showId,userId)
    REFERENCES UserTVShow (showId,userId);

-- Reference: UserTVShow_Users (table: UserTVShow)
ALTER TABLE UserTVShow ADD CONSTRAINT UserTVShow_Users FOREIGN KEY UserTVShow_Users (userId)
    REFERENCES Users (id);

-- End of file.