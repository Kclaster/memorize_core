SELECT id
    , attempt_score as attemptScore
    , attempt_date as attemptDate
FROM number_performance
WHERE number_id = :numberId