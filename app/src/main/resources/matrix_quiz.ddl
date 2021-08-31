CREATE DATABASE IF NOT EXISTS matrix_quiz;

USE matrix_quiz;

CREATE TABLE IF NOT EXISTS user (
    `id` CHAR(36) NOT NULL,
    `name` VARCHAR(10) NOT NULL,
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `delete_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `active` TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS quiz (
    `id` CHAR(36) NOT NULL,
    `user_id` char(36) NOT NULL,
    `topic` VARCHAR(30) NOT NULL,
    `quiz` VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS quiz_option (
    `id` CHAR(36) NOT NULL,
    `quiz_id` CHAR(36) NOT NULL,
    `option_name` VARCHAR(50) NOT NULL,
    `is_answer` TINYINT(1) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (quiz_id) REFERENCES quiz(id)
);
