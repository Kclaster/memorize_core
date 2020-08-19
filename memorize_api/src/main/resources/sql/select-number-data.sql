SELECT id as numberDataId
    , best_score_date as bestScoreDate
    , best_score as bestScore
    , user_id as userId
FROM numbers n
LEFT JOIN numbers_performances
ON number_id = n.id
WHERE user_id = ?