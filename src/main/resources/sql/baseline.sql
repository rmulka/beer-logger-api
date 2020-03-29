CREATE TABLE users (
   id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   first_name VARCHAR NOT NULL,
   last_name VARCHAR NOT NULL,
   username VARCHAR NOT NULL UNIQUE,
   email VARCHAR NOT NULL UNIQUE,
   password VARCHAR NOT NULL,
   enabled BOOLEAN NOT NULL DEFAULT true
);

CREATE TABLE authorities (
    username VARCHAR NOT NULL,
    authority VARCHAR NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users (first_name, last_name, username, email, password, enabled)
VALUES ('drinklog', 'user', 'drinkloguser', 'drinklog@email.com', '$2a$12$V/KFyYHuPvN9ZpjP.Lgwy.ZTyQBT57Jk.4IPucSyz2IlPyaFBFTGq', true);

INSERT INTO authorities (username, authority)
VALUES ('drinkloguser', 'ROLE_USER');