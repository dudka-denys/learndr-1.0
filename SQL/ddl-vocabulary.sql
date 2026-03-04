-- schema
CREATE    SCHEMA IF NOT EXISTS schema_vocabulary;

DROP      TABLE IF EXISTS schema_vocabulary.words;

-- roles
CREATE    TABLE IF NOT EXISTS schema_vocabulary.words (
          id_word BIGINT GENERATED ALWAYS AS IDENTITY (INCREMENT BY 1) PRIMARY KEY,
          word TEXT NOT NULL,
          meaning TEXT NOT NULL,
          context TEXT,
          next_review_at timestamptz, -- это и некст поле перенести в конец 
          repetition_count INTEGER NOT NULL DEFAULT 0, -- count of successful repetition phases
          learn_progress_percentage INTEGER NOT NULL DEFAULT 0,
          is_learned BOOLEAN NOT NULL DEFAULT FALSE,
          created_at timestamptz NOT NULL DEFAULT NOW(),
          review_lapse_count INTEGER NOT NULL DEFAULT 0, -- count of failed reviews in repetition phase
          CONSTRAINT word_progress_percent CHECK (
          (NOT is_learned)
OR        (learn_progress_percentage = 100)
          )
          );