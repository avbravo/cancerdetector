# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM payara/micro:6.2024.8-jdk21

COPY target/cancerdetectorserver.war $DEPLOY_DIR