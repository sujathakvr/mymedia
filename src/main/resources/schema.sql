create table users(
      username varchar_ignorecase(50) not null primary key,
      password varchar_ignorecase(50) not null,
      enabled boolean not null);
      
create table authorities (
      username varchar_ignorecase(50) not null,
      authority varchar_ignorecase(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));

create unique index ix_auth_username on authorities (username,authority);     

CREATE TABLE IF NOT EXISTS playlist 
  ( 
     id         VARCHAR(50) PRIMARY KEY, 
     name       VARCHAR(250) NOT NULL, 
     created_on DATE DEFAULT sysdate
  ); 
  
CREATE TABLE IF NOT EXISTS song 
  ( 
     id          VARCHAR(50) PRIMARY KEY, 
     playlist_id VARCHAR(50) NOT NULL, 
     name        VARCHAR(250) NOT NULL, 
     cover_url   VARCHAR(250) NOT NULL, 
     created_on  DATE DEFAULT sysdate, 
     FOREIGN KEY(playlist_id) REFERENCES playlist(id) ON UPDATE CASCADE 
  );  