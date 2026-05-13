FROM tomcat:9.0-jdk11

# Render free instance has limited memory, so cap JVM heap usage.
ENV JAVA_OPTS="-Xmx256m"

# Remove the default ROOT app and deploy this project as the root context.
RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
