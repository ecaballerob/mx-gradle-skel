FROM openjdk:14-alpine
COPY build/libs/mx-gradle-skel-*-all.jar mx-gradle-skel.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "mx-gradle-skel.jar"]