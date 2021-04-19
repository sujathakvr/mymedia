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