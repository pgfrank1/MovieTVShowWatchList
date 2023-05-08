-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-03-22 21:34:54.844

-- tables
-- Table: UserFriends
DROP SCHEMA IF EXISTS IndieProject;
CREATE SCHEMA IF NOT EXISTS IndieProject;
USE IndieProject;

CREATE TABLE UserFriends (
                             friendId int  NOT NULL,
                             userId int  NOT NULL,
                             CONSTRAINT userId PRIMARY KEY (friendId,userId)
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
                                   movieId int  NOT NULL,
                                   userId int  NOT NULL,
                                   comment varchar(255)  NOT NULL,
                                   timeCreated timestamp  NOT NULL,
                                   CONSTRAINT UserMovieComments_pk PRIMARY KEY (movieId,userId,timeCreated)
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
                                    showId int  NOT NULL,
                                    userId int  NOT NULL,
                                    comment varchar(255)  NOT NULL,
                                    timeCreated timestamp  NOT NULL,
                                    CONSTRAINT UserTVShowComments_pk PRIMARY KEY (showId,userId,timeCreated)
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
                       profilePhotoLocation varchar(50)  NULL,
                       firstName varchar(50)  NOT NULL,
                       lastName varchar(50)  NOT NULL,
                       CONSTRAINT Id PRIMARY KEY (id)
);

-- foreign keys
-- Reference: UserFriends_FriendId (table: UserFriends)
ALTER TABLE UserFriends ADD CONSTRAINT UserFriends_FriendId FOREIGN KEY UserFriends_FriendId (userId)
    REFERENCES Users (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: UserFriends_Users (table: UserFriends)
ALTER TABLE UserFriends ADD CONSTRAINT UserFriends_Users FOREIGN KEY UserFriends_Users (friendId)
    REFERENCES Users (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: UserMovieComments_UserMovie (table: UserMovieComments)
ALTER TABLE UserMovieComments ADD CONSTRAINT UserMovieComments_UserMovie FOREIGN KEY UserMovieComments_UserMovie (movieId,userId)
    REFERENCES UserMovie (movieId,userId)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: UserMovieRating_UserMovie (table: UserMovieRating)
ALTER TABLE UserMovieRating ADD CONSTRAINT UserMovieRating_UserMovie FOREIGN KEY UserMovieRating_UserMovie (movieId,userId)
    REFERENCES UserMovie (movieId,userId)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: UserMovie_Users (table: UserMovie)
ALTER TABLE UserMovie ADD CONSTRAINT UserMovie_Users FOREIGN KEY UserMovie_Users (userId)
    REFERENCES Users (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: UserTVShowComments_UserTVShow (table: UserTVShowComments)
ALTER TABLE UserTVShowComments ADD CONSTRAINT UserTVShowComments_UserTVShow FOREIGN KEY UserTVShowComments_UserTVShow (showId,userId)
    REFERENCES UserTVShow (showId,userId)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: UserTVShowRating_UserTVShow (table: UserTVShowRating)
ALTER TABLE UserTVShowRating ADD CONSTRAINT UserTVShowRating_UserTVShow FOREIGN KEY UserTVShowRating_UserTVShow (showId,userId)
    REFERENCES UserTVShow (showId,userId)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

-- Reference: UserTVShow_Users (table: UserTVShow)
ALTER TABLE UserTVShow ADD CONSTRAINT UserTVShow_Users FOREIGN KEY UserTVShow_Users (userId)
    REFERENCES Users (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

insert into Users (id, username, profilePhotoLocation, firstName, lastName)
values (1, 'pgfrank', '/testPhotoLocation', 'Patrick', 'Frank'),
       (2, 'user1', '/anotherTestLocation', 'Jeremy', 'Smith');

insert into UserFriends (userId, friendId) values (1, 2), (2, 1);

insert into UserTVShow (showId, userId, watched, planned, watching, dropped)
values (123, 1, true, false, false, false),
       (456, 2, false, true, false, false);

insert into UserMovie (movieId, userId, watched, planned, watching, dropped)
values (1234, 2, false, false, true, false),
       (5678, 1, false, false, false, true);

insert into UserMovieComments (comment, movieId, userId, timeCreated)
values ('This is a comment from Patrick Frank for a Movie', 5678, 1, CURRENT_TIMESTAMP()),
       ('This is a comment from Jeremy Smith for a Movie', 1234, 2, CURRENT_TIMESTAMP());

insert into UserTVShowComments (comment, showId, userId, timeCreated)
values ('This is a comment from Patrick Frank for a TV Show', 123, 1, CURRENT_TIMESTAMP()),
       ('This is a comment from Jeremy Smith for a TV Show', 456, 2, CURRENT_TIMESTAMP());

insert into UserMovieRating (userId, movieId, rating) values (1, 5678, 5), (2, 1234, 3);
insert into UserTVShowRating (userId, showId, rating) value (1, 123, 2), (2, 456, 4);

-- End of file.