FROM mysql:5.6

ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=demodb

EXPOSE 3306

COPY demodb.sql /docker-entrypoint-initdb.d/