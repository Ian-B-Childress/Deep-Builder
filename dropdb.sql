SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'deep_builder';

DROP DATABASE deep_builder;

create