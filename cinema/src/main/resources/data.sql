--INSERT INTO movie (title, premier, playtime, description, genre, actors, director, age_limit) 
--   VALUES ('Test movie', '2019.11.02.', 90, 'This is very good movie', 'sci-fi', 'Everybody', 'Domcsi', 16);

INSERT INTO employee (email, name, password, user_name) VALUES ('admin@email.com', 'admin', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'admin');
INSERT INTO employee (email, name, password, user_name) VALUES ('p3uvid@inf.elte.hu', 'Dominika', '$2a$04$yNvfa3RWptKUzZP0K6Zk5ewOwdkxO2m0.eorocnvtMIfUiPB.s8XO', 'dominika');
INSERT INTO employee (email, name, password, user_name) VALUES ('adv2p1@inf.elte.hu', 'Dóri', '$2a$04$N9BsJ7Gz9l17wF8TE2hax.XlaORXg4rDSR5cuH61dvWeVYm6I7g3u', 'dori');

INSERT INTO movie (actors, age_limit, description, director, genre, playtime, premier, title) VALUES ('First actor, Second actor', 12, 'You have to see this movie', 'Direct Director', 'sci-fi', 111, '2019-11-11', 'First movie');
INSERT INTO movie (actors, age_limit, description, director, genre, playtime, premier, title) VALUES ('First actor, Second actor, Third actor', 6, 'Best movie ever!', 'Direct Director''s wife', 'drama', 66, '2019-12-06', 'Second movie'); 
INSERT INTO movie (actors, age_limit, description, director, genre, playtime, premier, title) VALUES ('Actor numero uno', 18, 'If you don''t watch this movie...', 'Not a real director', 'action', 89, '2019-11-08', 'Third movie');

INSERT INTO room (name) VALUES ('Room 1');
INSERT INTO room (name) VALUES ('Room 2');
INSERT INTO room (name) VALUES ('Room 3');
INSERT INTO room (name) VALUES ('Room 4');

INSERT INTO screening (screening_time, movie_id, room_id) VALUES ('2019-12-01', 1, 1);
INSERT INTO screening (screening_time, movie_id, room_id) VALUES ('2019-12-02', 2, 1);
INSERT INTO screening (screening_time, movie_id, room_id) VALUES ('2019-12-02', 1, 3);
INSERT INTO screening (screening_time, movie_id, room_id) VALUES ('2019-12-05', 3, 4);
INSERT INTO screening (screening_time, movie_id, room_id) VALUES ('2019-12-11', 2, 2);
INSERT INTO screening (screening_time, movie_id, room_id) VALUES ('2019-12-15', 1, 4);
INSERT INTO screening (screening_time, movie_id, room_id) VALUES ('2019-12-25', 3, 2);
INSERT INTO screening (screening_time, movie_id, room_id) VALUES ('2019-12-25', 2, 4);
INSERT INTO screening (screening_time, movie_id, room_id) VALUES ('2019-12-25', 1, 1);

INSERT INTO booking (email, name, phone, screening_id) VALUES ('xy@email.com', 'XY', '0620123457', 1);

INSERT INTO seat (number, status, booking_id, room_id) VALUES (1, 'BOOKED', 1, 1);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (2, 'FREE', null, 1);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (3, 'FREE', null, 1);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (4, 'FREE', null, 1);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (5, 'FREE', null, 1);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (6, 'FREE', null, 1);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (7, 'FREE', null, 1);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (8, 'FREE', null, 1);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (9, 'FREE', null, 1);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (10, 'FREE', null, 1);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (11, 'FREE', null, 1);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (12, 'FREE', null, 1);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (1, 'FREE', null, 2);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (2, 'FREE', null, 2);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (3, 'FREE', null, 2);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (4, 'FREE', null, 2);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (5, 'FREE', null, 2);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (6, 'FREE', null, 2);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (7, 'FREE', null, 2);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (8, 'FREE', null, 2);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (9, 'FREE', null, 2);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (10, 'FREE', null, 2);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (11, 'FREE', null, 2);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (12, 'FREE', null, 2);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (1, 'FREE', null, 3);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (2, 'FREE', null, 3);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (3, 'FREE', null, 3);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (4, 'FREE', null, 3);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (5, 'FREE', null, 3);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (6, 'FREE', null, 3);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (7, 'FREE', null, 3);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (8, 'FREE', null, 3);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (9, 'FREE', null, 3);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (10, 'FREE', null, 3);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (11, 'FREE', null, 3);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (12, 'FREE', null, 3);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (1, 'FREE', null, 4);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (2, 'FREE', null, 4);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (3, 'FREE', null, 4);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (4, 'FREE', null, 4);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (5, 'FREE', null, 4);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (6, 'FREE', null, 4);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (7, 'FREE', null, 4);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (8, 'FREE', null, 4);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (9, 'FREE', null, 4);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (10, 'FREE', null, 4);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (11, 'FREE', null, 4);
INSERT INTO seat (number, status, booking_id, room_id) VALUES (12, 'FREE', null, 4);
