-- WITH updated_words AS (
--     UPDATE schema_vocabulary.words
--     SET is_learned = TRUE,
--         learn_progress_percentage = 100
--     WHERE id_word IN (
--         SELECT id_word
--         FROM schema_vocabulary.words
--         ORDER BY id_word
--         LIMIT 3
--     )
--     RETURNING id_word
-- )
SELECT id_word,
       word,
       meaning,
       context,
       next_review_at,
       repetition_count,
       learn_progress_percentage,
       is_learned,
       created_at,
       review_lapse_count
FROM schema_vocabulary.words
ORDER BY id_word
LIMIT 1000;
