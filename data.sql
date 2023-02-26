CREATE TYPE gender as ENUM('male', 'female');

CREATE TABLE characters(
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    character_gender gender,
    alias VARCHAR(100) DEFAULT NULL,
    character_picture VARCHAR(100)
);

CREATE TABLE movies(
    id SERIAL PRIMARY KEY,
    movie_title VARCHAR(100) NOT NULL,
    genre VARCHAR(100),
    release_year DATE DEFAULT CURRENT_DATE,
    director VARCHAR(100),
    movie_picture VARCHAR(100),
    trailer VARCHAR(100)
);

CREATE TABLE franchises(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);
