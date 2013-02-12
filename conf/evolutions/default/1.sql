# Tasks schema

# --- !Ups

CREATE TABLE tasks (
    id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    label varchar(255)
) Engine=InnoDB;

# --- !Downs

DROP TABLE tasks;