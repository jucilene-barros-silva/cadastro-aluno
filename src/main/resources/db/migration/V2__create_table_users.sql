create table TB_USERS
(
   id TEXT PRIMARY KEY UNIQUE,
   login TEXT NOT NULL UNIQUE,
   password TEXT NOT NULL,
   role TEXT NOT NULL
)