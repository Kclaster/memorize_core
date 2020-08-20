SELECT id
    , best_score_date as bestScoreDate
    , best_score as bestScore
    , athlete_id as userId
FROM number
WHERE athlete_id = :athleteId