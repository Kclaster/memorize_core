SELECT a.id
FROM athlete a
LEFT JOIN auth_user au
ON a.auth_user_id = au.id
WHERE au.username = :username