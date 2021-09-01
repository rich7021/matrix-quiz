#!/usr/bin/env sh

#apk add mysql mysql-client

#while ! mysqladmin ping -h"$DB_HOST" -u"$ROOT_USER" -p"$DB_PWD" --silent; do
#  sleep 1
#done
#
#echo "mysqld ping success"

chmod 644 /etc/my.cnf

ddl_path='/app/app/src/main/resources/matrix_quiz.ddl'
dml_path='/app/app/src/main/resources/matrix_quiz.dml'
tmp_ddl='/app/config/tmp_matrix_quiz.ddl'
tmp_dml='/app/config/tmp_matrix_quiz.dml'

cp $ddl_path $tmp_ddl
cp $dml_path $tmp_dml

sed -i 's/${APP_USER}/'${APP_USER}'/g' $tmp_dml
sed -i 's/${APP_PWD}/'${APP_PWD}'/g' $tmp_dml


mysql -h${DB_HOST} -u${ROOT_USER} -p${MYSQL_ROOT_PASSWORD} <$tmp_ddl
mysql -h${DB_HOST} -u${ROOT_USER} -p${MYSQL_ROOT_PASSWORD} <$tmp_dml

rm -f $tmp_ddl
rm -f $tmp_dml
