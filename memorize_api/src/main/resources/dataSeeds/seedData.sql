INSERT INTO auth_user_role (id, title) VALUES
(1, 'admin'),
(2, 'user');

-- decrypted bob password is bobPassword
-- decrypted susan password is, you guessed it, susanPassword
INSERT INTO auth_user (id, username, password, auth_user_role_id) VALUES
('ef2d7a8e-a145-4f6d-86c3-c7f794843b4a', 'bob', '$2y$10$89xUsggXmlYnbk6rgI6tmez/UDWE.4RfvMxYDVjdQMnRej6wKApSC', 1),
('ef2d7a8e-a145-4f6d-86c3-c7f794843b4b', 'susan', '$2y$10$jYyyvRZgjEu08ojG3vTZ..6UMUC6OvtGwqg.HdYkiKCp9Zf4K/uM2', 2),
('ef2d7a8e-a145-4f6d-82c3-c7f794843b4b', 'coordinator', '$2y$10$jYyyvRZgjEu08ojG3vTZ..6UMUC6OvtGwqg.HdYkiKCp9Zf4K/uM2', 2);

INSERT INTO athlete (id, auth_user_id) VALUES
('7be7e72e-be07-4b6d-a2a6-7b9417f442b7', 'ef2d7a8e-a145-4f6d-86c3-c7f794843b4a'),
('7be7e72e-be07-4b6d-a2a6-7b9417f442b3', 'ef2d7a8e-a145-4f6d-86c3-c7f794843b4b'),
('7be7e72e-be07-4b6d-a2a6-7b9417f442b4', 'ef2d7a8e-a145-4f6d-82c3-c7f794843b4b');

INSERT INTO number (id, best_score_date, best_score, athlete_id) VALUES
('7be7e72e-be07-4b6d-a2a6-7b9417f442c7', NOW()- interval '3 days', 12, '7be7e72e-be07-4b6d-a2a6-7b9417f442b7'),
('7be7e72e-be07-4b6d-a2a6-7b9417f442a7', NOW(), 7, '7be7e72e-be07-4b6d-a2a6-7b9417f442b3'),
('7be7e72e-be07-4b6d-a2a6-7b9417f442d7', NOW() - interval '21 days', 289, '7be7e72e-be07-4b6d-a2a6-7b9417f442b4');

INSERT INTO number_performance (id, attempt_date, attempt_score, number_id) VALUES
('c51b2a94-581c-40c9-a2c6-3ce025f3794a', NOW() - interval '20 days', 3, '7be7e72e-be07-4b6d-a2a6-7b9417f442c7'),
('c51b2a94-581c-40c9-a2c6-3ce025f3794b', NOW() - interval '19 days', 3, '7be7e72e-be07-4b6d-a2a6-7b9417f442c7'),
('c51b2a94-581c-40c9-a2c6-3ce025f3794c', NOW() - interval '18 days', 3, '7be7e72e-be07-4b6d-a2a6-7b9417f442c7'),
('c51b2a94-581c-40c9-a2c6-3ce025f3794d', NOW() - interval '17 days', 4, '7be7e72e-be07-4b6d-a2a6-7b9417f442c7'),
('a51b2a94-581c-40c9-a2c6-3ce025f3794a', NOW() - interval '16 days', 5, '7be7e72e-be07-4b6d-a2a6-7b9417f442c7');
