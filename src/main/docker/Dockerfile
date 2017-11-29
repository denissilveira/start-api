FROM java:8
MAINTAINER Yotz Team<team@yotz.tech>
VOLUME /tmp
ADD start-1.0.0.jar start.jar
RUN bash -c 'touch /start.jar'
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","/start.jar"]
