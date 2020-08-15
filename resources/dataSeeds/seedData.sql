INSERT INTO auth_user_roles (id, title) VALUES
(1, 'admin'),
(2, 'user');

-- decrypted bob password is bobPassword
-- decrypted susan password is, you guessed it, susanPassword
INSERT INTO auth_users (id, username, password, auth_user_role_id) VALUES
('ef2d7a8e-a145-4f6d-86c3-c7f794843b4a', 'bob', '$2y$10$89xUsggXmlYnbk6rgI6tmez/UDWE.4RfvMxYDVjdQMnRej6wKApSC', 1),
('ef2d7a8e-a145-4f6d-86c3-c7f794843b4b', 'susan', '$2y$10$jYyyvRZgjEu08ojG3vTZ..6UMUC6OvtGwqg.HdYkiKCp9Zf4K/uM2', 2);
