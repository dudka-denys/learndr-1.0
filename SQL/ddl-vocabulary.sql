DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE EXTENSION IF NOT EXISTS citext;


-- roles
CREATE TABLE IF NOT EXISTS roles (
    id_role integer GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1) PRIMARY KEY,
    code    text NOT NULL, -- name for backend
    name    text NOT NULL  -- readable, for UI
);

-- users
CREATE TABLE IF NOT EXISTS users (
    id_user            integer GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1) PRIMARY KEY,
    user_name       text NOT NULL,
    email              citext NOT NULL,
    preferred_locale   char(2) NOT NULL,
    password_hash      text NOT NULL,
    email_verified_at    timestamptz,
    last_login_at      timestamptz,
    fk_role_id            integer NOT NULL,

    CONSTRAINT ux_users_email UNIQUE (email),

    -- 2 буквы (ISO 639-1), в нижнем регистре
    CONSTRAINT chk_users_preferred_locale
        CHECK (preferred_locale ~ '^[a-z]{2}$'),

    CONSTRAINT fk_users_roles
        FOREIGN KEY (fk_role_id)
        REFERENCES roles (id_role)
);

-- words
CREATE    TABLE IF NOT EXISTS words (
          id_word BIGINT GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1) PRIMARY KEY,
          word TEXT NOT NULL,
          meaning TEXT NOT NULL,
          context TEXT,
          learn_progress_percentage INTEGER NOT NULL DEFAULT 0,
          is_learned BOOLEAN NOT NULL DEFAULT FALSE,
          created_at timestamptz NOT NULL DEFAULT NOW(),
          next_review_at timestamptz DEFAULT NOW() + INTERVAL '8 hours', -- repetition training field
          repetition_count INTEGER DEFAULT 0, -- count of successful repetition phases
          review_lapse_count INTEGER NOT NULL DEFAULT 0, -- count of failed reviews in repetition phase`
          fk_user_id INTEGER NOT NULL,
          CONSTRAINT word_progress_percent CHECK (
          (NOT is_learned) OR (learn_progress_percentage = 100)),
    CONSTRAINT fk_words_users FOREIGN KEY(fk_user_id) REFERENCES users (id_user)
          );
          

