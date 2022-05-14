#!/bin/bash

mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dchunk=$1"
