START TRANSACTION;

CREATE TABLE IF NOT EXISTS genre (
  movie_id int NOT NULL,
  genre_name text NOT NULL,
  PRIMARY KEY (movie_id, genre_name)
);

CREATE TABLE IF NOT EXISTS participates (
  person_id int NOT NULL,
  movie_id int NOT NULL,
  role text NOT NULL,
  PRIMARY KEY (person_id,movie_id)
);

CREATE TABLE IF NOT EXISTS person (
  id SERIAL PRIMARY KEY,
  name text NOT NULL,
  date_of_birth date NOT NULL,
  sex boolean NOT NULL,
  picture text DEFAULT NULL,
  roles text NOT NULL,
  description text NOT NULL
);

CREATE TABLE IF NOT EXISTS person_rating (
  user_id int NOT NULL,
  person_id int NOT NULL,
  comment text NOT NULL,
  rating int NOT NULL,
  PRIMARY KEY (user_id, person_id)
);

CREATE TABLE IF NOT EXISTS movies (
  id SERIAL PRIMARY KEY,
  title text NOT NULL,
  release_year int NOT NULL,
  description text NOT NULL,
  picture text NOT NULL,
  duration int NOT NULL
);

CREATE TABLE IF NOT EXISTS movie_rating (
  user_id int NOT NULL,
  movie_id int NOT NULL,
  comment text NOT NULL,
  rating int NOT NULL,
  PRIMARY KEY (user_id, movie_id)
);

CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  username text NOT NULL UNIQUE,
  password text NOT NULL,
  roles text NOT NULL DEFAULT 'USER',
  active boolean NOT NULL DEFAULT b'1',
  picture text DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS watchlist (
  user_id int NOT NULL,
  movie_id int NOT NULL,
  rank int NOT NULL,
  PRIMARY KEY (movie_id,user_id, rank)
);

ALTER TABLE genre
  ADD CONSTRAINT genre_ibfk_1 FOREIGN KEY (movie_id) REFERENCES movies (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE participates
  ADD CONSTRAINT participates_ibfk_1 FOREIGN KEY (movie_id) REFERENCES movies (id) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT participates_ibfk_2 FOREIGN KEY (person_id) REFERENCES person (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE person_rating
  ADD CONSTRAINT person_rating_ibfk_1 FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT person_rating_ibfk_2 FOREIGN KEY (person_id) REFERENCES person (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE movie_rating
  ADD CONSTRAINT movie_rating_ibfk_1 FOREIGN KEY (movie_id) REFERENCES movies (id) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT movie_rating_ibfk_2 FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE watchlist
  ADD CONSTRAINT watchlist_ibfk_1 FOREIGN KEY (movie_id) REFERENCES movies (id) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT watchlist_ibfk_2 FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;
  
CREATE SEQUENCE IF NOT EXISTS users_id_seq;

SELECT SETVAL('users_id_seq', (
  SELECT max(id) FROM users)
);

ALTER TABLE users
ALTER COLUMN id
SET DEFAULT nextval('users_id_seq'::regclass);

ALTER SEQUENCE users_id_seq
OWNED BY users.id;
CREATE SEQUENCE IF NOT EXISTS movies_id_seq;

SELECT SETVAL('movies_id_seq', (
  SELECT max(id) FROM movies)
);

ALTER TABLE movies
ALTER COLUMN id
SET DEFAULT nextval('movies_id_seq'::regclass);

ALTER SEQUENCE movies_id_seq
OWNED BY movies.id;
CREATE SEQUENCE IF NOT EXISTS person_id_seq;

SELECT SETVAL('person_id_seq', (
  SELECT max(id) FROM person)
);

ALTER TABLE person
ALTER COLUMN id
SET DEFAULT nextval('person_id_seq'::regclass);

ALTER SEQUENCE person_id_seq
OWNED BY person.id;
COMMIT;
