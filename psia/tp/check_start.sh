#!/bin/bash

if [ -z "`env | grep MY_HADOOP_HOME`" ]
then
	echo "La variable d'environnement MY_HADOOP_HOME n'est pas définie"
	exit 1
fi

BIN_HADOOP=$MY_HADOOP_HOME/bin

nb_daemons_running=`$BIN_HADOOP/start-all.sh| grep Stop |wc -l`
if [ $nb_daemons_running -eq 5 ]
then
	echo "Bravo : Hadoop fonctionne :)"
	exit 0
fi

daemons_failed=`$BIN_HADOOP/start-all.sh|grep starting|tr ',' ' '`
echo $daemons_failed


for word in `echo $daemons_failed`
do
	if [ "$word" = "namenode" ] || [ "$word" = "jobtracker" ] || [ "$word" = "tasktracker" ] || [ "$word" = "datanode" ] || [ "$word" = "secondarynamenode" ] 
	then
		echo "!!!!!!!!!!!!!!!!!!!!!! $word ne fonctionne pas !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
		echo "Pour plus d'informations : cat $MY_HADOOP_HOME/logs/*-$word-*.log "
	fi
done

exit 1
