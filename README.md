CREATE TABLE Movie (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       director VARCHAR(255),
                       releaseDate DATE
);
CREATE TABLE Screening (
                           id SERIAL PRIMARY KEY,
                           movie_id BIGINT,
                           startTime TIMESTAMP,
                           theaterNumber INT,
                           availableSeats INT,
                           price NUMERIC,
                           FOREIGN KEY (movie_id) REFERENCES Movie(id)
);
CREATE TABLE Reservation (
                             id SERIAL PRIMARY KEY,
                             screening_id BIGINT,
                             customerName VARCHAR(255),
                             seatsBooked INT,
                             totalPrice NUMERIC,
                             reservationTime TIMESTAMP,
                             FOREIGN KEY (screening_id) REFERENCES Screening(id)
);
CREATE TABLE Customer (
                          id SERIAL PRIMARY KEY,
                          firstName VARCHAR(255),
                          lastName VARCHAR(255),
                          email VARCHAR(255),
                          phone VARCHAR(20),
                          password VARCHAR(255),
                          roles VARCHAR(255)
);

