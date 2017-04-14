FROM java:8-jre
LABEL maintainer Nikita Podshivalov <nikitap4.92@gmail.com>
ADD ./build/libs/scraper.jar /
ADD ./.script.sh /
ENTRYPOINT ["/.script.sh"]

