DROP TABLE IF EXISTS athlete CASCADE;
DROP TABLE IF EXISTS number CASCADE;
DROP TABLE IF EXISTS number_performance CASCADE;
DROP TABLE IF EXISTS auth_users CASCADE;
DROP TABLE IF EXISTS auth_user_roles CASCADE;


CREATE TABLE auth_user_role
(
    id int PRIMARY KEY NOT NULL,
    title varchar(30) NOT NULL
);

CREATE TABLE auth_user
(
    id uuid PRIMARY KEY NOT NULL,
    username varchar(30) NOT NULL,
    password varchar(60) NOT NULL,
    auth_user_role_id int REFERENCES auth_user_role (id),
    is_expired boolean NOT NULL DEFAULT TRUE,
    is_locked boolean NOT NULL DEFAULT TRUE,
    is_credentials_expired boolean NOT NULL DEFAULT TRUE,
    is_enabled boolean NOT NULL DEFAULT TRUE
);

CREATE TABLE athlete
(
  id uuid PRIMARY KEY,
  auth_user_id uuid REFERENCES auth_user (id)
);

CREATE TABLE number (
  id uuid PRIMARY KEY,
  best_score_date timestamptz,
  best_score integer,
  athlete_id uuid REFERENCES athlete (id)
);

CREATE TABLE number_performance(
  id uuid PRIMARY KEY,
  attempt_date timestamptz,
  attempt_score integer,
  number_id uuid REFERENCES number (id)
);
