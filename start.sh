#!/bin/bash

for i in {1..10} ; do
    echo "${i}"
    for var in 150000 100000 50000 10000 5000 2500 1000 800 500 250 100 50 10 1
    do
      echo ${var}
      bash run.sh $var
      mysql -h localhost -P 3306 --protocol=tcp -u user -ppassword batch -e'DELETE FROM address2;'
    done
done
