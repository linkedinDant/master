#!/bin/bash

export HADOOP_HOME=${HOME}/master/psia/tp/hadoop
export PATH=${PATH}:${HADOOP_HOME}/bin
cd ${HADOOP_HOME}/bin
./start-all.sh
./checkStart.sh
