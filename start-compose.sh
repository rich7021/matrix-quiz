#!/usr/bin/env sh


DB_HOST='localhost'

while getopts ":U:P:u:p:h:" opt; do
  case $opt in
    U)
      root_user=$OPTARG
      ;;
    P)
      root_pwd=$OPTARG
      ;;
    u)
      app_user=$OPTARG
      ;;
    p)
      app_pwd=$OPTARG
      ;;
    h)
      db_host=$OPTARG
      ;;
  esac
done


DB_HOST=$db_host ROOT_USER=$root_user MYSQL_ROOT_PASSWORD=$root_pwd APP_USER=$app_user APP_PWD=$app_pwd docker-compose up