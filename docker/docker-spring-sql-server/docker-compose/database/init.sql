IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'DockerSpringSqlServer')
BEGIN
  CREATE DATABASE DockerSpringSqlServer;
END;
GO