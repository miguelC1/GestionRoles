-- Script SQL para PostgreSQL

-- Crear tabla 'rol'
CREATE TABLE rol (
                     id SERIAL PRIMARY KEY,
                     name VARCHAR(100) NOT NULL
);

-- Crear tabla 'user'
CREATE TABLE "user" (
                        id SERIAL PRIMARY KEY,
                        username VARCHAR(150) NOT NULL,
                        password VARCHAR(150) NOT NULL,
                        email VARCHAR(150) NOT NULL,
                        create_at TIMESTAMP,
                        CONSTRAINT uk_username UNIQUE (username)
);

-- Crear tabla 'user_detail'
CREATE TABLE user_detail (
                             id SERIAL PRIMARY KEY,
                             first_name VARCHAR(100) NOT NULL,
                             last_name VARCHAR(100) NOT NULL,
                             age INTEGER,
                             birth_day DATE,
                             user_id BIGINT UNIQUE,
                             FOREIGN KEY (user_id) REFERENCES "user" (id)
);

-- Crear tabla 'user_rol'
CREATE TABLE user_rol (
                          id SERIAL PRIMARY KEY,
                          active BOOLEAN NOT NULL,
                          created_at TIMESTAMP NOT NULL,
                          user_id BIGINT NOT NULL,
                          rol_id BIGINT NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES "user" (id),
                          FOREIGN KEY (rol_id) REFERENCES rol (id)
);
