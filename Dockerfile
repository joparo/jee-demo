FROM jboss/wildfly
COPY build/libs/jee-demo-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/