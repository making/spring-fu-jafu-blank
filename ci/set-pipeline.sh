#!/bin/sh
fly -t wing sp -p spring-fu-jafu-blank \
    -c `dirname $0`/pipeline.yml \
    -l `dirname $0`/credentials.yml