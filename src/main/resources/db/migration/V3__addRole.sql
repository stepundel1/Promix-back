create type role as enum ('ROLE_ADMIN', 'ROLE_CLIENT');
alter table users add column user_role role;