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
LIMIT 1000;