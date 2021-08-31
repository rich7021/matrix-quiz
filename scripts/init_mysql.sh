#!/usr/bin/env sh

#apk add mysql mysql-client

#while ! mysqladmin ping -h"$DB_HOST" -u"$ROOT_USER" -p"$DB_PWD" --silent; do
#  sleep 1
#done
#
#echo "mysqld ping success"

chmod 644 /etc/my.cnf

sed -i 's/${APP_USER}/'${APP_USER}'/g' /app/app/src/main/resources/matrix_quiz.dml
sed -i 's/${APP_PWD}/'${APP_PWD}'/g' /app/app/src/main/resources/matrix_quiz.dml

mysql -h${DB_HOST} -u${ROOT_USER} -p${MYSQL_ROOT_PASSWORD} </app/app/src/main/resources/matrix_quiz.ddl
mysql -h${DB_HOST} -u${ROOT_USER} -p${MYSQL_ROOT_PASSWORD} </app/app/src/main/resources/matrix_quiz.dml
