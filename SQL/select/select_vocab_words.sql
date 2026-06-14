-- ===================== UPDATE WORDS  =====================
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
-- ===================== UPDATE WORDS  =====================
-- id_user            integer GENERATED ALWAYS AS ID
-- user_name       text NOT NULL,
-- email              citext NOT NULL,
-- preferred_locale   char(2) NOT NULL,
-- fk_role_id            integer NOT NULL,
-- password_hash      text NOT NULL,
-- EmailVerifiedAt    timestamptz,
-- last_login_at      timestamptz,
-- ===================== INSERT WORDS  =====================
INSERT INTO public.roles (
  code,
  name
) VALUES (
  1, 'admin'
);
INSERT INTO public.users (
  user_name,
  email,
  preferred_locale,
  fk_role_id,
  password_hash
) VALUES (
  'dendrr', 'dudka.denis228@yahoo.com', 'ru', 1, 'asd'
);
INSERT INTO public.words (
  word,
  meaning,
  context,
  created_at,
  fk_user_id
) VALUES
('abandon', 'to leave something behind', 'He decided to abandon the old project.', NOW() - (random() * interval '365 days'), 1),
('accurate', 'correct and precise', 'The report was accurate enough for production.', NOW() - (random() * interval '365 days'), 1),
('achieve', 'to successfully complete something', 'She worked hard to achieve her goals.', NOW() - (random() * interval '365 days'), 1),
('adapt', 'to adjust to new conditions', 'Developers must adapt quickly to changes.', NOW() - (random() * interval '365 days'), 1),
('analyze', 'to examine carefully', 'The engineer analyzed the logs.', NOW() - (random() * interval '365 days'), 1),
('ancient', 'very old', 'They visited an ancient castle in France.', NOW() - (random() * interval '365 days'), 1),
('approve', 'to officially accept', 'The manager approved the deployment.', NOW() - (random() * interval '365 days'), 1),
('attempt', 'an effort to do something', 'His first attempt failed.', NOW() - (random() * interval '365 days'), 1),
('balance', 'a stable state', 'Work-life balance is important.', NOW() - (random() * interval '365 days'), 1),
('benefit', 'an advantage or positive effect', 'Exercise has many health benefits.', NOW() - (random() * interval '365 days'), 1),
('brief', 'short in duration', 'We had a brief conversation.', NOW() - (random() * interval '365 days'), 1),
('capture', 'to catch or record', 'The app captures user activity.', NOW() - (random() * interval '365 days'), 1),
('careful', 'paying attention to details', 'Be careful with database migrations.', NOW() - (random() * interval '365 days'), 1),
('challenge', 'a difficult task', 'Learning Java concurrency is a challenge.', NOW() - (random() * interval '365 days'), 1),
('combine', 'to join together', 'They combined two APIs into one service.', NOW() - (random() * interval '365 days'), 1),
('complex', 'complicated', 'This query is too complex.', NOW() - (random() * interval '365 days'), 1),
('confirm', 'to verify something', 'Please confirm your email address.', NOW() - (random() * interval '365 days'), 1),
('connect', 'to link together', 'The backend connects to PostgreSQL.', NOW() - (random() * interval '365 days'), 1),
('consider', 'to think carefully about', 'Consider using Docker Compose.', NOW() - (random() * interval '365 days'), 1),
('constant', 'unchanging', 'The server receives constant traffic.', NOW() - (random() * interval '365 days'), 1),
('create', 'to make something new', 'She created a new Angular component.', NOW() - (random() * interval '365 days'), 1),
('damage', 'physical or logical harm', 'Water damage destroyed the keyboard.', NOW() - (random() * interval '365 days'), 1),
('decide', 'to make a choice', 'He decided to learn Spring Boot.', NOW() - (random() * interval '365 days'), 1),
('deliver', 'to bring or provide', 'The API delivers JSON responses.', NOW() - (random() * interval '365 days'), 1),
('depend', 'to rely on something', 'Success depends on preparation.', NOW() - (random() * interval '365 days'), 1),
('design', 'to plan and build', 'They designed a scalable architecture.', NOW() - (random() * interval '365 days'), 1),
('develop', 'to build or improve', 'She develops enterprise software.', NOW() - (random() * interval '365 days'), 1),
('discover', 'to find something new', 'They discovered a security issue.', NOW() - (random() * interval '365 days'), 1),
('efficient', 'working well with little waste', 'This algorithm is very efficient.', NOW() - (random() * interval '365 days'), 1),
('encourage', 'to motivate positively', 'Good mentors encourage learning.', NOW() - (random() * interval '365 days'), 1),
('environment', 'surrounding conditions', 'Docker creates isolated environments.', NOW() - (random() * interval '365 days'), 1),
('essential', 'absolutely necessary', 'Sleep is essential for recovery.', NOW() - (random() * interval '365 days'), 1),
('estimate', 'an approximate calculation', 'We estimated the migration time.', NOW() - (random() * interval '365 days'), 1),
('evaluate', 'to assess something', 'The recruiter evaluated the candidate.', NOW() - (random() * interval '365 days'), 1),
('evidence', 'proof or indication', 'There was no evidence of corruption.', NOW() - (random() * interval '365 days'), 1),
('expand', 'to increase in size', 'The company plans to expand abroad.', NOW() - (random() * interval '365 days'), 1),
('feature', 'a function or characteristic', 'Pagination became a core feature.', NOW() - (random() * interval '365 days'), 1),
('flexible', 'easy to adjust', 'Remote work offers flexible schedules.', NOW() - (random() * interval '365 days'), 1),
('focus', 'to concentrate attention', 'Focus on backend fundamentals first.', NOW() - (random() * interval '365 days'), 1),
('generate', 'to produce automatically', 'The script generates fake data.', NOW() - (random() * interval '365 days'), 1),
('improve', 'to make better', 'Practice improves communication skills.', NOW() - (random() * interval '365 days'), 1),
('include', 'to contain as part', 'The package includes documentation.', NOW() - (random() * interval '365 days'), 1),
('increase', 'to become larger', 'Traffic increased after the release.', NOW() - (random() * interval '365 days'), 1),
('influence', 'to affect something', 'Sleep influences cognitive performance.', NOW() - (random() * interval '365 days'), 1),
('maintain', 'to keep in good condition', 'It is difficult to maintain legacy systems.', NOW() - (random() * interval '365 days'), 1),
('measure', 'to determine size or amount', 'The app measures response time.', NOW() - (random() * interval '365 days'), 1),
('modern', 'current and up-to-date', 'Spring Boot is widely used in modern systems.', NOW() - (random() * interval '365 days'), 1),
('monitor', 'to observe continuously', 'Admins monitor server health.', NOW() - (random() * interval '365 days'), 1),
('natural', 'normal or organic', 'His French sounds natural.', NOW() - (random() * interval '365 days'), 1),
('obtain', 'to get something', 'The service failed to obtain a token.', NOW() - (random() * interval '365 days'), 1),
('operate', 'to function or work', 'The machine operates automatically.', NOW() - (random() * interval '365 days'), 1),
('optimize', 'to improve efficiency', 'They optimized the SQL queries.', NOW() - (random() * interval '365 days'), 1),
('organize', 'to arrange systematically', 'She organized her study schedule.', NOW() - (random() * interval '365 days'), 1),
('perform', 'to execute or function', 'The database performs well under load.', NOW() - (random() * interval '365 days'), 1),
('prevent', 'to stop something from happening', 'Tests help prevent regressions.', NOW() - (random() * interval '365 days'), 1),
('process', 'a sequence of actions', 'Authentication is a critical process.', NOW() - (random() * interval '365 days'), 1),
('protect', 'to keep safe', 'HTTPS protects user data.', NOW() - (random() * interval '365 days'), 1),
('reduce', 'to make smaller', 'Caching reduces server load.', NOW() - (random() * interval '365 days'), 1),
('require', 'to need something', 'Angular requires Node.js.', NOW() - (random() * interval '365 days'), 1),
('resource', 'something useful or available', 'CPU is a limited resource.', NOW() - (random() * interval '365 days'), 1),
('response', 'an answer or reaction', 'The API response was delayed.', NOW() - (random() * interval '365 days'), 1),
('restore', 'to bring back', 'They restored the database backup.', NOW() - (random() * interval '365 days'), 1),
('schedule', 'a planned timetable', 'His work schedule changed recently.', NOW() - (random() * interval '365 days'), 1),
('secure', 'safe from danger', 'Passwords must be stored securely.', NOW() - (random() * interval '365 days'), 1),
('select', 'to choose', 'The query selects active users.', NOW() - (random() * interval '365 days'), 1),
('separate', 'to divide apart', 'Business logic should remain separate.', NOW() - (random() * interval '365 days'), 1),
('solution', 'a way to solve a problem', 'Docker was the simplest solution.', NOW() - (random() * interval '365 days'), 1),
('support', 'to help or maintain', 'The framework supports REST APIs.', NOW() - (random() * interval '365 days'), 1),
('update', 'to make more recent', 'He updated the frontend dependencies.', NOW() - (random() * interval '365 days'), 1),
('validate', 'to check correctness', 'The backend validates input data.', NOW() - (random() * interval '365 days'), 1),
('visible', 'able to be seen', 'The issue became visible in logs.', NOW() - (random() * interval '365 days'), 1);
-- ===================== INSERT WORDS  =====================
-- ===================== SELECT WORDS  =====================
SELECT id_word,
       word,
       meaning,
       context,
       next_review_at,
      --  repetition_count,
      --  learn_progress_percentage,
      --  is_learned,
       created_at,
       review_lapse_count
FROM public.words
ORDER BY id_word
LIMIT 1000;
-- ===================== SELECT WORDS  =====================

