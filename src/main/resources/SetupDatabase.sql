-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-02-28 22:30:43.842

-- tables
-- Table: userFriends
drop schema if exists IndieProject;
create schema IndieProject;
use IndieProject;

CREATE TABLE userFriends (
                             user_id int  NOT NULL,
                             friend_id int  NOT NULL,
                             CONSTRAINT userFriends_pk PRIMARY KEY (user_id,friend_id)
);

-- Table: userMovie
CREATE TABLE userMovie (
                           movie_id int  NOT NULL,
                           user_id int  NOT NULL,
                           watched bool  NOT NULL,
                           planned bool  NOT NULL,
                           watching bool  NOT NULL,
                           dropped bool  NOT NULL,
                           CONSTRAINT userMovie_pk PRIMARY KEY (movie_id,user_id)
);

-- Table: userMovieComments
CREATE TABLE userMovieComments (
                                   user_movie_comments_id int  NOT NULL AUTO_INCREMENT,
                                   comment varchar(255)  NOT NULL,
                                   movie_id int  NOT NULL,
                                   user_id int  NOT NULL,
                                   CONSTRAINT userMovieComments_pk PRIMARY KEY (user_movie_comments_id)
);

-- Table: userMovieRating
CREATE TABLE userMovieRating (
                                 user_id int  NOT NULL,
                                 movie_id int  NOT NULL,
                                 rating int  NOT NULL,
                                 CONSTRAINT userMovieRating_pk PRIMARY KEY (movie_id,user_id)
);

-- Table: userTVShow
CREATE TABLE userTVShow (
                            show_id int  NOT NULL,
                            user_id int  NOT NULL,
                            watched bool  NOT NULL,
                            planned bool  NOT NULL,
                            watching bool  NOT NULL,
                            dropped bool  NOT NULL,
                            CONSTRAINT userTVShow_pk PRIMARY KEY (show_id,user_id)
);

-- Table: userTVShowComments
CREATE TABLE userTVShowComments (
                                    tv_show_comment_id int  NOT NULL AUTO_INCREMENT,
                                    comment varchar(255)  NOT NULL,
                                    show_id int  NOT NULL,
                                    user_id int  NOT NULL,
                                    CONSTRAINT userTVShowComments_pk PRIMARY KEY (tv_show_comment_id)
);

-- Table: userTVShowRating
CREATE TABLE userTVShowRating (
                                  user_id int  NOT NULL,
                                  show_id int  NOT NULL,
                                  rating int  NOT NULL,
                                  CONSTRAINT userTVShowRating_pk PRIMARY KEY (user_id,show_id)
);

-- Table: user
CREATE TABLE user (
                      user_id int  NOT NULL AUTO_INCREMENT,
                      username varchar(50)  NOT NULL,
                      user_password varchar(50)  NOT NULL,
                      profile_photo_location varchar(50)  NOT NULL,
                      firstName varchar(50)  NOT NULL,
                      lastName varchar(50)  NOT NULL,
                      CONSTRAINT user_id PRIMARY KEY (user_id)
);

-- foreign keys
-- Reference: userFriends_friend_id (table: userFriends)
ALTER TABLE userFriends ADD CONSTRAINT userFriends_friend_id FOREIGN KEY userFriends_friend_id (friend_id)
    REFERENCES user (user_id);

-- Reference: userFriends_user_id (table: userFriends)
ALTER TABLE userFriends ADD CONSTRAINT userFriends_user_id FOREIGN KEY userFriends_user_id (user_id)
    REFERENCES user (user_id);

-- Reference: userMovieComments_userMovie (table: userMovieComments)
ALTER TABLE userMovieComments ADD CONSTRAINT userMovieComments_userMovie FOREIGN KEY userMovieComments_userMovie (movie_id,user_id)
    REFERENCES userMovie (movie_id,user_id);

-- Reference: userMovieRating_userMovie (table: userMovieRating)
ALTER TABLE userMovieRating ADD CONSTRAINT userMovieRating_userMovie FOREIGN KEY userMovieRating_userMovie (movie_id,user_id)
    REFERENCES userMovie (movie_id,user_id);

-- Reference: userMovie_user (table: userMovie)
ALTER TABLE userMovie ADD CONSTRAINT userMovie_user FOREIGN KEY userMovie_user (user_id)
    REFERENCES user (user_id);

-- Reference: userTVShowComments_userTVShow (table: userTVShowComments)
ALTER TABLE userTVShowComments ADD CONSTRAINT userTVShowComments_userTVShow FOREIGN KEY userTVShowComments_userTVShow (show_id,user_id)
    REFERENCES userTVShow (show_id,user_id);

-- Reference: userTVShowRating_userTVShow (table: userTVShowRating)
ALTER TABLE userTVShowRating ADD CONSTRAINT userTVShowRating_userTVShow FOREIGN KEY userTVShowRating_userTVShow (show_id,user_id)
    REFERENCES userTVShow (show_id,user_id);

-- Reference: userTVShow_user (table: userTVShow)
ALTER TABLE userTVShow ADD CONSTRAINT userTVShow_user FOREIGN KEY userTVShow_user (user_id)
    REFERENCES user (user_id);

insert into user (user_id, username, user_password, profile_photo_location, firstName, lastName)
values (1, 'pgfrank', 'p@ssw0rd', '/testPhotoLocation', 'Patrick', 'Frank'),
       (2, 'user1', 'anotherPassword', '/anotherTestLocation', 'Jeremy', 'Smith');

# insert into userFriends (user_id, friend_id) values (1, 2), (2, 1);

insert into userTVShow (show_id, user_id, watched, planned, watching, dropped)
values (123, 1, true, false, false, false),
       (456, 2, false, true, false, false);

insert into userMovie (movie_id, user_id, watched, planned, watching, dropped)
values (1234, 2, false, false, true, false),
       (5678, 1, false, false, false, true);

insert into userMovieComments (comment, movie_id, user_id)
values ('This is a comment from Patrick Frank for a Movie', 5678, 1),
       ('This is a comment from Jeremy Smith for a Movie', 1234, 2);

insert into userTVShowComments (comment, show_id, user_id)
values ('This is a comment from Patrick Frank for a TV Show', 123, 1),
       ('This is a comment from Jeremy Smith for a TV Show', 456, 2);

/*insert into userMovieRating (user_id, movie_id, rating) values (1, 5678, 5), (2, 1234, 3);
insert into userTVShowRating (user_id, show_id, rating) value (1, 123, 2), (2, 456, 4);*/

-- End of file.